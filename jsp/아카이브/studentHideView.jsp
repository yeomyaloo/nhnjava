<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta charset="UTF-8" />
    <title>학생 정보 조회(성적 숨김)</title>
</head>
<body>
    이름: ${student.name}<br />
    이메일: ${student.email}<br />
    평가: ${student.comment}<br />
    <br />
    <a href="/student/${student.id}/modify">정보 수정</a><br />
</body>
</html>
