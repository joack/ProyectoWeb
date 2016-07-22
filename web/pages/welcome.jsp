<%-- 
    Document   : welcome
    Created on : 07/07/2016, 02:12:25
    Author     : Joack
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<% String userName = (String) request.getSession().getAttribute("usuario"); %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Bienvenido de nuevo <%=userName%>!</h1>
    </body>
</html>
