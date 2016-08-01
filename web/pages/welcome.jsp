<%-- 
    Document   : welcome
    Created on : 07/07/2016, 02:12:25
    Author     : Joack
--%>

<%@page import="modelo.UsuarioComun"%>
<%@page import="DAO.UsuarioComunDAO"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<% 
    UsuarioComunDAO user = (UsuarioComunDAO)request.getSession().getAttribute("usuario");
    UsuarioComun  userDT = (UsuarioComun) request.getSession().getAttribute("userDT");
    
    String hola= "hola";
%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <!--h1>Bienvenido de nuevo</h1-->
    </body>
</html>
