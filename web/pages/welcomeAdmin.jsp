<%@page import="interfaces.IDescripcionArticulo"%>
<%@page import="modelo.Producto"%>
<%@page import="interfaces.IUser"%>
<%@page import="interfaces.IArticulo"%>
<%@page import="interfaces.IProduct"%>
<%@page import="SuperClases.Usuario"%>
<%@page import="SuperClases.Articulo"%>
<%@page import="org.apache.jasper.tagplugins.jstl.core.ForEach"%>
<%@page import="java.util.ArrayList"%>
<%@page import="DAO.UsuarioAdminDAO"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<%
    response.setHeader("Cache-Control","no-cache");
    response.setHeader("Cache-Control","no-store");
    response.setHeader("Pragma","no-cache");
    response.setDateHeader ("Expires", 0);      
    
    UsuarioAdminDAO user = (UsuarioAdminDAO) request.getSession().getAttribute("usuario"); 
   
    ArrayList<Producto> listaProductos = user.getAllProducts();
    ArrayList<IArticulo> listaArticulos = user.getAllArticulos();
    ArrayList<IDescripcionArticulo> listaDescrip = user.getAllDescripciones();
    
    ArrayList<IUser> usuarios = user.readAllUsers();
%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <link href="css/bootstrap.min.css" rel="stylesheet">
        <link href="css/bootstrap.css">
        <link href="css/welcomeAdmin.css" rel="stylesheet">
        <script src="js/jquery.min.js"></script>
        <script src="js/bootstrap.min.js"></script>
        <script src="js/jquery.dataTables.min.js"></script>     
        <title>Admin Page</title>
    </head>
    <body>      
        <h1 align="center" id="tituloPagina">Bienvenido de nuevo Admin!</h1>
        
        
        <div class="col-lg-12">            
            <div class="panel with-nav-tabs panel-primary">
                <div class="panel-heading" id="nav-panel-heading">
                    <ul class="nav nav-tabs" id="nav-tabs-menu">
                        <li class="active"><a data-toggle="tab" href="#home">Home</a></li>
                        <li><a href="#Listas" data-toggle="tab" >Listas</a></li>
                        <li><a href="#EdicionProductos" data-toggle="tab" >Productos</a></li>
                        <li><a href="#EdicionUsuarios" data-toggle="tab" >Usuarios</a></li>
                        <li class="pull-right"><a class="idLogout" href="#"><span class="glyphicon glyphicon-log-in"></span> Logout</a></li>
                    </ul>
                </div>
            
                <div class="panel-body">

                    <div class="tab-content">
                        <div id="home" class="tab-pane fade in active">

                            <h3>HOME</h3>
                            <p>Bienvenido a la pagina de administracion del sitio, en la misma se podran<br>
                               efectuar las siguientes operaciones: </p>

                            <ul>
                                <li>Agregar un producto( Articulo + Descripcion).</li>
                                <li>Agregar un Articulo.</li>
                                <li>Agregar una descripcion.</li>
                                <li>Agregar un nuevo usuario.</li>
                                <br>
                                <li>Editar un producto (cambiar la descripcion).</li>
                                <li>Editar un Articulo.</li>
                                <li>Editar Descripcion.</li>
                                <li>Editar usuarios.</li>                      
                                <br>
                                <li>Borrar un producto.</li>
                                <li>Borrar un Articulo.</li>
                                <li>Borrar Descripcion.</li>
                                <li>Borrar un usuario.</li>
                            </ul>
                        </div>        

                        <div id="Listas" class="tab-pane fade">
                            <br>
                            <div class="container-fluid">
                                <div class="container">
                                    <div class="panel panel-default">
                                        <div class="panel-heading" align="center">
                                            <h4><b><font color="black" style="font-family: fantasy;">Lista de Productos</font> </b></h4>
                                        </div>
                                        <div class="container-fluid">
                                            <div id="table" class="table-editable table-responsive">
                                                <br>
                                                <form action="${pageContext.request.contextPath}/pages/addProduct.jsp" method="get">
                                                    <table id="idProductTableShow" class="table table-bordered table-responsive">

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
                                                        </thead>
                                                        <tbody>
                                                        <% 
                                                            for( IProduct producto: listaProductos) 
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

           
                                                </form>
                                            </div>
                                        </div>
                                    </div>
                                </div>
                            </div>

                            <div class="container-fluid">
                                <div class="container">
                                    <div class="panel panel-default">
                                        <div class="panel-heading" align="center">
                                            <h4><b><font color="black" style="font-family: fantasy;">Lista de Usuarios</font> </b></h4> 
                                        </div>
                                        <div class="container-fluid">
                                            <div id="table" class="table-editable table-responsive  row-border order-column" >
                                                <br>
                                                <form action="administradorUsuarioCrear.do" method="get">

                                                    <table id="idUsersTableShow" class="table table-bordered table-condensed">
                                                        <thead>
                                                            <tr>
                                                                <th> Email      </th>
                                                                <th> Nick Name  </th>
                                                                <th> Password   </th>
                                                                <th> Rol        </th>

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
                                                                    out.println("</tr>");  
                                                                }
                                                            %>
                                                        </tbody>
                                                    </table>       
                                                </form>
                                            </div>
                                        </div>
                                    </div>
                                </div>
                            </div>                                         
                        </div>

                        <div id="EdicionProductos" class="tab-pane fade">
                            <br>
                            
                            <div class="container-fluid">
                                <div class="container">
                                    <div class="panel panel-default">
                                        <div class="panel-heading" align="center">
                                            <h4><b><font color="black" style="font-family: fantasy;">Lista de Productos</font> </b></h4>
                                        </div>
                                        <div class="container-fluid">
                                            <div id="table" class="table-editable table-responsive">
                                                <br>
                                                
                                                <table id="idProductEditTableShow" class="table table-bordered table-responsive">

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
                                                        <th>Action      </th>
                                                    </thead>
                                                    <tbody>
                                                    <% 
                                                        for( IProduct producto: listaProductos) 
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
                                                            out.println("<td width=\"7%\">"
                                                                        + " <a   type=\"button\" "
                                                                            + "  class=\"btn btn-primary btn-xs EditarProducto\" "
                                                                            + "  id=\"editProduc_dialog\">" 
                                                                            + "     <span class=\"glyphicon glyphicon-pencil\"></span>"
                                                                        + " </a>"

                                                                        + " <a    type=\"button\" "
                                                                            + "   class=\"btn btn-danger btn-xs BorrarProducto\" "
                                                                            + "   id=\"editProduc_dialog\">" 
                                                                            + "     <span class=\"glyphicon glyphicon-remove \"></span>"
                                                                        + " </a>"
                                                                 +  "</td>" );   
                                                        }
                                                    %> 
                                                    </tbody>
                                                </table>

                                                <button type="button" class="btn btn-success pull-left" data-toggle="modal" data-target="#AgregaerProducto_dialog">
                                                    Agregar Producto
                                                </button>
                                                <br>
                                                <br>
                                            </div>
                                        </div>
                                    </div>
                                </div>
                            </div>
                            
                            
                            
                            
                            <!-- TABLA ARTICULO -->
                            <div class="container-fluid">
                                <div class="container">
                                    <div class="panel panel-default"> 
                                        <div class="panel-heading" align="center">
                                            <h4><b><font color="black" style="font-family: fantasy;">Editar Articulo</font> </b></h4> 
                                        </div>                            

                                        <div class="container-fluid">
                                            <br>
                                            <table id="productTable" class="table table-bordered table-condensed ">
                                                <thead>
                                                    <th width="7%">ID Codigo</th>
                                                    <th>Marca</th>
                                                    <th>Modelo</th>
                                                    <th>Nombre</th> 
                                                    <th>Accion</th>

                                                </thead>
                                                <tbody>
                                                    <%
                                                        for( IArticulo producto: listaArticulos)
                                                        {                               
                                                            out.println("<tr>");
                                                            out.println("<td class=\"idCodigo\" >"+producto.getIdCodigo()+"</td>");
                                                            out.println("<td class=\"idMarca\">"+producto.getMarca()+"</td>");
                                                            out.println("<td class=\"idModelo\">"+producto.getModelo()+"</td>");
                                                            out.println("<td class=\"idNombre\">"+producto.getNombre()+"</td>");                                
                                                            out.println("<td width=\"7%\">"
                                                                            + " <a   type=\"button\" "
                                                                                + "  class=\"btn btn-primary btn-xs EditarArticulo\" "
                                                                                + "  id=\"editProduc_dialog\">" 
                                                                                + "     <span class=\"glyphicon glyphicon-pencil\"></span>"
                                                                            + " </a>"

                                                                            + " <a    type=\"button\" "
                                                                                + "   class=\"btn btn-danger btn-xs BorrarArticulo\" "
                                                                                + "   id=\"editProduc_dialog\">" 
                                                                                + "     <span class=\"glyphicon glyphicon-remove \"></span>"
                                                                            + " </a>"
                                                                     +  "</td>" );                                

                                                            out.println("</tr>");
                                                        }
                                                    %>
                                                </tbody>
                                            </table>
                                            <br>    
                                            <button type="button" class="btn btn-success pull-left" data-toggle="modal" data-target="#AgregarArticulo_dialog">
                                                    Agregar Articulo
                                            </button>
                                            <br>
                                            <br>
                                        </div>  
                                    </div> 
                                </div>
                            </div>
                            <!-- -->

                            <!-- TABLA DESCRIPCION ARTICULO -->
                            <div class="container-fluid">
                                <div class="container">
                                    <div class="panel panel-default">                             
                                        <div class="panel-heading" align="center">
                                            <h4><b><font color="black" style="font-family: fantasy;">Editar Descripcion Articulo</font> </b></h4> 
                                        </div>                            

                                        <div class="container-fluid">
                                            <br>
                                            <table id="productDescripTable" class="table table-bordered table-condensed ">
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
                                                        for( IDescripcionArticulo producto: listaDescrip)
                                                        {                                                           
                                                            out.println("<tr>");
                                                            out.println("<td class=\"idArticulo\">"+producto.getIdArticulo()+"</td>");
                                                            out.println("<td class=\"idPrecio\">"+producto.getPrecio()+"</td>");
                                                            out.println("<td class=\"idStock\">"+producto.getStock()+"</td>");
                                                            out.println("<td class=\"idDescrip\">"+producto.getDescripcion()+"</td>");
                                                            out.println("<td class=\"idImagen\">"+producto.getImagen()+"</td>");
                                                            out.println("<td width=\"7%\">"
                                                                           + " <a   type=\"button\" "
                                                                               + "  class=\"btn btn-primary btn-xs EditarDescripcion\" "
                                                                               + "  id=\"editProducDescrip_dialog\">" 
                                                                               + "     <span class=\"glyphicon glyphicon-pencil\"></span>"
                                                                           + " </a>"

                                                                           + " <a    type=\"button\" "
                                                                               + "   class=\"btn btn-danger btn-xs EditarDescipcionArticulo\" "
                                                                               + "   id=\"delEditProducDescrip_dialog\">" 
                                                                               + "     <span class=\"glyphicon glyphicon-remove \"></span>"
                                                                           + " </a>"
                                                                    +  "</td>" );                                

                                                            out.println("</tr>");
                                                        }
                                                    %>
                                                </tbody>
                                            </table>
                                            <br>    
                                            <button type="button" class="btn btn-success pull-left" data-toggle="modal" data-target="#AgregarDescripcion_dialog">
                                                    Agregar Descripcion
                                            </button>
                                            <br>
                                            <br>    
                                        </div>                             
                                    </div>
                                </div>
                            </div>
                            <!--  -->

                        </div>                                

                        <div id="EdicionUsuarios" class="tab-pane fade">
                            <br>
                            <!-- ***** TABLA LISTA DE USUARIOS ***** -->                
                            <div class="container-fluid">
                                <div class="container">
                                    <div class="panel panel-default">                       
                                        <div class="panel-heading" align="center">
                                            <h4><b><font color="black" style="font-family: fantasy;">Editar Usuarios</font> </b></h4> 
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
                            </div>
                           <!-- ****** FIN TABLA DE USUARIOS ****** -->

                        </div>

                    </div><!-- Fin DIV de Tabs--> 
                    
                </div>
            </div>
        </div>
