<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: yeomhwiju
  Date: 2022/10/28
  Time: 5:51 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>user_create</title>
</head>
<body>
<h1> 관리자 회원 삭제 페이지 </h1>
<form action="/delete_user.do" method="post">
    ID: <input type="text" name="delete_id"></br>
    <button type="submit"> 회원 삭제하기</button>
</form>

</body>
</html>
