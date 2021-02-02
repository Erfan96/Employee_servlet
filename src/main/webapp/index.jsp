<%--
  Created by IntelliJ IDEA.
  User: efsam
  Date: 1/27/2021
  Time: 4:01 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Employee</title>
    <link rel="stylesheet" type="text/css" href="index.css">
</head>
<body>
<div id="container">
    <p>Enter employee</p>
    <form action="save" method="post">
        <input name="fName" type="text" placeholder="Enter first name" required>
        <input name="lName" type="text" placeholder="Enter last name" required>
        <input name="email" type="text" placeholder="Enter email" required>
        <input id="but1" type="submit" value="submit">
    </form>
</div>
<form action="show">
    <input id="but2" type="submit" value="show">
</form>
</body>
</html>
