<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@ page import="java.sql.*" %>
<!DOCTYPE html>
<html>
<link rel="stylesheet" href="css/style.css">
<head>
    <meta charset="UTF-8">
    <title>房屋查询</title>
</head>
<body>
<h1>房屋查询</h1>
<form method="get" action="">
    <label for="keyword">请输入城市关键词：</label>
    <input type="text" id="keyword" name="keyword">
    <button type="submit">查询</button>
</form>
<hr>
<table border="1">
    <tr>
        <th>ID</th>
        <th>城市</th>
        <th>标题</th>
        <th>价格</th>
        <th>位置</th>
        <th>链接</th>
    </tr>
    <%
        String keyword = request.getParameter("keyword");
        if (keyword == null) {
            keyword = "";
        }
        // 数据库连接参数
        String url = "jdbc:mysql://localhost:3306/crawler";

        String username = "root";
        String password = "123456";

        // 查询语句
        String selectSql = "SELECT * FROM house WHERE title LIKE ?";
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            try {
                Class.forName("com.mysql.cj.jdbc.Driver");
            } catch (ClassNotFoundException e) {
                throw new RuntimeException(e);
            }
            conn = DriverManager.getConnection(url, username, password);
            ps = conn.prepareStatement(selectSql);
            // 设置占位符参数
            ps.setString(1, "%" + keyword + "%");
            rs = ps.executeQuery();
            // 遍历查询结果，将结果渲染到表格中
            while (rs.next()) {
                int id = rs.getInt("id");
                String city = rs.getString("city");
                String title = rs.getString("title");
                String price = rs.getString("price");
                String location = rs.getString("location");
                String img_url = rs.getString("img_url");
    %>
    <tr>
        <td><%= id %></td>
        <td><%= city %></td>
        <td><%= title %></td>
        <td><%= price %></td>
        <td><%= location %></td>
        <td><a href="<%= img_url %>" target="_blank"><%= img_url %></a></td>
    </tr>
    <%
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            // 关闭连接
            try {
                if (rs != null) {
                    rs.close();
                }
                if (ps != null) {
                    ps.close();
                }
                if (conn != null) {
                    conn.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    %>
</table>
</body>
</html>