<!-- ***********************************************************************************************-->                                             
 
<!-- ******** FORMULARIOS MODAL PARA PRODUCTOS ******** -->        

        <!-- PRODUCTO AGREGAR -->
        <div class="modal fade " width="30%" id="AgregaerProducto_dialog" role="dialog">
            <div class="modal-dialog" width="10%">
                <div class="modal-content " >
                    <div class="modal-header">
                        <button type="button" class="close" data-dismiss="modal">&times;</button>
                        <h4 class="modal-title" align="center">Agregar Producto</h4>
                    </div>
                    <div class="modal-body">
                        <form id="AgregarProducto_form" action="administradorProductoCrear.do" method="POST">
                            ID Codigo:                                          <br>
                            <input type="text" name="idCodigo" id="fld1" required>&nbsp;<span id="errmsg1"></span><br><br>                            
                            ID Descripcion:                                     <br>
                            <input type="text" name="idArticulo" id="fld1" required>&nbsp;<span id="errmsg1"></span><br><br>
                        </form>
                    </div>
                    <div class="modal-footer">
                        <button type="button" class="btn btn-default" data-dismiss="modal"
                                onclick="javascript:window.location.reload()">Close
                        </button>
                        <button type="button" id="submitAgregarProductoForm" class="btn btn-default">Send</button>
                    </div>
                </div>
            </div>
        </div>

        <!-- PRODUCTO BORRAR -->
 	<div class="modal fade" id="BorrarProducto_dialog" tabindex="-1" role="dialog" aria-labelledby="edit-modal-label">
            <div class="modal-dialog" role="document">
                <div class="modal-content">
                    <form class="form-horizontal" id="BorrarProducto_form" action="administradorProductoBorrar.do" method="POST">
                        <div class="modal-header">
                            <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
                            <h4 class="modal-title" id="edit-modal-label">Delete Product?</h4>
                        </div>
                        <div class="modal-body">
                            <div class="form-group">
                                <input type="text" class="hidden" id="idCodigo" name="idCodigo">

                            </div>
                            <h6>Estas seguro que quieres borrar este Producto?.</h6>
                        </div>
                    </form>
                    <div class="modal-footer">
                        <button type="button" class="btn btn-default" data-dismiss="modal"
                                onclick="javascript:window.location.reload()">No</button>
                        <button type="button" id="submitBorrarProductoForm" class="btn btn-primary">Yes</button>
                    </div>                    
                </div>
            </div>
        </div>         
        
        <!-- PRODUCTO EDITAR -->
	<div class="modal fade" id="EditarProducto_dialog" tabindex="-1" role="dialog" aria-labelledby="edit-modal-label">
            <div class="modal-dialog" role="document">
                <div class="modal-content">
                    <form class="form-horizontal" id="EditarProducto_form" action="administradorProductoEditar.do" method="POST">
                        <div class="modal-header">
                            <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
                            <h4 class="modal-title" id="edit-modal-label">Editar Producto</h4>
                        </div>
                        <div class="modal-body">
                            <input type="hidden" id="idCodigo" name="idCodigo" value="" class="hidden">
                            
                            <div class="form-group">
                                <label for="descArticulo" class="col-sm-2 control-label">Cod Descrip</label>
                                <div class="col-sm-10">
                                        <input type="text" class="form-control" id="idMarca" name="idArticulo" placeholder="Id Articulo" required>
                                </div>
                            </div>   
                        </div>
                    </form>
                    <div class="modal-footer">
                        <button type="button" class="btn btn-default" data-dismiss="modal"
                                onclick="javascript:window.location.reload()">Close
                        </button>
                        <button type="button" id="submitEditarProductoForm" class="btn btn-primary">Save changes</button>
                    </div>                    
                </div>
            </div>
        </div>         
 
        
