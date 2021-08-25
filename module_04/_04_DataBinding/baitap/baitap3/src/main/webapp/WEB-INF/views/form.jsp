<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Form</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.0/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-KyZXEAg3QhqLMpG8r+8fhAXLRk2vvoC2f3B09zVXn8CA5QIVfZOJ3BCsw2P0p/We" crossorigin="anonymous">
<%--    <style>--%>
<%--        body {--%>
<%--            text-align: center;--%>
<%--        }--%>
<%--    </style>--%>
</head>
<body>
<center>
    <h3>TỜ KHAI Y TẾ</h3>
    <h3 style="color: red">Khuyến cáo: khai báo thông tin sai phạm là vi phạm pháp luật</h3>
</center>

<div class="container-fluid col-lg-12" >
    <form:form action="/form" cssClass="row g-3" method="post" modelAttribute="infoPerson">
        <div class="col-12">
            <label for="inputEmail1" class="form-label">Họ và tên</label>
            <form:input path="name" id="inputEmail1" cssClass="form-control"/>
        </div>
        <div class="col-md-4">
            <label for="inputEmail4" class="form-label">Năm sinh</label>
            <form:input path="birthYear" id="inputEmail4" cssClass="form-control"/>
        </div>
        <div class="col-md-4">
            <label for="inputPassword4" class="form-label">Giới tính</label>
            <form:select path="gender" id="inputPassword4" cssClass="form-control">
                <form:option value="true">Nam</form:option>
                <form:option value="false">Nữ</form:option>
            </form:select>
        </div>
        <div class="col-md-4">
            <label for="inputAddress" class="form-label">Quốc tịch</label>
            <form:select path="nationality" id="inputAddress" cssClass="form-control">
                <form:option value="Việt Nam">Việt Nam</form:option>
                <form:option value="Nhật">Nhật Bản</form:option>
            </form:select>
        </div>
        <div class="col-12">
            <label for="inputAddress2" class="form-label">Số  CMND</label>
            <form:input path="idCard" id="inputAddress2" cssClass="form-control"/>
        </div>
        <div class="col-12">
            <label class="form-label">Thông tin đi lại</label>
            <br>
            <form:radiobutton path="transportVehicle" value="Tàu bay" label="Tàu bay"/>
            <form:radiobutton path="transportVehicle" value="Tàu thuyền" label="Tàu thuyền"/>
            <form:radiobutton path="transportVehicle" value="Ô tô" label="Ô tô"/>
            <form:radiobutton path="transportVehicle" value="Khác" label="Khác"/>
        </div>

        <div class="col-md-6">
            <div class="form-check">
                <label for="date" class="form-label">Ngày khởi hành</label>
                <form:input path="dayStart" id="date" cssClass="form-control"/>
            </div>
        </div>
        <div class="col-md-6">
            <label for="end" class="form-label">Ngày kết thúc </label>
            <form:input path="dayEnd" id="end" cssClass="form-control"/>
        </div>
        <div class="col-12">
            <label for="info" class="form-label">Trong vòng 14 ngày qua, Anh/Chị có đến tỉnh thành phố nào? </label><br>
            <form:textarea path="history" id="info" rows="3" cssClass="form-control"/>
        </div>
                    <div class="col-md-4">
                        <label for="inputState" class="form-label">Địa chỉ </label>
                        <form:input path="address" id="inputState" cssClass="form-control"/>
                    </div>
                    <div class="col-md-4">
                        <label for="inputZip" class="form-label">Điện thoại</label>
                        <form:input path="phone" id="inputZip" cssClass="form-control"/>
                    </div>
        <div class="col-md-4">
            <label for="inputState" class="form-label">Email</label>
            <form:input path="email" id="inputState" cssClass="form-control"/>
        </div>
        <div class="col-12">
            <center><input type="submit" value="Gửi tờ khai"></center>
        </div>
    </form:form>

</div>




<%--<form:form action="/form" method="post" modelAttribute="infoPerson">--%>
<%--    <table style="margin: 0 auto">--%>
<%--        <tr>--%>
<%--            <td>Name(*): </td>--%>
<%--            <td>--%>
<%--                <form:input path="name"/>--%>
<%--            </td>--%>
<%--        </tr>--%>



<%--        <tr>--%>
<%--            <td>Year of birth(*): </td>--%>
<%--            <td>--%>
<%--                <form:input path="birthYear"/>--%>
<%--            </td>--%>
<%--        </tr>--%>
<%--        <tr>--%>
<%--            <td>Gender(*): </td>--%>
<%--            <td><form:select path="gender">--%>
<%--                <c:forEach var="g" items="${genderList}">--%>
<%--                    <form:option value="${g}"/>--%>
<%--                </c:forEach>--%>
<%--            </form:select>--%>
<%--            </td>--%>
<%--        </tr>--%>
<%--        <tr>--%>
<%--            <td>Nationality: </td>--%>
<%--            <td><form:select path="nationality">--%>
<%--                <c:forEach var="n" items="${nationList}">--%>
<%--                    <form:option value="${n}"/>--%>
<%--                </c:forEach>--%>
<%--            </form:select>--%>
<%--            </td>--%>
<%--        </tr>--%>
<%--        <tr>--%>
<%--            <td>Id card(*): </td>--%>
<%--            <td>--%>
<%--                <form:input path="idCard"/>--%>
<%--            </td>--%>
<%--        </tr>--%>
<%--        <tr>--%>
<%--            <td>Transport information(*): </td>--%>
<%--            <td>--%>
<%--                <form:radiobutton path="transportVehicle" value="Airplane" label="Airplane"/>--%>
<%--                <form:radiobutton path="transportVehicle" value="Ship" label="Ship"/>--%>
<%--                <form:radiobutton path="transportVehicle" value="Car" label="Car"/>--%>
<%--                <form:radiobutton path="transportVehicle" value="Other" label="Other"/>--%>
<%--            </td>--%>
<%--        </tr>--%>
<%--        <tr>--%>
<%--            <td>Start date(*): </td>--%>
<%--            <td>--%>
<%--                <form:input path="dayStart"/>--%>
<%--            </td>--%>
<%--        </tr>--%>
<%--        <tr>--%>
<%--            <td>End date(*): </td>--%>
<%--            <td>--%>
<%--                <form:input path="dayEnd"/>--%>
<%--            </td>--%>
<%--        </tr>--%>
<%--        <tr>--%>
<%--            <td>Visited places:(*): </td>--%>
<%--            <td>--%>
<%--                <form:input path="history"/>--%>
<%--            </td>--%>
<%--        </tr>--%>
<%--        <tr>--%>
<%--            <td>Address:(*): </td>--%>
<%--            <td>--%>
<%--                <form:input path="address"/>--%>
<%--            </td>--%>
<%--        </tr>--%>
<%--        <tr>--%>
<%--            <td>Phone number:(*): </td>--%>
<%--            <td>--%>
<%--                <form:input path="phone"/>--%>
<%--            </td>--%>
<%--        </tr>--%>
<%--        <tr>--%>
<%--            <td>Email:(*): </td>--%>
<%--            <td>--%>
<%--                <form:input path="email"/>--%>
<%--            </td>--%>
<%--        </tr>--%>
<%--        <tr>--%>
<%--            <td><button type="submit" value="Create">Create</button></td>--%>
<%--        </tr>--%>
<%--    </table>--%>

<script src="/jquery/jquery-3.5.1.min.js"></script>
<script src="/jquery/popper.min.js"></script>
<script src="/bootstrap.js"></script>
</body>
</html>
