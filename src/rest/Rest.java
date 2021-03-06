package rest;

import java.io.IOException;
import java.util.List;
import java.util.Map;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Request;
import javax.ws.rs.core.UriInfo;

import entidades.Estacion;
import entidades.HistorialEstacion;
import entidades.Log;
import services.EstacionService;
import services.EstacionServiceImp;
import services.HistorialEstacionService;
import services.HistorialEstacionServiceImp;
import services.LogService;
import services.LogServiceImp;


@Path("/log")
public class Rest {
	@Context
	UriInfo uriInfo;
	@Context
	Request request;
	
	private LogService logService;
	private EstacionService estacionService;
	private HistorialEstacionService historialEstacionService;
	
	public Rest(){
		this.logService=new LogServiceImp();
		this.setEstacionService(new EstacionServiceImp());
		this.historialEstacionService = new HistorialEstacionServiceImp();
	}
	

	public LogService getLogService() {
		return logService;
	}

	public void setLogService(LogService logService) {
		this.logService = logService;
	}
	
	@GET
	@Produces({MediaType.APPLICATION_JSON })
	@Consumes(MediaType.APPLICATION_FORM_URLENCODED)
	public Map<String,Integer> getLogs(@QueryParam("tipoEntidad") String entidad)throws IOException{
		return this.getLogService().listarLogs(entidad);
	}
	
	@GET
	@Path("estaciones")
	@Produces({MediaType.APPLICATION_JSON })
	public List<Estacion> getEstaciones()throws IOException{
		return this.getEstacionService().listarActivas();
	}
	
	@GET
	@Path("historialEstadoEstacion")
	@Produces({MediaType.APPLICATION_JSON })
	@Consumes(MediaType.APPLICATION_FORM_URLENCODED)
	public Map<String,Integer> getHistorialEstadosEstacion(@QueryParam("idEstacion") String idEstacion)throws IOException{
		Long idLong = Long.parseLong(idEstacion);
		return this.historialEstacionService.historialDeLaEstacion(idLong);
	}

	public EstacionService getEstacionService() {
		return estacionService;
	}


	public void setEstacionService(EstacionService estacionService) {
		this.estacionService = estacionService;
	}
	
}
