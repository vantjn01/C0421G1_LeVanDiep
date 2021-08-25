<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h1>Home</h1>
<form:form action="update" method="post" modelAttribute="mailbox">
    <fieldset>
        <legend>Setting</legend>
        <table>
            <tr>
                <td><form:label path="language">Language:</form:label></td>
                <td><form:input path="language" items="${languague}"/></td>
            </tr>
            <tr>
                <td><form:label path="pageSize">Page Size:</form:label></td>
                <td><form:input path="pageSize" items="${size}"/><span>mail per page</span></td>
            </tr>
            <tr>
                <td><form:label path="spamsFilter">Spam Filter:</form:label></td>
                <td><form:input path="spamsFilter" /><span>Enable spams filter</span></td>
            </tr>
            <tr>
                <td><form:label path="signature">Signature:</form:label></td>
                <td><form:input path="signature" /></td>
            </tr>
            <tr>
                <td><form:button type="submit">Update</form:button></td>
                <td><form:button type="reset">Cancel</form:button></td>
            </tr>
        </table>
    </fieldset>
</form:form>
</body>
</html>
