<%--
  Created by IntelliJ IDEA.
  User: yeomyalooo
  Date: 2022-10-25
  Time: 오후 5:14
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<!--
      .do -> frontServlet을 거쳐서 가라고 해당 작업을 진행

-->
  <form method="post" action="/student/register.do">
    학생 아이디: <input type="text" name="id"></br>
    학생 이름: <input type="text" name="name"></br>
    학생 나이: <input type="text" name="age"></br>
    <button type="submit">제출하기</button>
  </form>

</body>
</html>
