<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>
<head>
    <title>Employee List</title>
    <link rel="stylesheet" href="../lib/bootstrap.min.css">
    <script src="//code.jquery.com/jquery-1.11.3.min.js"></script>
    <script type="text/javascript" src="http://ajax.aspnetcdn.com/ajax/jquery.validate/1.13.1/jquery.validate.min.js"></script>
</head>
<style>
    img{
        width: 50px;
        height: 100px;
        margin: 10px 150px;
    }
    nav a {
        margin-left: 100px;
    }
</style>
<body>
<header class="row" style="background-color: #e3e3e3">
    <img class="col-sm-1" src="img/logo@2x.png" />
    <div class="col-sm-3"></div>
    <div class="col-sm-3"></div>
    <div class="col-sm-2" style="margin: 40px">
        <h5>Nguyen Van A</h5>
    </div>
</header>
<nav class="navbar navbar-expand-lg navbar-light" style="background-color: #194d40; width: 100%">
    <a class="navbar-brand" href="/index.jsp" style="color: white">Home</a>
    <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
        <span class="navbar-toggler-icon"></span>
    </button>

    <div class="collapse navbar-collapse" id="navbarSupportedContent">
        <ul class="navbar-nav mr-auto">
            <li class="nav-item">
                <a class="nav-link" href="/products?action=" style="color: white">Product</a>
            </li>
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
            <h5>
                <a href="/products?action=create">Add New Product</a>
            </h5>
        </div>
        <div class="col-sm-10" align="center" >
            <form method="post" id="formDemo">
                <caption><h2>Add New Product</h2></caption>
                <h5 style="color: red"><c:out value="${messenger}"/></h5>
                <table border="1" cellpadding="5">
                    <tr>
                        <th>Name: (*)</th>
                        <td>
                            <input type="text" name="name"  size="45" />
                        </td>
                    </tr>
                    <tr>
                        <th>Price: (*)</th>
                        <td>
                            <input type="text" name="price" size="45"/>
                        </td>
                    </tr>
                    <tr>
                        <th>Discount:</th>
                        <td>
                            <select name="discount">
                                <option value="5">5%</option>
                                <option value="10">10%</option>
                                <option value="15">15%</option>
                                <option value="20">20%</option>
                            </select>
                        </td>
                    </tr>
                    <tr>
                        <th>Stock: (*)</th>
                        <td>
                            <input type="text" name="stock" size="45"/>
                        </td>
                    </tr>
                    <tr>
                        <td colspan="2" align="center">
                            <input type="submit" value="Save"/>
                        </td>
                    </tr>
                </table>
            </form>

        </div>
    </div>
</div>
<footer class="card" style="background-color: #194d40; color: white">
    <div class = "card-header text-center">
        <p>Product &copy; 2021</p>
    </div>
</footer>

<script src="lib/jquery-3.5.1.min.js"></script>
<script src="lib/bootstrap.min.js"></script>

</body>
</html>
