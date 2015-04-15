<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>Administrador</title>
<%@ include file="configHead.jsp"%>
<link href="css/zabuto_calendar.min.css" rel="stylesheet" type="text/css">
<script type="text/javascript" src="script/zabuto_calendar.min.js"></script>

<script type="application/javascript">
$(document).ready(function () {
    $("#my-calendar").zabuto_calendar({	 cell_border: true, show_days: true, language: "es",
    																	action: function(){
    																		return clickEnFecha(this.id);}
    });
});

function clickEnFecha(id){ 
	var fecha = $("#" + id).data("date");
	alert("abrir los horarios del "+fecha);}
</script>

<script>
function activarNav() {
	document.getElementById("inicio").setAttribute("class", "");
	document.getElementById("bicicletas").setAttribute("class", "active");
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
					<h3>Disponibilidades</h3>
		             <div id="my-calendar"></div>

					<!-- Contenedor Fin -->

				</div>
			</div>
		</div>
	</div>

</body>
</html>