package Crawler;

import org.apache.http.Header;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.HttpStatus;
import org.apache.http.client.HttpClient;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.message.BasicHeader;
import org.apache.http.protocol.BasicHttpContext;
import org.apache.http.protocol.HttpContext;
import org.apache.http.util.EntityUtils;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class HttpclientNovel {

    static List<String> novelName = new ArrayList<>();
    static List<String> novelURL = new ArrayList<>();
    static List<Header> headerList = new ArrayList<Header>();
    static int novelPartNumber = 0;
    static int Index = 0;

    public static void addHeader() {
        headerList.add(new BasicHeader("User-Agent", "Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/110.0.0.0 Safari/537.36 Edg/110.0.1587.57"));
        headerList.add(new BasicHeader("user-agent", "Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/111.0.0.0 Safari/537.36 Edg/111.0.1661.54"));
        headerList.add(new BasicHeader("User-Agent", "Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/111.0.0.0 Safari/537.36 Edg/111.0.1661.62"));
    }

    public static void Part(String URL) throws Exception {
        //初始化RequestConfig
        RequestConfig requestConfig = RequestConfig.custom()
                .setSocketTimeout(10000)
                .setConnectTimeout(10000)
                .setConnectionRequestTimeout(10000)
                .build();
        //初始化HttpContext
        HttpContext localContext = new BasicHttpContext();
        String url = URL;
        if (!url.contains("#Catalog")) {
            url = url + "#Catalog";
        }
        //初始化HttpClient
        HttpClient httpClient = HttpClients.custom()
                .setDefaultHeaders(headerList)
                .setDefaultRequestConfig(requestConfig)
                .build();
        HttpGet httpGet = new HttpGet(url);
        //执行请求获取HttpResponse
        HttpResponse httpResponse = null;
        try {
            httpResponse = httpClient.execute(httpGet, localContext);
        } catch (IOException e) {
            e.printStackTrace();
        }
        //获取响应状态码
        int StatusCode = 0;
        if (httpResponse != null) {
            StatusCode = httpResponse.getStatusLine().getStatusCode();
        }
        if (StatusCode == HttpStatus.SC_OK) { //状态码200表示响应成功
            //获取实体内容
            HttpEntity entity = httpResponse.getEntity();
            //注意设置编码
            String entityString = EntityUtils.toString(entity, "gbk");
            //输出实体内容
            System.out.println(entityString);
            System.out.println("----------------------------------------------------");
            System.out.println("----------------------------------------------------");
            System.out.println("----------------------------------------------------");

            Document doc = Jsoup.parse(entityString);
            Elements NovelName = doc.select("div.book-info > h1 > em");
            System.out.println("小说名:" + NovelName.text());
            Elements link = doc.select("#j-catalogWrap > div > div:nth-child(1) > ul").select("a");
            System.out.println(link);
            System.out.println("----------------------------------------------------");
            System.out.println("----------------------------------------------------");
            System.out.println("----------------------------------------------------");

            for (Element linkElement : link) {
                novelPartNumber++;

                //获取章节名
                String novelTitle = linkElement.text();

                //获取章节URL
                Element links = linkElement.select("a").first();
                String novelUrl = "https:" + links.attr("href");

                novelName.add(novelTitle);
                novelURL.add(novelUrl);

                System.out.println(novelTitle);
                System.out.println(novelUrl);
            }
            System.out.println("共获取到" + novelPartNumber + "章");
            EntityUtils.consume(httpResponse.getEntity()); //消耗实体
        } else {
            //关闭HttpEntity的流实体
            if (httpResponse != null) {
                EntityUtils.consume(httpResponse.getEntity()); //消耗实体
            }
        }
    }

    public static void save(String url, String directory) throws IOException {
        Path p = Paths.get(directory);
        if (!Files.exists(p)) {
            Files.createDirectory(p);
        }
        // 通过Jsoup连接目标网址
        Document document = Jsoup.connect(url)
                .timeout(5000)
                .userAgent("Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/58.0.3029.110 Safari/537.3").get();
        // 获取小说内容
        StringBuilder contentBuilder = new StringBuilder();
        Elements elements = document.select("div.read-content > p");
        for (Element element : elements) {
            String s = element.text();
            s = s.replace("　　", "");
            contentBuilder.append(s).append("\n");
        }
        String content = contentBuilder.toString();
        // 将小说内容保存到txt文件
        System.out.println(novelName.get(Index));
        String fileName = directory + "/" + (Index+1) + "." + novelName.get(Index) + ".txt ";
        BufferedWriter writer = new BufferedWriter(new FileWriter(fileName));
        writer.write(novelName.get(Index) + "\n\n");
        writer.write(content);
        writer.close();
        Index++;
    }

    public static void saveALl(String directory) throws IOException {

        Scanner s = new Scanner(System.in);
        System.out.println("请输入你要爬取的章节数:");
        int num = s.nextInt();
        System.out.println("爬取中...");
        for (int i = 0; i < num; i++) {
            save(novelURL.get(i), directory);
        }
        System.out.println("爬取完成，目标保存在/小说/");
    }

    public static void main(String[] args) throws Exception {
        addHeader();

        String url = "https://book.qidian.com/info/1035835833/";
        Part(url);

        String directory = "小说";
        saveALl(directory);

    }
}
