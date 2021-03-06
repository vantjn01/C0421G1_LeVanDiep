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
          <a class="nav-link" href="/home" style="font-size: 30px; margin-left: 80px">Home</a>
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
      <form class="d-flex" style="position: relative" action="/employee?action=search-employee" method="post">
        <input class="form-control rounded-pill" name="employeeName" id="demo-2" type="search" placeholder="Search employee name" aria-label="Search" style="width: 300px; height: 30px; margin-left: 100px; margin-top: 15px">
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

      <div class="card bg-dark text-white">
        <img src="bien.lang.jpg" class="card-img" alt="..." style="width: 1100px; height: 500px">
        <div class="card-img-overlay">
          <h5 class="card-title" style="color: red;">Furama Resort</h5>
          <p class="card-text" style="color: orange">Khu nghỉ dưỡng Furama, tọa lạc trên bãi biển Đà Nẵng, được coi là khu nghỉ dưỡng có uy tín nhất của Việt Nam, đã vinh dự đón tiếp những vị khách nổi tiếng của hoàng gia cũng như những chính trị gia. Khu nghỉ dưỡng là cửa ngỏ đi đến 3 Di sản thế giới được UNESCO công nhận: phố cổ Hội An, thánh địa Mỹ Sơn và cố đô Huế.</p>
<%--          <p class="card-text">Last updated 3 mins ago</p>--%>
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

