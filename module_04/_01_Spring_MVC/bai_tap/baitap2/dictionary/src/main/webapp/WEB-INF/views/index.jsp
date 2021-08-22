<%--
  Created by IntelliJ IDEA.
  User: Nam
  Date: 8/20/2021
  Time: 4:50 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
  <head>
    <title>$Title$</title>
    <link rel="stylesheet" href="/bootstrap.min.css">
  </head>
  <body>
  <h2 class="text-center text-danger">Dictionary English- Vietnamese</h2>
  <div class="container-fluid">
    <form action="/dictionary">
      <div class="form-group">
        <label>English</label>
        <input class="form-control" name="english" type="text" placeholder="Nhập từ Tiếng Anh" value="${eng}">
      </div>
      <div class="form-group">
        <label>Vietnamese</label>
        <input class="form-control" type="text" value="${viet}" disabled>
      </div>
      <button type="submit" class="btn btn-success">Dịch</button>
    </form>

  </div>
  <script src="/jquery/jquery-3.5.1.min.js"></script>
  <script src="/jquery/popper.min.js"></script>
  <script src="/bootstrap.js"></script>
  </body>
</html>
