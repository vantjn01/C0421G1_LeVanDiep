<%--
  Created by IntelliJ IDEA.
  User: Nam
  Date: 8/3/2021
  Time: 4:12 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
  <head>
    <title>List Customer</title>
    <style>
      .image{
        width: 100px;
        height: 100px;
      }
    </style>
  </head>
  <body>
  <h1>Danh sách khách hàng</h1>
  <table border="1">
    <tr>
      <th>Tên</th>
      <th>Ngày Sinh</th>
      <th>Địa chỉ</th>
      <th>Ảnh</th>

    </tr>
    <c:forEach var="customerObj" items="${customerListServlet}">
      <tr>
      <td><c:out value="${customerObj.name}"/></td>
      <td><c:out value="${customerObj.dateOfBirth}"/></td>
      <td><c:out value="${customerObj.address}"/></td>
      <td><img class="image" src="${customerObj.image}"></td>
      </tr>
    </c:forEach>
  </table>
  </body>
</html>
