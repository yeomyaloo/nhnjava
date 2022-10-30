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
<h1> 회원 게시물 등록 페이지 </h1>
<form action="/postCreate.do" method="post">


    User Id : <input type="text" name="postUserId">
    Title : <input type="text" name="postTitle">
    Content : <input type="text" name="postContent" width="200" height="200">


    <button type="submit"> 게시글 작성 </button>
</form>
<c:if test="${create_user eq fail}">
    <div style="color:red;"> 모든 항목을 채워주세요. </div>
</c:if>

</body>
</html>
