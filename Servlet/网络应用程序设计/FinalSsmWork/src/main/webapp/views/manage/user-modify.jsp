
<%@ page contentType="text/html;charset=UTF-8" language="java" import="java.util.*" isELIgnored="false" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
    <title>UserManage</title>
    <link href="../../css/register.css" rel="stylesheet" type="text/css"/>
</head>
<body>
<div class="cont">
    <h1>修改用户</h1>
    <a href="manaUser">
        <button type="submit">返回</button>
    </a>
</div>
<form action="modifyUser.do">
    <input type="hidden" class="text" name="uid" value="${user.uid}"/>
    <div>
        <label for="userName">用户名：</label>
        <input type="text" id="userName" name="userName" value="${user.uname}" readonly="readonly"/>
    </div>
    <div>
        <label for="passWord">密码：</label>
        <input type="password" id="passWord" name="passWord" value="${user.password}"/>
    </div>
    <div>
        <label for="email">邮箱：</label>
        <input type="email" id="email" name="email" value="${user.email}"/>
    </div>
    <div>
        <label>性别：
            <input type="radio" name="gender" value="男"
                   <c:if test="${user.gender=='男'}">checked="checked" </c:if>/>男
            <input type="radio" name="gender" value="女"
                   <c:if test="${user.gender=='女'}">checked="checked" </c:if>/>女
        </label>
    </div>
    <div>
        <label for="birthday">生日：
            <input type="date" id="birthday" name="birthday" value="${user.birthday}"/>
        </label>
    </div>
    <div class="container">
        <button type="submit">更新</button>
    </div>
</form>
</body>
</html>
