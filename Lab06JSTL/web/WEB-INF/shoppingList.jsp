<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Shopping List</title>
    </head>
    <body>
        <h1>Shopping List</h1>
        <form method="POST" action="shoppingList">
             <label>Username:</label>
            <input type="text" name="first_name" value="${username}">
            <input type="submit" value="Register name" action="register">
        </form>
    </body>
</html>
