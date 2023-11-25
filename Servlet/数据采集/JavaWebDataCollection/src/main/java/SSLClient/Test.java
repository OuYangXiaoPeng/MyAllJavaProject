package SSLClient;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.HttpStatus;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.util.EntityUtils;

public class Test {

    public static void main(String[] args) throws Exception {
        String url = "https://www.bilibili.com";

        SSLClient sslClient = new SSLClient();
        sslClient.initSSLClient("TLSv1.2"); // 使用TLSv1.2协议初始化HttpClient

        HttpClient httpClient = sslClient.getHttpClient();
        HttpGet httpGet = new HttpGet(url);

        HttpResponse httpResponse = httpClient.execute(httpGet);
        int statusCode = httpResponse.getStatusLine().getStatusCode();
        if (statusCode == HttpStatus.SC_OK) {
            HttpEntity entity = httpResponse.getEntity();
            if (entity != null) {
                String responseString = EntityUtils.toString(entity, "UTF-8");
                System.out.println(responseString);
            } else {
                System.out.println("Response contains no content");
            }
        } else {
            System.out.println("Request failed with status code " + statusCode);
        }
    }
}
