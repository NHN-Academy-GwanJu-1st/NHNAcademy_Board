<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>


<%@ include file="localeInclude.jsp"%>

<fmt:bundle basename="message">

<h1>NHN Academy<fmt:message key="Web.Servlet.Board"/></h1>

<form method="post" action="/login.do">
    <fmt:message key="ID"/> : <input type="text" name="id" placeholder="Input your id">
    <br>
    <fmt:message key="PW"/> : <input type="text" name="password" placeholder="Input your password">

    <br>
    <br>
    <br>

    <button type="submit"><fmt:message key="Login"/></button>

    <br>

<%--    <a href="userRegisterForm.do"><fmt:message key="UserRegister"/></a>--%>
</form>

<br>
<br>
<br>

<form method="post" action="/locale.do">
    <input type="submit" name="locale" value="ko">
    <input type="submit" name="locale" value="en">
</form>

<br>
<br>

</fmt:bundle>


</body>
</html>
