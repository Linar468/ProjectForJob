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
<p>
    <%
        java.util.Date now = new java.util.Date();
        String some = "Текущая дата: " + now;
    %>
    <%=some%>
</p>
<br>
<p>
    <%= new java.util.Date()%>
</p>
<br>
<p>
    <%
        out.println("Hello world");
    %>
</p>
<br>
<p>
    <%
        out.println("Hello world");
        for (int i = 0; i < 5; i++) {
            out.println("<p>" + "Hello: " + i + "</p>");
        }
    %>
</p>
<br>
<p>
    <%@ page import="java.util.Date, logic.TestClass" %>
    <%= new Date()%>
</p>
<br>

<p>
    <%
        TestClass testClass = new TestClass();
    %>
    <%=testClass.getInfo()%>
</p>

<br>
</body>
</html>
