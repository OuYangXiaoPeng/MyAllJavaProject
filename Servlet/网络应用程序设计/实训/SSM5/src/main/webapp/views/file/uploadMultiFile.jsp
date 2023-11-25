<%--
  Created by IntelliJ IDEA.
  User: OYXP
  Date: 2023/6/16
  Time: 8:45
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h1>上传附件</h1>
<form method="post" action="doMultiUpload" enctype="multipart/form-data">
    <input type="file" name="file"/>
    </br>
    <input type="file" name="file2"/>
    <button type="submit">提交</button>
</form>
</body>
</html>
