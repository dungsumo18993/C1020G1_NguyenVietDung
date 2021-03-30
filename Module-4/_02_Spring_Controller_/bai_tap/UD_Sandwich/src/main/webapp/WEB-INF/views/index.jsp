<%--
  Created by IntelliJ IDEA.
  User: ADMIN
  Date: 2/23/2021
  Time: 11:20 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
  <head>
    <title>Hiển Thị Gia Vị Sandwich</title>
  </head>
  <body>
  <form action="/save">
    <h1>Sandwich Condiments</h1>
    <input type="checkbox" name="condiment" value="Lettuce">Lettuce
    <input type="checkbox" name="condiment" value="Tomato">Tomato
    <input type="checkbox" name="condiment" value="Mustard">Mustard
    <input type="checkbox" name="condiment" value="Sprouts">Sprouts
    <hr  width="30%" align="left" />
    <input type="submit" value="Save">
  </form>
  <h2 style="color: blue">${condiment}</h2>

  </body>
</html>
