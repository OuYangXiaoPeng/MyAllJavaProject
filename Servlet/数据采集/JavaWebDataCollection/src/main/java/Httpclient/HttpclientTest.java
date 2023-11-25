package Httpclient;

import org.apache.http.*;
import org.apache.http.client.HttpClient;
import org.apache.http.client.config.CookieSpecs;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.message.BasicHeader;
import org.apache.http.protocol.BasicHttpContext;
import org.apache.http.protocol.HttpContext;
import org.apache.http.util.EntityUtils;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class HttpclientTest {

    static List<Header> headerList = new ArrayList<>();

    public static void addHeader() {
        headerList.add(new BasicHeader("User-Agent", "Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/110.0.0.0 Safari/537.36 Edg/110.0.1587.57"));
        headerList.add(new BasicHeader("user-agent", "Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/111.0.0.0 Safari/537.36 Edg/111.0.1661.54"));
        headerList.add(new BasicHeader("User-Agent", "Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/111.0.0.0 Safari/537.36 Edg/111.0.1661.62"));
    }

    public static void main(String[] args) throws ParseException, IOException {

        //初始化RequestConfig
        RequestConfig requestConfig = RequestConfig.custom()
                .setSocketTimeout(10000)
                .setConnectTimeout(10000)
                .setConnectionRequestTimeout(10000)
                .build();

        //初始化HttpContext
        HttpContext localContext = new BasicHttpContext();
        String url = "https://book.qidian.com/info/1025172188/#Catalog";
        //初始化HttpClient
        HttpClient httpClient = HttpClients.custom()
                .setDefaultHeaders(headerList)
                .setDefaultRequestConfig(requestConfig)
                .build();

        HttpGet httpGet = new HttpGet(url);
        httpGet.setHeader("User-Agent",
                "Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/111.0.0.0 Safari/537.36 Edg/111.0.1661.62");
        httpGet.setHeader("user-agent",
                "Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/111.0.0.0 Safari/537.36 Edg/111.0.1661.54");
        httpGet.setHeader("User-Agent",
                "Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/110.0.0.0 Safari/537.36 Edg/110.0.1587.57");

        //执行请求获取HttpResponse
        HttpResponse httpResponse = null;
        try {
            httpResponse = httpClient.execute(httpGet, localContext);
        } catch (IOException e) {
            e.printStackTrace();
        }
        //获取具体响应信息
        System.out.println("response:" + httpResponse);
        //响应状态
        String status = httpResponse.getStatusLine().toString();
        System.out.println("status:" + status);
        //获取响应状态码
        int StatusCode = httpResponse.getStatusLine().getStatusCode();
        System.out.println("StatusCode:" + StatusCode);
        ProtocolVersion protocolVersion = httpResponse.
                getProtocolVersion(); //协议的版本号
        System.out.println("protocolVersion:" + protocolVersion);
        //是否OK
        String phrase = httpResponse.getStatusLine().getReasonPhrase();
        System.out.println("phrase:" + phrase);
        Header[] headers = httpResponse.getAllHeaders();
        System.out.println("输出头信息为：");
        for (int i = 0; i < headers.length; i++) {
            System.out.println(headers[i]);
        }
        System.out.println("头信息输出结束");
        if (StatusCode == HttpStatus.SC_OK) { //状态码200表示响应成功
            //获取实体内容
            HttpEntity entity = httpResponse.getEntity();
            //注意设置编码
            String entityString = EntityUtils.toString(entity, "gbk");
            //输出实体内容
            System.out.println(entityString);
            EntityUtils.consume(httpResponse.getEntity()); //消耗实体
        } else {
            //关闭HttpEntity的流实体
            EntityUtils.consume(httpResponse.getEntity()); //消耗实体
        }
    }
}
