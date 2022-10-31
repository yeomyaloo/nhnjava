<%--
  Created by IntelliJ IDEA.
  User: yeomhwiju
  Date: 2022/10/28
  Time: 9:24 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<html>
<head>
    <title>login_ok</title>
</head>
<body>

    <%
        String id = request.getParameter("id");
        int cnt = (int) request.getAttribute("counter");
    %>

    <c:choose>
        <c:when test="${role eq \"ADMIN\"}">

            <h1> 관리자 페이지 </h1>
            <h3> 오늘의 방문자 : ${counter}</h3>
            <div></div>
            <p>[<span> ${id} </span>] 계정으로 로그인 했습니다.</p>

            <a href="/find_user.do"> 회원 조회하기 </a></br>
            <a href="/create_user.do"> 회원 생성하기 </a></br>
            <a href="/delete_user.do"> 회원 삭제하기 </a></br>
            <a href="/modify_user.do"> 회원 수정하기 </a></br>

            <form action="/logout.do" method="post">
                <button type="submit" name="logout">로그아웃 하기</button>
            </form>

            <div></div>


        </c:when>


        <c:when test="${role eq \"USER\"}">
            <c:if test="${sessionScope.id != null}">

                <h1> 사용자 페이지 </h1>
                <h3> 오늘의 방문자 : ${counter}</h3>

                <p>[<span> ${id} </span>] 님 환영합니다. </p>
                <a href="/myPage.do"> 내 페이지 확인하기 </a></br>
                <a href="/postCreate.do"> 게시물 작성하기 </a>
                <a href="/postList.do"> 게시물 조회 </a></br>
                <a href="/postModify.do"> 게시물 수정 </a></br>
                <a href="/postDelete.do"> 게시물 삭제 </a></br>


                <form action="/logout.do" method="post">
                    <button type="submit" name="logout">로그아웃 하기</button>
                </form>
            </c:if>
        </c:when>

    </c:choose>





</body>
</html>
