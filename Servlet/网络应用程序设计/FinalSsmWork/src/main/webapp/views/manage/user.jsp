<%@ page contentType="text/html;charset=UTF-8" language="java" import="java.util.*" isELIgnored="false" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
    <title>User</title>
    <link rel="stylesheet" href="../../css/user.css" type="text/css"/>
</head>
<body>
<div>
    <h1>用户管理</h1>
</div>
<table>
    <tr>
        <th>序号</th>
        <th>ID</th>
        <th>姓名</th>
        <th>性别</th>
        <th>Email</th>
        <th>生日</th>
        <th>操作 &nbsp;&nbsp;
            <a href="addUser.do">
                <button>新增用户</button>
            </a>
            <a href="LoginOut.do">
                <button>返回登录</button>
            </a>
        </th>
    </tr>
    <c:set var="count" value="${1}" scope="page" />
    <c:forEach var="user" items="${users}" varStatus="loop">
        <c:if test="${count <= 10}">
            <tr>
                <td>${(currentPage - 1) * pageSize + loop.count}</td>
                <td>${user.uid}</td>
                <td>${user.uname}</td>
                <td>${user.gender}</td>
                <td>${user.email}</td>
                <td>${user.birthday}</td>
                <td>
                    <a href="modifyUserPage.do?uid=${user.uid}">
                        <button>修改</button>
                    </a>
                    <a href="delUser.do?uid=${user.uid}">
                        <button>删除</button>
                    </a>
                </td>
            </tr>
        </c:if>
        <c:set var="count" value="${count + 1}" scope="page" />
    </c:forEach>
</table>

<c:set var="currentPage" value="${param.page != null ? param.page : 1}" scope="page" />
<c:set var="pageSize" value="10" scope="page" />

<c:if test="${currentPage > 1}">
    <a href="?page=${currentPage - 1}"><button>上一页</button></a>
</c:if>
<c:if test="${currentPage * pageSize < count}">
    <a href="?page=${currentPage + 1}"><button>下一页</button></a>
</c:if>

</body>

</html>
