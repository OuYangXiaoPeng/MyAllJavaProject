package servlet;


import db.MysqlDB;
import model.Product;
import mySQLTest.DangDangNet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

@WebServlet(name = "Product", value = "/product")
public class ProductServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        //实例化MysqlDB对象
        MysqlDB mysqlDB = new MysqlDB();
        try {
            //加载驱动
            Class.forName("com.mysql.jdbc.Driver");
            // 连接MySQL数据库
            Connection conn = DriverManager.getConnection(
                    mysqlDB.getUrl(),
                    mysqlDB.getUsername(),
                    mysqlDB.getPassword());

            // 构造SQL查询语句
            String sql = "SELECT * FROM content";


            String field = request.getParameter("field"); // 获取用户选择的属性
            String keyword = request.getParameter("keyword"); // 获取用户输入的关键字
            //将关键字传回输入框
            request.setAttribute("keyword", keyword);


            String key = request.getParameter("key");
            if (key != null && !key.isEmpty()) {
                //实例化获取网页的对象，并调用其方法
                DangDangNet dangDangNet = new DangDangNet();
                dangDangNet.addHeader();//加入请求头
                dangDangNet.Content(key);//根据关键字获取网页内容
                dangDangNet.mySQL();//写入mysql数据库
//                dangDangNet.savePicture();//保存图片到本地
            }
            //将关键字传回输入框
            request.setAttribute("key", key);


            // 构建SQL查询语句
            if (field != null && !field.isEmpty() && keyword != null && !keyword.isEmpty()) {
                switch (field) {
                    case "name":
                        sql += " WHERE name LIKE ?";
                        keyword = "%" + keyword + "%";
                        break;
                    case "id":
                        sql += " WHERE id = ?";
                        break;
                    case "writer":
                        sql += " WHERE writer LIKE ?";
                        keyword = "%" + keyword + "%";
                        break;
                }
            }

            // 使用PreparedStatement防止SQL注入攻击
            PreparedStatement pstmt = conn.prepareStatement(sql);
            if (keyword != null && !keyword.isEmpty()) {
                pstmt.setString(1, keyword);
            }

            ResultSet rs = pstmt.executeQuery();
            // 将结果保存在一个Product对象列表中
            List<Product> products = new ArrayList<>();
            while (rs.next()) {
                int id = rs.getInt("id");
                String names = rs.getString("name");
                String writer = rs.getString("writer");
                double price = rs.getDouble("price");
                String image = rs.getString("image");
                String url = rs.getString("url");

                Product product = new Product(id, names, price, writer, image, url);
//                System.out.println(product);
                products.add(product);
            }
            rs.close();
            pstmt.close();
            conn.close();

            // 将产品列表设置为request属性
            request.setAttribute("products", products);

            // 转发到JSP页面进行显示
            request.getRequestDispatcher("products.jsp").forward(request, response);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        doGet(request, response);
    }

}