<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
<html>
<head>
    <title>List student</title>

</head>
<body>
    <table border="1">
        <tr>
            <th>Id</th>
            <th>Name</th>
            <th>Date of birth</th>
            <th>Gender</th>
            <th>Rank</th>
            <th>Action</th>
        </tr>
<%--        <%--%>
<%--            List<Student> studentListAbc =--%>
<%--                    (List<Student>) request.getAttribute("studentListFromServlet");--%>
<%--            for (Student student : studentListAbc) {--%>
<%--        %>--%>
<%--        <tr>--%>
<%--            <td><%=student.getId()%></td>--%>
<%--            <td><%=student.getName()%></td>--%>
<%--            <td><%=student.getDateOfBirth()%></td>--%>
<%--        </tr>--%>
<%--        <%--%>
<%--            }--%>
<%--        %>--%>
        <c:forEach var="student" items="${studentListFromServlet}">
            <tr>
                <td><c:out value="${student.id}"/></td>
                <td><c:out value="${student.name}"/></td>
                <td><c:out value="${student.dateOfBirth}"/></td>
                <td>
                    <c:if test="${student.gender == 0}">
                        <span style="color: pink">Female</span>
                    </c:if>
                    <c:if test="${student.gender == 1}">
                        <span style="color: green">Male</span>
                    </c:if>
                </td>
                <td>
                    <c:choose>
                        <c:when test="${student.grade < 5}">
                            Bad
                        </c:when>
                        <c:when test="${student.grade < 8}">
                            Good
                        </c:when>
                        <c:otherwise>
                            Very good
                        </c:otherwise>
                    </c:choose>
                </td>
                <td>
                    <a href="/studentServlet?actionUser=update&id=${student.id}">Update</a>
                </td>
            </tr>
        </c:forEach>
    </table>
    ${tmp}
    <c:out value="${tmp}" />
<%--    <c:set scope=""--%>
</body>
</html>
