<%--
  Created by IntelliJ IDEA.
  User: Nam
  Date: 8/3/2021
  Time: 6:46 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
<html>
  <head>
    <title>Caculator</title>
  </head>
  <body>
  <h1>Simple Calculator</h1>

  <form action="/calculator" method="post">
    <label>First operand</label>
  <input type="text" name="first"><br>
    <label>Operator</label>
  <select name="op">
    <option value="Adidition">+</option>
    <option value="Subtraction">-</option>
    <option value="Multiplication">*</option>
    <option value="Division">/</option>
  </select><br>
    <label>Second operand</label>
  <input type="text" name="second"><br>
  <input type="submit" value="Calculate" id="calculate">
  </form>


  </body>
</html>
