<%--
  Created by IntelliJ IDEA.
  User: yeomyalooo
  Date: 2022-10-25
  Time: 오후 8:44
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<fmt:setLocale value="en"/>
<fmt:bundle basename="message">

<html>
  <head>
    <meta charset="UTF-8">
    <title>Login_form</title>
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
    <link rel="stylesheet" type="text/css" href="">
  </head>

  <style>
    .login_form{
      align-content: center;
      width: 300px;
      height: 300px;
      padding: 20px;
      border: 1px solid gray;
      text-align: center;
    }
  </style>
  <body>
  <h1> 게시판 사이트 </h1>

  <div class="login_form">
    <form action="/login.do" method="post">
      <label>아이디 : </label><input type="text" name="id"></br>
      <label>비밀번호 : </label><input type="password" name="pwd">
      </br> <button type="submit">로그인</button>
    </form>
    <c:choose>
      <c:when test="${is_login_fail eq \"fail\"}">
    <div style="color: red"> 잘못된 사용자 정보를 입력하셨습니다. </br> 다시 입력해주세요. </div>
      </c:when>
    </c:choose>
  </div>


  <fmt:message key="hello" />

  </body>
</html>
</fmt:bundle>
