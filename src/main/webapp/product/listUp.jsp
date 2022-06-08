<%--
  Created by IntelliJ IDEA.
  User: HELLO
  Date: 08/06/2022
  Time: 9:36 SA
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<form class="form-inline my-2 my-lg-0">
    <input class="form-control mr-sm-2" type="search" placeholder="Search" aria-label="Search" name="key">
    <button class="btn btn-outline-success my-2 my-sm-0" type="submit">Search</button>
</form>
<c:forEach var="item" items="${danhSach}">
    <h3>${item.id}, ${item.name}, ${item.price}, ${item.quantity}
        <c:if test="${item.price > 200}">
            - Khuyễn mãi 10%
        </c:if>
        <c:if test="${item.price < 200}">
            - Khuyễn mãi 20%
        </c:if></h3>
</c:forEach>

</body>
</html>
