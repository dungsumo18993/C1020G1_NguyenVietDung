<%--
  Created by IntelliJ IDEA.
  User: pato2
  Date: 26/01/2021
  Time: 9:57 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Update student</title>
</head>
<body>
    <form action="#" method="post">
        <p>
            Name:
            <input type="text" value="${studentInfo.name}">
        </p>
        <p>
            Date of birth:
            <input type="text" value="${studentInfo.dateOfBirth}">
        </p>
        <p>
            <input type="submit" value="Save" />
        </p>
    </form>
</body>
</html>
