<%--
  Created by IntelliJ IDEA.
  User: Nam
  Date: 8/20/2021
  Time: 4:50 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
  <head>
    <title>$Title$</title>
    <link rel="stylesheet" href="/bootstrap.min.css">
  </head>
  <body>
  <h2 class="text-center text-danger">USD-VNĐ</h2>
  <div class="container-fluid">
    <form action="/calculate">
      <div class="form-group">
        <label>Nhập số USD</label>
        <input class="form-control" name="usdInput" type="number" placeholder="Nhập USD" value="${usdInput}">
      </div>
      <button type="submit" class="btn btn-success">Đổi</button>
    </form>
    <div class="form-group">
      <label>Số tiền VND</label>
      <input class="form-control" name="vnd" type="number" value="${vnd}" disabled>
    </div>
  </div>
  <script src="/jquery/jquery-3.5.1.min.js"></script>
  <script src="/jquery/popper.min.js"></script>
  <script src="/bootstrap.js"></script>
  </body>
</html>
