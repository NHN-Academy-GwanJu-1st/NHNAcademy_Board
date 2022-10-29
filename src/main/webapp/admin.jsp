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


<h1><fmt:message key="Admin.Page"/></h1>


<br>
<br>

    <a href="userRegisterForm.do"><fmt:message key="UserRegister"/></a>

    <br>
<br>

<h2><fmt:message key="User.List"/></h2>
<%-- 여기서 그냥 모든 사용자 리스트를 쭉 뿌려주고 클릭 -> detatil view -> 수정 btn, 삭제 btn  --%>
<c:set var="userMap" value="${userRepository.findAll()}" scope="page"/>

<ul>
<c:forEach var="i" items="${userMap}">
    <c:if test="${i.key != 'admin'}">
    <li>
        <a href="/admin/view.do?id=${i.value.getId()}">${i.value.getName()}</a>
    </li>
    </c:if>
</c:forEach>
</ul>

</fmt:bundle>

</body>
</html>
