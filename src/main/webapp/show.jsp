<%@ page import="util.JpaUtil" %><%--
  Created by IntelliJ IDEA.
  User: efsam
  Date: 1/27/2021
  Time: 5:43 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Show</title>
</head>
<body>
<table align="center" border="2" cellpadding="5">
    <tr>
        <th>
            First name
        </th>
        <th>
            Last name
        </th>
        <th>
            Email
        </th>
    </tr>

    <c:forEach items="${list}" var="emp" >
    <tr>
        <td>
            <c:out value="${emp.firstName}"/>
        </td>
        <td>
            <c:out value="${emp.lastName}"/>
        </td>
        <td>
            <c:out value="${emp.email}"/>
        </td>
    </tr>
    </c:forEach>
</table>
</body>
</html>
<%
    JpaUtil.Shutdown();
%>
