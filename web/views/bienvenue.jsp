<%--
  Created by ArnaudClarat
  Date: 11-12-19
  Time: 18:36
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Bienvenue</title>
</head>
<body>
    <%
        if (session.getAttribute("nom") == null) {
            response.sendRedirect("views/login.jsp");
        }
    %>
    <h1>Bienvenue ${nom}</h1>
    <form action="logout">
        <input type="submit" value="Log Out">
    </form>
</body>
</html>
