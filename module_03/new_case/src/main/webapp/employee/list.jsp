<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <link rel="stylesheet" href="/bootstrap.min.css">
    <style>
        #name:hover {
            color: #523e02;
        }
        input {
            outline: none;
        }
        input[type=search] {
            -webkit-appearance: textfield;
            -webkit-box-sizing: content-box;
            font-family: inherit;
            font-size: 100%;
        }
        input::-webkit-search-decoration,
        input::-webkit-search-cancel-button {
            display: none;
        }
        input[type=search] {
            background: #ededed url(https://static.tumblr.com/ftv85bp/MIXmud4tx/search-icon.png) no-repeat 9px center;
            border: solid 1px #ccc;
            padding: 9px 10px 9px 32px;
            width: 55px;
            -webkit-border-radius: 10em;
            -moz-border-radius: 10em;
            border-radius: 10em;
            -webkit-transition: all .5s;
            -moz-transition: all .5s;
            transition: all .5s;
        }
        input[type=search]:focus {
            width: 130px;
            background-color: #fff;
            border-color: #66CC75;
            -webkit-box-shadow: 0 0 5px rgba(109,207,246,.5);
            -moz-box-shadow: 0 0 5px rgba(109,207,246,.5);
            box-shadow: 0 0 5px rgba(109,207,246,.5);
        }
        input:-moz-placeholder {
            color: #999;
        }
        input::-webkit-input-placeholder {
            color: #999;
        }
    </style>
</head>
<nav class="navbar navbar-expand-lg navbar-light sticky-top" style="background-color: rgba(217,215,210,0.94)">
    <div class="container-fluid">
        <a class="navbar-brand" href="#"><img width="200px" height="60px" src="/logoFURAMA.jpg"></a>
        <span style="float: right; font-size: 25px"><a href="#" id="name" style="text-decoration: none"> Nguyễn Văn A </a></span>
    </div>
</nav>
<nav class="navbar navbar-expand-lg navbar-light bg-light sticky-top" style="margin: 5px">
    <div class="container-fluid">
        <div class="collapse navbar-collapse" id="navbarSupportedContent">
            <ul class="navbar-nav me-auto mb-2 mb-lg-0">
                <li class="nav-item mx-3 hover-item">
                    <a class="nav-link" href="/furama" style="font-size: 30px; margin-left: 80px">Home</a>
                </li>
                <li class="nav-item hover-item">
                    <a class="nav-link " href="/employee" style="font-size: 30px; padding-left: 30px">Employee</a>
                </li>
                <li class="nav-item hover-item" >
                    <a class="nav-link " href="/furama" style="font-size: 30px; padding-left: 30px">Customer</a>
                </li>
                <li class="nav-item hover-item" >
                    <a class="nav-link " href="/furama?action=list-service" style="font-size: 30px; padding-left: 30px">Service</a>
                </li>
                <li class="nav-item hover-item" >
                    <a class="nav-link " href="/furama?action=list-contract" style="font-size: 30px; padding-left: 30px">Contract</a>
                </li>
            </ul>
            <form class="d-flex" style="position: relative" action="/furama?action=search-employee" method="post">
                <input class="form-control rounded-pill" name="employeeName" id="demo-2" type="search" placeholder="Search employee name" aria-label="Search" style="width: 300px; height: 30px; margin-left: 100px; margin-top: 15px">
            </form>
        </div>
    </div>
</nav>
<div class="container-fluid">
    <div class="row">
