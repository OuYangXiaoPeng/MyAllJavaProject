package Httpclient;

import org.apache.http.Header;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpRequestRetryHandler;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.message.BasicHeader;
import org.apache.http.util.EntityUtils;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class HttpclientDownloadFile {

    static List<Header> headersList = new ArrayList<>();

    public static void addHeader() {
        headersList.add(new BasicHeader("User-Agent", "Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/110.0.0.0 Safari/537.36 Edg/110.0.1587.57"));
        headersList.add(new BasicHeader("user-agent", "Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/111.0.0.0 Safari/537.36 Edg/111.0.1661.54"));
        headersList.add(new BasicHeader("User-Agent", "Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/111.0.0.0 Safari/537.36 Edg/111.0.1661.62"));
    }

    public static void main(String[] args) throws IOException {
        addHeader();

        //初始化RequestConfig
        RequestConfig requestConfig = RequestConfig.custom()
                .setSocketTimeout(10000)
                .setConnectTimeout(10000)
                .setConnectionRequestTimeout(10000)
                .build();
        //jdk-20下载
        String url = "https://download.oracle.com/java/20/latest/jdk-20_linux-x64_bin.tar.gz";
        //初始化HttpClient
        HttpClient httpClient = HttpClients.custom()
                .setDefaultRequestConfig(requestConfig)
                .setRetryHandler(new DefaultHttpRequestRetryHandler())//默认重试3次
                .setRetryHandler(new DefaultHttpRequestRetryHandler(5, true))//自定义5次
                .setDefaultHeaders(headersList)
                .build();

        HttpGet httpGet = new HttpGet(url);
        httpGet.setHeader("User-Agent",
                "Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/111.0.0.0 Safari/537.36 Edg/111.0.1661.62");
        httpGet.setHeader("user-agent",
                "Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/111.0.0.0 Safari/537.36 Edg/111.0.1661.54");
        httpGet.setHeader("User-Agent",
                "Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/110.0.0.0 Safari/537.36 Edg/110.0.1587.57");
        //获取结果
        HttpResponse httpResponse = null;
        try {
            httpResponse = httpClient.execute(httpGet);
        } catch (IOException e) {
            e.printStackTrace();
        }
        //下载文件的方法
        if (httpResponse != null && httpResponse.getStatusLine().getStatusCode() == 200) {
            System.out.println(httpResponse.getStatusLine().getStatusCode());
            String directory = "src/main/Downloader";
            Path p = Paths.get(directory);
            if (!Files.exists(p)) {
                Files.createDirectory(p);
            }
            OutputStream out = new FileOutputStream("src/main/Downloader/jdk-20_linux-x64_bin.tar.gz");
            System.out.println("正在下载中...");
            httpResponse.getEntity().writeTo(out);
            System.out.println("下载成功！");
            EntityUtils.consume(httpResponse.getEntity()); //消耗实体
        }
    }
}
