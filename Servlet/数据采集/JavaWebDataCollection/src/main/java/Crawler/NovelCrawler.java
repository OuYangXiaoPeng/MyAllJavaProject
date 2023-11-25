package Crawler;

//导入jsoup包

import org.jsoup.Connection;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class NovelCrawler {

    //定义一个字符串集合保存几本小说链接
    ArrayList<String> novelURL = new ArrayList<>();
    //定义一个字符串集合保存几本小说名字
    ArrayList<String> novelNAME = new ArrayList<>();
    //小说名
    String novelName;
    //获取的小说url
    String Nurl;
    //小说目录页数
    int page = 1;
    //记录小数的章节数
    int num = 0;
    //小说章节
    ArrayList<String> novelParts = new ArrayList<>();
    //小说章节url
    ArrayList<String> novelPartsUrl = new ArrayList<>();
    //用于保存多个请求头
    Map<String, String> headers = new HashMap<>();

    public void addHeader() {
        headers.put("User-Agent", "Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/110.0.0.0 Safari/537.36 Edg/110.0.1587.57");
        headers.put("user-agent", "Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/111.0.0.0 Safari/537.36 Edg/111.0.1661.54");
    }

    public void AllNovel() throws IOException {
        System.out.println("正在获取主页小说中...");
        //定义要爬取的小说网站的URL
        String url = "https://www.bbiquge.net/";

        //使用Jsoup连接网站并获取文档对象
        Connection doc = Jsoup.connect(url).headers(headers).timeout(12 * 1000);
        Document doce = doc.get();
//        System.out.println(doce.html());


        //使用选择器获取所有小说的链接元素
        Elements novelLinks = doce.select("div.pic > a");
//        System.out.println(novelLinks);
//        System.out.println();

        //遍历每个链接元素
        for (Element novelLink : novelLinks) {
            //获取小说的标题和URL
            String novelTitle = novelLink.select("a[title]").attr("title");
            String novelUrl = novelLink.attr("abs:href");
            novelNAME.add(novelTitle);
            novelURL.add(novelUrl);

            //打印小说的标题和URL
//            System.out.println(novelTitle + ": " + novelUrl);
        }

    }

    public void novelSelect() {
        System.out.println("请选择你要爬取的小说:(输入编号)");
        int index = 1;
        for (Object o : novelNAME) {
            System.out.println(index + ":" + o);
            index++;
        }
        Scanner s = new Scanner(System.in);
        int st = s.nextInt();
        System.out.println("正在获取小说目录获取...");
        novelName = novelNAME.get(st - 1);
        String url = novelURL.get(st - 1);
        Nurl = url;
    }

    public void NovelPart(String url) throws Exception {
        Connection novelDoce = Jsoup.connect(url).headers(headers);
        Document novelDoc = novelDoce.get();
//        System.out.println(novelDoc);


        //使用选择器获取所有章节的链接元素
        Elements chapterLinks = novelDoc.select("div.zjbox > dl > dd > a");
        for (Element chapterLink : chapterLinks) {
            num++;
            String part = chapterLink.text();
            String partUrl = chapterLink.attr("abs:href");
            novelParts.add(part);
            novelPartsUrl.add(partUrl);
            System.out.println(part);
        }

        String nextPage = Nurl;
        Elements chapterNext = novelDoc.select("body > div.zjbox > div > span:nth-child(3) > a");
        String partNext = chapterNext.attr("abs:href");
        if (!partNext.equals("javascript:")) {
            page++;
            nextPage = nextPage + "index_" + page + ".html";
//            System.out.println(nextPage);
            NovelPart(nextPage);
        } else {
            System.out.println("小说目录获取成功！");
        }
    }

    public void NovelContent() throws Exception {
        System.out.println("共获取了" + num + "章，请输入要爬取的章节数:");
        Scanner scanner = new Scanner(System.in);
        int num = scanner.nextInt();

        System.out.println("正在爬取中,请稍后...");

        String pathname = "." + novelName;
        Path p = Paths.get(pathname);
        if (!Files.exists(p)) {
            Files.createDirectory(p);
        }

        int node = 0;
        for (String o : novelPartsUrl) {

            Connection novelDoce = Jsoup.connect(o).headers(headers).timeout(12 * 1000);
            Document novelDoc = novelDoce.get();
//        System.out.println(novelDoc);


            Elements chapter = novelDoc.select("div#content");
            String chapterContent = chapter.text();
            String ch = "笔趣阁 www.bbiquge.net，最快更新" + novelName + "最新章节！";
            chapterContent = chapterContent.replace(ch, "");
//            System.out.println(chapterContent);


            //使用FileWriter创建文件并写入文件
            String filename = pathname + "/" + novelParts.get(node) + ".txt";
            FileWriter fileWriter = new FileWriter(filename);

            //写入章节名
            fileWriter.write(novelParts.get(node));
            System.out.println(novelParts.get(node));

            //写入每章内容，并换行
            System.out.println(chapterContent);
            for (int i = 0; i < chapterContent.length(); i++) {
                if (i == 1) {
                    fileWriter.write("    ");
                }
                fileWriter.write(chapterContent.charAt(i));
                if (i % 70 == 0) {
                    fileWriter.write("\n");
                }
            }
            fileWriter.close();

            node++;

            if (node == num) {
                System.out.println("爬取成功！！！");
                System.exit(0);
            }
        }
    }


    public static void main(String[] args) throws Exception {

        NovelCrawler novelCrawler = new NovelCrawler();

        //加入请求头
        novelCrawler.addHeader();

        //获取首页12本小说
        novelCrawler.AllNovel();

        //选择小说，并获取其目录
        novelCrawler.novelSelect();

        //获取小说目录内容
        novelCrawler.NovelPart(novelCrawler.Nurl);

        //获取小说内容并写入到txt文件中
        novelCrawler.NovelContent();

//        Connection novelDoce = Jsoup.connect("https://www.bbiquge.net/book/133303/index_26.html");
//        Document novelDoc = novelDoce.header("User-Agent", "Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/110.0.0.0 Safari/537.36 Edg/110.0.1587.57").get();
//        Elements chapterNext = novelDoc.select("body > div.zjbox > div > span:nth-child(3) > a");
//        String partNext = chapterNext.attr("abs:href");
//        System.out.println(partNext);

    }
}
