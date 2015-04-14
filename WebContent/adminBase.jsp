<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Administrador</title>
<%@ include file="configHead.jsp"%>
<link href="css/dataTables.bootstrap.css" rel="stylesheet"
	type="text/css">
<link href="css/bootstrap.min.css" rel="stylesheet" type="text/css">

<script
	src="http://ajax.googleapis.com/ajax/libs/jquery/2.0.2/jquery.min.js"></script>
<script src="script/bootstrap-hover-dropdown.js"></script>
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
		<div id="header-topbar-option-demo" class="page-header-topbar">
			<nav id="topbar" role="navigation" style="margin-bottom: 0;"
				data-step="3" class=" navbar navbar-default navbar-static-top">
				<div class="topbar-main" style="height: 315%; background-repeat:round;">
					<ul class="nav navbar navbar-top-links navbar-right mbn">
						<li class="dropdown topbar-user" style="background-color:rgb(118, 0 ,0);"><a data-hover="dropdown"
							href="#" class="dropdown-toggle">
							<i class="fa fa-tasks"></i>&nbsp; <span
								class="hidden-xs">Sergio Laserna</span>&nbsp;<span class="caret"></span></a>
							<ul class="dropdown-menu dropdown-user pull-right" >
								<li><a href="#"><i class="fa fa-user"></i>Mi Perfil</a></li>								
								<li class="divider"></li>
								<li><a href=""><i class="fa fa-key"></i>Cerrar
										Sesi&oacute;n</a></li>
							</ul>
						</li>
					</ul>
				</div>
			</nav>
		</div>

		<div id="wrapper">
			<nav id="sidebar" role="navigation" data-step="2"
				data-intro="Template has <b>many navigation styles</b>"
				data-position="right" class="navbar-default navbar-static-side"
				style="min-height: 100%; background-color: #F0F2F5;">
				<div class="sidebar-collapse menu-scroll">
					<ul id="side-menu" class="nav">

						<div class="clearfix"></div>
						<li class="active"><a href=""> <i
								class="fa fa-home fa-fw"></i> <span class="menu-title">Estaciones</span></a></li>
						<li><a href=""><i class="fa fa-bicycle fa-fw">
									<div class="icon-bg bg-pink"></div>
							</i><span class="menu-title">Bicicletas</span></a></li>
						<li><a href=""><i
								class="fa fa-group fa-fw">
									<div class="icon-bg bg-green"></div>
							</i><span class="menu-title">Usuarios</span></a></li>
					</ul>
				</div>
			</nav>
			<div id="page-wrapper" style="margin-top:8%; border:6px solid #7B0000;">
				<div class="page-content">

					<div class="box">
						<div class="box-header">
							<h3 class="box-title">Lista de estaciones</h3>
						</div>
						<!-- /.box-header -->
						<div style="  margin-top: 3%; margin-bottom: 2%;">
							<button class="btn btn-success"><i class="fa fa-plus-circle"></i></button>
							<label>Agregar</label>
						</div>
						<div class="box-body table-responsive">
							<table id="example1" class="table table-bordered table-striped">
								<thead>
									<tr>
										<th>Nombre</th>
										<th>Ubicaci&oacute;n</th>
										<th>Cant.Bicicletas</th>
										<th>Cant. Estacionamientos libres</th>
										<th>Estado</th>
										<th>Opciones</th>
									</tr>
								</thead>
								<tbody>
									<tr>
										<td>Estaci&oacute;n 1</td>
										<td>Berisso</td>
										<td>50</td>
										<td>4</td>
										<td>Operativa</td>
										<td><button class="btn btn-primary"><i class="fa fa-edit"></i></button><button class="btn btn-danger"><i class="fa fa-eraser"></i></button></td>
									</tr>
									<tr>
										<td>Estaci&oacute;n 2</td>
										<td>Berisso</td>
										<td>50</td>
										<td>5</td>
										<td>Operativa</td>
										<td><button class="btn btn-primary"><i class="fa fa-edit"></i></button><button class="btn btn-danger"><i class="fa fa-eraser"></i></button></td>
									</tr>
									<tr>
										<td>Estaci&oacute;n 3</td>
										<td>Tolosa</td>
										<td>50</td>
										<td>25</td>
										<td>Operativa</td>
										<td><button class="btn btn-primary"><i class="fa fa-edit"></i></button><button class="btn btn-danger"><i class="fa fa-eraser"></i></button></td>
									</tr>
									<tr>
										<td>Estaci&oacute;n 4</td>
										<td>Tolosa</td>
										<td>50</td>
										<td>25</td>
										<td>Operativa</td>
										<td><button class="btn btn-primary"><i class="fa fa-edit"></i></button><button class="btn btn-danger"><i class="fa fa-eraser"></i></button></td>
									</tr>
									<tr>
										<td>Estaci&oacute;n 5</td>
										<td>Tolosa</td>
										<td>50</td>
										<td>30</td>
										<td>Operativa</td>
										<td><button class="btn btn-primary"><i class="fa fa-edit"></i></button><button class="btn btn-danger"><i class="fa fa-eraser"></i></button></td>
									</tr>
									<tr>
										<td>Estaci&oacute;n 6</td>
										<td>La Plata</td>
										<td>50</td>
										<td>30</td>
										<td>Operativa</td>
										<td><button class="btn btn-primary"><i class="fa fa-edit"></i></button><button class="btn btn-danger"><i class="fa fa-eraser"></i></button></td>
									</tr>
									<tr>
										<td>Estaci&oacute;n 7</td>
										<td>La Plata</td>
										<td>50</td>
										<td>30</td>
										<td>Operativa</td>
										<td><button class="btn btn-primary"><i class="fa fa-edit"></i></button><button class="btn btn-danger"><i class="fa fa-eraser"></i></button></td>
									</tr>
									<tr>
										<td>Estaci&oacute;n 8</td>
										<td>La Plata</td>
										<td>70</td>
										<td>30</td>
										<td>Operativa</td>
										<td><button class="btn btn-primary"><i class="fa fa-edit"></i></button><button class="btn btn-danger"><i class="fa fa-eraser"></i></button></td>
									</tr>
									<tr>
										<td>Estaci&oacute;n 9</td>
										<td>La Plata</td>
										<td>70</td>
										<td>30</td>
										<td>Operativa</td>
										<td><button class="btn btn-primary"><i class="fa fa-edit"></i></button><button class="btn btn-danger"><i class="fa fa-eraser"></i></button></td>
									</tr>
									<tr>
										<td>Estaci&oacute;n 10</td>
										<td>La Plata</td>
										<td>70</td>
										<td>30</td>
										<td>Cerrada</td>
										<td><button class="btn btn-primary"><i class="fa fa-edit"></i></button><button class="btn btn-danger"><i class="fa fa-eraser"></i></button></td>
									</tr>
									<tr>
										<td>Estaci&oacute;n 11</td>
										<td>La Plata</td>
										<td>70</td>
										<td>30</td>
										<td>Cerrada</td>
										<td><button class="btn btn-primary"><i class="fa fa-edit"></i></button><button class="btn btn-danger"><i class="fa fa-eraser"></i></button></td>
									</tr>
									<tr>
										<td>Estaci&oacute;n 12</td>
										<td>La Plata</td>
										<td>78</td>
										<td>30</td>
										<td>Cerrada</td>
										<td><button class="btn btn-primary"><i class="fa fa-edit"></i></button><button class="btn btn-danger"><i class="fa fa-eraser"></i></button></td>
									</tr>
									<tr>
										<td>Estaci&oacute;n 13</td>
										<td>La Plata</td>
										<td>0</td>
										<td>-</td>
										<td>En construcci&oacute;n</td>
										<td><button class="btn btn-primary"><i class="fa fa-edit"></i></button><button class="btn btn-danger"><i class="fa fa-eraser"></i></button></td>
									</tr>
								</tbody>
								<tfoot>
									<tr>
										<th>Nombre</th>
										<th>Ubicaci&oacute;n</th>
										<th>Cant.Bicicletas</th>
										<th>Cant. Estacionamientos libres</th>
										<th>Estado</th>
										<th>Opciones</th>
									</tr>
								</tfoot>
							</table>
						</div>
						<!-- /.box-body -->
					</div>
					<!-- /.box -->
				</div>
			</div>
		</div>
	</div>

</body>
</html>