<%--
  Created by IntelliJ IDEA.
  User: OYXP
  Date: 2023/6/8
  Time: 10:52
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Product List</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}beautify.css">
</head>
<body>
<h1>Product List</h1>

<div id="container">
    <div style="display:inline-flex">
        <form method="get" action="${pageContext.request.contextPath}/product">
            <label for="key">
                <a href="https://www.dangdang.com/" target="_blank">当当网</a>搜索:
            </label>
            <input type="text" name="key" id="key" value="${key}">
            <input type="submit" value="搜索">
        </form>
        &nbsp;&nbsp;&nbsp;&nbsp;
        <form method="get" action="${pageContext.request.contextPath}/product">
            <label for="keyword">关键字:</label>
            <select name="field" id="field">
                <option value="name">Name</option>
                <option value="id">ID</option>
                <option value="writer">Writer</option>
            </select>
            <input type="text" name="keyword" id="keyword" value="${keyword}">
            <input type="submit" value="搜索" id="search">
        </form>
    </div>
</div>


<table border="1">
    <tr>
        <th>ID</th>
        <th>Image</th>
        <th>Price</th>
        <th>Name</th>
        <th>Writer</th>
    </tr>

    <c:forEach var="product" items="${products}">
        <tr>
            <td>${product.id}</td>
            <td><img src=${product.image} width="100" alt=""></td>
            <td><fmt:formatNumber type="currency" value="${product.price}"/></td>
            <td><a href="${product.url}" target="_blank">${product.name}</a></td>
            <td>${product.writer}</td>
        </tr>
    </c:forEach>
</table>
</body>


<script>
    // 获取上次选择的值
    var lastSelected = localStorage.getItem('lastSelected');
    // 设置默认选项
    if (lastSelected != null) {
        document.getElementById('field').value = lastSelected;
    }
    // 监听选择事件，保存选项到缓存
    document.getElementById('field').addEventListener('change', function () {
        localStorage.setItem('lastSelected', this.value);
    });
</script>

</html>
