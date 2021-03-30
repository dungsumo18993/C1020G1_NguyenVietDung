<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: ADMIN
  Date: 1/26/2021
  Time: 3:57 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Edit customer</title>
</head>
<body>
<h1>Edit customer</h1>
<p>
    <c:if test='${requestScope["message"] != null}'>
        <span class="message">${requestScope["message"]}</span>
    </c:if>
</p>
<p>
    <a href="/products">Back to product list</a>
</p>
<form method="post">
    <fieldset>
        <legend>Product information</legend>
        <table>
            <tr>
                <td>Name: </td>
                <td><input type="text" name="name" value="${requestScope.product.name}"></td>
            </tr>
            <tr>
                <td>Price: </td>
                <td><input type="text" name="price" value="${requestScope.product.price}"></td>
            </tr>
            <tr>
                <td>Description: </td>
                <td><input type="text" name="description" value="${requestScope.product.description}"></td>
            </tr>
            <tr>
                <td>Producer: </td>
                <td><input type="text" name="producer" value="${requestScope.product.producer}"></td>
            </tr>
            <tr>
                <td></td>
                <td><input type="submit" value="Update customer"></td>
            </tr>
        </table>
    </fieldset>
</form>
</body>
</html>
