<%@ taglib prefix="security" uri="http://www.springframework.org/security/tags" %>
<%--
  Created by IntelliJ IDEA.
  User: Linar
  Date: 28.01.2021
  Time: 19:24
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title></title>
</head>
<body>
<h3>
    Information for all Employees
</h3>
<br><br>
<security:authorize access="hasRole('HR')">
<input type="button" value="Salary" onclick="window.location.href = 'hr_info'">
Only for HR staff
</security:authorize>
<br><br>

<security:authorize access="hasRole('MANAGER')">
<input type="button" value="Performance" onclick="window.location.href = 'manager_info'">
Only for Managers
</security:authorize>

</body>
</html>
