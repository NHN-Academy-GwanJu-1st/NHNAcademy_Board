<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>

<h1>Admin User View Page</h1>

<br>
<br>
<br>

<div style="display: flex; align-items: center">
<img src="${user.getProfile()}" style="width: 80px; margin-right: 20px">
<p>${user.getName()}</p>
</div>
<br>
<br>

<a href="/admin/modifyForm.do?id=${user.getId()}">update</a>
<a href="/admin/delete.do?id=${user.getId()}">delete</a>

</body>
</html>
