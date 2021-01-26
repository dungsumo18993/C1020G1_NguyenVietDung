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
  <fieldset>
    <legend style="color: blue">Product</legend>
    <form method="post" action="/display_discount">
      <table>
        <tr>
          <td>Product Description: </td>
          <td><input type="text" name="productName"></td>
        </tr>
        <tr>
          <td>List Price: </td>
          <td><input type="text" name="price"></td>
        </tr>
        <tr>
          <td>Discount Percent (%): </td>
          <td><input type="text" name="discount"></td>
        </tr>
        <tr>
          <td></td>
          <td><input type = "submit" id = "submit" value = "Calculate Discount"/></td>
        </tr>
      </table>
    </form>
  </fieldset>

  </body>
</html>
