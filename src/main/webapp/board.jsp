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


<h1><fmt:message key="Board.Page"/></h1>
<br>
<br>
<a href="/logout.do"><fmt:message key="Logout"/></a>
<br>

<p><fmt:message key="Visit.Count"/>: ${visitCount}</p>
<br>
<p>로그인 한 사용자 수: ${sessionScope.size()}</p>


<h2><fmt:message key="Board.List"/></h2>
<br>

<table border="1" style="border-collapse: collapse; text-align: center; width: 1000px">
    <thead>
        <tr>
            <td style="width: 150px"><fmt:message key="No"/></td>
            <td><fmt:message key="Title"/></td>
            <td style="width: 200px"><fmt:message key="Date"/></td>
            <td style="width: 100px"><fmt:message key="ViewCount"/></td>
        </tr>
    </thead>

    <tbody>
        <c:forEach var="i" items="${boardMap}">
            <tr>
                <td>${i.value.getId()}</td>
                <td>
                    <a href="/board/view.do?id=${i.value.getId()}">${i.value.getTitle()}</a>
                </td>
                <td><fmt:formatDate value="${i.value.getDate()}" pattern="yyyy-MM-dd HH:ss"/></td>
                <td>${i.value.getViewCount()}</td>
            </tr>
        </c:forEach>
    </tbody>
</table>

<br>
<br>

<a href="/board/registerForm.do?id=${sessionScope.id.getId()}"><fmt:message key="Go.Board.Register"/></a>

</fmt:bundle>
</body>
</html>
