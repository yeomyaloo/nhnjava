<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page import="com.nhnacademy.repository.UserRepository" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="com.nhnacademy.domain.User" %>
<%@ page import="java.util.List" %>
<%@ page import="com.nhnacademy.repository.ArrayUserRepository" %>
<%@ page import="java.util.Objects" %>
<%@ page import="com.nhnacademy.repository.PostRepository" %>
<%@ page import="com.nhnacademy.domain.Post" %><%--
  Created by IntelliJ IDEA.
  User: yeomhwiju
  Date: 2022/10/28
  Time: 5:49 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>post list</title>
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

<h1> 회원 게시글 목록 </h1>

<table>
    <tr>
        <td> 회원 아이디 </td><td> 게시글 제목 </td><td> 게시글 본문 </td> <td> 작성시간</td>
    </tr>
    <%
        ServletContext servletContext = request.getSession().getServletContext();
        PostRepository postRepository = (PostRepository) servletContext.getAttribute("postRepository");
        if (Objects.nonNull(postRepository)){
            for (Post post: postRepository.getPosts()){
    %>
    <tr>
        <td>${postRepository.getPosts().get(i).getId()}</td>
        <td>${userRepository.getUsers().get(i).getTitle()}</td>
        <td>${userRepository.getUsers().get(i).getContent()}</td>
        <td>${userRepository.getUsers().get(i).getWriteTime()}</td>
    </tr>
    <% }
        } %>
</table>

</body>
</html>