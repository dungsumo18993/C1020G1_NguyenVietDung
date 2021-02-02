<%--
  Created by IntelliJ IDEA.
  User: ADMIN
  Date: 1/31/2021
  Time: 10:18 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<link rel="stylesheet" href="lib/bootstrap.min.css">
<html>
  <head>
    <title>Hệ Thống Quản Lý Khu Nghỉ Dưỡng Furama</title>
  </head>
  <style>
    img{
      width: 50px;
      height: 100px;
      margin: 10px 150px;
    }
    a{
      margin-left: 100px;
    }
  </style>
  <body>
    <header class="row" style="background-color: #e3e3e3">
      <img class="col-sm-1" src="img/logo@2x.png" />
      <div class="col-sm-3"></div>
      <div class="col-sm-3"></div>
      <div class="col-sm-2" style="margin: 40px">
        <h5>Nguyễn Việt Dũng</h5>
      </div>
    </header>
    <nav class="navbar navbar-expand-lg navbar-light" style="background-color: #194d40; width: 100%">
      <a class="navbar-brand" href="#" style="color: white">Home</a>
      <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
        <span class="navbar-toggler-icon"></span>
      </button>

      <div class="collapse navbar-collapse" id="navbarSupportedContent">
        <ul class="navbar-nav mr-auto">
          <li class="nav-item">
            <a class="nav-link" href="/employee?action=" style="color: white">Employee</a>
          </li>
          <li class="nav-item">
            <a class="nav-link" href="/customers?action=" style="color: white">Customer</a>
          </li>
          <li class="nav-item active">
            <a class="nav-link" href="#" style="color: white">Service<span class="sr-only">(current)</span></a>
          </li>
          <li class="nav-item active">
            <a class="nav-link" href="#" style="color: white">Contract<span class="sr-only">(current)</span></a>
          </li>
        </ul>
        <form class="form-inline my-2 my-lg-0">
          <input class="form-control mr-sm-2" type="search" placeholder="Search" aria-label="Search">
          <button class="btn btn-outline-success my-2 my-sm-0" type="submit">Search</button>
        </form>
      </div>
    </nav>
  <div class="container-fluid">
    <div class="row">
      <div class="col-sm-2" style="text-align: center">
          <h5>Item One</h5>
          <h5>Item Two</h5>
          <h5>Item Three</h5>
      </div>
      <div class="col-sm-10" >
        <img src="img/furama-resort-da-nang.jpg" alt="" style="height: 100%; width: 100%; margin: 0">
      </div>
    </div>
  </div>
    <footer class="card" style="background-color: #194d40; color: white">
      <div class = "card-header text-center">
        <p>Furama &copy; 2021</p>
      </div>
    </footer>

<script src="lib/jquery-3.5.1.min.js"></script>
<script src="lib/bootstrap.min.js"></script>
</body>
</html>
