<%--
  Created by IntelliJ IDEA.
  User: 123
  Date: 2019/8/6
  Time: 21:01
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
    <title>商品列表</title>
</head>
<body>
<table>
    <tr>
        <%--表头 --%>
        <th>ID</th>
        <th>商品名称</th>
        <th>商品详情</th>
        <th>商品图片</th>
        <th>商品价格</th>
        <th>操作</th>
    </tr>
    <c:forEach items="${gli.data}" var="gs">
    <tr>
        <td>${gs.id}</td>
        <td>${gs.gname}</td>
        <td>${gs.subtitle}</td>
        <td>${gs.mainImage}</td>
        <td>${gs.price}</td>
        <td>
            <a href="">富文本上传图片</a>
            <a href="">新增OR更新产品</a>
            <a href="">产品上下架</a>
            <a href="">图片上传</a>
        </td>

    </tr>
    </c:forEach>
</body>
</html>
