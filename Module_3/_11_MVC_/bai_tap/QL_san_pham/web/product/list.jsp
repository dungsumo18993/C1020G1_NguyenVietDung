<%--
  Created by IntelliJ IDEA.
  User: ADMIN
  Date: 1/26/2021
  Time: 3:00 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Product List</title>
</head>
<body>
    <h1>Products</h1>
    <p>
        <a href="/products?action=create">Create new product</a>
    </p>
    <table border="1">
        <tr>
            <td>Name</td>
            <td>Price</td>
            <td>Description</td>
            <td>Producer</td>
            <td>Edit</td>
            <td>Delete</td>
            <td>Detail</td>
        </tr>
        <c:forEach var="product" items='${requestScope["products"]}' >
            <tr>
                <td>${product.name}</td>
                <td>${product.price}</td>
                <td>${product.description}</td>
                <td>${product.producer}</td>
                <td><a href="/products?action=edit&id=${product.id}">edit</a></td>
                <td><a href="/products?action=delete&id=${product.id}">delete</a></td>
                <td><a href="/products?action=view&id=${product.id}">detail</a></td>
            </tr>
        </c:forEach>
    </table>

</body>
</html>
