<%--
  Created by IntelliJ IDEA.
  User: ADMIN
  Date: 2/23/2021
  Time: 12:25 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
  <head>
    <title>Calculator</title>
  </head>
  <body>
  <h1>Calculator</h1>
  <form action="/calculate" method="post">
    <input type="text" name="number1">
    <input type="text" name="number2">
    <hr  width="30%" align="left" />
    <button type="submit" name="cal" value="Addition">Addition(+)</button>
    <button type="submit" name="cal" value="Subtraction">Subtraction(-)</button>
    <button type="submit" name="cal" value="Multiplication">Multiplication(*)</button>
    <button type="submit" name="cal" value="Division">Division(/)</button>
  </form>
  <h2>Result ${cal}: <span style="color: red">${result}</span> </h2>
  </body>
</html>
