<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
  <head>
    <title>$Title$</title>
  </head>
  <body>
<h1>Welcome</h1>
<%--<h3>Account: ${user.account}</h3>--%>
<h3>Language: ${mailbox.language}</h3>
<h3>Page Size : ${mailbox.pageSize}</h3>
<h3>Spams Filter : ${mailbox.spamsFilter}</h3>
<h3>Signature : ${mailbox.signature}</h3>
<%--<h3>Name: ${user.name}</h3>--%>
<%--<h3>Email: ${user.email}</h3>--%>
<%--<h3>Age: ${user.age}</h3>--%>
  </body>
</html>
