<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>ABM bicicletas</title>
<%@ include file="configHead.jsp"%>

<link href="css/dataTables.bootstrap.css" rel="stylesheet"
	type="text/css">

<script src="script/bootstrap.min.js" type="text/javascript"></script>
<script src="script/jquery.dataTables.js" type="text/javascript"></script>
<script src="script/dataTables.bootstrap.js" type="text/javascript"></script>
<!-- paginado script -->
<script type="text/javascript">
	$(function() {
		$("#example1").dataTable();
	});
</script>
<script>

function activarNav() {
	document.getElementById("inicio").setAttribute("class", "");
	document.getElementById("usuarios").setAttribute("class", "");
    document.getElementById("estaciones").setAttribute("class", "");
	document.getElementById("bicicletas").setAttribute("class", "active");
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
					<div class="box">
						<div class="box-header">
							<h3 class="box-title">Lista de Bicicletas</h3>
						</div>
						<!-- /.box-header -->
						<div style="margin-top: 3%; margin-bottom: 2%;">
							<a href="redireccionAltaBici">
								<button class="btn btn-success">
									<i class="fa fa-plus-circle"></i> <span class="menu-title">Agregar</span>
								</button>
							</a>
						</div>
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
										<td><a href="verDisponibilidadBici">
												<button class="btn btn-info">
													<i class="fa fa-eye"></i> Ver disponibilidad
												</button>
										</a> <a href="verModificarBici">
												<button class="btn btn-primary">
													<i class="fa fa-edit"></i> Modificar
												</button>
										</a>
											<button class="btn btn-danger">
												<i class="fa fa-eraser"></i> Eliminar
											</button></td>
									</tr>
									<tr>
										<td>134</td>
										<td>01/02/2014</td>
										<td>Apta Para el uso</td>
										<td>Estaci&oacute;n 1</td>
										<td><a href="verDisponibilidadBici">
												<button class="btn btn-info">
													<i class="fa fa-eye"></i> Ver disponibilidad
												</button>
										</a> <a href="verModificarBici">
												<button class="btn btn-primary">
													<i class="fa fa-edit"></i> Modificar
												</button>
										</a>
											<button class="btn btn-danger">
												<i class="fa fa-eraser"></i> Eliminar
											</button></td>
									</tr>
									<tr>
										<td>576</td>
										<td>01/02/2014</td>
										<td>Apta Para el uso</td>
										<td>Estaci&oacute;n 1</td>
										<td><a href="verDisponibilidadBici">
												<button class="btn btn-info">
													<i class="fa fa-eye"></i> Ver disponibilidad
												</button>
										</a> <a href="verModificarBici">
												<button class="btn btn-primary">
													<i class="fa fa-edit"></i> Modificar
												</button>
										</a>
											<button class="btn btn-danger">
												<i class="fa fa-eraser"></i> Eliminar
											</button></td>
									</tr>
									<tr>
										<td>456</td>
										<td>01/02/2014</td>
										<td>En desuso</td>
										<td>Estaci&oacute;n 3</td>
										<td><a href="verDisponibilidadBici">
												<button class="btn btn-info">
													<i class="fa fa-eye"></i> Ver disponibilidad
												</button>
										</a> <a href="verModificarBici">
												<button class="btn btn-primary">
													<i class="fa fa-edit"></i> Modificar
												</button>
										</a>
											<button class="btn btn-danger">
												<i class="fa fa-eraser"></i> Eliminar
											</button></td>
									</tr>
									<tr>
										<td>094</td>
										<td>01/02/2014</td>
										<td>Denunciada</td>
										<td>Estaci&oacute;n 1</td>
										<td><a href="verDisponibilidadBici">
												<button class="btn btn-info">
													<i class="fa fa-eye"></i> Ver disponibilidad
												</button>
										</a> <a href="verModificarBici">
												<button class="btn btn-primary">
													<i class="fa fa-edit"></i> Modificar
												</button>
										</a>
											<button class="btn btn-danger">
												<i class="fa fa-eraser"></i> Eliminar
											</button></td>
									</tr>
									<tr>
										<td>234</td>
										<td>01/02/2014</td>
										<td>En reparaci&oacute;n</td>
										<td>Estaci&oacute;n 1</td>
										<td><a href="verDisponibilidadBici">
												<button class="btn btn-info">
													<i class="fa fa-eye"></i> Ver disponibilidad
												</button>
										</a> <a href="verModificarBici">
												<button class="btn btn-primary">
													<i class="fa fa-edit"></i> Modificar
												</button>
										</a>
											<button class="btn btn-danger">
												<i class="fa fa-eraser"></i> Eliminar
											</button></td>
									</tr>

								</tbody>
								<tfoot>
									<tr>
										<th>Identificador</th>
										<th>Fecha de ingreso</th>
										<th>Estado</th>
										<th>Ubicaci&oacute;n actual</th>
										<th>Opciones</th>
									</tr>
								</tfoot>
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