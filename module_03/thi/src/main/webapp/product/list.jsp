
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>

    <link rel="stylesheet" href="/bootstrap.min.css">

    <style>
        a:hover {
            color: white;
            text-decoration: none;
        }
        .button {
            background-color: #4CAF50; /* Green */
            border: none;
            border-radius: 5px;
            color: white;
            padding: 6px 8px;
            text-align: center;
            text-decoration: none;
            display: inline-block;
            font-size: 15px;
            margin: 4px 2px;
            cursor: pointer;
            -webkit-transition-duration: 0.4s; /* Safari */
            transition-duration: 0.4s;
        }

        .button:hover {
            box-shadow: 0 12px 16px 0 rgba(0,0,0,0.24),0 17px 50px 0 rgba(0,0,0,0.19);
        }
    </style>
    <title>CRUD | Văn Diệp</title>
</head>
<body>
<form class="form-horizontal" method="post" action="list-product">
    <fieldset>

        <!-- Form Name -->
        <div style="margin-top: auto">
            <legend style="margin-top: 40px; text-align: center">PRODUCT DETAIL</legend>
        </div>

        <!-- Text input-->
        <div class="form-group">
            <label class="col-md-4 control-label" for="product_name">Name</label>
            <div class="col-md-4">
                <input id="product_name" name="name" class="form-control input-md" required="" type="text" VALUE="${product.getName()}" disabled>

            </div>
        </div>

        <!-- Text input-->
        <div class="form-group">
            <label class="col-md-4 control-label" for="product_name_fr">Price</label>
            <div class="col-md-4">
                <input id="product_name_fr" name="price" class="form-control input-md" required="" type="text" VALUE="${product.getPrice()}" disabled>

            </div>
        </div>

        <!-- Select Basic -->
        <div class="form-group">
            <label class="col-md-4 control-label" for="product_categorie">Category</label>
            <div class="col-md-4">
                <%--                <select id="product_categorie" name="product_categorie" class="form-control">--%>
                <%--                </select>--%>
                <input id="product_categorie" name="quantity" class="form-control" required="" type="text" VALUE="${product.getQuantity()}" disabled>
            </div>
        </div>

        <!-- Text input-->
        <div class="form-group">
            <label class="col-md-4 control-label" for="available_quantity">Color</label>
            <div class="col-md-4">
                <input id="available_quantity" name="color" class="form-control input-md" required="" type="text" VALUE="${product.getColor()}" disabled>
            </div>
        </div>

        <!-- Text input-->
        <div class="form-group">
            <label class="col-md-4 control-label" for="product_weight">Description</label>
            <div class="col-md-4">
                <input id="product_weight" name="description" class="form-control input-md" required="" type="text" VALUE="${product.getDescription()}" disabled>

            </div>
        </div>



        <!-- Button -->
        <td>
            <button style="background-color: greenyellow; width: 70px" type="button" class="btn"><a href="/furama?action=edit-customer&id=${customer.customerId}">Edit</a></button>
            <button style="background-color: skyblue" onclick="onDelete(${customer.customerId})" type="button" class="btn" data-toggle="modal" data-target="#modelId">Delete</button>
        </td>

    </fieldset>
</form>
<script src="/jquery/jquery-3.5.1.min.js"></script>
<script src="/jquery/popper.min.js"></script>
<script src="/bootstrap.js"></script>
</body>
</html>

