<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Usuario</title>
<%@ include file="configHead.jsp"%>

<script src="https://maps.googleapis.com/maps/api/js?v=3.exp"></script>
<script>
	// 	var map;
	var geocoder;
	var map = new google.maps.Marker;
	function initialize() {
		geocoder = new google.maps.Geocoder();
		var mapOptions = {
			zoom : 12,
			center : new google.maps.LatLng(-34.9205284, -57.9531702),
			mapTypeId : google.maps.MapTypeId.ROADMAP
		};
		map = new google.maps.Map(document.getElementById('map-canvas'),
				mapOptions);
		
	    var marker = new google.maps.Marker({
	        position: map.getCenter()
	        , map: map
	        , title: 'Estación 6'
	        , icon: '/LaPlataEnBici/images/icons/estacion.png'
	    });
	 
	    var popup = new google.maps.InfoWindow({
	        content: '<b>Datos de la estación: </b><br>' +
	        		 'Estado: Operativa. <br>' +
	        		 'Cant. Bicicletas: 50. <br>' +
	        		 'Cant. Estacionamientos libres: 30.'
	    });
	 	
	    google.maps.event.addListener(marker, 'click', function(){
	        popup.open(map, marker);
	    });
		
	}

	google.maps.event.addDomListener(window, 'load', initialize);
</script>

<script>
	function activarNav() {
		document.getElementById("inicio").setAttribute("class", "");
		document.getElementById("mapaEstaciones").setAttribute("class",
				"active");
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

					<div class="col-lg-4">
						<div class="panel panel-blue" style="background: #fff;">
							<div class="panel-heading">Mapa de estaciones</div>
							<div class="panel-body pan">
								<form action="">
									<div class="form-body pal">
										<div class="form-group mbn">
											<label for="inputSubject" class="control-label">
												Direcci&oacute;n a buscar</label>
											<div class="input-icon right">
												<i class="fa fa-map-marker"></i> <input id="inputSubject"
													type="text" placeholder="" class="form-control" />
											</div>
										</div>
									</div>
									<div class="form-actions text-right pal">
										<button type="submit" class="btn btn-primary">Buscar en Mapa</button>
									</div>
								</form>
							</div>
						</div>
					</div>


					<div class="col-lg-6">
						<div id="map-canvas" style="width: 507px; height: 527px;"
							class="embed-responsive-item"></div>
					</div>

					<!-- Contenedor Fin -->

				</div>
			</div>
		</div>
	</div>

</body>
</html>