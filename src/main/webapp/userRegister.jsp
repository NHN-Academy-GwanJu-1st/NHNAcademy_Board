<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>

<%@ include file="localeInclude.jsp"%>

<fmt:bundle basename="message">

<h1><fmt:message key="User.Register.Page"/></h1>

<br>
<br>
<br>

<form method="post" action="/userRegister.do">
    <fmt:message key="ID"/> : <input type="text" name="id"></br>
    <fmt:message key="PW"/> : <input type="text" name="password"></br>
    <fmt:message key="Name"/> : <input type="text" name="name"></br>
    <fmt:message key="Profile"/> : <input type="text" name="profile"></br>

    <br>
    <br>
    <br>
    <button type="submit"><fmt:message key="Register"/></button>
</form>
</fmt:bundle>
</body>
</html>
