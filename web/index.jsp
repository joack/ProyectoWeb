<%-- 
    Document   : index
    Created on : 03/08/2016, 01:46:08
    Author     : Joack
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>

<html lang="en">
    <head>
        <meta charset="utf-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <meta name="viewport" content="width=device-width, initial-scale=1">

        <title>E-Shop | Joack</title>
        <link rel="stylesheet" href="http://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.6.3/css/font-awesome.min.css">
        <link href="css/bootstrap.min.css" rel="stylesheet">
        <link href="css/index.css" rel="stylesheet">
        <script src="js/jquery.min.js"></script>
        <script src="js/bootstrap.min.js"></script>
    </head>
    <body>
<!-- Fixed navbar -->
<nav class="navbar navbar-inverse">
    <div class="container-fluid">
        <div class="navbar-header">
            <a class="navbar-brand" href="#">E-Shop</a>
             <button type="button" class="navbar-toggle" data-toggle="collapse" data-target="#myNavbar">
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
            </button>           
        </div>
        <div class="collapse navbar-collapse" id="myNavbar">
            <ul class="nav navbar-nav">
                <li><a  data-toggle="modal" data-target="#contact_dialog" href="#">Contact me</a></li>
            </ul>
            <ul class="nav navbar-nav navbar-right">
                <li><a href="#" data-toggle="modal" data-target="#signUp_dialog"><span class="glyphicon glyphicon-user"></span> Sign Up</a></li>
                <!--li><a href="login.jsp"><span class="glyphicon glyphicon-log-in"></span> Login</a></li-->
                <li class="dropdown">
                    <a class="dropdown-toggle" href="#" data-toggle="dropdown">
                        <span class="glyphicon glyphicon-log-in"></span> Sign In <strong class="caret"></strong></a>
                    <div class="dropdown-menu" style="padding: 15px; padding-bottom: 0px;">
                        <form method="post" action="login.do" accept-charset="UTF-8">
                            <input style="margin-bottom: 15px;" type="email" placeholder="Username" id="username" name="txtUserName" required>
                            <input style="margin-bottom: 15px;" type="password" placeholder="Password" id="password" name="txtPass" required>
                            <input class="btn btn-primary btn-block" type="submit" id="sign-in" value="Sign In"><br>
                            
                        </form>
                        <span class="divider"></span>
                        <button type="button" class="btn btn-block"  data-toggle="modal" data-target="#forgotPassword_dialog">Forgot Password</button>
                        <br>
                    </div>
                </li>      
            </ul>
        </div>
    </div>
</nav>

        <!-- FORGOT PASSWORD -->
        <div class="modal fade" id="forgotPassword_dialog" role="dialog">
            <div class="modal-dialog">
                <div class="modal-content">
                    <div class="modal-header ">
                        <button type="button" class="close" data-dismiss="modal">&times;</button>
                        <h4 class="modal-title">Forgot Password?</h4>
                    </div>
                    <div class="modal-body">
                        <p>Ingrese su mail</p>
                        <form  class="form-horizontal" id="forgotPassword_form"action="forgotPass.do" method="get">
                        
                            <div class="input-group col-sm-6">
                                <span class="input-group-addon" id="basic-addon1">@</span>
                                <input type="text" class="form-control" placeholder="E-mail" name="email" aria-describedby="basic-addon1">
                            </div>                           
   
                        </form>
                        <div class="modal-footer">
                            <button type="button" class="btn btn-default hide" data-dismiss="modal" id="forgotPasswordCloseBtn">
                                Close
                            </button>
                            <button class="btn btn-primary" type="button" id="submitForgotPass">Enviar</button>
                        </div>
                    </div>
                </div>
            </div>
        </div>

        <!-- CONTACT ME-->
        <div class="modal fade" id="contact_dialog" role="dialog">
            <div class="modal-dialog">
                <div class="modal-content">
                    <div class="modal-header ">
                        <button type="button" class="close" data-dismiss="modal">&times;</button>
                        <h4 class="modal-title">Mis datos</h4>
                    </div>
                    <div class="modal-body">
                        <h3 align="center"><b>Joaquin Acuña</b></h3>
                        <div class="thumbnail">
                            <image src="imagenes/joaquin.jpg">
                            
                        </div>
                        <br>
                        <p align="center">Email: joaquinacuna_1407@hotmail.com</p>
                        <p align="center">Email: joaquinacuna.1407@gmail.com</p>
                        <br>
                        <p align="center">LinkedIn: <a href="https://www.linkedin.com/in/joaquin-acuña-3763a540">
                                https://www.linkedin.com/in/joaquin-acuña-3763a540</a></p>
                        <p align="center">Agosto 2016. Curso Java SE - Comunidad IT</p>
                        
                        <div class="modal-footer">
                            <a class="btn btn-primary" data-dismiss="modal">Cerrar</a>
                        </div>
                           
                  
                    </div>
                </div>
            </div>
        </div>


        <!-- USUARIO AGREGAR -->
        <div class="modal fade" id="signUp_dialog" role="dialog">
            <div class="modal-dialog">
                <div class="modal-content">
                    <form class="form-horizontal" id="addUser_form" action="signup.do" method="POST">
                        <div class="modal-header">
                            <button type="button" class="close" data-dismiss="modal">&times;</button>
                            <h4 class="modal-title">Registrate!</h4>
                        </div>
                        <div class="modal-body">
                        
                            <div class="form-group">
                                <label for="mobile" class="col-sm-2 control-label">Email</label>
                                <div class="col-sm-10">
                                    <input type="email" class="form-control" name="email" required>
                                </div>
                            </div>
                            <div class="form-group">
                                <label for="mobile" class="col-sm-2 control-label">Nick</label>
                                <div class="col-sm-10">
                                    <input type="text" class="form-control" name="nick" required>
                                </div>
                            </div>
                            <div class="form-group">
                                <label for="mobile" class="col-sm-2 control-label">Password</label>
                                <div class="col-sm-10">
                                    <input type="text" class="form-control" name="pass" required>
                                </div>
                            </div>
                            <div class="form-group hide">
                                <label for="mobile" class="col-sm-2 control-label">isAdmin</label>
                                <div class="col-sm-10">
                                    <input type="checkbox" class="form-control" name="admin">
                                </div>
                            </div>
                        </div>
                    </form>
                    <div class="modal-footer">
                        <button type="button" class="btn btn-default" data-dismiss="modal"
                                onclick="javascript:window.location.reload()">Close
                        </button>
                        <button type="button" id="submitAddUserForm" class="btn btn-default">Send</button>
                    </div>
                </div>
            </div>
        </div>        
        
        
        
        <!-- PAGE FOOTER - CONTACTS -->
        <div class="nav navbar-default navbar-fixed-bottom">
            <div class="container">
                <p class="navbar-text pull-left">Site Built by <strong>Joaquin Acuña</strong>.</p>
                <div class="pull-right navbar-btn">
                    <a href="https://github.com/joack/ProyectoWeb" target="_blank" class=""><span><i class="fa fa-github" aria-hidden="true" style="font-size:24px"></i></i></span></a>
                    <a href="https://ar.linkedin.com/in/joaquin-acuña-3763a540" target="_blank" class=""><span><i class="fa fa-linkedin-square" style="font-size:24px"></i></span></a>
                </div>
            </div>
        </div>

        <script src="js/index.js"></script>
    </body>
</html>

