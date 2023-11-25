
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
<html>
<head>
    <title>注册用户页面</title>
    <link href="../../css/register.css" rel="stylesheet" type="text/css"/>
</head>
<body>
<div class="cont">
    <h1>注册用户</h1>
    <a href="Login.do">
        <button type="submit">返回</button>
    </a>
</div>
<form action="/Register" method="post">
    <div>
        <label for="userName">用户名：</label>
        <input type="text" id="userName" name="userName" value="${user.uname}" required/>
    </div>
    <div>
        <label for="passWord">密码：</label>
        <input type="password" id="passWord" name="passWord" value="${user.password}" required/>
    </div>
    <div>
        <label for="passWord2">确认密码：</label>
        <input type="password" id="passWord2" name="passWord2" value="${user.password2}" required/>
    </div>
    <div>
        <label for="email">邮箱：</label>
        <input type="email" id="email" name="email" value="${user.email}" required/>
    </div>
    <div>
        <label>性别：
            <input type="radio" name="gender" value="男" checked="checked"/>男
            <input type="radio" name="gender" value="女"/>女
        </label>
    </div>
    <div>
        <label for="birthday">生日：
            <input type="date" id="birthday" name="birthday" value="${user.birthday}" required>
        </label>
    </div>
    <div class="container">
        <button type="submit">注册</button>
    </div>
</form>
</body>
<script>
    // 在JSP文件中获取后端传递的错误信息
    var errorMessage = "${errorMessage}";

    // 如果错误信息不为空，则显示弹窗
    if (errorMessage) {
        alert(errorMessage);
    }


    //ajax进行判断
    $(document).ready(function () {
        $('input[name="userName"]').on('blur', function () {
            var userName = $(this).val();
            $.ajax({
                url: '/checkUserName',
                type: 'POST',
                data: {userName: userName},
                success: function (response) {
                    if (response === 'exist') {
                        alert('用户名已存在，请重新输入');
                    }
                }
            });
        });
    });
</script>
</html>