<%--
  Created by IntelliJ IDEA.
  User: 123
  Date: 2019/8/6
  Time: 19:17
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>用户登录</title>
    <link rel="stylesheet" href="css/login.css">
</head>
<body>
<div id="wk">
    <div id="contiue">
        <form action="/manage/user/login.do" method="post" id="contiue_f">
            <input type="text" name="username" placeholder="请输入用户名" class="cf_f" >
            <br>
            <input type="password" name="password" placeholder="请输入密码" class="cf_f">
            <br>
            <input type="submit" value="登陆" id="cf_3">
        </form>
    </div>
</div>
</body>
</html>
