<%-- 
    Document   : welcome
    Created on : 07/07/2016, 02:12:25
    Author     : Joack
--%>

<%@page import="modelo.UsuarioComun"%>
<%@page import="DAO.UsuarioComunDAO"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<% 
    Object user   = request.getSession().getAttribute("usuario");
    UsuarioComunDAO usuario = null;
    usuario = (UsuarioComunDAO)user;
    
    Object userDT = request.getSession().getAttribute("userDT");
    UsuarioComun userData = new UsuarioComun();
    
    userData = (UsuarioComun)userDT;
    
    
    
    String hola= "hola";
%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Bienvenido de nuevo </h1>
    </body>
</html>
