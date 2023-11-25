
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>登录页面</title>
    <link rel="stylesheet" href="../../css/login.css" type="text/css"/>
</head>
<body>
<h1>用户登录</h1>
<div class="form-container">
    <form method="post" action="backLogin.do">
        <label for="user">用户名</label>
        <input type="text" name="username" id="user" value="${user.uname}"/>
        <label for="password">密码</label>
        <input type="password" name="password" id="password" value="${user.password}"/>
        <div class="button-container">
            <button type="submit">登录</button>
            <button type="submit" formaction="/Register.do">注册</button>
        </div>
    </form>
</div>
</body>
<script>
    // 在JSP文件中获取后端传递的错误信息
    var errorMessage = "${errorMessage}";

    // 如果错误信息不为空，则显示弹窗
    if (errorMessage) {
        alert(errorMessage);
    }
</script>
</html>
