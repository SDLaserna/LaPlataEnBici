<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>Administrador</title>
<%@ include file="configHead.jsp"%>
<script>

function activarNav() {
	document.getElementById("inicio").setAttribute("class", "");
	document.getElementById("bicicletas").setAttribute("class", "active");
	document.getElementById("usuarios").setAttribute("class", "");
    document.getElementById("estaciones").setAttribute("class", "");
}
</script>
</head>
<body onLoad="activarNav()">
	<div>
		<!-- Incluir  Cabecera -->
		<%@ include file="header.jsp"%>

		<div id="wrapper">

			<!-- Incluir Navegador lateral -->
			<%@ include file="adminNav.jsp"%>

			<div id="page-wrapper"
				style="margin-top: 8%; border: 6px solid #7B0000;">
				<div class="page-content">

					<!--   Contenedor -->
					<div class="panel panel-green">
                                            <div class="panel-heading">
                                                Modificar Bicicleta</div>
                                            <div class="panel-body pan">
                                                <form action="#">
                                                <div class="form-body pal">
                                                    <div class="row">
                                                        <div class="col-md-6">
                                                            <div class="form-group">
                                                                <label for="inputName" class="control-label">
                                                                    Color</label>
                                                                <div class="input-icon right">
                                                                    <i class="fa fa-tint"></i>
                                                                    <input id="inputName" type="text" placeholder="" class="form-control"></div>
                                                            </div>
                                                        </div>
                                                        <div class="col-md-6">
                                                            <div class="form-group">
                                                                <label for="inputEmail" class="control-label">
                                                                    Rodado</label>
                                                                <div class="input-icon right">
                                                                    <i class="fa fa-bicycle"></i>
                                                                    <input  type="text" placeholder="" class="form-control"></div>
                                                            </div>
                                                        </div>
                                                        <div class="col-md-6">
                                                            <div class="form-group">
                                                                <label for="inputName" class="control-label">
                                                                    Marca</label>
                                                                <div class="input-icon right">
                                                                    <i class="fa fa-tag"></i>
                                                                    <input id="inputName" type="text" placeholder="" class="form-control"></div>
                                                            </div>
                                                        </div>
														<div class="col-md-6">
                                                            <div class="form-group">
                                                                <label for="inputEmail" class="control-label">
                                                                    Estaci&oacute;n</label>
                                                                <div class="input-icon right">
                                                                    <i class="fa fa-flag fa-fw"></i>
                                                                    <input  type="text" placeholder="" class="form-control"></div>
                                                            </div>
                                                        </div>
                                                        </div>
                                                    <div class="form-group">
                                                        <label for="inputMessage" class="control-label">
                                                            Descripci&oacute;n</label><textarea rows="5" class="form-control"></textarea></div>
                                                </div>
                                                <div class="form-actions text-right pal">
                                                    <button type="submit" class="btn btn-success">
                                                        Modificar</button>
                                                </div>
                                                </form>
                                            </div>
                                        </div>
					<!-- Contenedor Fin -->

				</div>
			</div>
		</div>
	</div>

</body>
</html>