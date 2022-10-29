<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>

<%@ include file="localeInclude.jsp"%>


<fmt:bundle basename="message">

<h1><fmt:message key="Board.Register.Form.Page"/></h1>

<br>
<br>
<br>

<form method="post" action="/board/register.do">
<input type="hidden" name="userId" value="${sessionScope.id.getId()}">
<input type="text" name="title" placeholder="Input Board Title" style="width: 400px; height: 40px">

    <br>
    <br>
    <br>

<textarea cols="10" rows="30" name="content" style="width: 950px; height: 450px; resize: none;"></textarea>

  <br>
  <br>
  <br>

  <button type="submit"><fmt:message key="Register"/></button>

</form>
</fmt:bundle>

</body>
</html>
