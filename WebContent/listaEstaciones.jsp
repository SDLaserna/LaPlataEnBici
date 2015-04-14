<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Usuario</title>

<%@ include file="configHead.jsp"%>

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
<body>
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
							<h3 class="box-title">Lista de estaciones</h3>
						</div>
						<!-- /.box-header -->
						
						<div class="box-body table-responsive">
							<table id="example1" class="table table-bordered table-striped">
								<thead>
									<tr>
										<th>Nombre</th>
										<th>Ubicaci&oacute;n</th>
										<th>Cant.Bicicletas</th>
										<th>Cant. Estacionamientos libres</th>
										<th>Estado</th>
									</tr>
								</thead>
								<tbody>
									<tr>
										<td>Estaci&oacute;n 1</td>
										<td>Berisso</td>
										<td>50</td>
										<td>4</td>
										<td>Operativa</td>
									</tr>
									<tr>
										<td>Estaci&oacute;n 2</td>
										<td>Berisso</td>
										<td>50</td>
										<td>5</td>
										<td>Operativa</td>
									</tr>
									<tr>
										<td>Estaci&oacute;n 3</td>
										<td>Tolosa</td>
										<td>50</td>
										<td>25</td>
										<td>Operativa</td>
									</tr>
									<tr>
										<td>Estaci&oacute;n 4</td>
										<td>Tolosa</td>
										<td>50</td>
										<td>25</td>
										<td>Operativa</td>
									</tr>
									<tr>
										<td>Estaci&oacute;n 5</td>
										<td>Tolosa</td>
										<td>50</td>
										<td>30</td>
										<td>Operativa</td>
									</tr>
									<tr>
										<td>Estaci&oacute;n 6</td>
										<td>La Plata</td>
										<td>50</td>
										<td>30</td>
										<td>Operativa</td>
									</tr>
									<tr>
										<td>Estaci&oacute;n 7</td>
										<td>La Plata</td>
										<td>50</td>
										<td>30</td>
										<td>Operativa</td>
									</tr>
									<tr>
										<td>Estaci&oacute;n 8</td>
										<td>La Plata</td>
										<td>70</td>
										<td>30</td>
										<td>Operativa</td>
									</tr>
									<tr>
										<td>Estaci&oacute;n 9</td>
										<td>La Plata</td>
										<td>70</td>
										<td>30</td>
										<td>Operativa</td>
									</tr>
									<tr>
										<td>Estaci&oacute;n 10</td>
										<td>La Plata</td>
										<td>70</td>
										<td>30</td>
										<td>Cerrada</td>
									</tr>
									<tr>
										<td>Estaci&oacute;n 11</td>
										<td>La Plata</td>
										<td>70</td>
										<td>30</td>
										<td>Cerrada</td>
									</tr>
									<tr>
										<td>Estaci&oacute;n 12</td>
										<td>La Plata</td>
										<td>78</td>
										<td>30</td>
										<td>Cerrada</td>
									</tr>
									<tr>
										<td>Estaci&oacute;n 13</td>
										<td>La Plata</td>
										<td>0</td>
										<td>-</td>
										<td>En construcci&oacute;n</td>
									</tr>
								</tbody>
								<tfoot>
									<tr>
										<th>Nombre</th>
										<th>Ubicaci&oacute;n</th>
										<th>Cant.Bicicletas</th>
										<th>Cant. Estacionamientos libres</th>
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