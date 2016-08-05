<%-- 
    Document   : error
    Created on : 06/07/2016, 21:55:51
    Author     : Joack
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<% 
    String error = (String) request.getSession().getAttribute("error"); 
    String volverLink = (String) request.getSession().getAttribute("link");
%>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Error</title>
    </head>
    <body>
        <h1>Se ha producido un error: </h1>                           
        <p><%=error%></p>
        <br><br>
        
        <a href=${pageContext.request.contextPath}<%=volverLink%>><Button>Volver</Button>
    </body>
</html>
