package mySQLTest;

import org.junit.Test;

import java.sql.*;

public class DangDangNetTest {

    //配置连接mysql的url、用户名和密码
    String url = "jdbc:mysql://localhost:3306/classtest?useUnicode=true&characterEncoding=utf8&useSSL=true";
    String username = "root";
    String password = "123456";

    //连接到mysql数据库
    java.sql.Connection con;
    {
        try {
            con = DriverManager.getConnection(url, username, password);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    //创建一个Statement对象，用来发送sql语句到数据库。例如：
    Statement stmt;
    {
        try {
            stmt = con.createStatement();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }


    @Test
    public void insert() throws Exception{
        //获取Content表格已有的记录总条数
        Statement stmt1 = con.createStatement();
        ResultSet rs = stmt1.executeQuery("SELECT COUNT(*) FROM Content;");
        rs.next();
        int count = rs.getInt(1);
        rs.close();
        stmt1.close();

        //创建一个预处理语句，插入数据到表的列中
        String Price = "¥155";
        String Names = "原神";
        String Writer ="米哈游";
        String Date = "2020.9";
        String Url = "https://www.yuanshen.com/#/";
        String Editor = "米哈游";
        PreparedStatement pstmt = con.prepareStatement("INSERT INTO content VALUES (?,?,?,?,?,?,?);");
        pstmt.setInt(1, count+1);
        pstmt.setString(2, Price);
        pstmt.setString(3, Names);
        pstmt.setString(4, Writer);
        pstmt.setString(5, Date);
        pstmt.setString(6, Url);
        pstmt.setString(7, Editor);
        pstmt.executeUpdate(); //执行插入操作

        //关闭
        pstmt.close();
        stmt.close();
        con.close();
        System.out.println("插入成功!");
    }

    @Test
    public void delete() throws Exception {
        //使用预处理语句删除Content表格中指定name的图书信息
        String name = "原神";
        PreparedStatement pstmt = con.prepareStatement("DELETE FROM content WHERE name=?;");
        pstmt.setString(1, name);
        pstmt.executeUpdate(); //执行删除操作

        //关闭
        pstmt.close();
        stmt.close();
        con.close();
        System.out.println("删除成功!");
    }

    @Test
    public void update() throws Exception {
        //使用预处理语句修改Content表格中指定name的图书价格为60元
        String price = "¥100";
        String name = "原神";
        PreparedStatement pstmt = con.prepareStatement("UPDATE content SET price=? WHERE name=?;");
        pstmt.setString(1, price);
        pstmt.setString(2, name);
        pstmt.executeUpdate(); //执行更新操作

        //关闭
        pstmt.close();
        stmt.close();
        con.close();
        System.out.println("更新成功!");
    }

    @Test
    public void selectAll() throws Exception {
        //使用Statement对象查询Content表格中所有图书信息，并将其打印出来
        String sql = "SELECT * FROM content;";
        java.sql.ResultSet rs = stmt.executeQuery(sql); //执行查询操作
        while (rs.next()) {
            int id = rs.getInt("id");
            String price = rs.getString("price");
            String name = rs.getString("name");
            String writer = rs.getString("writer");
            String date = rs.getString("date");
            String url = rs.getString("url");
            String editor = rs.getString("editor");
            System.out.println("id: " + id + ", price: " + price + ", name: " + name + ", writer: " + writer +
                    ", date: " + date + ", url: " + url + ", editor: " + editor);
        }

        //关闭
        stmt.close();
        con.close();
    }


}
