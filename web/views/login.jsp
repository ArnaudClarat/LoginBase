<%--
  Created by ArnaudClarat
  Date: 11-12-19
  Time: 18:33
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Page de connexion</title>
</head>
<body>
    <form action="login" method="post">
        Nom : <input type="text" name="nom">
        Password : <input type="text" name="password">
        <input type="submit" value="Login">
    </form>
    <form action="newuser" method="post">
        <input type="submit" value="New User">
    </form>
</body>
</html>
