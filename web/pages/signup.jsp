<%-- 
    Document   : signup
    Created on : 15/07/2016, 13:24:19
    Author     : Joack
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<% boolean habilitarOpcion = (boolean)request.getSession().getAttribute("ok"); %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Bienvenido, regístrate!</h1>                                        
        <br>
        <br>
        <form action="signup.do" method="get">
            Email:     <input type="text" name="email" value="" />              <br>
            User Name: <input type="text" name="nick"  value="" />              <br>
            Password:  <input type="text" name="pass"  value="" />              <br>
            <%
                if( habilitarOpcion )
                {
                    out.println( "Administrador: <input type=\"checkbox\" name=\"admin\"/>" );                
                }
            %>
            <br>
            <input type="submit" value="Enviar" />
        </form>
    </body>
</html>
