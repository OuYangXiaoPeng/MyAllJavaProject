<%--
  Created by IntelliJ IDEA.
  User: OYXP
  Date: 2023/5/8
  Time: 10:42
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" import="java.util.*" isELIgnored="false" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
    <%@include file="../static/back-head.html" %>
    <title>User</title>
</head>
<body onload="getNowFormatDate()">
<div id="logo"><img src="../../images/logo.gif"></div>
<div id="header" class="wrap">
    <div class="help"><a href="index.do">返回前台页面</a></div>
    <div class="navbar">
        <ul class="bar">
            <li><a href="index.do">首页</a></li>
            <li class="current"><a href="manaUser.do">用户</a></li>
            <li><a href="manaBook.do">商品</a></li>
            <li><a href="manaBookOrder.do">订单</a></li>

        </ul>
    </div>
</div>
<div id="childNav">
    <div class="welcome wrap">
        管理员你好，今天是<span id="time"></span>，欢迎回到管理后台。
    </div>
</div>

<div id="main" class="wrap">
    <div id="menu-mng" class="lefter">
        <div class="box">
            <dl>
                <dt>用户管理</dt>
                <dd><em><a href="addUserPage.do">新增</a> </em><a href="manaUser.do">用户管理</a></dd>
                <dt>商品管理</dt>
                <dd><em><a href="addBookPage.do">新增</a> </em><a href="manaBook.do">商品管理</a></dd>
                <dt>订单管理</dt>
                <dd><em><a href="addBookOrderPage.do">新增(暂定)</a> </em><a href="manaBookOrder.do">订单管理</a></dd>
            </dl>
        </div>
    </div>
    <div class="main">
        <h2>用户管理</h2>
        <div class="manage">
            <table class="table table-hover">
                <tr class="active">
                    <th>ID</th>
                    <th>姓名</th>
                    <th>性别</th>
                    <th>Email</th>
                    <th>手机</th>
                    <th>操作</th>
                </tr>
                <c:forEach var="user" items="${users}">
                    <tr>
                        <td class="first w4 c">${user.uid}</td>
                        <td class="w1 c">${user.uname}</td>
                        <td class="w2 c">${user.gender}</td>
                        <td>${user.email}</td>
                        <td class="w4 c">${user.phone}</td>
                        <td class="w1 c"><a href="modifyUserPage.do?uid=${user.uid}">修改</a>
                            <a href="delUser.do?uid=${user.uid}">删除</a></td>
                    </tr>
                </c:forEach>

            </table>
            <div class="pager">
                <ul class="clearfix">
                    <c:choose>
                        <c:when test="${pageInfo.hasPreviousPage}">
                            <li><a href="manaUser.do?pageNum=1">首页</a></li>
                            <li><a href="manaUser.do?pageNum=${pageInfo.prePage}">上一页</a></li>
                        </c:when>
                        <c:otherwise>
                            <li><span>首页</span></li>
                            <li><span>上一页</span></li>
                        </c:otherwise>
                    </c:choose>

                    <c:forEach var="index" begin="1" end="${pageInfo.pages}">
                        <li <c:if test="${index==pageInfo.pageNum}">class="current"</c:if>>
                            <a href="manaUser.do?pageNum=${index}">${index}</a>
                        </li>
                    </c:forEach>

                    <c:choose>
                        <c:when test="${pageInfo.hasNextPage}">
                            <li><a href="manaUser.do?pageNum=${pageInfo.nextPage}">下一页</a></li>
                            <li><a href="manaUser.do?pageNum=${pageInfo.pages}">尾页</a></li>
                        </c:when>
                    </c:choose>
                    <%--                    <c:otherwise>--%>
                    <%--                        <li><span>下一页</span></li>--%>
                    <%--                        <li><span>尾页</span></li>--%>
                    <%--                    </c:otherwise>--%>
                </ul>
            </div>
        </div>
    </div>

    <div class="clear"></div>
</div>
<%@include file="../static/footer.html" %>
</body>
</html>
