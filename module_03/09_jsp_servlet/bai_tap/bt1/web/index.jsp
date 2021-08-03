<%--
  Created by IntelliJ IDEA.
  User: Nam
  Date: 8/2/2021
  Time: 9:12 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
  <head>
    <title>$Title$</title>
  </head>
  <body>
<form action="/product_servlet" method="post" >
  <p>Mô tả sp</p>
  <input type="text" name="ten_sp"/>
  <p>Giá</p>
  <input type="text" name="gia">
  <p>Phần trăm</p>
  <input type="text" name="phan_tram">
  <input type="submit" value="Giá sau khi chiếc khấu">

</form>
  </body>
</html>
