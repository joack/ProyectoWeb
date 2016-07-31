<%@page import="interfaces.IUser"%>
<%@page import="interfaces.IArticulo"%>
<%@page import="SuperClases.Usuario"%>
<%@page import="modelo.Electrodomestico"%>
<%@page import="SuperClases.Articulo"%>
<%@page import="org.apache.jasper.tagplugins.jstl.core.ForEach"%>
<%@page import="java.util.ArrayList"%>
<%@page import="DAO.UsuarioAdminDAO"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<% 
    UsuarioAdminDAO user = (UsuarioAdminDAO) request.getSession().getAttribute("usuario"); 
    ArrayList<IArticulo> listaProductos = user.readAllArticulos();
    ArrayList<IUser> usuarios = user.readAllUsers();
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

        </script>        
        <title>Admin Page</title>
    </head>
    <body>      
        <h1 align="center">Bienvenido de nuevo Admin!</h1>
 
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
                                    <!--th>Action   </th-->
                                </thead>
                                <tbody>
                                <% 
                                    for( IArticulo producto: listaProductos) 
                                    {
                                        out.println("<tr>");
                                        out.println("   <td class=\"idCodigo\" width=\"10%\"   >" +producto.getIdCodigo()+     "</td>");
                                        out.println("   <td class=\"idArticulo\" width=\"10%\" >" +producto.getIdArticulo()+   "</td>");
                                        out.println("   <td class=\"idMarca\"  >"                 +producto.getMarca()+        "</td>");
                                        out.println("   <td class=\"idModelo\" >"                 +producto.getModelo()+       "</td>");
                                        out.println("   <td class=\"idNombre\" >"                 +producto.getNombre()+       "</td>");
                                        out.println("   <td class=\"idDescrip\">"                 +producto.getDescripcion()+  "</td>");
                                        out.println("   <td class=\"idPrecio\" >"                 +producto.getPrecio()+       "</td>");
                                        out.println("   <td class=\"idStock\"  >"                 +producto.getStock()+        "</td>");
                                        out.println("   <td class=\"idImagen\" >"                 +producto.getImagen()+       "</td>");
                                        out.println("</tr>");   
                                    }
                                %> 
                                </tbody>
                            </table>

                            <button type="button" class="btn btn-success pull-left" data-toggle="modal" data-target="#productAdd_dialog">
                                Agregar Producto
                            </button>     
                            <br>
                            <br>
                        </form>
                    </div>

                </div>
            </div>    
        </div>   
<!-- ****** FIN TABLA DE PRODUCTOS ****** --> 
 
<!-- TABLA PRODUCTO -->
<div class="container-fluid">
    <button class="btn btn-primary" data-toggle="collapse" data-target="#productToggle">Articulos</button><br>
    <div class="panel panel-default">
        <br>
        <div class="container-fluid" id="productToggle">
            <div class="panel panel-default">
                <table class="table table-bordered table-condensed ">
                    <thead>
                        <th width="7%">ID Codigo</th>
                        <th>Marca</th>
                        <th>Modelo</th>
                        <th>Nombre</th> 
                        <th>Accion</th>
                           
                    </thead>
                    <tbody>
                        <%
                            for( IArticulo producto: listaProductos)
                            {                               
                                out.println("<tr>");
                                out.println("<td class=\"idCodigo\" >"+producto.getIdCodigo()+"</td>");
                                out.println("<td class=\"idMarca\">"+producto.getMarca()+"</td>");
                                out.println("<td class=\"idModelo\">"+producto.getModelo()+"</td>");
                                out.println("<td class=\"idNombre\">"+producto.getNombre()+"</td>");                                
                                out.println("<td width=\"7%\">"
                                                + " <a   type=\"button\" "
                                                    + "  class=\"btn btn-primary btn-xs editProduct\" "
                                                    + "  id=\"editProduc_dialog\">" 
                                                    + "     <span class=\"glyphicon glyphicon-pencil\"></span>"
                                                + " </a>"

                                                + " <a    type=\"button\" "
                                                    + "   class=\"btn btn-danger btn-xs editProduct\" "
                                                    + "   id=\"editProduc_dialog\">" 
                                                    + "     <span class=\"glyphicon glyphicon-remove \"></span>"
                                                + " </a>"
                                         +  "</td>" );                                
                                
                                out.println("</tr>");
                            }
                        %>
                    
                    </tbody>
                </table>
            </div>
            
        </div>
    </div> 
    
