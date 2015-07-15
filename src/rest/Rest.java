package rest;

import java.io.IOException;
import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Request;
import javax.ws.rs.core.UriInfo;

import entidades.Log;
import services.LogService;
import services.LogServiceImp;


@Path("/log")
public class Rest {
	@Context
	UriInfo uriInfo;
	@Context
	Request request;
	
	private LogService logService;
	
	public Rest(){
		this.logService=new LogServiceImp();
	}
	

	public LogService getLogService() {
		return logService;
	}

	public void setLogService(LogService logService) {
		this.logService = logService;
	}
	
	@GET
	@Produces({ MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON })
	@Consumes(MediaType.APPLICATION_FORM_URLENCODED)
	public List<Log> getLogs(@QueryParam("tipoEntidad") String entidad)throws IOException{
		return this.getLogService().listarLogs(entidad);
	}
	
}
