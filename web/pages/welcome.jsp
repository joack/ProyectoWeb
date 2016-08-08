<%-- 
    Document   : welcome
    Created on : 07/07/2016, 02:12:25
    Author     : Joack
--%>

<%@page import="modelo.Producto"%>
<%@page import="modelo.ElementoDelCarrito"%>
<%@page import="modelo.Carrito"%>
<%@page import="modelo.UsuarioComun"%>
<%@page import="DAO.UsuarioComunDAO"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<%
    response.setHeader("Cache-Control","no-cache");
    response.setHeader("Cache-Control","no-store");
    response.setHeader("Pragma","no-cache");
    response.setDateHeader ("Expires", 0);
    
    UsuarioComunDAO usuario = (UsuarioComunDAO)request.getSession().getAttribute("usuario");   
    UsuarioComun userData = (UsuarioComun)request.getSession().getAttribute("userDT");
    Carrito cart = (Carrito)request.getSession().getAttribute("carrito");
%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <link rel="stylesheet" href="http://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.6.3/css/font-awesome.min.css">
        <link href="css/bootstrap.min.css" rel="stylesheet">
        <link rel="stylesheet" href="css/bootstrap.min.css">
        <link href="css/welcomeUser.css" rel="stylesheet">
        <script src="js/jquery.min.js"></script>
        <script src="js/bootstrap.min.js"></script>        
    </head>
    <body>

        <nav class="navbar navbar-inverse">
            <div class="container-fluid">
                <div class="navbar-header">
                    <a class="navbar-brand" href="index.jsp">my brand</a>
                     <button type="button" class="navbar-toggle" data-toggle="collapse" data-target="#myNavbar">
                        <span class="icon-bar"></span>
                        <span class="icon-bar"></span>
                        <span class="icon-bar"></span>
                    </button>           
                </div>
                <div class="collapse navbar-collapse" id="myNavbar">
                    <ul class="nav navbar-nav active-tab" id="myTab">
                        <li class="active" >
                            <a href="#home" data-toggle="tab">
                                <span class="glyphicon glyphicon-home"></span>
                                Home
                            </a>
                        </li>
                        <li>
                            <a href="#carrito" data-toggle="tab">
                                <span class="glyphicon glyphicon-shopping-cart"></span>
                                Carrito
                            </a>
                        </li>
                        <li><a href="#shop" data-toggle="tab"> 
                                <span class="glyphicon glyphicon-usd"></span>
                                Shop
                            </a>
                        </li>
                        <li>
                            <a href="#" data-toggle="modal" data-target="#contact_dialog">
                                <span class="glyphicon glyphicon-envelope"></span> 
                                Contact
                            </a>
                        </li>
                    </ul>
                    <ul class="nav navbar-nav navbar-right">
                        
                        <li class="dropdown">
                            <a class="dropdown-toggle" data-toggle="dropdown" href="#">
                                <span class="glyphicon glyphicon-user"></span>
                                Hola, <%=userData.getNickName()%><span class="caret"></span>
                            </a>
                            <ul class="dropdown-menu">
                                <li><a href="#">Page 1-1</a></li>
                                <li><a href="#">Page 1-2</a></li>
                                <li><a href="#">Page 1-3</a></li>
                                <li class="divider"></li>
                                <li><a href="#" class="idLogout" ><span class="glyphicon glyphicon-log-out"></span> Logout</a></li>
                            </ul>
                        </li>     
                    </ul>
                </div>
            </div>
        </nav>
 
        <div class="container-fluid">               
            <div class="tab-content">
                <div id="home" class="tab-pane fade in active">

                    <h3>HOME</h3>
                    <p>Bienvenido a la pagina de compra del usuario, en la misma se podran<br>
                       efectuar las siguientes operaciones: </p>

                    <ul>
                        <li>Agregar un producto al carrito.</li>
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
                
                <div id="carrito" class="tab-pane fade">
                    <div class="container-fluid">
                        
                        <div class="panel panel-default" >
                            <div class="panel-heading" align="center">Productos en el Carrito</div>
                            <div class="panel-body">
                                <table class="table table-bordered table-responsive">
                                    <thead>
                                        <th class="hide">IdCodigo</th>
                                        <th class="hide">RemainStock</th>
                                        <th>Nombre</th>
                                        <th>Modelo</th>
                                        <th>Marca</th>
                                        <th>Descripcion</th>
                                        <th width="7%">Cantidad</th>
                                        <th width="7%">Precio</th>
                                        <th height="10%">Imagen</th>
                                        <th>Accion</th>
                                        <th></th>
                                    </thead>
                                    <tbody>
                                        <%                                          
                                            for( ElementoDelCarrito producto: cart.getProductos())
                                            {
                                                out.println("<tr id=\"menu\">");
                                                out.println("<td class=\"hide tIdCodigo\">"+producto.getProductKey()+"</th>");
                                                out.println("<td class=\"hide tStock\">"+producto.getProducto().getStock()+"</th>");
                                                out.println("<td>"+producto.getProducto().getNombre()+"</td>");
                                                out.println("<td>"+producto.getProducto().getModelo()+"</td>");
                                                out.println("<td>"+producto.getProducto().getMarca()+"</td>");
                                                out.println("<td>"+producto.getProducto().getDescripcion()+"</td>");
                                                out.println("<td class=\"tCant\">"+producto.getCantidad()+"</td>");
                                                out.println("<td>"+"<span>$ </span>"+String.format("%.2f", producto.getPrecioProducto())+"</td>");
                                                out.println("<td align=\"center\">"+"<image src=\""+producto.getProducto().getImagen()+"\"></td>");
                                                out.println("<td>"  +"<a class=\"btn btn-xs btn-success addProd\">"
                                                                    +"<span class=\"glyphicon glyphicon-plus\"></span></a>  "
                                                                    +"<a class=\"btn btn-xs btn-danger removeProd\">"
                                                                    +"<span class=\"glyphicon glyphicon-minus\"></span></a>"+"</td>"
                                                            );
                                                
                                                out.println("<td>"+"<a class=\"btn btn-xs btn-primary editProd\">"
                                                                    +"<span class=\"glyphicon glyphicon-pencil\"></span></a>  "
                                                                    +"<a class=\"btn btn-xs btn-danger deleteProd\" >"
                                                                    +"<span class=\"glyphicon glyphicon-remove\"></span></a>"+"</td>"
                                                            );
                                                out.println("</tr>");
                                                
                                            }
                                        %>
                                    </tbody>
                                </table>
                                    <div class="pull-right">
                                        <strong>Total $</strong><input type="text" disabled="" value="<%=String.format("%.2f", usuario.getTotalPrice())%>"> 
                                    </div>
                                    <br><br>
                                    <button class="btn btn-primary" data-toggle="modal" data-target="#carritoPagar_dialog">
                                        Pagar
                                    </button>
                                    <button class="btn btn-danger" data-toggle="modal" data-target="#carritoVaciar_dialog">
                                        Vaciar Carrito
                                    </button> 
                                    
                                    
                                    
                            </div>
                        </div>
                        
                    </div>
                </div> 
    
                
                
                
                <div id="shop" class="tab-pane fade">
                    <div class="container-fluid">
                        <div class="panel panel-default">
                            <div class="panel-heading">Title</div>
                            <div class="panel-body">
                                <div class="row">
                                    <div class="col-sm-4">
                                        <div class="panel with-nav-tabs panel-primary">
                                            <div class="panel-heading" id="nav-panel-heading">
                                                <ul class="nav nav-tabs" id="nav-tabs-menu">
                                                    <li class="active">
                                                        <a data-toggle="tab" href="#shopItem1-1">Item</a>
                                                    </li>
                                                    <li>
                                                        <a href="#shopItem1-2" data-toggle="tab" >Info</a>
                                                    </li>
                                                </ul>
                                            </div>

                                            <div class="panel-body">
                                                <div class="tab-content">
                                                    <div id="shopItem1-1" class="tab-pane active">
                                                        <p>Item</p>
                                                    </div>
                                                    <div id="shopItem1-2" class="tab-pane">
                                                        <p>Info</p>
                                                    </div>
                                                </div>
                                            </div>
                                       </div>
                                   </div>

                               </div> 
                            </div>
                       </div>
                    </div>                  
                </div>
            </div>                
        </div>

                
                
                
                
                
                
                
                
                
                
