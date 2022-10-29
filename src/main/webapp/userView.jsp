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

<h1><fmt:message key="User.View.Page"/></h1>

<br>
<br>
<br>

<div style="display: flex; align-items: center">
    <img src="${user.getProfile()}" alt="img" style="width: 80px; margin-right: 20px">
    <p>${user.getName()}</p>
</div>
</fmt:bundle>
</body>
</html>
