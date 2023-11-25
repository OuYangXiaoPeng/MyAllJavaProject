package SSLClient;

import org.apache.http.HttpException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.config.AuthSchemes;
import org.apache.http.client.config.CookieSpecs;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.config.Registry;
import org.apache.http.config.RegistryBuilder;
import org.apache.http.conn.socket.ConnectionSocketFactory;
import org.apache.http.conn.socket.PlainConnectionSocketFactory;
import org.apache.http.conn.ssl.NoopHostnameVerifier;
import org.apache.http.conn.ssl.SSLConnectionSocketFactory;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.impl.conn.PoolingHttpClientConnectionManager;

import javax.net.ssl.SSLContext;
import javax.net.ssl.X509TrustManager;
import java.security.KeyManagementException;
import java.security.NoSuchAlgorithmException;
import java.security.cert.X509Certificate;
import java.util.Arrays;

public class SSLClient {

    private HttpClient httpClient;

    /**
     * 基于SSL配置HttpClient
     *
     * @param SSLProtocolVersion 可选项：SSL, SSLv3, TLS, TLSv1, TLSv1.1, TLSv1.2
     * @throws HttpException 初始化HttpClient失败时抛出异常
     */
    public void initSSLClient(String SSLProtocolVersion) throws HttpException {
        RequestConfig defaultConfig = null;
        PoolingHttpClientConnectionManager pcm = null;
        try {
            X509TrustManager xtm = new SSL509TrustManager(); //创建信任管理
            //创建SSLContext对象，并使用指定的信任管理器初始化
            SSLContext context = SSLContext.getInstance(SSLProtocolVersion);
            context.init(null, new X509TrustManager[]{xtm}, null);

            /*从SSLContext对象中得到SSLConnectionSocketFactory对象
             *NoopHostnameVerifier.INSTANCE表示接受任何有效的和符合目标主机的SSL会话
             */
            SSLConnectionSocketFactory sslConnectionSocketFactory = new SSLConnectionSocketFactory(context, NoopHostnameVerifier.INSTANCE);

            //设置全局请求配置，包括cookie规范
            defaultConfig = RequestConfig.custom()
                    .setCookieSpec(CookieSpecs.STANDARD_STRICT)
                    .setExpectContinueEnabled(true)
                    .setTargetPreferredAuthSchemes(Arrays.asList(AuthSchemes.NTLM, AuthSchemes.DIGEST))
                    .setProxyPreferredAuthSchemes(Arrays.asList(AuthSchemes.BASIC))
                    .build();

            // 注册http和https套接字工厂
            Registry<ConnectionSocketFactory> sfr = RegistryBuilder.<ConnectionSocketFactory>create()
                    .register("http", PlainConnectionSocketFactory.INSTANCE)
                    .register("https", sslConnectionSocketFactory)
                    .build();

            //基于sfr创建连接管理器
            pcm = new PoolingHttpClientConnectionManager(sfr);
            //基于连接管理器和配置，实例化HttpClient
            httpClient = HttpClients.custom()
                    .setConnectionManager(pcm)
                    .setDefaultRequestConfig(defaultConfig)
                    .build();
        } catch (NoSuchAlgorithmException | KeyManagementException e) {
            throw new HttpException("初始化HttpClient失败", e);
        }
    }

    /**
     * 获取已初始化的HttpClient对象
     *
     * @return HttpClient对象
     */
    public HttpClient getHttpClient() {
        return httpClient;
    }

    //实现X509TrustManager接口
    private static class SSL509TrustManager implements X509TrustManager {

        //检查客户端证书
        public void checkClientTrusted(X509Certificate[] x509Certificates, String s) {
            //do nothing 接受任意客户端证书
        }

        //检查服务器端证书
        public void checkServerTrusted(X509Certificate[] x509Certificates, String s) {
        //do nothing 接受任意服务器端证书
        }

        //返回受信任的X509证书数组
        public X509Certificate[] getAcceptedIssuers() {
            return new X509Certificate[0];
        }
    }
}