<!-- ********************************************************************************************************* -->

<!-- ******** FORMULARIOS MODAL PARA ARTICULOS ******** --> 

        <!-- ARTICULO AGREGAR -->
        <div class="modal fade " width="30%" id="AgregarArticulo_dialog" role="dialog">
            <div class="modal-dialog" width="10%">
                <div class="modal-content " >
                    <div class="modal-header">
                        <button type="button" class="close" data-dismiss="modal">&times;</button>
                        <h4 class="modal-title" align="center">Agregar Articulo</h4>
                    </div>
                    <div class="modal-body">
                        <form id="AgregarArticulo_form" action="administradorArticuloAgregar.do" method="POST">
                            ID Codigo:                                          <br>
                            <input type="text" name="idCodigo" id="fld1" required>&nbsp;<span id="errmsg1"></span><br><br>                          
                            Marca:                                              <br>
                            <input type="text" name="idMarca" required>        <br>
                            Modelo:                                             <br>
                            <input type="text" name="idModelo" required>       <br>
                            Nombre:                                             <br>
                            <input type="text" name="idNombre" required>       <br>                     
                        </form>
                    </div>
                    <div class="modal-footer">
                        <button type="button" class="btn btn-default" data-dismiss="modal"
                                onclick="javascript:window.location.reload()">Close
                        </button>
                        <button type="button" id="submitArgregarArticuloForm" class="btn btn-default">Send</button>
                    </div>
                </div>
            </div>
        </div>        
        
        <!-- ARTICULO BORRAR -->
	<div class="modal fade" id="BorrarArticulo_dialog" tabindex="-1" role="dialog" aria-labelledby="edit-modal-label">
            <div class="modal-dialog" role="document">
                <div class="modal-content">
                    <form class="form-horizontal" id="BorrarArticulo_form" action="administradorArticuloBorrar.do" method="POST">
                        <div class="modal-header">
                            <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
                            <h4 class="modal-title" id="edit-modal-label">Borrar Articulo?</h4>
                        </div>
                        <div class="modal-body">
                            <div class="form-group">
                                <input type="text" class="hidden" id="idCodigo" name="idCodigo">
                            </div>
                            <h6>Estas seguro que quieres borrar este Articulo?.</h6>
                        </div>
                    </form>
                    <div class="modal-footer">
                        <button type="button" class="btn btn-default" data-dismiss="modal"
                                onclick="javascript:window.location.reload()">No</button>
                        <button type="button" id="submitBorrarArticuloForm" class="btn btn-primary">Yes</button>
                    </div>                    
                </div>
            </div>
        </div>        
        
        <!-- ARTICULO EDITAR -->
	<div class="modal fade" id="EditarArticulo_dialog" tabindex="-1" role="dialog" aria-labelledby="edit-modal-label">
            <div class="modal-dialog" role="document">
                <div class="modal-content">
                    <form class="form-horizontal" id="EditarArticulo_form" action="administradorArticuloEditar.do" method="POST">
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
                        <button type="button" id="submitEditarArticuloForm" class="btn btn-primary">Save changes</button>
                    </div>                    
                </div>
            </div>
        </div>        
 
