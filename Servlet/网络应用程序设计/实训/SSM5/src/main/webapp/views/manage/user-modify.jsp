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
        <h2>修改用户</h2>
        <div class="manage">
            <form action="modifyUser.do">
                <input type="hidden" class="text" name="uid" value="${user.uid}"/>
                <table class="form">
                    <tr>
                        <td class="field">用户名：</td>
                        <td><input type="text" class="text" name="uname" value="${user.uname}" readonly="readonly"/>
                        </td>
                    </tr>
                    <tr>
                        <td class="field">密码：</td>
                        <td><input type="password" class="text" name="password" value="${user.password}"></td>
                    </tr>
                    <tr>
                        <td class="field">性别：</td>
                        <td>
                            <input type="radio" name="gender" value="男"
                                   <c:if test="${user.gender=='男'}">checked="checked" </c:if>/>男
                            <input type="radio" name="gender" value="女"
                                   <c:if test="${user.gender=='女'}">checked="checked" </c:if>/>女
                        </td>
                    </tr>
                    <tr>
                        <td class="field">邮箱：</td>
                        <td><input type="text" class="text" name="email" value="${user.email}"></td>
                    </tr>
                    <tr>
                        <td class="field">手机号码：</td>
                        <td><input type="text" class="text" name="phone" value="${user.phone}"></td>
                    </tr>
                    <tr>
                        <td class="field">送货地址：</td>
                        <td><input type="text" class="text" name="address" value="${user.address}"></td>
                    </tr>

                    <tr>
                        <td></td>
                        <td><input class="btn btn-info" type="submit" name="submit" value="更新"/></td>
                    </tr>
                </table>
            </form>
        </div>
    </div>

</div>
<div class="clear"></div>
</div>
<%@include file="../static/footer.html" %>
</body>
</html>
