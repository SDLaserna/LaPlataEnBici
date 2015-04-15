<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>Administrador</title>
<%@ include file="configHead.jsp"%>
<script type="text/javascript" src="script/jquery-1.10.2.min.js"> </script>
<script src="script/main.js"></script>
    
    <script src="script/jquery-migrate-1.2.1.min.js"></script>
    <script src="script/bootstrap.min.js"></script>
    <script src="script/jquery.metisMenu.js"></script>
    <script src="script/jquery.slimscroll.js"></script>
    <script src="script/icheck.min.js"></script>
	<script src="https://maps.googleapis.com/maps/api/js?v=3.exp"></script>
<script>
	// 	var map;
	var geocoder;
	var map = new google.maps.Marker;
	var marker = new google.maps.Marker;
	function initialize() {
		geocoder = new google.maps.Geocoder();
		var mapOptions = {
			zoom : 12,
			center : new google.maps.LatLng(-34.9205284, -57.9531702),
			mapTypeId : google.maps.MapTypeId.ROADMAP
		};
		map = new google.maps.Map(document.getElementById('map-canvas'),
				mapOptions);
	}

	google.maps.event.addDomListener(window, 'load', initialize);
</script>
<script>

function activarNav() {
	document.getElementById("inicio").setAttribute("class", "");
	document.getElementById("bicicletas").setAttribute("class", "");
	document.getElementById("usuarios").setAttribute("class", "");
    document.getElementById("estaciones").setAttribute("class", "active");
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
					<div class="col-lg-4">
					<div class="panel panel-green">
                                            <div class="panel-heading">
                                                Modificar Estaci&oacute;n</div>
                                            <div class="panel-body pan">
                                                <form action="#">
                                                <div class="form-body pal">
                                                    <div class="form-group">
                                                        <label for="inputSubject" class="control-label">
                                                            Nombre</label>
                                                        <div class="input-icon right">
                                                            <i class="fa fa-tag"></i>
                                                            <input id="inputSubject" type="text" placeholder="" class="form-control"></div>
                                                    </div>
                                                    <div class="form-group">
                                                        <label for="inputSubject" class="control-label">
                                                            Cantidad de estacionamientos</label>
                                                        <div class="input-icon right">
                                                            <i class="fa fa-tag"></i>
                                                            <input id="inputSubject" type="text" placeholder="" class="form-control"></div>
                                                    </div>
                                                    <div class="form-group">
                                                        <label for="inputSubject" class="control-label">
                                                            Estado</label>
                                                            <select class="form-control">
					                                                <option>Operativo</option>
					                                                <option>Cerrado</option>
					                                                <option>En construccion</option>
                                            				</select>
                                            		</div>	
                                                    <div class="form-group">
                                                        <label for="inputSubject" class="control-label">
                                                            Ubicaci&oacute;n</label>
                                                        <div class="input-icon right">
                                                            <i class="fa fa-tag"></i>
                                                            <input id="inputSubject" type="text" placeholder="" class="form-control"></div>
                                                    </div>
                                                    <button type="button" data-container="body" data-toggle="popover" data-placement="right" data-content="Se busca en el mapa la direccion contenida en el campo 'Ubicacion' y se habilita el boton agregar si existe el punto " class="btn btn-default" data-original-title="" title="">Buscar en Mapa</button>
                                                    
                                                </div>
                                                <div class="form-actions text-right pal">
                                                    <button type="submit" class="btn btn-success">
                                                        Modificar</button>
                                                </div>
                                                </form>
                                            </div>
                                        </div>
                                      </div>
                                      
                                      <div class="col-lg-6">
											<div id="map-canvas" style="width: 507px;  height: 527px;" class="embed-responsive-item"></div>
                                    </div>
					<!-- Contenedor Fin -->

				</div>
			</div>
		</div>
	</div>

</body>
</html>