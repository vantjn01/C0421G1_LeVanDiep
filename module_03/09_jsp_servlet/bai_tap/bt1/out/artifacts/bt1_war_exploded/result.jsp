<%--
  Created by IntelliJ IDEA.
  User: Nam
  Date: 8/2/2021
  Time: 10:47 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h3 style="color: red">
    ten_sp:<%=request.getAttribute("ten_sp")%>
</h3>
<h3 style="color: green">
    gia_ck:<%=request.getAttribute("gia_ck")%>
</h3>
<h3 style="color: blue">
    gia sau khi chiet khau:<%=request.getAttribute("gia_sp")%>
</h3>
</body>
</html>
