package Crawler;

import org.jsoup.Connection;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.Map;

public class ClassWork {

    Map<String, String> headers = new HashMap<>();

    public void addHeader() {
        headers.put("User-Agent", "Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/110.0.0.0 Safari/537.36 Edg/110.0.1587.57");
        headers.put("user-agent", "Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/111.0.0.0 Safari/537.36 Edg/111.0.1661.54");
    }

    public void Data() throws Exception {
        Connection connect = Jsoup.connect("https://search.jd.com/Search").headers(headers);
        // 添加参数
        Map<String, String> map = new HashMap<>();
        map.put("keyword", "原神宵宫");
        map.put("enc", "utf-8");

        connect.data(map);
        Document doc = connect.get();
        System.out.println(doc.html());
    }

    public void Picture(String url,String name) throws Exception {
        String imageUrl = url;
        Connection connect = Jsoup.connect(imageUrl).headers(headers);
        Connection.Response response = connect
                .method(Connection.Method.GET)
                .timeout(10*60*1000)
                .maxBodySize(Integer.MAX_VALUE)
                .ignoreContentType(true).execute();


        BufferedInputStream bufferedInputStream = response.bodyStream();

        if (response.statusCode() == 200) {
            //响应转化成输出流
            String pathname = ".image";
            Path p = Paths.get(pathname);
            if (!Files.exists(p)) {
                Files.createDirectory(p);
            }
            String filename = ".image/"+name;
            saveImage(bufferedInputStream, filename);
        }else {
            System.out.println("响应失败！！！");
        }


    }

    public static void saveImage(BufferedInputStream in, String savePath)
            throws Exception {
        byte[] buffer = new byte[1024];
        int len = 0;
        //创建缓冲流
        FileOutputStream fileOutStream = new FileOutputStream(new File(savePath));
        BufferedOutputStream bufferedOut = new BufferedOutputStream(fileOutStream);
        //图片写入
        while ((len = in.read(buffer, 0, 1024)) != -1) {
            bufferedOut.write(buffer, 0, len);
        }
        //缓冲流释放与关闭
        bufferedOut.flush();
        bufferedOut.close();
        System.out.println("图片保存成功！！！");
    }


    public static void main(String[] args) throws Exception {
        ClassWork classWork = new ClassWork();
        //存入请求头
        classWork.addHeader();
        //加入参数爬取
//        classWork.Data();
        //爬取图片并保存
        String url = "http://pcsource.upupoo.com/theme/2001112900/previewFix.jpg";
        String name = "小真寻.jpg";
        classWork.Picture(url,name);
    }

}
