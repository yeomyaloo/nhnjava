<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: yeomhwiju
  Date: 2022/10/30
  Time: 11:57 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>

    <c:choose>
        <c:when test="${role eq \"ADMIN\"}">



        </c:when>
        <c:when test="${role eq \"USER\"}">



        </c:when>

    </c:choose>

</body>
</html>
