<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page import="com.nhnacademy.repository.UserRepository" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="com.nhnacademy.domain.User" %>
<%@ page import="java.util.List" %>
<%@ page import="com.nhnacademy.repository.ArrayUserRepository" %>
<%@ page import="java.util.Objects" %><%--
  Created by IntelliJ IDEA.
  User: yeomhwiju
  Date: 2022/10/28
  Time: 5:49 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>user_list</title>
</head>

<style>
    table {
        width: 100%;
        border: 1px solid #444444;
        border-collapse: collapse;
    }
    th, td {
        border: 1px solid #444444;
        padding: 10px;
    }
</style>
<body>

<h1> 관리자 회원 목록 페이지 </h1>
<div> 현재 회원명 ${userRepository.getUsers().size()} </div>

<table>
    <tr>
        <td> 회원 아이디 </td><td> 회원명 </td><td> 프로필 사진 </td>
    </tr>
    <%
        ServletContext servletContext = request.getSession().getServletContext();
        UserRepository userRepository = (UserRepository) servletContext.getAttribute("userRepository");
        if (Objects.nonNull(userRepository)){
            for (User user: userRepository.getUsers()){
    %>
    <tr>
        <td>${userRepository.getUsers().get(i).getId()}</td>
        <td>${userRepository.getUsers().get(i).getName()}</td>
        <td>${userRepository.getUsers().get(i).getProfileFileName()}</td>
    </tr>
    <% } %>
</table>
<%
}  else{
%>
<div> 생성한 회원 목록이 없습니다. </br>회원을 생성해주세요. </div>
<a href="/create_user.do">회원 생성하기</a>
<%
    }%>



</body>
</html>