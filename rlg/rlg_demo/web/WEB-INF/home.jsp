<%--
  Created by IntelliJ IDEA.
  User: 123
  Date: 2019/8/6
  Time: 19:33
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="com.itdr.pojo.Users" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
    <title>主页</title>
</head>
<body>

<div>  欢迎 ${user.uname}</div>
<ul>
    <li>
        <a href="/manage/user/list.do">用户列表</a>
    </li>
    <li>
        <a href="/manage/product/list.do">商品列表</a>
    </li>
    <li></li>
</ul>
<%--<%--%>
    <%--HttpSession hs=request.getSession();--%>
    <%--Users u=(Users) hs.getAttribute("user");--%>
<%--%>--%>
<%--<p>--%>
    <%--<%=u.getUname()%>--%>
<%--</p>--%>
</body>
</html>
