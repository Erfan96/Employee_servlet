<%--
  Created by IntelliJ IDEA.
  User: efsam
  Date: 2/1/2021
  Time: 11:31 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<html>
<head>
    <title>Detail</title>
    <link rel="stylesheet" type="text/css" href="detail.css">
</head>

<body>
<table id="emp">
    <form action="update" method="post">
        <c:forEach var="emp" items="${list}">
        <tr>
            <th>First name :</th>
            <td><input name="fName" value="<c:out value="${emp.get(0)}"/>"></td>
        </tr>
        <tr>
            <th>Last name :</th>
            <td><input name="lName" value="<c:out value="${emp.get(1)}"/>"></td>
        </tr>
        <tr>
            <th>Email :</th>
            <td><input name="email" value="<c:out value="${emp.get(2)}"/>"></td>
        </tr>
        <tr>
            <th>Father name :</th>
            <td><input name="faName" value="<c:out value="${emp.get(4)}"/>"></td>
        </tr>
        <tr>
            <th>National code :</th>
            <td><input name="naCode" value="<c:out value="${emp.get(5)}"/>"></td>
        </tr>
        <tr>
            <th>Birth certificate number :</th>
            <td><input name="cerNum" value="<c:out value="${emp.get(6)}"/>"></td>
        </tr>
        <tr>
            <th>State :</th>
            <td><input name="state" value="<c:out value="${emp.get(7)}"/>"></td>
        </tr>
        <tr>
            <th>Street :</th>
            <td><input name="street" value="<c:out value="${emp.get(8)}"/>"></td>
        </tr>
        <tr>
            <th>Postal code :</th>
            <td><input name="postCode" value="<c:out value="${emp.get(9)}"/>"></td>
        </tr>
        <tr>
            <th>Phone number :</th>
            <td><input name="phoneNum" value="<c:out value="${emp.get(10)}"/>"></td>
        </tr>
        <td align="center">
            <button id="but1" type="submit">Update</button>
        </td>
    </form>
    <td align="center">
        <form action="delete" method="post">
            <button id="but2" type="submit">delete</button>
        </form>
    </td>
    </tr>
    </c:forEach>

</table>
</body>
</html>
