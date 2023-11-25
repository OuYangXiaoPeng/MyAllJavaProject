<%--
  Created by IntelliJ IDEA.
  User: OYXP
  Date: 2023/5/6
  Time: 14:18
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<html>
<head>
    <%@include file="../static/back-head.html" %>
    <title>index</title>
</head>
<body onload="getNowFormatDate()">
<div id="logo"><img src="../../images/logo.gif"></div>
<div id="header" class="wrap">
    <div class="help"><a href="index.do">返回前台页面</a></div>
    <div class="navbar">
        <ul class="bar">
            <li class="current"><a href="mana.do">首页</a></li>
            <li><a href="manaUser.do">用户</a></li>
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
        <h2>管理页面</h2>
        <div id="welcome" class="manage">
            <div class="shadow">
                <em class="corner lb"></em>
                <em class="corner rt"></em>
                <div class="box">
                    <div class="msg">
                        <p>欢迎回来</p>
                    </div>
                </div>
            </div>
        </div>
    </div>
    <div class="clear"></div>
</div>

<%@include file="../static/footer.html" %>
</body>
</html>
