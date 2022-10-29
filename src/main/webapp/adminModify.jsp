<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>


<%@ include file="localeInclude.jsp"%>

<fmt:bundle basename="message">


<h1><fmt:message key="Admin.User.Modify.Page"/></h1>

<br>
<br>
<br>

<form method="post" action="/admin/modify.do">
    <fmt:message key="ID"/> : <input type="text" name="id" value="${user.getId()}" readonly></br>
    <fmt:message key="PW"/> : <input type="text" name="password" value="${user.getPassword()}"></br>
    <fmt:message key="Name"/> : <input type="text" name="name" value="${user.getName()}"></br>
    <fmt:message key="Profile"/> : <input type="text" name="profile" value="${user.getProfile()}"></br>

    <br>
    <br>
    <br>
    <button type="submit"><fmt:message key="Register"/></button>

</form>

</fmt:bundle>
</body>
</html>
