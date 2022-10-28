<%--
  Created by IntelliJ IDEA.
  User: yeomyalooo
  Date: 2022-10-25
  Time: 오후 8:44
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
  <head>
    <title>welcome</title>
  </head>

  <style>
    .login_form{
      width: 300px;
      height: 300px;

    }

  </style>
  <body>
  <h1> 게시판 사이트 </h1>

  <form class="login_form" action="/login.do" method="post">
    <label>아이디 : </label><input type="text" name="id"></br>
    <label>비밀번호 : </label><input type="password" name="pwd">
    </br> <button type="submit">로그인</button>
  </form>

  </body>
</html>
