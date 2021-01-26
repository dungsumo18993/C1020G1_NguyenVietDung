<%--
  Created by IntelliJ IDEA.
  User: ADMIN
  Date: 1/26/2021
  Time: 4:40 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Detail Product</title>
</head>
<body>
<h1>Product details</h1>
<p>
    <a href="/products">Back to customer list</a>
</p>
<table>
    <tr>
        <td>Name: </td>
        <td>${requestScope.product.name}</td>
    </tr>
    <tr>
        <td>Price: </td>
        <td>${requestScope.product.price}</td>
    </tr>
    <tr>
        <td>Description: </td>
        <td>${requestScope.product.description}</td>
    </tr>
    <tr>
        <td>Producer: </td>
        <td>${requestScope.product.producer}</td>
    </tr>
</table>
</body>
</html>
