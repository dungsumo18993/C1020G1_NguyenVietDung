<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<link rel="stylesheet" href="../lib/bootstrap.min.css">
<html>
<head>
    <title>Employee List</title>
</head>
<style>
    img{
        width: 50px;
        height: 100px;
        margin: 10px 150px;
    }
    nav a{
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
    <a class="navbar-brand" href="#" style="color: white">Home</a>
    <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
        <span class="navbar-toggler-icon"></span>
    </button>

    <div class="collapse navbar-collapse" id="navbarSupportedContent">
        <ul class="navbar-nav mr-auto">
            <li class="nav-item active">
                <a class="nav-link" href="#" style="color: white" ><a href="/employee" >Employee</a> <span class="sr-only">(current)</span></a>
            </li>
            <li class="nav-item">
                <a class="nav-link" href="#" style="color: white">Customer</a>
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
                <a href="/employee?action=create">Add New Employee</a>
            </h5>
        </div>
        <div class="col-sm-10" align="center" >
            <caption><h2>List of Employee</h2></caption>
            <table border="1" cellpadding="5" style="text-align: center">
                <tr>
                    <th>ID</th>
                    <th>Name</th>
                    <th>BirthDay</th>
                    <th>ID Card</th>
                    <th>Salary</th>
                    <th>Phone</th>
                    <th>Email</th>
                    <th>Address</th>
                    <th>Username</th>
                    <th>Position</th>
                    <th>Education Degree</th>
                    <th>Division</th>
                    <th>Actions</th>
                </tr>
                <c:forEach var="employee" items="${employeeList}">
                    <tr>
                        <td><c:out value="${employee.id}"/></td>
                        <td><c:out value="${employee.name}"/></td>
                        <td><c:out value="${employee.dateOfBirth}"/></td>
                        <td><c:out value="${employee.idCard}"/></td>
                        <td><c:out value="${employee.salary}"/></td>
                        <td><c:out value="${employee.phone}"/></td>
                        <td><c:out value="${employee.email}"/></td>
                        <td><c:out value="${employee.address}"/></td>
                        <td><c:out value="${employee.username}"/></td>
                        <td><c:out value="${employee.position}"/></td>
                        <td><c:out value="${employee.educationDegree}"/></td>
                        <td><c:out value="${employee.division}"/></td>
                        <td>
                            <button type="button" class="btn btn-primary" data-toggle="modal" data-target="#exampleModal">
                                <a href="/employee?action=edit&id=${employee.id}" style="color: white">Edit</a>
                            </button>
                            <button type="button" class="btn btn-primary" data-toggle="modal" data-target="#exampleModal">
                                Delete
                            </button>
                        </td>
                    </tr>
                            <!-- Modal -->
                            <div class="modal fade" id="exampleModal" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel" aria-hidden="true">
                                <div class="modal-dialog" role="document">
                                    <div class="modal-content">
                                        <div class="modal-header">
                                            <h5 class="modal-title" id="exampleModalLabel">
                                                Are you sure you want to delete ?</h5>
                                            <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                                                <span aria-hidden="true">&times;</span>
                                            </button>
                                        </div>
                                        <div class="modal-body">
                                            ...
                                        </div>
                                        <div class="modal-footer">
                                            <button type="button" class="btn btn-secondary" data-dismiss="modal">Close</button>
                                            <button class="btn btn-primary">
                                                <a href="/employee?action=delete&id=${employee.id}" style="color: white">Save changes</a>
                                            </button>
                                        </div>
                                    </div>
                                </div>
                            </div>
                        </td>
                    </tr>
                </c:forEach>
            </table>
        </div>
    </div>
</div>
<footer class="card" style="background-color: #194d40; color: white">
    <div class = "card-header text-center">
        <p>Furama &copy; 2021</p>
    </div>
</footer>

<script src="../lib/jquery-3.5.1.min.js"></script>
<script src="../lib/bootstrap.min.js"></script>
</body>
</html>
