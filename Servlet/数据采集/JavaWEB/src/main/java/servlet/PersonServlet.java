package servlet;

import mode.Person;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

@WebServlet("/PersonServlet")
public class PersonServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        // 建立数据库连接
        String url = "jdbc:mysql://localhost:3306/mydatabase?useSSL=false&characterEncoding=utf8";
        String user = "root";
        String password = "123456";
        Connection conn = null;
        PreparedStatement stmt = null;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            conn = DriverManager.getConnection(url, user, password);

            // 构建查询语句
            String keyword = request.getParameter("keyword");
            String sql = "SELECT * FROM person";
            if (keyword != null && !keyword.trim().isEmpty()) {
                sql += " WHERE name LIKE ? OR id LIKE ? OR country LIKE ?";
            }
            request.setAttribute("keyword", keyword);

            // 使用PreparedStatement防止SQL注入攻击
            PreparedStatement pstmt = conn.prepareStatement(sql);
            if (keyword != null && !keyword.isEmpty()) {
                pstmt.setString(1, "%" + keyword + "%"); // 第一个占位符表示name
                pstmt.setString(2, "%" + keyword + "%"); // 第二个占位符表示id
                pstmt.setString(3, "%" + keyword + "%"); // 第三个占位符表示country
            }
            ResultSet rs = pstmt.executeQuery();

            // 将数据封装到List中
            List<Person> persons = new ArrayList<>();
            while (rs.next()) {
                int id = rs.getInt("id");
                String name = rs.getString("name");
                String sales = rs.getString("sales");
                String profit = rs.getString("profit");
                String country = rs.getString("country");
//                System.out.println(persons);
                persons.add(new Person(id, name, sales, profit, country));
            }

            // 将数据传递到页面
            request.setAttribute("persons", persons);
            request.getRequestDispatcher("person.jsp").forward(request, response);

            rs.close();
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        } finally {
            // 关闭数据库连接
            try {
                if (stmt != null) {
                    stmt.close();
                }
                if (conn != null) {
                    conn.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        doGet(request, response);
    }
}