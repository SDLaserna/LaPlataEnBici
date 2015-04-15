<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Usuario</title>
<%@ include file="configHead.jsp"%>

<script>
	function activarNav() {
		document.getElementById("inicio").setAttribute("class", "");
		document.getElementById("mapaEstaciones").setAttribute("class", "");
		document.getElementById("listaEstaciones").setAttribute("class", "");
		document.getElementById("misBicicletas")
				.setAttribute("class", "active");
	}
</script>

<link href="css/dataTables.bootstrap.css" rel="stylesheet"
	type="text/css">

<script src="script/bootstrap.min.js" type="text/javascript"></script>
<script src="script/jquery.dataTables.js" type="text/javascript"></script>
<script src="script/dataTables.bootstrap.js" type="text/javascript"></script>

</head>
<body onLoad="activarNav()">
	<div>
		<!-- Incluir  Cabecera -->
		<%@ include file="header.jsp"%>

		<div id="wrapper">

			<!-- Incluir Navegador lateral -->
			<%@ include file="userNav.jsp"%>

			<div id="page-wrapper"
				style="margin-top: 8%; border: 6px solid #7B0000;">
				<div class="page-content">

					<!--   Contenedor -->

					<div class="box">
						<div class="box-header">
							<h3 class="box-title">Mis Bicicletas</h3>
						</div>
						<!-- /.box-header -->

						<div class="box-body table-responsive">
							<table id="example1" class="table table-bordered table-striped">
								<thead>
									<tr>
										<th>Identificador</th>
										<th>Fecha de ingreso</th>
										<th>Estado</th>
										<th>Ubicaci&oacute;n actual</th>
										<th>Opciones</th>
									</tr>
								</thead>
								<tbody>
									<tr>
										<td>123</td>
										<td>01/02/2014</td>
										<td>Apta Para el uso</td>
										<td>Estaci&oacute;n 1</td>
										<td><a href="estacionarBicicleta">
												<button class="btn btn-info">
													<i class="fa fa-flag-checkered"></i> Estacionar
												</button>
										</a>
											<button class="btn btn-danger">
												<i class="fa fa-thumbs-o-down"></i> Denunciar
											</button></td>
									</tr>
									<tr>
										<td>134</td>
										<td>01/02/2014</td>
										<td>Apta Para el uso</td>
										<td>Estaci&oacute;n 1</td>
										<td><a href="estacionarBicicleta">
												<button class="btn btn-info">
													<i class="fa fa-flag-checkered"></i> Estacionar
												</button>
										</a>
											<button class="btn btn-danger">
												<i class="fa fa-thumbs-o-down"></i> Denunciar
											</button></td>
									</tr>
									<tr>
										<td>576</td>
										<td>01/02/2014</td>
										<td>Apta Para el uso</td>
										<td>Estaci&oacute;n 1</td>
										<td><a href="estacionarBicicleta">
												<button class="btn btn-info">
													<i class="fa fa-flag-checkered"></i> Estacionar
												</button>
										</a>
											<button class="btn btn-danger">
												<i class="fa fa-thumbs-o-down"></i> Denunciar
											</button></td>
									</tr>
								</tbody>
							</table>
						</div>
						<!-- /.box-body -->
					</div>
					<!-- /.box -->

					<!-- Contenedor Fin -->

				</div>
			</div>
		</div>
	</div>

</body>
</html>