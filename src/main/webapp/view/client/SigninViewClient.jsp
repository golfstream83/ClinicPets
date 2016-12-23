<%--
  Created by IntelliJ IDEA.
  User: Victor Tulin
  Date: 10.12.2016
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<c:if test="${error != ''}">
    <div style="background-color: red">
        <c:out value="${error}"/>
    </div>
</c:if>
<form action="${pageContext.servletContext.contextPath}/signin" method="POST">
    <input type="hidden"  name="id" value="${client.getId()}">
    <table>
        <tr>
            <td align="right" >Login : </td>
            <td>
                <input type="text" name="login">
            </td>
        </tr>
        <tr>
            <td align="right" >Password : </td>
            <td>
                <input type="password" name="password">
            </td>
        </tr>
        <tr>
            <td><input type="submit" align="center" value="Submit"/></td>
        </tr>
    </table>
</form>
</body>
</html>
