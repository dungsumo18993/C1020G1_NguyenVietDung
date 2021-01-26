<%--
  Created by IntelliJ IDEA.
  User: ADMIN
  Date: 1/25/2021
  Time: 3:48 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
  <head>
    <title>Calculator</title>
  </head>
  <body>
  <h1>Simple Calculator</h1>
  <form action="/calculator">
    <fieldset>
      <legend>Calculator</legend>
      <table>
        <tr>
          <td>First operand: </td>
          <td><input type="text" name="firstNum"></td>
        </tr>
        <tr>
          <td>Operator:</td>
          <td>
            <select name="operator">
              <option value="addition">Addition</option>
              <option value="subtraction">Subtraction</option>
              <option value="multiplication">Multiplication</option>
              <option value="division">Division</option>
            </select>
          </td>
        </tr>
        <tr>
          <td>Second operand:</td>
          <td><input type="text" name="secondNum"></td>
        </tr>
        <tr>
          <td></td>
          <td><input type="submit" placeholder="Calculate"></td>
        </tr>
      </table>
    </fieldset>
  </form>
  </body>
</html>
