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

<h1>json支持</h1>
<button id="btn">json支持</button>

</body>

<script>
    $(function () {
        $("#btn").click(function () {

            // json对象
            var user = {id: 1, name: "蔡徐坤", password: "CTRL"}

            $.post({
                url: "/demo1/test4",
                // ajax默认格式
                contentType: "application/x-www-form-urlencoded",
                data: user,
                success: function (res) {
                    console.log(res)
                }
            })

        })

    })
</script>

</html>
