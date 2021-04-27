<%@ page import="some.Cart" %><%--
  Created by IntelliJ IDEA.
  User: Linar
  Date: 02.02.2021
  Time: 12:56
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Show Cart</title>
</head>
<body>
<%
    Cart cart = (Cart) session.getAttribute("cart");
%>
<p>Наименование: <%= cart.getName()%></p>
<p>Количество: <%= cart.getQuantity()%></p>

</body>
</html>
