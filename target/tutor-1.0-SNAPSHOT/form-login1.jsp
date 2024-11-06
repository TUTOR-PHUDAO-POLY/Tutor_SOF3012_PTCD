<%--
  Created by IntelliJ IDEA.
  User: hangnt169
  Date: 4/11/24
  Time: 20:50
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<%--Code giao dien--%>
<%--1. action: đường dẫn: bắt buộc là dấu /
    2. method: post
    3. type button: submit => TRUYỀN ĐƯỢC DỮ LIỆU ĐI
--%>
<form action="/ket-qua" method="post">
    <label>Username:</label>
    <input type="text" name="user">
    <br>
    <label>Password:</label>
    <input type="password" name="pass">
    <br/>
    <button type="submit">Login</button>
</form>
</body>
</html>
