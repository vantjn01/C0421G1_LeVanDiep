<%--
  Created by IntelliJ IDEA.
  User: Nam
  Date: 8/23/2021
  Time: 10:39 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Home</title>
</head>
<body>
<h1>Email Validate</h1>
<h3 style="color: orange">${message}</h3>
<form action="validate" , method="post">
    <input type="text", name="email"></br>
    <input type="submit" value="Validate">
</form>
</body>
</html>
