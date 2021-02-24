<%--
  Created by IntelliJ IDEA.
  User: ADMIN
  Date: 2/24/2021
  Time: 11:04 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<html>
  <head>
    <title>Hòm thư điện tử</title>
  </head>
  <body>
  <h1>Settings</h1>
  <form:form action="addEmail" method="post" modelAttribute="email">
    <table>
      <tr>
        <td><form:label path="language">Languages: </form:label></td>
        <td><form:select path="language" items="${language}"/></td>
      </tr>
      <tr>
        <td><form:label path="size">Page size: </form:label></td>
        <td>
          Show
          <form:select path="size" items="${size}"/>
          email per page
        </td>
      </tr>
      <tr>
        <td><form:label path="filter">Spams filter: </form:label></td>
        <td><form:checkbox path="filter" value="Enable spams filter"/>Enable spams filter</td>
      </tr>
      <tr>
        <td><form:label path="signature">Signature: </form:label></td>
        <td style="width: 45px"><form:textarea path="signature" rows="5" col="20"/></td>
      </tr>
      <tr>
        <td></td>
        <td>
          <input type="submit" value="Update"/>
          <input type="submit" value="Cancel">
        </td>
      </tr>
    </table>
  </form:form>

  </body>
</html>
