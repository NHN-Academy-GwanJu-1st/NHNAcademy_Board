<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>

<h1>Admin User Modify Page</h1>

<br>
<br>
<br>

<form method="post" action="/admin/modify.do">
    ID : <input type="text" name="id" value="${user.getId()}" readonly></br>
    PW : <input type="text" name="password" value="${user.getPassword()}"></br>
    Name : <input type="text" name="name" value="${user.getName()}"></br>
    Profile : <input type="text" name="profile" value="${user.getProfile()}"></br>

    <br>
    <br>
    <br>
    <button type="submit">Register</button>

</form>
</body>
</html>
