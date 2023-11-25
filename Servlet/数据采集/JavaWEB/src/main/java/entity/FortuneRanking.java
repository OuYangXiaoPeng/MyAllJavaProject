package entity;

import org.jsoup.Connection;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.BufferedInputStream;
import java.io.FileOutputStream;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;


public class FortuneRanking {

    List<String> Name = new ArrayList<String>();
    List<String> Url = new ArrayList<String>();
    List<String> Prices = new ArrayList<String>();
    List<String> Profit = new ArrayList<String>();
    List<String> Country = new ArrayList<String>();

    public void Context(String rl) throws Exception {
        //请求链接
        Connection conn = Jsoup.connect(rl)
                .timeout(5000);//设置5秒的超时

        Document Doc = conn.get();
//        System.out.println(Doc);

        Elements elements = Doc.select("#table1 > tbody > tr");
//        System.out.println(elements);
        for (Element element : elements) {
            Element name = element.select("td").get(1);
            Element na = name.select("a").first();

            //加入名称
            Name.add(na.text());
            //筛选出href并合成url
            String url = na.attr("href").replace("../../../..", "");
            String u = "https://www.fortunechina.com/" + url;
            //加入url
            Url.add(u);

            //获取并加入营业收入
            Element price = element.select("td").get(2);
            Prices.add(price.text());

            //获取并加入利润
            Element profit = element.select("td").get(3);
            Profit.add(profit.text());

            //获取并加入国家
            Element country = element.select("td").get(4);
            Country.add(country.text());

            System.out.println("--------------------------------");
            System.out.println(name.text());
            System.out.println(u);
            System.out.println(price.text());
            System.out.println(profit.text());
            System.out.println(country.text());
        }
    }

    public void saveImage(String rl, String directory) throws Exception {
        System.out.println("保存图片中...");
        Connection conn = Jsoup.connect(rl)
                .timeout(5000);//设置5秒的超时
        Document Doc = conn.get();
//        System.out.println(Doc);

        Elements elements = Doc.select("body > div.main > div > div.hf-bottom > div.hf-b-link.hf-b-link2 > a > span.pic > img");
        String img = elements.attr("src");

        Path p = Paths.get(directory);
        //如果没有目录，创建目录
        if (!Files.exists(p)) {
            Files.createDirectory(p);
        }
        URL url = new URL(img); // 创建URL对象
        BufferedInputStream bis = new BufferedInputStream(url.openStream()); // 获取图片流
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
    }

    public void saveSql() throws Exception {
        // 连接到数据库
        java.sql.Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/mydatabase", "root", "123456");

        // 创建表
        Statement stmt = conn.createStatement();
        stmt.executeUpdate(
                "create table if not exists person" +
                        "(" +
                        "id      int not null  primary key," +
                        "name    varchar(255) null," +
                        "sales   varchar(255) null," +
                        "profit  varchar(255) null," +
                        "country varchar(255) null" +
                        ");"
        );

        PreparedStatement delete = conn.prepareStatement("TRUNCATE TABLE person;");
        delete.executeUpdate();

        // 创建预处理语句
        PreparedStatement ps = conn.prepareStatement("INSERT INTO person VALUES (?, ?, ?, ?, ?)");

        // 插入数据,插入前100
        for (int i = 0; i < 100; i++) {
            ps.setInt(1, i+1);
            ps.setString(2, Name.get(i));
            ps.setString(3, Prices.get(i));
            ps.setString(4, Profit.get(i));
            ps.setString(5, Country.get(i));
            ps.executeUpdate();
        }

        // 关闭资源
        ps.close();
        stmt.close();
        conn.close();
    }


    public static void main(String[] args) throws Exception {
        String url = "https://www.fortunechina.com/fortune500/c/2022-08/03/content_415683.htm";
        FortuneRanking fortuneRanking = new FortuneRanking();

        //获取网页内容并进行保存至集合
        fortuneRanking.Context(url);
        System.out.println("------------------------");

        //保存图片的路径
        String directory = "src/main/webapp/images/";
        fortuneRanking.saveImage(url, directory);
        System.out.println("------------------------");

        //保存到数据库
        fortuneRanking.saveSql();
        System.out.println("数据库保存运行完毕！");
    }

}
