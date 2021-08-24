<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
  <head>
    <title>$Title$</title>
  </head>
  <body>
  <h1>Sandwich Condiments</h1>
  <form action="/save", method="get">
    <input type="checkbox" id="vehicle1" name="condiment" value="Lettuce">
    <label for="vehicle1"> Lettuce</label>
    <input type="checkbox" id="vehicle2" name="condiment" value="Tomato">
    <label for="vehicle2"> Tomato</label>
    <input type="checkbox" id="vehicle3" name="condiment" value="Mustard">
    <label for="vehicle3"> Mustard</label>
    <input type="checkbox" id="vehicle4" name="condiment" value="Sprouts">
    <label for="vehicle4"> Sprouts</label><br>
    <input type="submit" value="Save">

  </form>

<%--  <c:if test="${result!=null}">${result}</c:if>--%>
<%--  <p>${result}</p>--%>
  <c:forEach var="c" items="${result}">${c}</c:forEach>
  <c:if test="${result==null}">
    <p>Quý khách chưa chọn món</p>
  </c:if>
  </body>
</html>
