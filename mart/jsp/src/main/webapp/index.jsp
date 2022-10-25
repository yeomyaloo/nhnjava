<%--
  Created by IntelliJ IDEA.
  User: yeomyalooo
  Date: 2022-10-25
  Time: 오후 2:32
  To change this template use File | Settings | File Templates.
--%>


<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" %>
<html>
<head>
  <title><%= "title" %>></title>
</head>
<body>



    <% for (int i=1; i<10; i++){
      for (int j=1; j < 10; j++) { %>
    <div><%=i%>*<%=j%> = <%=i*j %> </div></br>
    <%
      }
    }
    %>


</body>
</html>
