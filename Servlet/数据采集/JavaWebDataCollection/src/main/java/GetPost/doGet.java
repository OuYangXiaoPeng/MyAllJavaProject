package GetPost;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.utils.URIBuilder;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;

public class doGet {

    public static void main(String[] args) throws Exception {
        HttpClient client = HttpClients.custom().build();

        URIBuilder uriBuilder = new URIBuilder("http://www.iqiyi.com/v_19rxtbha1k.html")
                .addParameter("r_area","pcw_rec_like").addParameter("r_source","565%40551%40137");

        HttpGet httpGet = new HttpGet(uriBuilder.build());

        HttpResponse response = client.execute(httpGet);
        if (response.getStatusLine().getStatusCode() == 200){
            HttpEntity entity = response.getEntity();

            System.out.println(EntityUtils.toString(entity,"utf-8"));

            EntityUtils.consume(entity);
        }else {
            System.out.println("code=="+response.getStatusLine().getStatusCode());
        }

    }
}
