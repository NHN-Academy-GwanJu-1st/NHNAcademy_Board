<%--
  Created by IntelliJ IDEA.
  User: 강명관
  Date: 2022-10-27
  Time: 오전 9:38
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>

<h1>NHN Academy Web Servlet Board</h1>

<form method="post" action="/login.do">
    ID : <input type="text" name="id" placeholder="Input your id">
    <br>
    PW : <input type="text" name="password" placeholder="Input your password">

    <br>
    <br>
    <br>

    <button type="submit">Login</button>

    <br>

    <a href="userRegisterForm.do">UserRegister</a>
</form>

<br>
<br>



</body>
</html>
