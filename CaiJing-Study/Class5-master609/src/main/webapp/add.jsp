<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<!DOCTYPE html>
<html lang="zh-CN">
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>新增用户</title>

    <link href="/css/bootstrap.min.css" rel="stylesheet">
    <script src="/js/jquery-2.1.0.min.js"></script>
    <script src="/js/bootstrap.min.js"></script>
</head>
<body>
<div class="container">
    <center><h3>新增用户</h3></center>
    <form action="/user/save" method="post">
        <div class="form-group">
            <label for="username">姓名：</label>
            <input type="text" class="form-control" id="username" name="username" placeholder="请输入用户名">
        </div>


        <div class="form-group">
            <label for="password">密码：</label>
            <input type="password" class="form-control" id="password" name="password" placeholder="请输入密码">
        </div>


        <div class="form-group">
            <label for="birthday">出生年月：</label>
            <input type="date" class="form-control" id="birthday" name="birthday"/>
        </div>

        <div class="form-group">
            <label for="address">住址：</label>
            <input type="text" class="form-control" id="address" name="address" placeholder="请输入地址"/>
        </div>

        <div class="form-group" style="text-align: center">
            <input class="btn btn-primary" type="submit" value="提交" />
            <input class="btn btn-warning" type="reset" value="重置" />
            <a class="btn btn-default" href="/list.jsp">返回</a>
        </div>
    </form>
</div>
</body>
</html>