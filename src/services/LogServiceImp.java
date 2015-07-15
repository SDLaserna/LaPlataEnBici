package services;

import java.util.List;

import daos.LogDAO;
import daos.LogDAOImp;
import entidades.Log;

public class LogServiceImp implements LogService {
	
	
	private LogDAO logDAO = new LogDAOImp();

	@Override
	public void persistirLog(Log l) {
		this.logDAO.generarLog(l);
	}

	@Override
	public List<Log> listarLogs(Object entidad) {
		return this.logDAO.listarLogs(entidad);
	}
	
	

}
