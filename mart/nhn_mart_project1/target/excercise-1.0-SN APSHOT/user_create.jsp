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
    <h1> 관리자 회원 등록 페이지 </h1>
    <form action="/create_user.do" method="post">
        ID: <input type="text" name="create_id"></br>
        PASSWORD: <input type="password" name="create_password"></br>
        NAME: <input type="text" name="create_name"></br>
        PROFILE: <input type="text" name="create_profile"></br>

        <button type="submit"> 회원 생성하기 </button>
    </form>
    <c:if test="${create_user eq fail}">
        <div style="color:red;"> 모든 항목을 채워주세요. </div>
    </c:if>

</body>
</html>
