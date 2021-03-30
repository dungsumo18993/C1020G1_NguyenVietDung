<%--
  Created by IntelliJ IDEA.
  User: ADMIN
  Date: 2/22/2021
  Time: 4:13 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Từ Điển</title>
</head>
<body>
<form action="/result">
    <h1>Từ Điển Anh Việt</h1>
    <input type="text" name="vocabulary">
    <input type="submit" value="Search">
</form>
<h2>${vocabulary}: <span style="color: red">${result}</span></h2>
</body>
</html>
