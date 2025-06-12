<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>添加用户</title>
    <style>
        form {
            width: 400px;
            margin: 20px auto;
            padding: 20px;
            border: 1px solid #ddd;
            border-radius: 4px;
        }
        input[type="text"], input[type="date"] {
            width: 100%;
            padding: 8px;
            margin: 8px 0;
            display: inline-block;
            border: 1px solid #ccc;
            border-radius: 4px;
            box-sizing: border-box;
        }
        input[type="submit"] {
            width: 100%;
            background-color: #4CAF50;
            color: white;
            padding: 10px 16px;
            margin: 8px 0;
            border: none;
            border-radius: 4px;
            cursor: pointer;
        }
        .back-btn {
            display: block;
            width: 100px;
            margin: 20px auto;
            text-align: center;
            padding: 8px;
            background-color: #f44336;
            color: white;
            text-decoration: none;
            border-radius: 4px;
        }
    </style>
</head>
<body>
<h2 align="center">添加用户</h2>

<form action="addUser" method="post">
    <label for="username">用户名:</label>
    <input type="text" id="username" name="username" required>

    <label for="birthday">生日:</label>
    <input type="date" id="birthday" name="birthday" required>

    <label for="sex">性别:</label>
    <input type="text" id="sex" name="sex" required>

    <label for="address">地址:</label>
    <input type="text" id="address" name="address" required>

    <input type="submit" value="添加">
</form>

<a href="userList.jsp" class="back-btn">返回列表</a>
</body>
</html>