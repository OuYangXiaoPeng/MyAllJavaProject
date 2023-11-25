<%--
  Created by IntelliJ IDEA.
  User: OYXP
  Date: 2023/5/10
  Time: 21:38
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" import="java.util.*" isELIgnored="false" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
    <%@include file="../static/back-head.html" %>
    <title>BookOrder</title>
</head>
<body onload="getNowFormatDate()">
<div id="logo"><img src="../../images/logo.gif"></div>
<div id="header" class="wrap">
    <div class="help"><a href="index.do">返回前台页面</a></div>
    <div class="navbar">
        <ul class="bar">
            <li><a href="index.do">首页</a></li>
            <li><a href="manaUser.do">用户</a></li>
            <li><a href="manaBook.do">商品</a></li>
            <li class="current"><a href="manaBookOrder.do">订单</a></li>

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
        <h2>订单管理</h2>
        <div class="manage">
            <table class="table table-hover">
                <tr class="active">
                    <th>商品ID</th>
                    <th>日期</th>
                    <th>用户名</th>
                    <th>地址</th>
                    <th>状态</th>
                    <th>用户ID</th>
                    <th>操作</th>
                </tr>
                <c:forEach var="bookorder" items="${bookOrders}">
                    <tr>
                        <td class="first w4 c">${bookorder.oid}</td>
                        <td>${bookorder.date}</td>
                        <td>${bookorder.oname}</td>
                        <td>${bookorder.address}</td>
                        <td>${bookorder.status}</td>
                        <td class="w4 c">${bookorder.uid}</td>
                        <td class="w1 c"><a href="modifyBookOrderPage.do?oid=${bookorder.uid}">修改</a>
                            <a href="delBookOrder.do?oid=${bookorder.uid}">删除</a></td>
                    </tr>
                </c:forEach>

            </table>
            <div class="pager">
                <ul class="clearfix">
                    <c:choose>
                        <c:when test="${pageInfo.hasPreviousPage}">
                            <li><a href="manaBookOrder.do?pageNum=1">首页</a></li>
                            <li><a href="manaBookOrder.do?pageNum=${pageInfo.prePage}">上一页</a></li>
                        </c:when>
                        <c:otherwise>
                            <li><span>首页</span></li>
                            <li><span>上一页</span></li>
                        </c:otherwise>
                    </c:choose>

                    <c:forEach var="index" begin="1" end="${pageInfo.pages}">
                        <li <c:if test="${index==pageInfo.pageNum}">class="current"</c:if>>
                            <a href="manaBookOrder.do?pageNum=${index}">${index}</a>
                        </li>
                    </c:forEach>

                    <c:choose>
                        <c:when test="${pageInfo.hasNextPage}">
                            <li><a href="manaBookOrder.do?pageNum=${pageInfo.nextPage}">下一页</a></li>
                            <li><a href="manaBookOrder.do?pageNum=${pageInfo.pages}">尾页</a></li>
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
