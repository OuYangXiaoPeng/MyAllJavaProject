<%--
  Created by IntelliJ IDEA.
  User: OYXP
  Date: 2023/6/17
  Time: 10:23
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Person</title>
    <style>
        body {
            display: flex;
            flex-direction: column;
            align-items: center;
        }

        table {
            border-collapse: collapse;
            width: 80%;
            margin-top: 20px;
            font-size: 16px;
            text-align: center;
        }

        th, td {
            padding: 8px;
            border: 1px solid #ddd;
        }

        th {
            background-color: #f2f2f2;
        }
    </style>
</head>
<body>
<h1>2022年《财富》世界100强排行榜</h1>
<!-- 添加查询功能 -->
<form action="${pageContext.request.contextPath}/PersonServlet" method="get">
    <label>根据关键字：</label>
    <label>
        <input type="text" name="keyword" value="${keyword}"/>
    </label>
    <input type="submit" value="查询"/>
</form>

<table>
    <tr>
        <th>排名</th>
        <th>名称</th>
        <th>营业收入(百万美元)</th>
        <th>利润(百万美元)</th>
        <th>国家</th>
    </tr>
    <c:forEach var="person" items="${persons}">
        <tr>
            <td>${person.id}</td>
            <td>${person.name}</td>
            <td>${person.sales}</td>
            <td>${person.profit}</td>
            <td>${person.country}</td>
        </tr>
    </c:forEach>
</table>
</body>
</html>