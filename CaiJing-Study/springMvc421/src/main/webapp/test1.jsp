<%--
  Created by IntelliJ IDEA.
  User: OYXP
  Date: 2025/4/21
  Time: 下午2:19
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <script src="js/jquery-3.5.1.js"></script>
</head>
<body>
<h1>表单提交</h1>
<form action="/demo1/test1" method="post">

    <input type="text" name="id" placeholder="id"/><br/>
    <input type="text" name="username" placeholder="用户名"/><br/>

    <input type="submit" value="提交"/>
</form>

<h1>json提交</h1>
<button id="btn">json提交</button>

</body>

<script>
    $(function () {
        $("#btn").click(function () {
// Json对象
            var province = {id: 1, name: "吉林省"}
            $.post({
                url: "/demo1/test1",
// ajax默认的提交格式为: application/x-www-form-urlencoded
                contentType: "application/x-www-form-urlencoded",
                data: province,
                success: function (res) {
                    console.log(res);
                }
            })
        })
    })
</script>

</html>