<!-- *********************************************************************** -->                
        
        <!-- CARRITO VACIAR -->
 	<div class="modal fade" id="carritoVaciar_dialog" tabindex="-1" role="dialog" aria-labelledby="edit-modal-label">
            <div class="modal-dialog" role="document">
                <div class="modal-content">
                    <form class="form-horizontal" id="carritoVaciar_form" action="usuarioCarritoVaciar.do" method="POST">
                        <div class="modal-header">
                            <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
                            <h4 class="modal-title" id="edit-modal-label">Vaciar Carrito?</h4>
                        </div>
                        <div class="modal-body">
                            <h6>¿Estas seguro que quieres vaciar el carrito?.</h6>
                        </div>
                    </form>
                    <div class="modal-footer">
                        <button class="btn btn-default hide" id="carritoVaciarBtnClose" onclick="javaScrip:window.location.reload()">Close</button>
                        <button class="btn btn-default" id="carritoVaciarBtnNo" data-dismiss="modal">No</button>
                        <button type="button" id="submitVaciarCarritoForm" class="btn btn-primary">Yes</button>
                    </div>                    
                </div>
            </div>
        </div>         
               
        <!-- CARRITO INCREMENTAR ELEMENTO-->
  	<div class="modal fade" id="carritoIncrementar_dialog" role="dialog">
            <div class="modal-dialog" role="document">
                <div class="modal-content">
                    <form class="form-horizontal" id="carritoIncrementar_form" action="usuarioCarritoIncrementar.do" method="POST">
                        <input type="text" name="idCodigo" id="idCodigo">
                        <input type="text" name="cantidad" id="cantidad">
                    </form>
                    <div class="modal-footer">                      
                        <button type="button" id="submitCarritoIncrementarForm" class="hide"></button>
                    </div>                    
                </div>
            </div>
        </div>       
 
        <!-- CARRITO DECREMENTAR ELEMENTO-->
  	<div class="modal fade" id="carritoDecrementar_dialog" role="dialog" >
            <div class="modal-dialog" role="document">
                <div class="modal-content">
                    <form class="form-horizontal" id="carritoDecrementar_form" action="usuarioCarritoDecrementar.do" method="POST">
                        <input type="text" name="idCodigo" id="idCodigo">
                        <input type="text" name="cantidad" id="cantidad">
                    </form>
                    <div class="modal-footer">                      
                        <button type="button" id="submitCarritoDecrementarForm" class="hide"></button>
                    </div>                    
                </div>
            </div>
        </div>         
        
        <!-- CARRITO BORRAR ELEMENTO-->
  	<div class="modal fade" id="carritoBorra_dialog" role="dialog" >
            <div class="modal-dialog" role="document">
                <div class="modal-content">
                    <form class="form-horizontal" id="carritoBorrar_form" action="usuarioCarritoBorrar.do" method="POST">
                        <input type="text" name="idCodigo" id="idCodigo">                       
                    </form>
                    <div class="modal-footer">                      
                        <button type="button" id="submitCarritoBorrarForm" class="hide"></button>
                    </div>                    
                </div>
            </div>
        </div>  
           
        <!-- CARRITO EDITAR -->
	<div class="modal fade" id="carritoEditar_dialog" role="dialog" >
            <div class="modal-dialog" role="dialog">
                <div class="modal-content">
                    <form class="form-horizontal" id="carritoEditar_form" action="usuarioCarritoEditar.do" method="POST">
                        <div class="modal-header">
                            <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
                            <h4 class="modal-title" id="edit-modal-label">Editar Cantidad</h4>
                        </div>
                        <div class="modal-body">
                            <input type="text" id="idCodigo" name="idCodigo" value="" class="hidden">
                            
                            <div class="form-group">
                                <label for="descArticulo" class="col-sm-2 control-label">Cantidad</label>
                                <div class="col-sm-4">
                                    <input type="text" class="form-control" id="idCantidad" name="cantidad" required>&nbsp;<span id="errmsg1"></span>
                                    <h5><small id="idRemainStock"></small></h5>
                                </div>
                            </div>   
                        </div>
                    </form>
                    <div class="modal-footer">
                        <button type="button" class="btn btn-default hide" data-dismiss="modal" id="carritoEditarBtnClose"
                                onclick="javaScript:location.reload()">
                            Close
                        </button>
                        <button class="btn btn-default" data-dismiss="modal" id="carritoEditarBtnNo">
                            No
                        </button>
                        <button type="button" id="submitEditarProductoForm" class="btn btn-primary">Save changes</button>
                    </div>                    
                </div>
            </div>
        </div>         
        
        <!-- CARRITO PAGAR -->
 	<div class="modal fade" id="carritoPagar_dialog" tabindex="-1" role="dialog" aria-labelledby="edit-modal-label">
            <div class="modal-dialog" role="document">
                <div class="modal-content">
                    <form class="form-horizontal" id="carritoPagar_form" action="usuarioCarritoPagar.do" method="POST">
                        <div class="modal-header">
                            <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
                            <h4 class="modal-title" id="edit-modal-label">Pagar?</h4>
                        </div>
                        <div class="modal-body">
                            <h6>¿Estas seguro que no deseas agregar nada mas?.</h6>
                        </div>
                    </form>
                    <div class="modal-footer">
                        <button class="btn btn-default hide" id="carritoPagarBtnClose" onclick="javaScrip:location.reload()">Close</button>
                        <button class="btn btn-default" id="carritoPagarBtnNo" data-dismiss="modal">No, seguir comprando</button>
                        <button type="button" id="submitCarritoPagarForm" class="btn btn-primary">Listo</button>
                    </div>                    
                </div>
            </div>
        </div>        
        
        
        
        
        
        
        <div class="hidden" id="AgregarAlCarrito">
            <%
                cart.addItem(1, 1);
            %>
        </div>
        
