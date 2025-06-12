<%@ page language="java" import="java.util.*" pageEncoding="UTF-8" isELIgnored="false" %>
<!DOCTYPE html>
<html lang="zh-CN">
<head>
    <meta charset="utf-8"/>
    <meta http-equiv="X-UA-Compatible" content="IE=edge"/>
    <meta name="viewport" content="width=device-width, initial-scale=1"/>
    <title>用户登录</title>

    <link href="/css/bootstrap.min.css" rel="stylesheet">
    <script src="/js/jquery-2.1.0.min.js"></script>
    <script src="/js/bootstrap.min.js"></script>
    <script type="text/javascript">
    </script>
</head>
<body>
<div class="container" style="width: 400px;">
    <h3 style="text-align: center;">用户登录</h3>
    <%-- 提交的路径--%>
    <form action="/user/login" method="post">
        <div class="form-group">
            <label for="user">用户名：</label>
            <input type="text" name="username" class="form-control" id="user" placeholder="请输入用户名"/>
        </div>

        <div class="form-group">
            <label for="password">密码：</label>
            <input type="password" name="password" class="form-control" id="password" placeholder="请输入密码"/>
        </div>

        <div class="form-inline">
            <label for="code">验证码：</label>
            <input type="text" name="checkCode"
                   class="form-control" id="verifycode"
                   placeholder="请输入验证码" style="width: 120px;"/>
            <a onclick="document.getElementById('code').src='/checkCode.jsp?v='+Math.random()">
                <img src="/checkCode.jsp" title="看不清点击刷新" id="code"/>
            </a>
        </div>
        <h4 style="color: red">${error}</h4>
        <hr/>
        <div class="form-group" style="text-align: center;">
            <input class="btn btn-primary" type="submit" value="登录">
            <input class="btn btn-warning" type="reset" value="重置">
        </div>
    </form>
    <div class="form-group" style="text-align: center;">
        <a href="add.jsp">没有用户？注册一个</a>
    </div>

</div>
</body>
</html>