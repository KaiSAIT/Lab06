<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Shopping List</title>
    </head>
    <body>
        <h1>Shopping List</h1>
        <p>Hello, ${user.username}</p>
        <a href="shoppingList?action=logout">Logout</a>
        <h2>List</h2>
        <form method="POST" action="add">
            <label>Add item:</label>
            <input type="text" name="item" value="${item}">
            <input type="hidden" name="action" value="add">
            <input type="submit" value="Add" action="add">
        </form>
        <form method="POST" action="delete">
            <c:forEach var="items" items="${items}">
                <input type="radio" name="item" value="${items}">${items}>
            </c:forEach>
            <input type="submit" value="Delete" action="delete">
            <input type="hidden" name="action" value="delete">
        </form>
    </body>
</html>
