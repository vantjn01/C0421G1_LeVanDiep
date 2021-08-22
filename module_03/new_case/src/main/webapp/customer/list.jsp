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
<body >
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
                    <a class="nav-link" href="/" style="font-size: 30px; margin-left: 80px">Home</a>
                </li>
                <li class="nav-item hover-item">
                    <a class="nav-link " href="/employee" style="font-size: 30px; padding-left: 30px">Employee</a>
                </li>
                <li class="nav-item hover-item" >
                    <a class="nav-link " href="/furama" style="font-size: 30px; padding-left: 30px">Customer</a>
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
    <div class="row">
        <div class="col-lg-2" style=" background-color: rgba(121,120,118,0.25)">
            <div class="row">
                <div class="col-lg-12 my-lg-1 mx-3">
                    <a href="#" style="text-decoration: none; font-size: 25px">Item one</a>
                </div>
            </div>
            <div class="row">
                <div class="col-lg-12 my-lg-1 mx-3">
                    <a href="#" style="text-decoration: none; font-size: 25px">Item two</a>
                </div>
            </div>
            <div class="row">
                <div class="col-lg-12 my-lg-1 mx-3">
                    <a href="#" style="text-decoration: none; font-size: 25px">Item three</a>
                </div>
            </div>
        </div>
        <div class="col-lg-10">
            <div class="row">
                <div class="col-lg-12">
                    <input type="hidden" name="action" value="list-customer">
                    <center>
                        <h1>Customer Management</h1>
                        <h2>
                            <a href="/furama?action=create-customer">Add New Customer</a>
                            <caption><h2>List of Customer</h2></caption>
                            <p>
                                <c:if test='${requestScope["msg"] != null}'>
                                    <span class="message" style="color: red; font-style: italic; font-size: 20px">${requestScope["msg"]}</span>
                                </c:if>
                            </p>
                        </h2>
                    </center>
                    <div align="center">
                        <c:if test="${empty listCustomer}">
                            <h3 style="color: red">Customer List Empty!</h3>
                        </c:if>
                        <c:if test="${not empty listCustomer}">
                            <table border="1" cellpadding="5" style="margin-bottom: 30px">
                                <tr style="text-align: center">
                                    <th>ID</th>
                                    <th>Code</th>
                                    <th>Type</th>
                                    <th>Name</th>
                                    <th>Day of birth</th>
                                    <th>Gender</th>
                                    <th>ID Card</th>
                                    <th>Phone</th>
                                    <th>Email</th>
                                    <th>Address</th>
                                    <th colspan="2">Action</th>
                                </tr>
                                <c:forEach var="customer" items="${listCustomer}">
                                    <tr>
                                        <td><c:out value="${customer.customerId}"/></td>
                                        <td><c:out value="${customer.customerCode}"/></td>
                                        <td>
                                            <c:choose>
                                                <c:when test="${customer.customerTypeId == 1}">Diamond</c:when>
                                                <c:when test="${customer.customerTypeId == 2}">Platinium</c:when>
                                                <c:when test="${customer.customerTypeId == 3}">Gold</c:when>
                                                <c:when test="${customer.customerTypeId == 4}">Silver</c:when>
                                                <c:otherwise>Member</c:otherwise>
                                            </c:choose>
                                        </td>
                                        <td><c:out value="${customer.customerName}"/></td>
                                        <td><c:out value="${customer.customerBirthday}"/></td>
                                        <td>
                                            <c:choose>
                                                <c:when test="${customer.customerGender == 0}">Male</c:when>
                                                <c:when test="${customer.customerGender == 1}">Female</c:when>
                                                <c:otherwise>Other</c:otherwise>
                                            </c:choose>
                                        </td>
                                        <td><c:out value="${customer.customerIdCard}"/></td>
                                        <td><c:out value="${customer.customerPhone}"/></td>
                                        <td><c:out value="${customer.customerEmail}"/></td>
                                        <td><c:out value="${customer.customerAddress}"/></td>
                                        <td>
                                            <button style="background-color: greenyellow; width: 70px" type="button" class="btn"><a href="/furama?action=edit-customer&id=${customer.customerId}">Edit</a></button>
                                            <button style="background-color: skyblue" onclick="onDelete(${customer.customerId})" type="button" class="btn" data-toggle="modal" data-target="#modelId">Delete</button>
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
        <div class="row text-center" style="background-color: #0dcaf0">
            <div class="col-lg-12">
                <p style=" display: flex; flex-direction: column; justify-content: center; text-align: center; font-weight: bold; font-size: 20px;
               width: 100%; margin-top: 15px">Contact US</p>
                <p style=" display: flex; flex-direction: column; justify-content: center; text-align: center;
               width: 100%"> 103 - 105 Vo Nguyen Giap Street, Khue My Ward, Ngu Hanh Son District, Danang City, Vietnam</p>
            </div>
        </div>
    </div>
</div>

<!-- Modal -->
<div class="modal fade" id="modelId" tabindex="-1" role="dialog" aria-labelledby="modelTitleId" aria-hidden="true">
    <div class="modal-dialog" role="document">
        <div class="modal-content">
            <div class="modal-header">
                <h5 class="modal-title">Confirm delete</h5>
                <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                    <span aria-hidden="true">&times;</span>
                </button>
            </div>
            <form>
                <input type="hidden" name="action" value="delete-customer">
                <input type="hidden" name="id" value="" id="idCustomerDelete">
                <div class="modal-body">
                   Delete this customer?
                </div>
                <div class="modal-footer">
                    <button type="button" class="btn btn-secondary" data-dismiss="modal">Cancel</button>
                    <button type="submit" class="btn btn-primary">Confirm</button>
                </div>
            </form>
        </div>
    </div>
</div>


<script src="/jquery/jquery-3.5.1.min.js"></script>
<script src="/jquery/popper.min.js"></script>
<script src="/bootstrap.js"></script>

<script>
    function onDelete(id) {
        document.getElementById("idCustomerDelete").value = id;
    }
</script>
</body>
</html>
