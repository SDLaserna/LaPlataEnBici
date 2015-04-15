<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>Administrador</title>
<%@ include file="configHead.jsp"%>
<link href="css/zabuto_calendar.min.css" rel="stylesheet" type="text/css">


<script>
function activarNav() {
	document.getElementById("inicio").setAttribute("class", "");
	document.getElementById("bicicletas").setAttribute("class", "active");
	document.getElementById("usuarios").setAttribute("class", "");
    document.getElementById("estaciones").setAttribute("class", "");
}
</script>

<link href="css/dataTables.bootstrap.css" rel="stylesheet"	type="text/css">

<script src="script/bootstrap.min.js" type="text/javascript"></script>
<script src="script/jquery.dataTables.js" type="text/javascript"></script>
<script src="script/dataTables.bootstrap.js" type="text/javascript"></script>
<!-- paginado script -->
<script type="text/javascript">
	$(function() {
		$("#example1").dataTable();
	});
</script>

</head>
<body onload="activarNav()">
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
							<h3 class="box-title">Historial de disponibilidad</h3>
						</div>
						<!-- /.box-header -->
						
						<div class="box-body table-responsive">
							<table id="example1" class="table table-bordered table-striped">
								<thead>
									<tr>
										<th>Fecha</th>
										<th>Hora</th>
										<th>Estado</th>
									</tr>
								</thead>
								<tbody>
									<tr>
										<td>25/01/2014</td>
										<td>12:12:12 hs</td>
										<td>Apta para el uso</td>
									</tr>
									<tr>
										<td>25/05/2014</td>
										<td>12:00:12 hs</td>
										<td>Denunciada</td>
									</tr>
									<tr>
										<td>25/08/2014</td>
										<td>15:12:00 hs</td>
										<td>En reparaci&oacute;n</td>
									</tr>
									<tr>
										<td>30/08/2014</td>
										<td>12:12:12 hs</td>
										<td>Apta para el uso</td>
									</tr>
								</tbody>
								<tfoot>
									<tr>
										<th>Fecha</th>
										<th>Hora</th>
										<th>Estado</th>
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