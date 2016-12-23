<%--
  Created by IntelliJ IDEA.
  User: Victor Tulin
  Date: 26.11.2016
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Add client</title>
</head>
<body>
<form action="${pageContext.servletContext.contextPath}/client/add" method="POST">
    <table>
        <tr>
            <td align="right" >Login : </td>
            <td>
                <input type="text" name="login">
            </td>
        </tr>
        <tr>
            <td><input type="submit" align="center" value="Submit"/></td>
        </tr>
    </table>
</form>
</body>
</html>
