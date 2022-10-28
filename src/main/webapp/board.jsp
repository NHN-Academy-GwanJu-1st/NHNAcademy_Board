<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>

<h1>Board Page</h1>
<br>
<br>
<a href="/logout.do">Logout</a>
<br>

<h2>Board List</h2>
<br>

<table border="1" style="border-collapse: collapse; text-align: center; width: 1000px">
    <thead>
        <tr>
            <td style="width: 150px">No</td>
            <td>Title</td>
            <td style="width: 200px">Date</td>
            <td style="width: 100px">ViewCount</td>
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

<a href="/board/registerForm.do?id=${sessionScope.id.getId()}">Go Board Register</a>

</body>
</html>
