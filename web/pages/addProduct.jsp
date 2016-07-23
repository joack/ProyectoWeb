<%-- 
    Document   : addProduct
    Created on : 22/07/2016, 11:22:55
    Author     : Joack
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link href="${pageContext.request.contextPath}/css/bootstrap.min.css" rel="stylesheet">
        <link href="${pageContext.request.contextPath}/css/bootstrap.css" rel="stylesheet">
        <title>JSP Page</title>
    </head>
    <body>
        <h1 align="center">Add Product</h1>
        
        <form action="../administradorProductoCrear.do" method="get">
            <div class="container">
                <div class="panel panel-default">
                    <div class="panel-heading" align="center">
                        <h4>Agregar producto</h4>
                    </div>
                    <div class="panel-body panel-success panel" width="50%">
                        <div class="container-fluid">
                            <div class="form-group">
                                <label for="formGroupExampleInput">Example label</label>
                                <input type="text" class="form-control" name="idCodigo" placeholder="Numeric Field" required="required">
                            </div>               
                            <div class="form-group">
                                <label for="formGroupExampleInput">ID Descripcion Producto:</label>    
                                <input type="text" class="form-control" name="idArticulo" placeholder="Numeric Field" required="required" >                                 
                            </div>
                            <div class="form-group">
                                <label for="formGroupExampleInput">Marca:</label>
                                <input type="text" class="form-control" name="txtMarca" placeholder="Marca del articulo" required="required" >
                            </div>
                            <div class="form-group">
                                <label for="formGroupExampleInput">Modelo:</label>
                                <input type="text" class="form-control" name="txtModelo" placeholder="Modelo del Articulo" required="required">
                            </div>
                            <div class="form-group">
                                <label for="formGroupExampleInput">Nombre:</label>
                                <input type="text" class="form-control" name="txtNombre" placeholder="Nombre del articulo" required="required">
                            </div>
                            <div class="form-group">
                                <label for="formGroupExampleInput">Descripcion:</label>
                                <input type="text" class="form-control" name="txtDescripcion" placeholder="Descripcion del Articulo" required="required">
                            </div>
                            <div class="form-group">
                                <label for="formGroupExampleInput">Stock:</label>
                                <input type="text" class="form-control" name="txtStock" placeholder="Stock del Articulo ( Numeric Field )" required="required">
                            </div>                            
                            <div class="form-group">
                                <label for="formGroupExampleInput">Precio:</label>
                                <input type="text" class="form-control" name="txtPrecio" placeholder="Precio del Articulo ( Numeric Field )" required="required">
                            </div>
                            <fieldset class="form-group">
                                <label for="formGroupExampleInput">URL Imagen:</label>
                                <input type="text" class="form-control" name="txtImagen" placeholder="URL imagen" required="required" >
                            </div>
                        
                            <div class="pull-left">
                                <button class="btn btn-success">Add</button>
                            </div>                        
                        </div>

                            
                    </div>
                    
                </div>
            </div>    
            
        </form>
    </body>
</html>
