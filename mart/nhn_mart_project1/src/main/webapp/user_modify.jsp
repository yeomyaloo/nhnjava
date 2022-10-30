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
<h1> 관리자 회원 수정 페이지 </h1>
<form action="/modify_user.do" method="post">
    ID: <input type="text" name="modify_id"></br>
    PASSWORD: <input type="password" name="modify_password"></br>
    NAME: <input type="text" name="modify_name"></br>
    PROFILE: <input type="text" name="modify_profile"></br>

    <button type="submit"> 회원 수정하기 </button>
</form>


<c:if test="${modify_user eq fail}">
    <div style="color:red;"> 수정할 회원 정보를 모두 입력해주세요 </div>
</c:if>

</body>
</html>
