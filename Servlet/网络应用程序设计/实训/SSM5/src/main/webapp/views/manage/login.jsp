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
    <title>BOOK HOUSE后台管理系统登录界面</title>
    <meta name="viewport" content="width=device-width"/>
    <link href="../../css/base.css" rel="stylesheet" type="text/css"/>
    <link href="../../css/login.css" rel="stylesheet" type="text/css"/>
</head>
<body>

<div class="login">
    <form action="/backLogin.do" method="get">
        <div class="logo"></div>
        <div class="login_form">
            <div class="user">
                <input class="text_value" name="username" type="text" style="width: 245px;height: 50px"/>
                <input class="text_value" name="password" type="password" style="width: 245px;height: 50px"/>
            </div>
            <button class="button" id="submit" type="submit">登录</button>
        </div>

        <div id="tip"></div>

    </form>
</div>

</body>
</html>
