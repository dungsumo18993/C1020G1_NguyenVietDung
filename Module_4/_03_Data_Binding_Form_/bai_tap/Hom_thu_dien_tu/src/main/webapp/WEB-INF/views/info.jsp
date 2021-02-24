<%--
  Created by IntelliJ IDEA.
  User: ADMIN
  Date: 2/24/2021
  Time: 2:33 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Info</title>
</head>
<body>
<h1 style="color: blue">Email Information</h1>
<table>
    <tr>
        <td>Language: </td>
        <td>${language}</td>
    </tr>
    <tr>
        <td>Page size: </td>
        <td>${size}</td>
    </tr>
    <tr>
        <td>Spams filter: </td>
        <td>${filter}</td>
    </tr>
    <tr>
        <td>Signature: </td>
        <td>${signature}</td>
    </tr>
</table>
</body>
</html>
