<%-- 
    Document   : success
    Created on : 23/07/2016, 16:16:58
    Author     : Joack
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<% String exito = (String)request.getSession().getAttribute("exito");%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Exito:</h1>
        <p><%= exito%></p>
    </body>
</html>
