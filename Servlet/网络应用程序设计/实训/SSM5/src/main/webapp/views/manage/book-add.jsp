<%--
  Created by IntelliJ IDEA.
  User: OYXP
  Date: 2023/5/10
  Time: 0:02
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <%@include file="../static/back-head.html" %>
    <title>Book-Add</title>
</head>
<body onload="getNowFormatDate()">
<div id="logo"><img src="../../images/logo.gif"></div>
<div id="header" class="wrap">
    <div class="help"><a href="index.do">返回前台页面</a></div>
    <div class="navbar">
        <ul class="bar">
            <li><a href="index.do">首页</a></li>
            <li><a href="manaUser.do">用户</a></li>
            <li class="current"><a href="manaBook.do">商品</a></li>
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
        <h2>新增商品</h2>
        <div class="manage">
            <form action="addBook" method="post" onsubmit="return validateInput()">
                <table class="form">
                    <tr>
                        <td class="field">书名：</td>
                        <td><input type="text" class="text" name="bookName" value=""/></td>
                    </tr>
                    <tr>
                        <td class="field">简介：</td>
                        <td><input type="text" class="text" name="detail" value=""/></td>
                    </tr>
                    <tr>
                        <td class="field">价格：</td>
                        <td><input type="text" class="text" name="price" value=""/></td>
                    </tr>
                    <tr>
                        <td class="field">作者：</td>
                        <td><input type="text" class="text" name="writer" value=""/></td>
                    </tr>
                    <tr>
                        <td class="field">出版社：</td>
                        <td><input type="text" class="text" name="printer" value=""/></td>
                    </tr>
                    <tr>
                        <td class="field">日期：</td>
                        <td><input type="date" class="text" name="date" value=""/></td>
                    </tr>
                    <tr>
                        <td class="field">类型：</td>
                        <td><input type="text" class="text" name="type" value=""/></td>
                    </tr>
                    <tr>
                        <td class="field">图片：</td>
                        <td><input type="text" class="text" name="image" value=""/></td>
                    </tr>
                    <tr>
                        <td class="field">库存：</td>
                        <td><input type="text" class="text" name="store" value=""/></td>
                    </tr>

                    <tr>
                        <td></td>
                        <td><input class="btn btn-info" type="submit" name="submit" value="添加"/></td>
                    </tr>
                </table>
            </form>
        </div>
    </div>

</div>
<div class="clear"></div>

<script>
    function validateInput() {
        var input = document.getElementsByName("store")[0].value;
        if (isNaN(input)) {
            alert("库存只能输入数字！");
            return false;
        }
        return true;
    }
</script>

<%@include file="../static/footer.html" %>
</body>
</html>

