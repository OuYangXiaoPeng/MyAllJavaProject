<%--
  Created by IntelliJ IDEA.
  User: OYXP
  Date: 2025/4/7
  Time: 下午2:26
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>测试基本数据类型</title>
</head>
<body>
<h1>测试参数类型绑定</h1>
<%--
action:提交的地址
method:提交的方法
--%>

<form action="/demo01/demo01" method="post">
    <input type="text" name="id" placeholder="城市id"/><br/>
    <input type="text" name="cityName" placeholder="城市名称"/><br/>
    <input type="text" name="GDP" placeholder="城市GDP"/><br/>
    <input type="text" name="capital" placeholder="是否是省会"/><br/>
    <input type="submit" value="测试参数类型绑定"/>
</form>

<h1>测试参数类型绑定-普通实体类</h1>
<form action="/demo01/demo02" method="post">
    <input type="text" name="id" placeholder="城市id"/><br/>
    <input type="text" name="cityName" placeholder="城市名称"/><br/>
    <input type="text" name="GDP" placeholder="城市GDP"/><br/>
    <input type="text" name="capital" placeholder="是否是省会"/><br/>
    <input type="submit" value="测试参数类型绑定"/>
</form>

<h1>测试参数类型绑定-数组</h1>
<form action="/demo01/demo03" method="post">
    <input type="checkbox" value="1" name="ids"/>
    <input type="checkbox" value="2" name="ids"/>
    <input type="checkbox" value="3" name="ids"/>
    <input type="checkbox" value="4" name="ids"/><br/>
    <input type="submit" value="测试参数类型绑定"/>
</form>

<h1>测试参数类型绑定-list集合</h1>
<form action="/demo01/demo04" method="post">
    <input type="checkbox" value="1" name="ids"/>
    <input type="checkbox" value="2" name="ids"/>
    <input type="checkbox" value="3" name="ids"/>
    <input type="checkbox" value="4" name="ids"/><br/>
    <input type="submit" value="测试参数类型绑定"/>
</form>

<h1>测试参数类型绑定-set集合</h1>
<form action="/demo01/demo05" method="post">
    <input type="checkbox" value="1" name="ids"/>
    <input type="checkbox" value="2" name="ids"/>
    <input type="checkbox" value="3" name="ids"/>
    <input type="checkbox" value="4" name="ids"/><br/>
    <input type="submit" value="测试参数类型绑定"/>
</form>

<h1>测试参数类型绑定-map集合</h1>
<form action="/demo01/demo06" method="post">
    <input type="text" name="id" placeholder="城市id"/><br/>
    <input type="text" name="cityName" placeholder="城市名称"/><br/>
    <input type="text" name="GDP" placeholder="城市GDP"/><br/>
    <input type="text" name="capital" placeholder="是否是省会"/><br/>
    <input type="submit" value="测试参数类型绑定"/>
</form>

</body>
</html>
