<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>

<c:if test="${sessionScope.locale == null}">
  <fmt:setLocale value="en"></fmt:setLocale>
  <fmt:setBundle basename="message" var="message"></fmt:setBundle>
</c:if>

<c:if test="${sessionScope.locale != null}">
  <fmt:setLocale value="${sessionScope.locale}"></fmt:setLocale>
  <fmt:setBundle basename="message" var="message"></fmt:setBundle>
</c:if>

</body>
</html>
