<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>

<h1>Admin Page</h1>


<br>
<br>
<br>

<h2>User List</h2>
<%-- 여기서 그냥 모든 사용자 리스트를 쭉 뿌려주고 클릭 -> detatil view -> 수정 btn, 삭제 btn  --%>
<c:set var="userMap" value="${userRepository.findAll()}" scope="page"/>

<ul>
<c:forEach var="i" items="${userMap}">
    <c:if test="${i.key != 'admin'}">
    <li>
        <a href="/admin/view.do?name=${i.value.getName()}">${i.value.getName()}</a>
    </li>
    </c:if>
</c:forEach>
</ul>

</body>
</html>
