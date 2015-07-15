package rest;



import javax.ws.rs.Path;

import services.LogService;
import services.LogServiceImp;


@Path("/estadisticas")
public class Rest {

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
	
}
