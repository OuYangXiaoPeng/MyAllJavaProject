<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" isELIgnored="false" %>
<%@ taglib uri="http://java.sun.com/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>用户列表</title>
    <style>
        table {
            border-collapse: collapse;
            width: 80%;
            margin: 20px auto;
        }
        th, td {
            border: 1px solid #ddd;
            padding: 8px;
            text-align: left;
        }
        th {
            background-color: #f2f2f2;
        }
        .action-btn {
            margin-right: 5px;
        }
        .add-btn {
            display: block;
            width: 100px;
            margin: 20px auto;
            text-align: center;
            padding: 8px;
            background-color: #4CAF50;
            color: white;
            text-decoration: none;
            border-radius: 4px;
        }
    </style>
</head>
<body>
<h2 align="center">用户列表</h2>

<a href="addUser.jsp" class="add-btn">添加用户</a>

<table>
    <tr>
        <th>ID</th>
        <th>用户名</th>
        <th>生日</th>
        <th>性别</th>
        <th>地址</th>
        <th>操作</th>
    </tr>
    <c:forEach items="${userList}" var="user">
        <tr>
            <td>${user.id}</td>
            <td>${user.username}</td>
            <td>
                <fmt:formatDate value="${user.birthday}" pattern="yyyy-MM-dd" />
            </td>
            <td>${user.sex}</td>
            <td>${user.address}</td>
            <td>
                <a href="editUser.jsp?id=${user.id}" class="action-btn">修改</a>
                <a href="deleteUser?id=${user.id}" onclick="return confirm('确定要删除吗?')" class="action-btn">删除</a>
            </td>
        </tr>
    </c:forEach>
</table>
</body>
</html>