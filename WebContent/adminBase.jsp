<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Administrador</title>
<%@ include file="configHead.jsp"%>
<script>

function activarNav() {
	document.getElementById("inicio").setAttribute("class", "active");
	document.getElementById("bicicletas").setAttribute("class", "");
	document.getElementById("usuarios").setAttribute("class", "");
    document.getElementById("estaciones").setAttribute("class", "");
}
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
					

					<!-- Contenedor Fin -->

				</div>
			</div>
		</div>
	</div>

</body>
</html>