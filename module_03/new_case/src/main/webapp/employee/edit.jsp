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
<body>
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
                    <a class="nav-link " href="/furama?action=list-customer" style="font-size: 30px; padding-left: 30px">Customer</a>
                </li>
                <li class="nav-item hover-item" >
                    <a class="nav-link " href="#" style="font-size: 30px; padding-left: 30px">Service</a>
                </li>
                <li class="nav-item hover-item" >
                    <a class="nav-link " href="#" style="font-size: 30px; padding-left: 30px">Contract</a>
                </li>
            </ul>
            <form class="d-flex" style="position: relative">
                <input class="form-control rounded-pill" id="demo-2" type="search" placeholder="Search" aria-label="Search" style="width: 300px; height: 30px; margin-left: 100px; margin-top: 15px">
            </form>
        </div>
    </div>
</nav>
<div class="container-fluid">
<%--    <div class="row">--%>
<%--        <div class="col-lg-2" style=" background-color: rgba(121,120,118,0.25)">--%>
<%--            <div class="row">--%>
<%--                <div class="col-lg-12 my-lg-1 mx-3">--%>
<%--                    <a href="#" style="text-decoration: none; font-size: 25px">Item one</a>--%>
<%--                </div>--%>
<%--            </div>--%>
<%--            <div class="row">--%>
<%--                <div class="col-lg-12 my-lg-1 mx-3">--%>
<%--                    <a href="#" style="text-decoration: none; font-size: 25px">Item two</a>--%>
<%--                </div>--%>
<%--            </div>--%>
<%--            <div class="row">--%>
<%--                <div class="col-lg-12 my-lg-1 mx-3">--%>
<%--                    <a href="#" style="text-decoration: none; font-size: 25px">Item three</a>--%>
<%--                </div>--%>
<%--            </div>--%>
<%--        </div>--%>
    <div class="col-lg-12"  style="background-image: url('https://hoaidoan.vn/wp-content/uploads/2021/03/background-dep-2.png')">
        <input type="hidden" name="action" value="">
        <div class="row">
            <div class="col-lg-12">
                <h1 style="text-align: center">Editing Employee</h1>
                <center>
                    <p>
                        <c:if test='${requestScope["msg"] != null}'>
                            <span class="message" style="color: blue; font-weight: bold; text-align: center">${requestScope["msg"]}</span>
                        </c:if>
                    </p>
                    <form method="post" style="alignment: center">
                        <input type="hidden" name="action" value="edit-employee">
                        <table border="1" cellpadding="5">
                            <c:if test="${employee != null}">
                                <input type="hidden" name="id" value="<c:out value='${employee.employee_id}' />"/>
                            </c:if>
                            <tr>
                                <th>Employee name:</th>
                                <td>
                                    <input type="text" name="name"
                                           value="<c:out value='${employee.employee_name}' />"
                                    />
                                </td>
                            </tr>
                            <tr>
                                <th>Day of birth:</th>
                                <td>
                                    <input type="text" name="dob"
                                           value="<c:out value='${employee.employee_birthday}' />"
                                    />
                                </td>
                            </tr>
                            <tr>
                                <th>ID Card:</th>
                                <td>
                                    <input type="text" name="card"
                                           value="<c:out value='${employee.employee_id_card}' />"
                                    />
                                </td>
                            </tr>
                            <tr>
                                <th>Salary:</th>
                                <td>
                                    <input type="number" name="salary"
                                           value="<c:out value='${employee.employee_salary}' />"
                                    />
                                </td>
                            </tr>
                            <tr>
                                <th>Phone number:</th>
                                <td>
                                    <input type="number" name="phone"
                                           value="<c:out value='${employee.employee_phone}' />"
                                    />
                                </td>
                            </tr>
                            <tr>
                                <th>Email:</th>
                                <td>
                                    <input type="text" name="email"
                                           value="<c:out value='${employee.employee_email}' />"
                                    />
                                </td>
                            </tr>
                            <tr>
                                <th>Address:</th>
                                <td>
                                    <input type="text" name="address"
                                           value="<c:out value='${employee.employee_address}' />"
                                    />
                                </td>
                            </tr>
                            <tr>
                                <th>Position:</th>
                                <td>
                                    <select name="position" style="width: 182px">
                                        <c:forEach var="position" items="${positionList}">
                                            <option value='${position.positionId}' >${position.positionName}</option>
                                        </c:forEach>
                                    </select>
                                </td>
                            </tr>
                            <tr>
                                <th>Education degree:</th>
                                <td>
                                    <select name="education" style="width: 182px">
                                        <c:forEach var="education" items="${educationList}">
                                            <option value='${education.educationId}' >${education.educationName}</option>
                                        </c:forEach>
                                    </select>
                                </td>
                            </tr>
                            <tr>
                                <th>Division:</th>
                                <td>
                                    <select name="division" style="width: 182px">
                                        <c:forEach var="division" items="${divisionList}">
                                            <option value='${division.divisionId}' >${division.divisionName}</option>
                                        </c:forEach>
                                    </select>
                                </td>
                            </tr>
                            <tr>
                                <th>Username:</th>
                                <td>
                                    <select name="username" style="width: 182px">
                                        <c:forEach var="username" items="${userList}">
                                            <option value='${username.username}' >${username.username}</option>
                                        </c:forEach>
                                    </select>
                                </td>
                            </tr>
                            <tr>
                                <td></td>
                                <td align="center" class="rounded-pill" style="width: 150px">
                                    <input class="rounded-pill" style="width: 100px" type="submit" value="Save"/>
                                </td>
                            </tr>
                        </table>
                    </form>
                </center>
            </div>
        </div>
    </div>
</div>
<div class="container-fluid">
    <div class="row text-center" style="background-color: #0dcaf0">
        <div class="col-lg-12">
            <p style=" display: flex; flex-direction: column; justify-content: center; text-align: center; font-weight: bold; font-size: 20px;
               width: 100%; margin-top: 15px">Contact US</p>
            <p style=" display: flex; flex-direction: column; justify-content: center; text-align: center;
               width: 100%"> 103 - 105 Vo Nguyen Giap Street, Khue My Ward, Ngu Hanh Son District, Danang City, Vietnam</p>
        </div>
    </div>
</div>

</body>
</html>
