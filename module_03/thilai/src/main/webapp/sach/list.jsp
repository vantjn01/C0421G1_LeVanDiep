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

<div class="container-fluid">
    <div class="row">
<%--        <div class="col-lg-12">--%>
<%--            <div class="row">--%>
                <div class="col-lg-12">
                    <input type="hidden" name="action" value="list-sach">
                    <center>
<%--                        <h1>Danh sách sach</h1>--%>
                        <h2>
                            <a href="/sach">Danh sách sách</a>
<%--                            <caption><h2>Danh sách sách</h2></caption>--%>
                            <p>
                                <c:if test='${requestScope["msg"] != null}'>
                                    <span class="message" style="color: red; font-style: italic; font-size: 20px">${requestScope["msg"]}</span>
                                </c:if>
                            </p>
                        </h2>
                    </center>
                    <div align="center">
                        <c:if test="${empty listSach}">
                            <h3 style="color: red">Sách trống!</h3>
                        </c:if>
                        <c:if test="${not empty listSach}">
                            <table border="1" cellpadding="5" style="margin-bottom: 30px">
                                <tr style="text-align: center">
                                    <th>ID</th>
                                    <th>Tên sách</th>
                                    <th>Tác giả</th>
                                    <th>Mô tả</th>
                                    <th>Số lượng</th>
<%--                                    <th>Gender</th>--%>
<%--                                    <th>ID Card</th>--%>
<%--                                    <th>Phone</th>--%>
<%--                                    <th>Email</th>--%>
<%--                                    <th>Address</th>--%>
                                    <th colspan="2">Action</th>
                                </tr>
                                <c:forEach var="sach" items="${listSach}">
                                    <tr>
                                        <td><c:out value="${sach.id_sach}"/></td>
                                        <td><c:out value="${sach.ten_sach}"/></td>
<%--                                        <td>--%>
<%--                                            <c:choose>--%>
<%--                                                <c:when test="${customer.customerTypeId == 1}">Diamond</c:when>--%>
<%--                                                <c:when test="${customer.customerTypeId == 2}">Platinium</c:when>--%>
<%--                                                <c:when test="${customer.customerTypeId == 3}">Gold</c:when>--%>
<%--                                                <c:when test="${customer.customerTypeId == 4}">Silver</c:when>--%>
<%--                                                <c:otherwise>Member</c:otherwise>--%>
<%--                                            </c:choose>--%>
<%--                                        </td>--%>
                                        <td><c:out value="${sach.tac_gia}"/></td>
                                        <td><c:out value="${sach.mo_ta}"/></td>
<%--                                        <td>--%>
<%--                                            <c:choose>--%>
<%--                                                <c:when test="${customer.customerGender == 0}">Male</c:when>--%>
<%--                                                <c:when test="${customer.customerGender == 1}">Female</c:when>--%>
<%--                                                <c:otherwise>Other</c:otherwise>--%>
<%--                                            </c:choose>--%>
<%--                                        </td>--%>
                                        <td><c:out value="${sach.so_luong}"/></td>
<%--                                        <td><c:out value="${customer.customerPhone}"/></td>--%>
<%--                                        <td><c:out value="${customer.customerEmail}"/></td>--%>
<%--                                        <td><c:out value="${customer.customerAddress}"/></td>--%>
                                        <td>
                                            <button style="background-color: greenyellow; width: 70px" type="button" class="btn"><a href="/sach?action=muon-sach&id=${sach.id_sach}">Mượn</a></button>
<%--                                            <button style="background-color: skyblue" onclick="onDelete(${customer.customerId})" type="button" class="btn" data-toggle="modal" data-target="#modelId">Delete</button>--%>
                                        </td>
                                    </tr>
                                </c:forEach>
                            </table>
                        </c:if>
                    </div>
<%--                </div>--%>
<%--            </div>--%>
        </div>
    </div>
<%--    <div class="container-fluid">--%>
<%--        <div class="row text-center" style="background-color: #0dcaf0">--%>
<%--            <div class="col-lg-12">--%>
<%--                <p style=" display: flex; flex-direction: column; justify-content: center; text-align: center; font-weight: bold; font-size: 20px;--%>
<%--               width: 100%; margin-top: 15px">Contact US</p>--%>
<%--                <p style=" display: flex; flex-direction: column; justify-content: center; text-align: center;--%>
<%--               width: 100%"> 103 - 105 Vo Nguyen Giap Street, Khue My Ward, Ngu Hanh Son District, Danang City, Vietnam</p>--%>
<%--            </div>--%>
<%--        </div>--%>
<%--    </div>--%>
</div>

<%--<!-- Modal -->--%>
<%--<div class="modal fade" id="modelId" tabindex="-1" role="dialog" aria-labelledby="modelTitleId" aria-hidden="true">--%>
<%--    <div class="modal-dialog" role="document">--%>
<%--        <div class="modal-content">--%>
<%--            <div class="modal-header">--%>
<%--                <h5 class="modal-title">Confirm delete</h5>--%>
<%--                <button type="button" class="close" data-dismiss="modal" aria-label="Close">--%>
<%--                    <span aria-hidden="true">&times;</span>--%>
<%--                </button>--%>
<%--            </div>--%>
<%--            <form>--%>
<%--                <input type="hidden" name="action" value="delete-customer">--%>
<%--                <input type="hidden" name="id" value="" id="idCustomerDelete">--%>
<%--                <div class="modal-body">--%>
<%--                    Delete this customer?--%>
<%--                </div>--%>
<%--                <div class="modal-footer">--%>
<%--                    <button type="button" class="btn btn-secondary" data-dismiss="modal">Cancel</button>--%>
<%--                    <button type="submit" class="btn btn-primary">Confirm</button>--%>
<%--                </div>--%>
<%--            </form>--%>
<%--        </div>--%>
<%--    </div>--%>
<%--</div>--%>


<script src="/jquery/jquery-3.5.1.min.js"></script>
<script src="/jquery/popper.min.js"></script>
<script src="/bootstrap.js"></script>

<%--<script>--%>
<%--    function onDelete(id) {--%>
<%--        document.getElementById("idCustomerDelete").value = id;--%>
<%--    }--%>
<%--</script>--%>
</body>
</html>
