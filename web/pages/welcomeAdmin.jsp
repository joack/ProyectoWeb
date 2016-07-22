<%@page import="SuperClases.Usuario"%>
<%@page import="modelo.Electrodomestico"%>
<%@page import="SuperClases.Articulo"%>
<%@page import="org.apache.jasper.tagplugins.jstl.core.ForEach"%>
<%@page import="java.util.ArrayList"%>
<%@page import="DAO.UsuarioAdminDAO"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<% 
    UsuarioAdminDAO user = (UsuarioAdminDAO) request.getSession().getAttribute("usuario"); 
    ArrayList<Articulo> listaProductos = user.readAllArticulos();
    ArrayList<Usuario> usuarios = user.readAllUsers();
%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link href="css/bootstrap.min.css" rel="stylesheet">
        <link href="css/bootstrap.css">
        <script>
            $(document).ready(function() {
                $('#unaTabla').DataTable( {
                    "scrollY":        "3px",
                    "scrollCollapse": true,
                    "paging":         false
                } );
            } );

        </script>
        
        
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Bienvenido de nuevo Admin!</h1>
 
        
<div class="container-fluid">
    <div class="panel panel-default">
        <div class="panel-heading" align="center">
            <h4><b><font color="black" style="font-family: fantasy;">Lista de Productos</font> </b></h4>
        </div>
    <div class="container-fluid">
    <div id="table" class="table-editable table-responsive">
        <br>
        <form action="administradorProducto.do" method="get">
            <table id="unaTabla" class="table table-bordered table-condensed ">
                
                <thead>
                    <th width="10%">ID Codigo   </th>
                    <th width="10%">ID Articulo </th>
                    <th>Marca       </th>
                    <th>Modelo      </th>
                    <th>Nombre      </th>
                    <th>Descripcion </th>
                    <th>Precio      </th>
                    <th>Stock       </th>
                    <th>Imagen      </th>
                    <th>Edit        </th>
                    <th>Short       </th>
                </thead>
                <tbody>
                <% 
                    for ( int i= 0; i < listaProductos.size(); i++) 
                    {
                        out.println("<tr>");
                        out.println("   <td contenteditable=\"true\" name=\"id\" >"+listaProductos.get(i).getIdCodigo()+    "</td>");
                        out.println("   <td width=\"10%\" contenteditable=\"true\">"+listaProductos.get(i).getIdArticulo()+  "</td>");
                        out.println("   <td contenteditable=\"true\">"+listaProductos.get(i).getMarca()+                     "</td>");
                        out.println("   <td contenteditable=\"true\">"+listaProductos.get(i).getModelo()+                    "</td>");
                        out.println("   <td contenteditable=\"true\">"+listaProductos.get(i).getNombre()+                    "</td>");
                        out.println("   <td contenteditable=\"true\">"+listaProductos.get(i).getDescripcion()+               "</td>");
                        out.println("   <td contenteditable=\"true\">"+listaProductos.get(i).getPrecio()+                    "</td>");
                        out.println("   <td contenteditable=\"true\">"+listaProductos.get(i).getStock()+                     "</td>");
                        out.println("   <td contenteditable=\"true\">"+listaProductos.get(i).getImagen()+                    "</td>");
                        out.println("<td><span class=\"table-edit glyphicon glyphicon-edit\"></span></td>" );
                        out.println("<td><span class=\"table-up glyphicon glyphicon-arrow-up\"></span>" );
                        out.println("    <span class=\"table-down glyphicon glyphicon-arrow-down\"></span></td>" );                        
                        out.println("</tr>");   
                    }
                %> 
                </tbody>
                

            </table>
            <button action="administradorProducto.do" type="submit" class="btn btn-default pull-left" >Boton</button>
            <a  class="btn btn-default">Delete Row</a>
            <br><br>
        </form>
    </div>
            
    </div>
    </div>    
</div>   

        



<div class="container-fluid">
    <div class="panel panel-default">
        <div class="panel-heading" align="center">
            <h4><b><font color="black" style="font-family: fantasy;">Lista de Productos</font> </b></h4> 
        </div>
        <div class="container-fluid">
            <div id="table" class="table-editable table-responsive">
                <br>
                <table id="tableUsers" class="table table-bordered table-condensed">
                    <thead>
                        <tr>
                            <th> Email      </th>
                            <th> Nick Name  </th>
                            <th> Password   </th>
                            <th> Rol        </th>
                            <th> Accion     </th>
                        </tr>
                    </thead>
                    <tbody>

                        <% 
                            for ( Usuario usuario: usuarios) 
                            {

                                out.println("<tr>");
                                //out.println("<form action=\"administradorProducto.do\" method=\"get\" >");
                                out.println("   <td id=\""+usuario.getEmail()+"\">"+usuario.getEmail()+"</td>");
                                out.println("   <td>"+usuario.getNickName()+"</td>");
                                out.println("   <td>"+usuario.getPassword()+"</td>");
                                out.println("   <td>"+usuario.getRol()+"</td>");
                                out.println("   <td><button  onClick=\"myF()\">asdfa</button></td>");
                                //out.println("</form>"); 
                                out.println("</tr>");  

                            }
                        %>

                    </tbody>
                </table>
            </div>
        </div>
        </div>
    </div>
</div>
    
</html>
