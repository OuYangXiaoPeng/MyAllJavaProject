<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<!DOCTYPE html>
<html lang="zh-CN">
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <title>用户列表</title>

    <link href="/css/bootstrap.min.css" rel="stylesheet">
    <script src="/js/jquery-2.1.0.min.js"></script>
    <script src="/js/bootstrap.min.js"></script>
    <style type="text/css">
        td, th {
            text-align: center;
        }
    </style>
</head>
<body>
<div class="container">
    <h3 style="text-align: center">用户列表</h3>
    <form action="/user/xxxxx">
        <input type="text" class="form-control" id="username" name="username" placeholder="请输入用户名">
        <input type="text" class="form-control" id="addresss" name="addresss" placeholder="请输入地址">
        <input type="submit" value="搜索">
    </form>
    <table border="1" class="table table-bordered table-hover">
        <tr style="background-color:rgb(51, 122, 183);">
            <th style="color:white">ID</th>
            <th style="color:white">用户名</th>
            <th style="color:white">密码</th>
            <th style="color:white">生日</th>
            <th style="color:white">住址</th>
            <th style="color:white">操作</th>
        </tr>
        <%-- 遍历数组取值--%>
        <c:forEach items="${userList}" var="user">
        <tr>
            <td>${user.id}</td>
            <td>${user.username}</td>
            <td>${user.password}</td>
            <td>
                   <fmt:formatDate value="${user.birthday}" pattern="yyyy-MM-dd" />
            </td>
            <td>${user.address}</td>
            <td>
                <a class="btn btn-info btn-sm" href="/user/findById?id=${user.id}"><i class="glyphicon glyphicon-pencil"></i>修改</a>
                <a class="btn btn-danger btn-sm" href="/user/delete?id=${user.id}"><i class="glyphicon glyphicon-remove"></i>删除</a>
            </td>
        </tr>

        </c:forEach>
        <tr>
            <td colspan="8" align="center">
                <a class="btn btn-success" href="/add.jsp"><i class="glyphicon glyphicon-plus"></i>新增用户</a>
            </td>
        </tr>

    </table>
</div>
</body>
</html>