</div>
<!-- -->

<!-- TABLA DESCRIPCION PRODUCTO -->
<div class="container-fluid">
    <button class="btn btn-primary" data-toggle="collapse" data-target="#productDescripToggle">Descipcion Articulos</button><br>
    <div class="panel panel-default">
        <br>
        <div class="container-fluid collapse" id="productDescripToggle">
            <div class="panel panel-default">
                <table class="table table-bordered table-condensed ">
                    <thead>
                        <th width="8%">ID Descrip</th>
                        <th width="7%">Precio</th>
                        <th width="7%">Stock</th>
                        <th>Descripcion</th>
                        <th>Imagen</th> 
                        <th>Accion</th>
                           
                    </thead>
                    <tbody>
                        <%
                            for( IArticulo producto: listaProductos)
                            {
                                //IArticulo iProducto = (IArticulo) producto;
                                
                                out.println("<tr>");
                                out.println("<td class=\"idArticulo\">"+producto.getIdArticulo()+"</td>");
                                out.println("<td class=\"idPrecio\">"+producto.getPrecio()+"</td>");
                                out.println("<td class=\"idStock\">"+producto.getStock()+"</td>");
                                out.println("<td class=\"idDescrip\">"+producto.getDescripcion()+"</td>");
                                out.println("<td class=\"idImagen\">"+producto.getImagen()+"</td>");
                                out.println("<td width=\"7%\">"
                                                + " <a   type=\"button\" "
                                                    + "  class=\"btn btn-primary btn-xs editProductDesc\" "
                                                    + "  id=\"editProducDescrip_dialog\">" 
                                                    + "     <span class=\"glyphicon glyphicon-pencil\"></span>"
                                                + " </a>"

                                                + " <a    type=\"button\" "
                                                    + "   class=\"btn btn-danger btn-xs delEditProductDesc\" "
                                                    + "   id=\"delEditProducDescrip_dialog\">" 
                                                    + "     <span class=\"glyphicon glyphicon-remove \"></span>"
                                                + " </a>"
                                         +  "</td>" );                                
                                
                                out.println("</tr>");
                            }
                        %>
                    
                    </tbody>
                </table>
            </div>
            
        </div>
    </div> 
    
