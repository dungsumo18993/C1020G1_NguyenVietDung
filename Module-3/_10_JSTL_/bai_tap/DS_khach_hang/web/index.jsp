<%--
  Created by IntelliJ IDEA.
  User: ADMIN
  Date: 1/25/2021
  Time: 11:56 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
  <head>
    <title>Danh Sách Khách Hàng</title>
    <link rel="stylesheet" href="css/bootstrap.min.css">
    <style>
      img {
        width: 150px;
        height: 150px;
      }
      td {
        vertical-align: middle !important;
      }
      * {
        box-sizing: border-box;
      }
    </style>
  </head>
  <body>
  <table class="table">
    <thead>
    <tr>
      <th colspan="6" style="text-align: center">Danh sách khách hàng</th>
    </tr>
    <tr>
      <th scope="col">Name</th>
      <th scope="col">Day of birth</th>
      <th scope="col">Gender</th>
      <th scope="col">Address</th>
      <th scope="col">Number of oders</th>
      <th scope="col">Avatar</th>
    </tr>
    </thead>
    <tbody>
    <c:forEach var="customer" items="${customerListFromServlet}">
      <tr>
        <td><c:out value="${customer.name}"/></td>
        <td><c:out value="${customer.dayOfBirth}"/></td>
        <td>
          <c:if test="${customer.gender == 0}">
            <span style="color:deeppink;">Female</span>
          </c:if>
          <c:if test="${customer.gender == 1}">
            <span style="color:blue;">Male</span>
          </c:if>
        </td>
        <td><c:out value="${customer.address}"/></td>
        <td>
          <c:choose>
            <c:when test="${customer.numberOfOder < 4}">
              <span>Member</span>
            </c:when>
            <c:when test="${customer.numberOfOder < 8}">
              <span style="color: grey">Silver</span>
            </c:when>
            <c:when test="${customer.numberOfOder < 10}">
              <span style="color: gold">Gold</span>
            </c:when>
            <c:otherwise>
              <span style="color: red">Diamond</span>
            </c:otherwise>
          </c:choose>
        </td>
        <td><img src="${customer.image}"/></td>
      </tr>
    </c:forEach>
    </tbody>
  </table>
  </body>
</html>
