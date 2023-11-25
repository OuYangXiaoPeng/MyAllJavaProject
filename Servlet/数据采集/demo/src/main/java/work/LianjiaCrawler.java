package work;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.BufferedInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class LianjiaCrawler {

    public static void main(String[] args) throws Exception {
        Path p = Paths.get("src/main/webapp/images");
        //如果没有目录，创建目录
        if (!Files.exists(p)) {
            Files.createDirectory(p);
        }
        URL ur = new URL("https://image1.ljcdn.com/110000-inspection/62519f276613d75ed99176c4e3cecab2-024.jpg.296x216.jpg"); // 创建URL对象
        BufferedInputStream bis = new BufferedInputStream(ur.openStream()); // 获取图片流
        FileOutputStream fos = new FileOutputStream("src/main/webapp/images/image.jpg"); // 创建输出流
        byte[] buffer = new byte[1024];
        int count = 0;
        while ((count = bis.read(buffer, 0, 1024)) != -1) { // 将图片流写入文件
            fos.write(buffer, 0, count);
            fos.flush();
        }
        fos.close();
        bis.close();
        System.out.println("图片保存成功！");


        // 数据库连接参数
        String url = "jdbc:mysql://localhost:3306/crawler";
        String username = "root";
        String password = "123456";

        // 输入城市
        Scanner scanner = new Scanner(System.in);
        System.out.print("请输入您要查询的城市：");
        String city = scanner.next();

        // 构造请求url
        String requestUrl = String.format("https://%s.lianjia.com/ershoufang/", city);

        // 设置header
        Map<String, String> headers = new HashMap<>();
        headers.put("User-Agent", "Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/91.0.4472.77 Safari/537.36");

        // 获取响应
        Document doc = null;
        try {
            doc = Jsoup.connect(requestUrl).headers(headers).get();
        } catch (IOException e) {
            e.printStackTrace();
        }

        // 获取二手房列表
        Elements houseList = null;
        if (doc != null) {
            houseList = doc.select("ul.sellListContent li");
        }

        // 建立数据库连接，准备写入数据
        Connection conn = null;
        PreparedStatement ps = null;

        conn = DriverManager.getConnection(url, username, password);
        conn.setAutoCommit(false);

        PreparedStatement delete = conn.prepareStatement("TRUNCATE TABLE house;");
        delete.executeUpdate();
        // 构造写入数据的SQL语句
        String insertSql = "INSERT INTO house(city, img, title, price, location, img_url) VALUES (?, ?, ?, ?, ?, ?)";
        ps = conn.prepareStatement(insertSql);

        // 遍历二手房列表，获取详细信息并写入数据库
        if (houseList != null) {
            for (Element house : houseList) {
                String img = house.select("img").attr("data-src");
                String title = house.select("div.title").text();
                String price = house.select("div.priceInfo div.totalPrice").text();
                Elements locationList = house.select("div.positionInfo a");
                String location = "";
                if (locationList.size() > 1) {
                    location = locationList.get(0).text() + " " + locationList.get(1).text();
                }
                String imgUrl = house.select("div.title").select("a").attr("href");

                // 参数占位符赋值
                ps.setString(1, city);
                ps.setString(2, img);
                ps.setString(3, title);
                ps.setString(4, price);
                ps.setString(5, location);
                ps.setString(6, imgUrl);
                ps.addBatch();

            }
        }
        // 批量执行SQL语句
        ps.executeBatch();
        // 提交事务
        conn.commit();
        System.out.println("完成！");

        // 关闭连接
        ps.close();
        conn.close();


    }
}