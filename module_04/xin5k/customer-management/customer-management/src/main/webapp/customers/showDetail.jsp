<%--
  Created by IntelliJ IDEA.
  User: ShouYou
  Date: 23/08/2021
  Time: 4:20 CH
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<table>
    <caption>Customers List</caption>
    <thead>
    <tr>
        <th>Id</th>
        <th>Name</th>
        <th>Email</th>
        <th>Address</th>
    </tr>
    </thead>
    <tbody>
        <tr>
            <td>
                <c:out value="${customerDetail.id}"/>
            </td>
            <td>
<%--              //  <a href=""></a>--%>
                <c:out value="${customerDetail.name}"/>
            </td>
            <td>
                <c:out value="${customerDetail.email}"/>
            </td>
            <td>
                <c:out value="${customerDetail.address}"/>
            </td>
        </tr>

    </tbody>
</table>

</body>
</html>