<%--        <div class="col-lg-1" style=" background-color: rgba(121,120,118,0.25)">--%>
<%--            <div class="row">--%>
<%--                <div class="col-lg-12 my-lg-1 mx-3">--%>
<%--                    <a href="/furama?action=meeting-info" style="text-decoration: none; font-size: 25px">MEETINGS</a>--%>
<%--                </div>--%>
<%--            </div>--%>
<%--            <div class="row">--%>
<%--                <div class="col-lg-12 my-lg-1 mx-3">--%>
<%--                    <a href="/furama?action=culinary" style="text-decoration: none; font-size: 25px">CULINARY</a>--%>
<%--                </div>--%>
<%--            </div>--%>
<%--            <div class="row">--%>
<%--                <div class="col-lg-12 my-lg-1 mx-3">--%>
<%--                    <a href="/furama?action=spa" style="text-decoration: none; font-size: 25px">SPA & FITNESS</a>--%>
<%--                </div>--%>
<%--            </div>--%>
<%--        </div>--%>
        <div class="col-lg-12" style="background-image: url('https://hoaidoan.vn/wp-content/uploads/2021/03/background-dep-2.png')">
            <div class="row">
                <div class="col-lg-12">
                    <input type="hidden" name="action" value="list-employee">
                    <center>
                        <h1>Employee Management</h1>
                        <h2>
                            <a href="/employee?action=create-employee">Add New Employee</a>
                            <caption><h2>List of Employee</h2></caption>
                            <p>
                                <c:if test='${requestScope["msg"] != null}'>
                                    <span class="message" style="color: red; font-style: italic; font-size: 20px">${requestScope["msg"]}</span>
                                </c:if>
                            </p>
                        </h2>
                    </center>
                    <div align="center">
                        <c:if test="${empty listEmployee}">
                            <h3 style="color: red">Employee List is empty!</h3>
                        </c:if>
                        <c:if test="${not empty listEmployee}">
                            <table border="1" cellpadding="5" style="margin-bottom: 30px">
                                <tr style="text-align: center">
                                    <th>ID</th>
                                    <th>Name</th>
                                    <th>Day of birth</th>
                                    <th>ID Card</th>
                                    <th>Salary</th>
                                    <th>Phone</th>
                                    <th>Email</th>
                                    <th>Address</th>
                                    <th>Position</th>
                                    <th>Education Degree</th>
                                    <th>Division</th>
                                    <th>Username</th>
                                    <th colspan="2">Action</th>
                                </tr>
                                <c:forEach var="employee" items="${listEmployee}">
                                    <tr>
                                        <td><c:out value="${employee.employee_id}"/></td>
                                        <td><c:out value="${employee.employee_name}"/></td>
                                        <td><c:out value="${employee.employee_birthday}"/></td>
                                        <td><c:out value="${employee.employee_id_card}"/></td>
                                        <td><c:out value="${employee.employee_salary}"/></td>
                                        <td><c:out value="${employee.employee_phone}"/></td>
                                        <td><c:out value="${employee.employee_email}"/></td>
                                        <td><c:out value="${employee.employee_address}"/></td>
                                        <td>
                                            <c:choose>
                                                <c:when test="${employee.position_id == 1}">Lễ tân</c:when>
                                                <c:when test="${employee.position_id == 2}">Phục vụ</c:when>
                                                <c:when test="${employee.position_id == 3}">Chuyên viên</c:when>
                                                <c:when test="${employee.position_id == 4}">Giám sát</c:when>
                                                <c:when test="${employee.position_id == 5}">Quản lý</c:when>
                                                <c:otherwise>Giám đốc</c:otherwise>
                                            </c:choose>
                                        </td>
                                        <td>
                                            <c:choose>
                                                <c:when test="${employee.education_degree_id == 1}">Trung cấp</c:when>
                                                <c:when test="${employee.education_degree_id == 2}">Cao Đẳng</c:when>
                                                <c:when test="${employee.education_degree_id == 3}">Đại học</c:when>
                                                <c:otherwise>Sau đại học</c:otherwise>
                                            </c:choose>
                                        </td>
                                        <td>
                                            <c:choose>
                                                <c:when test="${employee.division_id == 1}">Sale – Marketing</c:when>
                                                <c:when test="${employee.division_id == 2}">Hành chính</c:when>
                                                <c:when test="${employee.division_id == 3}">Phục vụ</c:when>
                                                <c:otherwise>Quản lý</c:otherwise>
                                            </c:choose>
                                        </td>
<%--                                        <td>--%>
<%--&lt;%&ndash;                                            <c:choose>&ndash;%&gt;--%>
<%--&lt;%&ndash;                                                <c:when test="${employee.username == vandiep01}">12345678</c:when>&ndash;%&gt;--%>
<%--&lt;%&ndash;                                                <c:when test="${employee.username == vandiep02}">12345678</c:when>&ndash;%&gt;--%>
<%--&lt;%&ndash;                                                <c:otherwise>12345678</c:otherwise>&ndash;%&gt;--%>
<%--&lt;%&ndash;                                            </c:choose>&ndash;%&gt;--%>
<%--                                        </td>--%>
                                        <td><c:out value="${employee.username}"/></td>
                                        <td>
                                            <button style="background-color: rgba(182,201,170,0.82); width: 70px" type="button" class="btn rounded-pill"><a href="/employee?action=edit-employee&id=${employee.employee_id}">Edit</a></button>
                                            <button style="background-color: rgba(188,49,55,0.92)" onclick="onDelete(${employee.employee_id})" type="button" class="btn rounded-pill" data-toggle="modal" data-target="#modelId">Delete</button>
                                        </td>
                                    </tr>
                                </c:forEach>
                            </table>
                        </c:if>
                    </div>
                </div>
            </div>
        </div>
    </div>
    <div class="container-fluid">
        <div class="row text-center" style="background-color: rgba(100,188,170,0.92)">
            <div class="col-lg-12">
                <p style=" display: flex; flex-direction: column; justify-content: center; text-align: center; font-weight: bold; font-size: 20px;
               width: 100%; margin-top: 15px">Contact US</p>
                <p style=" display: flex; flex-direction: column; justify-content: center; text-align: center;
               width: 100%"> 103 - 105 Vo Nguyen Giap Street, Khue My Ward, Ngu Hanh Son District, Danang City, Vietnam</p>
            </div>
        </div>
    </div>
</div>



<script src="/jquery/jquery-3.5.1.min.js"></script>
<script src="/jquery/popper.min.js"></script>
<script src="/bootstrap.js"></script>

<script>
</script>
</body>
</html>
