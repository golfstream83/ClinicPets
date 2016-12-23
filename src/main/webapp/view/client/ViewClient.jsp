<%--
  Created by IntelliJ IDEA.
  User: Victor Tulin
  Date: 27.11.2016
--%>
<%@ page language="java" pageEncoding="UTF-8" session="true"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>View client</title>
</head>
<body>
<a href="${pageContext.servletContext.contextPath}/view/client/AddClient.jsp">Добавить пользователя</a>
<table border="1">
    <tr>
        <td>Логин</td>
        <td>Действия</td>
    </tr>
    <c:forEach var="client" items="${clients}">
        <tr valign="top">
            <td>${client.getLogin()}</td>
            <td>
                <a href="${pageContext.servletContext.contextPath}/client/edit?id=${client.getId()}">Редактировать</a>
                <a href="${pageContext.servletContext.contextPath}/client/delete?id=${client.getId()}">Удалить</a>
            </td>
        </tr>
    </c:forEach>
</table>
</body>
</html>
