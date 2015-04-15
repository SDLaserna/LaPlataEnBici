<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html >
<html>
<head>
<title>Registrarse</title>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<%@ include file="/configHead.jsp"%>
</head>
<body
	style="background: url('images/bg/bgRegistrar.PNG') center center fixed;">
	<div class="col-lg-4" style="margin-left: 36%; margin-top: 3%;">
		<div class="panel panel-orange">
			<div class="panel-heading">Formulario de Registro</div>
			<div class="panel-body pan">
				<form action="">
					<div class="form-body pal">
						<div class="form-group">
							<div class="input-icon right">
								<i class="fa fa-user"></i> <input id="inputName" type="text"
									placeholder="Nombre de Usuario" class="form-control">
							</div>
						</div>
						<div class="form-group">
							<div class="input-icon right">
								<i class="fa fa-envelope"></i> <input id="inputEmail"
									type="text" placeholder="Direccion de email"
									class="form-control">
							</div>
						</div>
						<hr>
						<div class="row">
							<div class="col-md-6">
								<div class="form-group">
									<input id="inputFirstName" type="text" placeholder="Nombre"
										class="form-control">
								</div>
							</div>
							<div class="col-md-6">
								<div class="form-group">
									<input id="inputLastName" type="text" placeholder="Apellido"
										class="form-control">
								</div>
							</div>
						</div>
						<div class="form-group">
							<div class="input-icon right">
								<i class="fa fa-lock"></i> <input id="inputPassword"
									type="text" placeholder="DNI" class="form-control">
							</div>
						</div>
						<div class="form-group">
							<div class="input-icon right">
								<i class="fa fa-calendar"></i><input id="inputPassword"
									type="date"  class="form-control">
							</div>
						</div>
						<div class="form-group">
							<div class="input-icon right">
								<i class="fa fa-home"></i> <input id="inputConfirmPassword"
									type="text" placeholder="Domicilio"
									class="form-control">
							</div>
						</div>
						<div class="form-group">
							<select class="form-control">
								<option>Genero</option>
								<option value="0">Masculino</option>
								<option value="1">Femenino</option>
								<option value="2">Otro</option>
							</select>
						</div>
						<div class="form-group">
							<div class="checkbox">
								<label>
									<div class="icheckbox_minimal-grey" style="position: relative;">
										<input tabindex="5" type="checkbox"
											style="position: absolute; top: -20%; left: -20%; display: block; width: 140%; height: 140%; margin: 0px; padding: 0px; border: 0px; opacity: 0; background: rgb(255, 255, 255);">
										<ins class="iCheck-helper"
											style="position: absolute; top: -20%; left: -20%; display: block; width: 140%; height: 140%; margin: 0px; padding: 0px; border: 0px; opacity: 0; background: rgb(255, 255, 255);"></ins>
									</div>&nbsp; Quiero recibir actualizaciones por mail
								</label>
							</div>
						</div>
						<div class="form-group mbn">
							<div class="checkbox">
								<label>
									<div class="icheckbox_minimal-grey" style="position: relative;">
										<input tabindex="5" type="checkbox"
											style="position: absolute; top: -20%; left: -20%; display: block; width: 140%; height: 140%; margin: 0px; padding: 0px; border: 0px; opacity: 0; background: rgb(255, 255, 255);">
										<ins class="iCheck-helper"
											style="position: absolute; top: -20%; left: -20%; display: block; width: 140%; height: 140%; margin: 0px; padding: 0px; border: 0px; opacity: 0; background: rgb(255, 255, 255);"></ins>
									</div>&nbsp; Acepto los t&eacute;rminos y condiciones
								</label>
							</div>
						</div>
					</div>
					<div class="col-md-6" style="margin-bottom: 4%;">
						<button type="submit" class="btn btn-primary"
							style="margin-left: 24%;">Registrarse</button>
					</div>
					<div class="col-md-6">
						<a class="btn btn-danger" href="inicio">Cancelar</a>
					</div>
				</form>
			</div>
		</div>
	</div>
</body>
</html>