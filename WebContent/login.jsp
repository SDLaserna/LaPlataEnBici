<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1" %> 
<!DOCTYPE html>
<html>
<head>
<title>Login</title>
<head>
    <title>Login</title>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <%@ include file="configHead.jsp" %>
</head>
</head>

<body style="background: url('images/bg/bglogin.PNG') center center fixed;">
    <div class="page-form">
        <div class="panel panel-blue">
            <div class="panel-body pan">
                <form action="login" class="form-horizontal" method="post">
                <div class="form-body pal">
                    <div class="col-md-12 text-center">
                        <h1 style="margin-top: -90px; font-size: 48px; color:white;">
                            Iniciar Sesi&oacute;n</h1>
                        <br>
                    </div>
                    <div class="form-group">
                        <div class="col-md-3">
                            <img src="images/avatar/profile-pic.png" class="img-responsive" style="margin-top: -35px;">
                        </div>
                        <div class="col-md-9 text-center">
                            <h1>
                                Bienvenid@
                              </h1>
                            <br>
                            <p>
                                por favor ingresa tus datos para comenzar</p>
                        </div>
                    </div>
                    <div class="form-group" >
                        <label for="inputName" class="col-md-3 control-label">
                            Usuario:</label>
                        <div class="col-md-9">
                            <div class="input-icon right">
                                <i class="fa fa-user"></i>
                                <input id="inputName" type="text" placeholder="nombre de usuario" class="form-control" name="inputUser"></div>
                        </div>
                    </div>
                    <div class="form-group">
                        <label for="inputPassword" class="col-md-3 control-label">
                            Contrase&ntilde;a:</label>
                        <div class="col-md-9">
                            <div class="input-icon right">
                                <i class="fa fa-lock"></i>
                                <input id="inputPassword" type="password" placeholder="contrase&ntilde;a" class="form-control"  name="inputPass"></div>
                        </div>
                    </div>
                    <div class="form-group mbn">
                        <div class="col-lg-12" align="right">
                            <div class="form-group mbn">
                                <div class="col-lg-3">
                                    &nbsp;
                                </div>
                                <div class="col-lg-9">
                                    <a href="" class="btn btn-default">Volver</a>&nbsp;&nbsp;
                                    <button type="submit" class="btn btn-default">
                                        Iniciar Sesi&oacute;n</button>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
                </form>
            </div>
        </div>
        <div class="col-lg-12 text-center">
            <p>
                Olvidaste la contrase&ntilde;a?
            </p>
        </div>
    </div>
</body>

</html>