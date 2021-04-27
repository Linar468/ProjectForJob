<%--
  Created by IntelliJ IDEA.
  User: Linar
  Date: 01.02.2021
  Time: 16:04
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>First JSP</title>
</head>
<body>
<h1>Test JSP</h1>

<%
    java.util.Date now = new java.util.Date();
    String some = "Текущая дата:" + now;

%>
<p>
    <%=some%>
    <br>
<%= new java.util.Date()%>
</p>
<br>
<br>
<%
out.println("Hello world");
%>

<%
    out.println("Hello world");
    for(int i = 0; i<10;i++){
        out.println("<p>" + "Hello: " + i + "</p>");
    }

%>

</body>
</html>
