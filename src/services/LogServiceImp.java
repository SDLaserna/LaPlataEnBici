package services;

import daos.LogDAO;
import daos.LogDAOImp;
import entidades.Log;

public class LogServiceImp implements LogService {
	
	
	private LogDAO logDAO = new LogDAOImp();

	@Override
	public void persistirLog(Log l) {
		this.logDAO.generarLog(l);
	}

}