</div>
<!--  -->

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
                                        for ( IUser usuario: usuarios) 
                                        {
                                            out.println("<tr>");
                                            out.println("   <td class=\"tEmail\">"+ usuario.getEmail()    +"</td>");
                                            out.println("   <td class=\"tNick\" >"+ usuario.getNickName() +"</td>");
                                            out.println("   <td class=\"tPass\" >"+ usuario.getPassword() +"</td>");
                                            out.println("   <td class=\"tRol\"  >"+ usuario.getRol()      +"</td>");
                                            out.println("<td width=\"7%\">"
                                                            + " <a   type=\"button\" "
                                                                + "  class=\"btn btn-primary btn-xs editUserButton\" "
                                                                + "  id=\"editProduc_dialog\">" 
                                                                + "     <span class=\"glyphicon glyphicon-pencil\"></span>"
                                                            + " </a>"

                                                            + " <a    type=\"button\" "
                                                                + "   class=\"btn btn-danger btn-xs removeUserButton\" "
                                                                + "   id=\"editProduc_dialog\">" 
                                                                + "     <span class=\"glyphicon glyphicon-remove \"></span>"
                                                            + " </a>"
                                                     +  "</td>" );  
                                        }
                                    %>
                                </tbody>
                            </table>
 
                            <button type="button" class="btn btn-success" data-toggle="modal" class="form-control" data-target="#addUser_dialog">
                                Agregar Usuario
                            </button> 
                            <br>
                            <br>       
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

         <!-- Edit Product -->
	<div class="modal fade" id="productEdit_dialog" tabindex="-1" role="dialog" aria-labelledby="edit-modal-label">
            <div class="modal-dialog" role="document">
                <div class="modal-content">
                    <form class="form-horizontal" id="productEdit_form" action="administradorProductoEditar.do" method="POST">
                        <div class="modal-header">
                            <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
                            <h4 class="modal-title" id="edit-modal-label">Edit selected row</h4>
                        </div>
                        <div class="modal-body">
                            <input type="hidden" id="idCodigo" name="idCodigo" value="" class="hidden">
                            <div class="form-group">
                                <label for="email" class="col-sm-2 control-label">Marca</label>
                                <div class="col-sm-10">
                                        <input type="text" class="form-control" id="idMarca" name="idMarca" placeholder="Marca Producto" required>
                                </div>
                            </div>
                            <div class="form-group">
                                <label for="mobile" class="col-sm-2 control-label">Modelo</label>
                                <div class="col-sm-10">
                                    <input type="text" class="form-control" id="idModelo" name="idModelo" placeholder="Modelo Porducto" required>
                                </div>
                            </div>
                            <div class="form-group">
                                <label for="mobile" class="col-sm-2 control-label">Nombre</label>
                                <div class="col-sm-10">
                                    <input type="text" class="form-control" id="idNombre" name="idNombre" placeholder="Nombre Producto" required>
                                </div>
                            </div>
                        </div>
                    </form>
                    <div class="modal-footer">
                        <button type="button" class="btn btn-default" data-dismiss="modal"
                                onclick="javascript:window.location.reload()">Close
                        </button>
                        <button type="button" id="submitProductEditForm" class="btn btn-primary">Save changes</button>
                    </div>                    
                </div>
            </div>
        </div>        
 
        <!-- Delete Producto --> 
         
         
        <!-- Edit Product Descrip -->
	<div class="modal fade" id="productEditDescrip_dialog" tabindex="-1" role="dialog" aria-labelledby="edit-modal-label">
            <div class="modal-dialog" role="document">
                <div class="modal-content">
                    <form class="form-horizontal" id="productEditDescrip_form" action="administradorProductoDescripcionEditar.do" method="POST">
                        <div class="modal-header">
                            <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
                            <h4 class="modal-title" id="edit-modal-label">Edit selected row</h4>
                        </div>
                        <div class="modal-body">                            
                            <div class="form-group" type="hidden">
                                <label for="firstname" class="col-sm-2 control-label">ID Descripcion</label>
                                <div class="col-sm-10">
                                    <input type="text" class="form-control" id="idArticulo" name="idArticulo" placeholder="ID Articulo" required>
                                </div>
                            </div>
                            <div class="form-group">
                                <label for="mobile" class="col-sm-2 control-label">Descripcion</label>
                                <div class="col-sm-10">
                                    <input type="text" class="form-control" id="idDescrip" name="idDescrip" placeholder="Descripcion" required>
                                </div>
                            </div>
                            <div class="form-group">
                                <label for="mobile" class="col-sm-2 control-label">Precio</label>
                                <div class="col-sm-10">
                                    <input type="text" class="form-control" id="idPrecio" name="idPrecio" placeholder="Precio" required>
                                </div>
                            </div>
                            <div class="form-group">
                                <label for="mobile" class="col-sm-2 control-label">Stock</label>
                                <div class="col-sm-10">
                                    <input type="text" class="form-control" id="idStock" name="idStock" placeholder="Stock" required>
                                </div>
                            </div>
                            <div class="form-group">
                                <label for="mobile" class="col-sm-2 control-label">Imagen</label>
                                <div class="col-sm-10">
                                    <input type="text" class="form-control" id="idImagen" name="idImagen" placeholder="URL Imagen" required>
                                </div>
                            </div>
                        </div>
                    </form>
                    <div class="modal-footer">
                        <button type="button" class="btn btn-default" data-dismiss="modal"
                                onclick="javascript:window.location.reload()">Close
                        </button>
                        <button type="button" id="submitProductEditDescripForm" class="btn btn-primary">Save changes</button>
                    </div>                    
                </div>
            </div>
        </div>
         
        <!-- Delete Product Descrip -->
	<div class="modal fade" id="delProductEditDescrip_dialog" tabindex="-1" role="dialog" aria-labelledby="edit-modal-label">
            <div class="modal-dialog" role="document">
                <div class="modal-content">
                    <form class="form-horizontal" id="delProductEditDescrip_form" action="administradorProductoDescripcionBorrar.do" method="POST">
                        <div class="modal-header">
                            <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
                            <h4 class="modal-title" id="edit-modal-label">Delete descrip?</h4>
                        </div>
                        <div class="modal-body">
                            <div class="form-group">
                                <input type="text" class="hidden" id="idArticulo" name="idArticulo" placeholder="ID Articulo" required>
                                <input type="text" class="hidden" id="idDescrip"  name="idDescrip"  placeholder="Descripcion" required>
                                <input type="text" class="hidden" id="idPrecio"   name="idPrecio"   placeholder="Precio"      required>
                                <input type="text" class="hidden" id="idStock"    name="idStock"    placeholder="Stock"       required>
                                <input type="text" class="hidden" id="idImagen"   name="idImagen"   placeholder="URL Imagen"  required>
                            </div>
                            <h6>Estas seguro que quieres borrar esta descripcion?.</h6>
                        </div>
                    </form>
                    <div class="modal-footer">
                        <button type="button" class="btn btn-default" data-dismiss="modal"
                                onclick="javascript:window.location.reload()">Close
                        </button>
                        <button type="button" id="submitDelProductEditDescripForm" class="btn btn-primary">Yes</button>
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

    <!-- Modal editUser -->
        <div class="modal fade" id="editUser_dialog" role="dialog">
            <div class="modal-dialog">
                <div class="modal-content">
                    <div class="modal-header">
                        <button type="button" class="close" data-dismiss="modal">&times;</button>
                        <h4 class="modal-title">Enter your name</h4>
                    </div>
                    <div class="modal-body">
                        <form id="editUser_form" action="administradorUsuarioEditar.do" method="POST">
                            <div class ="form-group">
                                <div>
                                    <label for="email" class="control-label">Email</label>
                                    <div>
                                        <input type="email" name="email" id="idEmail"> 
                                    </div>
                                </div>
                            </div>                            
                            <div class="form-group">
                                <label for="NickName" class=" control-label">User Name</label>
                                <div>
                                    <input type="text"  name="nick"  id="idUserName" placeholder="Nick Name">
                                </div>
                            </div>
                            <div class="form-group">
                                <label for="Password" class=" control-label">Password</label>
                                <div >
                                    <input type="text"  name="pass"  id="idUserPass" placeholder="Password">
                                </div>
                            </div>      
                            <div class="form-grup">
                                <label for="isAdmin" class=" control-label">isAdmin</label>
                                <div >
                                    <input type="checkbox"  name="isAdmin" id="idIsAdmin">
                                </div>
                            </div>
                        </form>
                    </div>
                    <div class="modal-footer">
                        <button type="button" class="btn btn-default" data-dismiss="modal"
                                onclick="javascript:window.location.reload()">Close
                        </button>
                        <button type="button" id="submitEditUserFormButton" class="btn btn-default">Send</button>
                    </div>
                </div>
            </div>
        </div>

    <!-- Modal delete User-->
        <div class="modal fade" id="deleteUser_dialog" role="dialog">
            <div class="modal-dialog">
                <div class="modal-content">
                    <div class="modal-header">
                        <button type="button" class="close" data-dismiss="modal">&times;</button>
                        <h4 class="modal-title">Enter your name</h4>
                    </div>
                    <div class="modal-body">
                        <form id="deleteUser_form" action="administradorUsuarioBorrar.do" method="POST">
                            <input type="text" name="email"  class="hidden" id="idEmail">
                            <p>Esta seguro de querer eliminar a este usuario?.</p>
                        </form>
                    </div>
                    <div class="modal-footer">
                        <button type="button" class="btn btn-default" data-dismiss="modal"
                                onclick="javascript:window.location.reload()">Close
                        </button>
                        <button type="button" id="submitDeleteUserFormButton" class="btn btn-default">Yes</button>
                    </div>
                </div>
            </div>
        </div>    
    
        <script src="js/tablaAdminScript.js"></script>
                            
    </body>    
</html>