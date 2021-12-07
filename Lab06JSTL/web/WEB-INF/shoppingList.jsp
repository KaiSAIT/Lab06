<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Shopping List</title>
    </head>
    <body>
        <h1>Shopping List</h1>
        <p>Hello, ${user.username}</p>
        <a href="login">Logout</a>
        <h2>List</h2>
        <form method="POST" action="add">
            <label>Add item:</label>
            <input type="text" name="item" value="${item}">
            <input type="submit" value="Add" action="add">
        </form>
        <form method="POST" action="delete">
            <c:forEach items="${item}" var="item">
                <input type="checkbox" name="itemCheckbox">
                <label>${item}</label>
                <input type="submit" value="Delete" action="delete">
            </c:forEach>
        </form>
    </body>
</html>
