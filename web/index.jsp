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

        <title>no title</title>
        <link rel="stylesheet" href="http://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.6.3/css/font-awesome.min.css">
        <link href="css/bootstrap.min.css" rel="stylesheet">
        <link rel="stylesheet" href="css/bootstrap.min.css">
        <script src="js/jquery.min.js"></script>
        <script src="js/bootstrap.min.js"></script>
    </head>
    <body>
<!-- Fixed navbar -->
<nav class="navbar navbar-inverse">
    <div class="container-fluid">
        <div class="navbar-header">
            <a class="navbar-brand" href="index_.html">my brand</a>
             <button type="button" class="navbar-toggle" data-toggle="collapse" data-target="#myNavbar">
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
            </button>           
        </div>
        <div class="collapse navbar-collapse" id="myNavbar">
            <ul class="nav navbar-nav">


                <li class="dropdown"><a class="dropdown-toggle" data-toggle="dropdown" href="#">Page 1 <span class="caret"></span></a>
                    <ul class="dropdown-menu">
                        <li><a href="#">Page 1-1</a></li>
                        <li><a href="#">Page 1-2</a></li>
                        <li><a href="#">Page 1-3</a></li>
                    </ul>
                </li>
                <li><a href="#">Page 2</a></li>
            </ul>
            <ul class="nav navbar-nav navbar-right">
                <li><a href="pages/signup.jsp"><span class="glyphicon glyphicon-user"></span> Sign Up</a></li>
                <!--li><a href="login.jsp"><span class="glyphicon glyphicon-log-in"></span> Login</a></li-->
                <li class="dropdown">
                    <a class="dropdown-toggle" href="#" data-toggle="dropdown">Sign In <strong class="caret"></strong></a>
                    <div class="dropdown-menu" style="padding: 15px; padding-bottom: 0px;">
                        <form method="post" action="login.do" accept-charset="UTF-8">
                            <input style="margin-bottom: 15px;" type="email" placeholder="Username" id="username" name="txtUserName" required>
                            <input style="margin-bottom: 15px;" type="password" placeholder="Password" id="password" name="txtPass" required>
                            <input class="btn btn-primary btn-block" type="submit" id="sign-in" value="Sign In"><br>
                            
                        </form>
                        <span class="divider"></span>
                        <button type="button" class="btn btn-block"  data-toggle="modal" data-target="#forgot_dialog">Forgot Password</button>
                        <br>
                    </div>
                </li>      
            </ul>
        </div>
    </div>
</nav>


        <div class="modal fade" id="forgot_dialog" role="dialog">
            <div class="modal-dialog">
                <div class="modal-content">
                    <div class="modal-header ">
                        <button type="button" class="close" data-dismiss="modal">&times;</button>
                        <h4 class="modal-title">Forgot Password?</h4>
                    </div>
                    <div class="modal-body">
                        <p>Ingrese su mail</p>
                        <form action="forgotPass.do" method="get">
                        
                            <div class="input-group col-sm-6">
                                <span class="input-group-addon" id="basic-addon1">@</span>
                                <input type="text" class="form-control" placeholder="E-mail" name="email" aria-describedby="basic-addon1">
                            </div>                           
                            <br>
                            <button class="btn btn-primary" type="submit">Enviar</button>
                        </form>    
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


    </body>
</html>

