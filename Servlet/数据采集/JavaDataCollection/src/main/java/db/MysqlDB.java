package db;

public class MysqlDB {

    //配置连接mysql的url、用户名和密码
    String url = "jdbc:mysql://localhost:3306/classtest?useUnicode=true&characterEncoding=GBK&serverTimezone=UTC";
    String username = "root";
    String password = "123456";

    public String getUrl() {
        return url;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }
}
