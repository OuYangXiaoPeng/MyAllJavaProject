<%--
  Created by IntelliJ IDEA.
  User: OYXP
  Date: 2025/4/21
  Time: 下午3:03
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>多文件上传</title>
</head>
<body>
<form action="demo1/upload_many" enctype="multipart/form-data" method="post">
    <input type="file" name="manyfile"/><br/>
    <input type="file" name="manyfile"/><br/>
    <input type="file" name="manyfile"/><br/>
    <input type="file" name="manyfile"/><br/>
    <input type="submit" value="多文件上传"/>
</form>
</body>
</html>
