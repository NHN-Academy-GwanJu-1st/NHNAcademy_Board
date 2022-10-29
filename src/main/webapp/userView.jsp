<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>

<h1>User View Page</h1>

<br>
<br>
<br>

<div style="display: flex; align-items: center">
    <img src="${user.getProfile()}" alt="img" style="width: 80px; margin-right: 20px">
    <p>${user.getName()}</p>
</div>
</body>
</html>
