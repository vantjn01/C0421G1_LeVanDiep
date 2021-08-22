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

<div class="container-fluid">
    <div class="row">
        <div class="col-lg-12">
            <input type="hidden" name="action" value="">
            <div class="row">
                <div class="col-lg-12">
                    <h1 style="text-align: center">mượn sách</h1>
                    <center>
                        <p>
                            <c:if test='${requestScope["msg"] != null}'>
                                <span class="message" style="color: blue; font-weight: bold; text-align: center">${requestScope["msg"]}</span>
                            </c:if>
                        </p>
                        <form method="post" style="alignment: center">
                            <input type="hidden" name="action" value="edit-sach">
                            <table align="center">
                                <tr>
                                    <th>Mã mượn sách </th>
                                    <td>
                                        <input type="text" name="id_sach"
                                               value="<c:out value='${sach.id_sach}' />"
                                        />
                                    </td>
                                </tr>
<%--                                <tr>--%>
<%--                                    <td>Type ID:</td>--%>
<%--                                    <td>--%>
<%--                                        <select name="type" style="width: 182px">--%>
<%--                                            <c:forEach var="customerType" items="${typeList}">--%>
<%--                                                <option value='${customerType.customerTypeId}' >${customerType.customerTypeName}</option>--%>
<%--                                            </c:forEach>--%>
<%--                                        </select>--%>
<%--                                    </td>--%>
<%--                                </tr>--%>
                                <tr>
                                    <td>Tên sách</td>
                                    <td>
                                        <input type="text" name="ten_sach"
                                               value=<c:out value="${sach.ten_sach}" />
                                        />
                                    </td>
                                </tr>
                                <tr>
                                    <td>Tên học sinh:</td>
                                    <td>
                                        <input type="text" name="hoc_sinh"
                                               value=<c:out value="${hoc_sinh.ho_ten}"/>
                                        />
                                    </td>
                                </tr>
<%--                                <tr>--%>
<%--                                    <td>Gender:</td>--%>
<%--                                    <td>--%>
<%--                                        <select name="gender" style="width: 182px">--%>
<%--                                            <option selected>Choose one</option>--%>
<%--                                            <option value="0">Male</option>--%>
<%--                                            <option value="1">Female</option>--%>
<%--                                        </select>--%>
<%--                                    </td>--%>
<%--                                </tr>--%>
                                <tr>
                                    <td>Số lượng:</td>
                                    <td>
                                        <input type="text" name="so_luong"
                                               value=<c:out value="${sach.so_luong}"/>
                                        />
                                    </td>
                                </tr>
<%--                                <tr>--%>
<%--                                    <td>Phone number:</td>--%>
<%--                                    <td>--%>
<%--                                        <input type="text" name="phone"--%>
<%--                                               value=<c:out value="${customer.customerPhone}"/>--%>
<%--                                        />--%>
<%--                                    </td>--%>
<%--                                </tr>--%>
<%--                                <tr>--%>
<%--                                    <td>Email:</td>--%>
<%--                                    <td>--%>
<%--                                        <input type="text" name="email"--%>
<%--                                               value=<c:out value="${customer.customerEmail}"/>--%>
<%--                                        />--%>
<%--                                    </td>--%>
<%--                                </tr>--%>
<%--                                <tr>--%>
<%--                                    <td>Address:</td>--%>
<%--                                    <td>--%>
<%--                                        <input type="text" name="address"--%>
<%--                                               value="<c:out value='${customer.customerAddress}' />"--%>
<%--                                        />--%>
<%--                                    </td>--%>
<%--                                </tr>--%>
                                <tr>
                                    <td></td>
                                    <td>
                                        <button class="rounded-pill my-lg-1" type="submit" style="width: 160px; height: 35px">Mượn</button>
                                    </td>
                                </tr>
                            </table>
                        </form>
                    </center>
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
</body>
</html>