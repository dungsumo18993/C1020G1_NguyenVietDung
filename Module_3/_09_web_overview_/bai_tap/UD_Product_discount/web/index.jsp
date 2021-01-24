<%--
  Created by IntelliJ IDEA.
  User: ADMIN
  Date: 1/24/2021
  Time: 9:35 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
  <head>
    <title>Product Discount</title>
  </head>
  <body>
  <h2>Product</h2>
  <form method="post" action="/display_discount">
    <p>Product Description: </p>
    <input type="text" name="productName">
    <p>List Price: </p>
    <input type="text" name="price">
    <p>Discount Percent (%): </p>
    <input type="text" name="discount"></br>
    <input type = "submit" id = "submit" value = "Calculate Discount"/>
  </form>
  </body>
</html>
