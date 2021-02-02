<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: ADMIN
  Date: 1/31/2021
  Time: 10:18 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<link rel="stylesheet" href="../lib/bootstrap.min.css">
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
    nav a{
        margin-left: 100px;
    }
</style>
<body>
<header class="row" style="background-color: #e3e3e3">
    <img class="col-sm-1" src="../img/logo@2x.png" />
    <div class="col-sm-3"></div>
    <div class="col-sm-3"></div>
    <div class="col-sm-2" style="margin: 40px">
        <h5>Nguyễn Việt Dũng</h5>
    </div>
</header>
<nav class="navbar navbar-expand-lg navbar-light" style="background-color: #194d40; width: 100%">
    <a class="navbar-brand" href="#" style="color: white"><a href="/employee?action=">Home</a></a>
    <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
        <span class="navbar-toggler-icon"></span>
    </button>

    <div class="collapse navbar-collapse" id="navbarSupportedContent">
        <ul class="navbar-nav mr-auto">
            <li class="nav-item active">
                <a class="nav-link" href="#" style="color: white" ><a href="/employee?action=">Employee</a> <span class="sr-only">(current)</span></a>
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
        <div class="col-sm-10" >
            <div align="center">
                <form method="post">
                    <caption>
                        <h2>
                            Edit Employee
                        </h2>
                    </caption>
                    <table border="1" cellpadding="5">
                        <c:if test="${requestScope.employee != null}">
                            <input type="hidden" name="id" value="<c:out value='${requestScope.employee.id}' />"/>
                        </c:if>
                        <tr>
                            <th>Employee Name:</th>
                            <td>
                                <input type="text" name="name" size="45"
                                       value="<c:out value='${requestScope.employee.name}' />"
                                />
                            </td>
                        </tr>
                        <tr>
                            <th>Employee Date Of Birth:</th>
                            <td>
                                <input type="date" name="dateOfBirth" size="15"
                                       value="<c:out value='${requestScope.employee.dateOfBirth}' />"
                                />
                            </td>
                        </tr>
                        <tr>
                            <th>Employee ID Card:</th>
                            <td>
                                <input type="text" name="idCard" size="15"
                                       value="<c:out value='${requestScope.employee.idCard}' />"
                                />
                            </td>
                        </tr>
                        <tr>
                            <th>Employee Salary:</th>
                            <td>
                                <input type="text" name="salary" size="15"
                                       value="<c:out value='${requestScope.employee.salary}' />"
                                />
                            </td>
                        </tr>
                        <tr>
                            <th>Employee Phone:</th>
                            <td>
                                <input type="text" name="phone" size="15"
                                       value="<c:out value='${requestScope.employee.phone}' />"
                                />
                            </td>
                        </tr>
                        <tr>
                            <th>Employee Email:</th>
                            <td>
                                <input type="text" name="email" size="15"
                                       value="<c:out value='${requestScope.employee.email}' />"
                                />
                            </td>
                        </tr>
                        <tr>
                            <th>Employee Address:</th>
                            <td>
                                <input type="text" name="address" size="15"
                                       value="<c:out value='${requestScope.employee.address}' />"
                                />
                            </td>
                        </tr>
                        <tr>
                            <th>Employee User Name:</th>
                            <td>
                                <input type="text" name="userName" size="15"
                                       value="<c:out value='${requestScope.employee.username}' />"
                                />
                            </td>
                        </tr>
                        <tr>
                            <th>Employee Position:</th>
                            <td>
                                <input type="text" name="position" size="15"
                                       value="<c:out value='${requestScope.employee.position}' />"
                                />
                                <select>
                                    <option value="1">1 - Lễ Tân</option>
                                    <option value="2">2 - Phục Vụ</option>
                                    <option value="3">3 - Chuyên Viên</option>
                                    <option value="4">4 - Giám Sát</option>
                                    <option value="5">5 - Quản Lý</option>
                                    <option value="6">6 - Giám Đốc</option>
                                </select>
                            </td>
                        </tr>
                        <tr>
                            <th>Employee Education Degree:</th>
                            <td>
                                <input type="text" name="educationDegree" size="15"
                                       value="<c:out value='${requestScope.employee.educationDegree}' />"
                                />
                                <select>
                                    <option>1 - Trung Cấp</option>
                                    <option>2 - Cao Đẳng</option>
                                    <option>3 - Đại Học</option>
                                    <option>4 - Sau Đại Học</option>
                                </select>
                            </td>
                        </tr>
                        <tr>
                            <th>Employee Division:</th>
                            <td>
                                <input type="text" name="division" size="15"
                                       value="<c:out value='${requestScope.employee.division}' />"
                                />
                                <select>
                                    <option>1 - Sale-Marketing</option>
                                    <option>2 - Hành Chính</option>
                                    <option>3 - Phục Vụ</option>
                                    <option>4 - Quản Lý</option>
                                </select>
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