<!-- ********************************************************************************************************* -->    
         
       
<!-- ******** FORMULARIOS MODAL PARA DESCRIPCION ******** -->     
        
        <!-- DESCRIPCION AGREGAR-->
        <div class="modal fade " width="30%" id="AgregarDescripcion_dialog" role="dialog">
            <div class="modal-dialog" width="10%">
                <div class="modal-content " >
                    <div class="modal-header">
                        <button type="button" class="close" data-dismiss="modal">&times;</button>
                        <h4 class="modal-title" align="center">Agregar Articulo</h4>
                    </div>
                    <div class="modal-body">
                        <form id="AgregarDescripcion_form" action="administradorDescripcionAgregar.do" method="POST">
                            ID Descripcion:                                     <br>
                            <input type="text" name="idArticulo" id="fld1" required>&nbsp;<span id="errmsg1"></span><br><br>                          
                            Stock:                                              <br>
                            <input type="text" name="idStock"   id="fld2" required>&nbsp;<span id="errmsg2"></span><br>
                            precio:                                             <br>
                            <input type="text" name="idPrecio"  id="fld3" required>&nbsp;<span id="errmsg3"></span><br>
                            Descripcion:                                        <br>
                            <input type="text" name="idDescrip" required>       <br>
                            URL Imagen:                                         <br>
                            <input type="text" name="idImagen" required>        <br>
                        </form>
                    </div>
                    <div class="modal-footer">
                        <button type="button" class="btn btn-default" data-dismiss="modal"
                                onclick="javascript:window.location.reload()">Close
                        </button>
                        <button type="button" id="submitArgregarDescripcionForm" class="btn btn-default">Send</button>
                    </div>
                </div>
            </div>
        </div>     
    
        <!-- DESCRIPCION BORRAR -->
	<div class="modal fade" id="BorrarDescripcionArticulo_dialog" tabindex="-1" role="dialog" aria-labelledby="edit-modal-label">
            <div class="modal-dialog" role="document">
                <div class="modal-content">
                    <form class="form-horizontal" id="BorrarDescripcionArticulo_form" action="administradorDescripcionBorrar.do" method="POST">
                        <div class="modal-header">
                            <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
                            <h4 class="modal-title" id="edit-modal-label">Delete descrip?</h4>
                        </div>
                        <div class="modal-body">
                            <div class="form-group">
                                <input type="text" class="hidden" id="idArticulo" name="idArticulo">
                                
                            </div>
                            <h6>Estas seguro que quieres borrar esta descripcion?.</h6>
                        </div>
                    </form>
                    <div class="modal-footer">
                        <button type="button" class="btn btn-default" data-dismiss="modal"
                                onclick="javascript:window.location.reload()">Close
                        </button>
                        <button type="button" id="submitBorrarDescripcionArticuloForm" class="btn btn-primary">Yes</button>
                    </div>                    
                </div>
            </div>
        </div>   
    
        <!-- DESCRIPCION EDITAR -->
	<div class="modal fade" id="EditarDescripcion_dialog" tabindex="-1" role="dialog" aria-labelledby="edit-modal-label">
            <div class="modal-dialog" role="document">
                <div class="modal-content">
                    <form class="form-horizontal" id="EditarDescripcion_form" action="administradorDescripcionEditar.do" method="POST">
                        <div class="modal-header">
                            <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
                            <h4 class="modal-title" id="edit-modal-label">Edit selected row</h4>
                        </div>
                        <div class="modal-body">                            
                            
                            <input type="text" class="hidden" id="idArticulo" name="idArticulo">
                 
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
                        <button type="button" id="submitEditarDescripcionForm" class="btn btn-primary">Save changes</button>
                    </div>                    
                </div>
            </div>
        </div>
         
       
 <!-- ********************************************************************************************************* -->
        
<!-- ******** FORMULARIOS MODAL PARA USUARIOS ******** -->

        <!-- USUARIO AGREGAR -->
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

        <!-- USUARIO BORRAR -->
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
        
        <!-- USUARIO EDITAR -->
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
      
    
    
<!-- ********************************************************************************************************* -->            
        
        <!-- LOGOUT-->
        <div class="modal fade" id="logout_dialog" role="dialog">
            <div class="modal-dialog">
                <div class="modal-content">
                    <div class="modal-header">
                        <button type="button" class="close" data-dismiss="modal">&times;</button>
                        <h4 class="modal-title">Logout</h4>
                    </div>
                    <div class="modal-body">
                        <p>Desea cerrar sesion?</p>
                    </div>
                    <div class="modal-footer">
                        <form action="logout.do" method="get">
                            <button type="button" class="btn btn-primary" data-dismiss="modal">No</button>                        
                            <button type="submit" class="btn btn-primary" id="submitLogout">Yes</button>
                        </form>
                    </div>
                </div>
            </div>
        </div>
        <!---->
        
        
        <script src="js/tablaAdminScript.js"></script>    
    </body>    
</html>