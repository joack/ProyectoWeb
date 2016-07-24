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
        <script src="js/jquery.min.js"></script>
        <script src="js/bootstrap.min.js"></script>
        <script src="js/jquery.dataTables.min.js"></script>
        <script type="text/javascript">
            function myFunc(id)
            {
                alert(id);
            }
        </script>        
        <title>Admin Page</title>
    </head>
    <body>
        <h1>Bienvenido de nuevo Admin!</h1>
 
<!-- ***** TABLA LISTA DE PRODUCTOS *****-->        
        <div class="container-fluid">
            <div class="panel panel-default">
                <div class="panel-heading" align="center">
                    <h4><b><font color="black" style="font-family: fantasy;">Lista de Productos</font> </b></h4>
                </div>
            <div class="container-fluid">
            <div id="table" class="table-editable table-responsive">
                <br>
                <form action="${pageContext.request.contextPath}/pages/addProduct.jsp" method="get">
                    <table id="productTable" class="table table-bordered table-condensed ">

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
                 
                    <button type="button" class="btn btn-default pull-left" data-toggle="modal" data-target="#productAdd_dialog">
                        Agregar
                    </button>
                    <a  class="btn btn-default">Delete Row</a>
                    <br><br>
                </form>
            </div>

            </div>
            </div>    
        </div>   
<!-- ****** FIN TABLA DE PRODUCTOS ****** --> 
   

<!-- ***** TABLA LISTA DE USUARIOS ***** -->                
        <div class="container-fluid">
            <div class="panel panel-default">
                <div class="panel-heading" align="center">
                    <h4><b><font color="black" style="font-family: fantasy;">Lista de Usuarios</font> </b></h4> 
                </div>
                <div class="container-fluid">
                    <div id="table" class="table-editable table-responsive  row-border order-column" >
                        <br>
                        <form action="administradorUsuarioCrear.do" method="get">

                            <table id="usersTable" class="table table-bordered table-condensed">
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
 
                            <button type="button" class="btn btn-default" data-toggle="modal" class="form-control" data-target="#addUser_dialog">
                                Agregar Usuario
                            </button>
                            <button class="btn btn-default" > Eliminar Usuario</button> <br><br>       
                        </form>
                    </div>

                </div>
            </div>
        </div>
<!-- ****** FIN TABLA DE USUARIOS ****** -->

 
<!-- ******** FORMULARIOS MODAL PARA PRODUCTOS ******** -->        
        <!-- Add Product -->
        <div class="modal fade " width="30%" id="productAdd_dialog" role="dialog">
            <div class="modal-dialog" width="10%">
                <div class="modal-content " >
                    <div class="modal-header">
                        <button type="button" class="close" data-dismiss="modal">&times;</button>
                        <h4 class="modal-title" align="center">Agregar Producto</h4>
                    </div>
                    <div class="modal-body">
                        <form id="productAdd_form" action="administradorProductoCrear.do" method="POST">
                            ID Codigo:                                          <br>
                            <input type="text" name="idCodigo" id="fld1" required>&nbsp;<span id="errmsg1"></span><br><br>
                            ID Descripcion:                                     <br>
                            <input type="text" name="idArticulo" id="fld2" required>&nbsp;<span id="errmsg2"></span><br>
                            Marca:                                              <br>
                            <input type="text" name="txtMarca" required>                 <br>
                            Modelo:                                             <br>
                            <input type="text" name="txtModelo" required>                <br>
                            Nombre:                                             <br>
                            <input type="text" name="txtNombre" required>                <br>
                            Descipcion:                                         <br>
                            <input type="text" name="txtDescrip" required>               <br>
                            Stock:                                              <br>
                            <input type="text" name="txtStock" id="fld3" required>&nbsp;<span id="errmsg3"></span><br>
                            Precio:                                             <br>
                            <input type="text" name="txtPrecio" id="fld4" required>&nbsp;<span id="errmsg4"></span><br>
                            URL Imagen:                                         <br>
                            <input type="text" name="txtImagen" required>                <br>
                        </form>
                    </div>
                    <div class="modal-footer">
                        <button type="button" class="btn btn-default" data-dismiss="modal"
                                onclick="javascript:window.location.reload()">Close
                        </button>
                        <button type="button" id="submitProductForm" class="btn btn-default">Send</button>
                    </div>
                </div>
            </div>
        </div>
        

<!-- ******** FORMULARIOS MODAL PARA USUARIOS ******** -->
    <!-- Modal addUser -->
        <div class="modal fade" id="addUser_dialog" role="dialog">
            <div class="modal-dialog">
                <div class="modal-content">
                    <div class="modal-header">
                        <button type="button" class="close" data-dismiss="modal">&times;</button>
                        <h4 class="modal-title">Enter your name</h4>
                    </div>
                    <div class="modal-body">
                        <form id="addUser_form" action="signup.do" method="POST">
                            Email:      <input type="email" name="email">   <br/>
                            User Name:  <input type="text" name="nick">    <br/>
                            Password:   <input type="text" name="pass">   <br/>
                            isAdmin:    <input type="checkbox" name="admin"><br/>
                        </form>
                    </div>
                    <div class="modal-footer">
                        <button type="button" class="btn btn-default" data-dismiss="modal"
                                onclick="javascript:window.location.reload()">Close
                        </button>
                        <button type="button" id="submitAddUserForm" class="btn btn-default">Send</button>
                    </div>
                </div>
            </div>
        </div> 
    
        <script src="js/tablaAdminScript.js"></script>
                            
    </body>    
</html>