<!-- *********************************************************************** -->  

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
     
        <!-- MODAL CONTACT -->
        <div class="modal fade" id="contact_dialog" role="dialog">
            <div class="modal-dialog">
                <div class="modal-content">
                    <div class="modal-header">
                        <button type="button" class="close" data-dismiss="modal">&times;</button>
                        <h4 class="modal-title">Contact Form</h4>
                    </div>
                        <div class="modal-body">
                        <form class="form-horizontal" name="commentform" method="post" action="">
                            <div class="form-group">
                                <label class="control-label col-md-4" for="first_name">First Name</label>
                                <div class="col-md-6">
                                    <input type="text" class="form-control" id="first_name" name="first_name" placeholder="First Name"/>
                                </div>
                            </div>
                            <div class="form-group">
                                <label class="control-label col-md-4" for="last_name">Last Name</label>
                                <div class="col-md-6">
                                    <input type="text" class="form-control" id="last_name" name="last_name" placeholder="Last Name"/>
                                </div>
                            </div>
                            <div class="form-group">
                                <label class="control-label col-md-4" for="email">Email Address</label>
                                <div class="col-md-6">
                                <!--span class="input-group-addon">@</span-->
                                    <input type="email" class="form-control" id="email" name="email" placeholder="Email Address"/>
                                </div>
                            </div>
                            <div class="form-group">
                                <label class="control-label col-md-4" for="comment">Question or Comment</label>
                                <div class="col-md-6">
                                    <textarea rows="6" class="form-control" id="comments" name="comments" placeholder="Your question or comment here"></textarea>
                                </div>
                            </div>
                        </form>
                    </div>
                    <div class="modal-footer">
                        <button type="button" class="btn btn-default" data-dismiss="modal">
                            Close
                        </button>
                        <button type="button" id="submitEditUserFormButton" class="btn btn-default">Send</button>
                    </div>
                </div>
            </div>
        </div>        
        
        
        
        
        
        
        <!-- PAGE FOOTER - CONTACTS -->
        <div class="nav navbar-default navbar-fixed-bottom">
            <div class="container">
                <p class="navbar-text pull-left">Site Built by <strong>Joaquin Acuña</strong>.</p>
                <div class="pull-right navbar-btn">
                    <a href="http://www.facebook.com/Joack23" target="_blank" class=""><span><i class="fa fa-facebook-official" style="font-size:24px"></i></span></a>
                    <a href="https://ar.linkedin.com/in/joaquin-acuña-3763a540" target="_blank" class=""><span><i class="fa fa-linkedin-square" style="font-size:24px"></i></span></a>
                </div>
            </div>
        </div>
        
        <script src="js/usuarioScript.js"></script>
    </body>
</html>
