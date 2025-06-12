package cn.cjxy.config;

import com.alibaba.druid.pool.DruidDataSource;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

import javax.sql.DataSource;

@Configuration////标注为配置类层并注入ioc容器
@ComponentScan("cn.cjxy")//包扫描
@PropertySource("jdbc.properties")//加载文件
public class SpringConfig {
    @Value("${jdbc.username}") // 注入属性值
    private String username;
    @Value("${jdbc.password}")
    private String password;
    @Value("${jdbc.url}")
    private String url;
    @Value("${jdbc.driverClassName}")
    private String driverClassName;

    //配置
    @Bean//相当于bean标签
    public DataSource dataSource() {
        //得到连接对象
        DruidDataSource ds = new DruidDataSource();
        //将数据库需要的放进去
        ds.setUsername(username);
        ds.setPassword(password);
        ds.setUrl(url);
        ds.setDriverClassName(driverClassName);
        return ds;
    }
}
