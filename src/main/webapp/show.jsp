<%@ page import="util.JpaUtil" %>
<%@ page import="java.io.PrintWriter" %><%--
  Created by IntelliJ IDEA.
  User: efsam
  Date: 1/27/2021
  Time: 5:43 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    int count = 1;
%>
<html>
<head>
    <title>Show</title>
    <link rel="stylesheet" type="text/css" href="show.css">
</head>
<body>
<table id="emp">
    <tr>
        <th>
            Num
        </th>
        <th>
            Full name
        </th>
        <th>
            Email
        </th>
    </tr>

    <c:forEach items="${list}" var="emp" >
        <tr>
            <td>
                <%=count++%>
            </td>
            <td>
                <a href="detail?value=${emp.employeeId}"><c:out value="${emp.firstName}"/> <c:out value="${emp.lastName}"/></a>
            </td>
            <td>
                <c:out value="${emp.email}"/>
            </td>
        </tr>
    </c:forEach>
</table>
</body>
</html>

