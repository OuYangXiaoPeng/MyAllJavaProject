package mySQLTest;

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
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Stream;


public class DangDangNet {

    List<String> Names = new ArrayList<>();
    List<String> Writer = new ArrayList<>();
    List<String> Date = new ArrayList<>();
    List<String> Editor = new ArrayList<>();
    List<String> Url = new ArrayList<>();
    List<Double> Price = new ArrayList<>();
    List<String> Picture = new ArrayList<>();
    Map<String, String> headers = new HashMap<>();

    public void addHeader() {
        headers.put("User-Agent", "Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/110.0.0.0 Safari/537.36 Edg/110.0.1587.57");
        headers.put("user-agent", "Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/111.0.0.0 Safari/537.36 Edg/111.0.1661.54");
    }

    public void Content(String key) throws Exception {
        //Jsoup
        //请求链接
        Connection conn = Jsoup.connect("https://search.dangdang.com/?key=" + key + "&act=input")
                .timeout(5000);//设置5秒的超时
        // 手动设置字符编码格式
        conn.header("Content-Type", "text/html; charset=gbk");
        //加入请求头,调用 get()方法发送请求，获取响应内容并转换为一个 Document 对象
        Document novelDoc = conn.headers(headers).get();
//        System.out.println(novelDoc);

        //select()方法获取价格
        Elements price = novelDoc.select("p.price > span.search_now_price");
        for (Element p : price) {
            String pr = String.valueOf(p);
            //使用正则表达式筛选数字
            Pattern pattern = Pattern.compile("&yen;(\\d+\\.?\\d*)");
            Matcher matcher = pattern.matcher(pr);
            if (matcher.find()) {
                double pri = Double.parseDouble(matcher.group(1));
                Price.add(pri);
//                System.out.println(pri);
            }
        }

        //使用选择器获取名和url
        Elements chapterLinks = novelDoc.select("p.name > a");
//        System.out.println(chapterLinks);
        for (Element chapter : chapterLinks) {
            String name = chapter.select("a[title]").attr("title");
            Names.add(name);
            String url = chapter.attr("abs:href");
            Url.add(url);
//            System.out.println("名:" + name + ",url:" + url);
        }

        //获取作者
        Elements writer = novelDoc.select("p.search_book_author > span:nth-child(1) > a");
        for (Element w : writer) {
            String wri = w.text();
            Writer.add(wri);
//            System.out.println(wri);
        }

        //获取日期
        Elements date = novelDoc.select("p.search_book_author > span:nth-child(2)");
        for (Element d : date) {
            String da = d.text();
            Date.add(da);
//            System.out.println(da);
        }

        //获取出版社
        Elements editor = novelDoc.select("p.search_book_author > span:nth-child(3) > a");
        for (Element e : editor) {
            String ed = e.text();
            Editor.add(ed);
//            System.out.println(ed);
        }

        //获取图片
        Elements picture = novelDoc.select("a > img");
        for (Element img : picture) {
            if (img.hasAttr("data-original")) { // 判断是否有 data-original 属性
                String pi = img.attr("data-original");
                Picture.add("https:" + pi);
            } else {
                String pi = img.attr("src");
                Picture.add("https:" + pi);
            }
        }
        Picture.remove(0);
        Picture.remove(Picture.size() - 1);

    }

    //获取最小的列表长度
    public int getMinimumSize(List<String> names, List<String> writer, List<String> date, List<String> editor,
                              List<String> url, List<Double> price, List<String> picture) {
        int minSize = Stream.of(names.size(), writer.size(), date.size(), editor.size(), url.size(),
                        price.size(), picture.size())
                .min(Integer::compare)
                .orElse(0);
        return minSize;
    }

    public void mySQL() throws Exception {
        //实例化MysqlDB对象
        MysqlDB mysqlDB = new MysqlDB();

        //连接到mysql数据库
        java.sql.Connection con = DriverManager.getConnection(
                mysqlDB.getUrl(),
                mysqlDB.getUsername(),
                mysqlDB.getPassword()
        );

        //创建表格的操作
        PreparedStatement table = con.prepareStatement(
                "create table if not exists content(" +
                        "id int(100) not null primary key auto_increment," +
                        "price double null," +
                        "name varchar(255) null," +
                        "writer varchar(255) null," +
                        "date varchar(255) null," +
                        "url varchar(255) null," +
                        "editor varchar(255) null," +
                        "image varchar(255) null" +
                        ");"
        );
        table.executeUpdate();//执行

        //创建一个预处理语句，删除表格中的所有内容
        PreparedStatement delete = con.prepareStatement(
                "TRUNCATE TABLE content;"
        );
        delete.executeUpdate();//执行操作

        //设置指针id为1
        int node = 1;
        //创建一个预处理语句，插入数据到表的列中
        PreparedStatement pstmt = con.prepareStatement(
                "INSERT INTO content VALUES (?,?,?,?,?,?,?,?);"
        );

        //调用方法，得到最小的列表长度
        int minimumSize = getMinimumSize(Names, Writer, Date, Editor, Url, Price, Picture);

        //利用for循环，在b站top表格中分别插入id、视频名、视频URL、UP名和UP主页地址
        for (int i = 0; i < minimumSize; i++) {
//            System.out.println(videoName.get(i));
            pstmt.setInt(1, node); //
            pstmt.setDouble(2, Price.get(i)); //
            pstmt.setString(3, Names.get(i)); //
            pstmt.setString(4, Writer.get(i)); //
            pstmt.setString(5, Date.get(i)); //
            pstmt.setString(6, Url.get(i)); //
            pstmt.setString(7, Editor.get(i)); //
            pstmt.setString(8, Picture.get(i)); //
            pstmt.executeUpdate(); //执行插入操作
            //指针自增1
            node++;
        }

        //关闭
        pstmt.close();
        con.close();
    }

    public void savePicture() throws Exception {
        String directory = "src/main/webapp/images/";
        Path p = Paths.get(directory);
        //如果没有目录，创建目录
        if (!Files.exists(p)) {
            Files.createDirectory(p);
        }
        for (int i = 0; i < Picture.size(); i++) {
            URL url = new URL(Picture.get(i)); // 创建URL对象
            BufferedInputStream bis = new BufferedInputStream(url.openStream()); // 获取图片流
            FileOutputStream fos = new FileOutputStream("src/main/webapp/images/image" + (i + 1) + ".jpg"); // 创建输出流
            byte[] buffer = new byte[1024];
            int count = 0;
            while ((count = bis.read(buffer, 0, 1024)) != -1) { // 将图片流写入文件
                fos.write(buffer, 0, count);
                fos.flush();
            }
            fos.close();
            bis.close();
        }
    }


    public static void main(String[] args) throws Exception {
        //实例化对象
        DangDangNet dangDangNet = new DangDangNet();
        //加入请求头
        dangDangNet.addHeader();

        Scanner scanner = new Scanner(System.in);
        System.out.println("请输入你要查询的关键字:");
        String line = scanner.next();
        System.out.println("搜索中...");

        //调用查找数据的方法
        dangDangNet.Content(line);
        System.out.println("搜索成功，获取内容中...");

        //调用将数据保存在数据库的方法
        dangDangNet.mySQL();
        System.out.println("获取成功！\n请在MySQL库中content表格中查看.");

        //调用保存图片的方法
        System.out.println("保存图片中...");
        dangDangNet.savePicture();
        System.out.println("图片保存成功！\n保存路径‘src/main/webapp/images’");
    }

}
