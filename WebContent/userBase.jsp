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
	document.getElementById("inicio").setAttribute("class", "active");
	document.getElementById("mapaEstaciones").setAttribute("class", "");
    document.getElementById("listaEstaciones").setAttribute("class", "");
	document.getElementById("misBicicletas").setAttribute("class", "");
}
</script>

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
					

					<!-- Contenedor Fin -->

				</div>
			</div>
		</div>
	</div>

</body>
</html>