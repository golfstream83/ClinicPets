<%--
  Created by IntelliJ IDEA.
  User: Victor Tulin
  Date: 28.11.2016
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Edit client</title>
</head>
<body>
<form action="${pageContext.servletContext.contextPath}/client/edit" method="POST">
    <input type="hidden"  name="id" value="${client.getId()}">
    <table>
        <tr>
            <td align="right" >Login : </td>
            <td>
                <input type="text" name="login" value="${client.getLogin()}">
            </td>
        <tr>
            <td><input type="submit" align="center" value="Submit"/></td>
        </tr>
    </table>
</form>
</body>
</html>
