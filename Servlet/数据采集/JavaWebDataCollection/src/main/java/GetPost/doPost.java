package GetPost;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.client.HttpClient;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;

import java.util.ArrayList;
import java.util.List;

public class doPost {

    public static void main(String[] args) throws Exception {
        HttpClient client = HttpClients.custom().build();
        HttpPost post = new HttpPost("https://hz.zcloudsoft.cn:8443/api/person/login");

        List<NameValuePair> valuePairList = new ArrayList<>();
        valuePairList.add(new BasicNameValuePair("accounts","panli"));
        valuePairList.add(new BasicNameValuePair("password","123456"));
        post.setEntity(new UrlEncodedFormEntity(valuePairList,"UTF-8"));

        HttpResponse response = client.execute(post);
        if (response.getStatusLine().getStatusCode() == 200){
            HttpEntity entity = response.getEntity();

            System.out.println(EntityUtils.toString(entity,"utf-8"));

            EntityUtils.consume(entity);
        }else {
            System.out.println("code=="+response.getStatusLine().getStatusCode());
        }

    }

}
