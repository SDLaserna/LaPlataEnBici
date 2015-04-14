<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html >
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>Insert title here</title>
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
<script>

function activarNav() {
	document.getElementById("inicio").setAttribute("class", "");
	document.getElementById("bicicletas").setAttribute("class", "");
    document.getElementById("estaciones").setAttribute("class", "");
	document.getElementById("usuarios").setAttribute("class", "active");
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
							<h3 class="box-title">Lista de Usuarios</h3>
						</div>
						<!-- /.box-header -->
						
						<div class="box-body table-responsive">
							<table id="example1" class="table table-bordered table-striped">
								<thead>
									<tr>
										<th>Nombres</th>
										<th>Apellido</th>
										<th>DNI</th>
										<th>Opciones</th>
									</tr>
								</thead>
								<tbody>
									<tr>
										<td>Ernersto</td>
										<td>Larralde</td>
										<td>54265456</td>
										<td>
											<button class="btn btn-info">
												<i class="fa fa-eraser"></i> Inhabilitacion Temporal
											</button>
											<button class="btn btn-danger">
												<i class="fa fa-eraser"></i> Inhabilitacion definitiva
											</button>
										</td>
											
									</tr>
									<tr>
										<td>Sergio David</td>
										<td>Laserna</td>
										<td>38638535</td>
										<td>
										<button class="btn btn-info">
												<i class="fa fa-eraser"></i> Inhabilitacion Temporal
											</button>
											<button class="btn btn-danger">
												<i class="fa fa-eraser"></i> Inhabilitacion definitiva
											</button>
										</td>
									</tr>
									<tr>
										<td>Candela Suyay</td>
										<td>Goncebat</td>
										<td>90000000</td>
										<td>
										<button class="btn btn-info">
												<i class="fa fa-eraser"></i> Inhabilitacion Temporal
											</button>
											<button class="btn btn-danger">
												<i class="fa fa-eraser"></i> Inhabilitacion definitiva
											</button>
										</td>
									</tr>
								</tbody>
								<tfoot>
									<tr>
										<th>Nombres</th>
										<th>Apellido</th>
										<th>DNI</th>
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