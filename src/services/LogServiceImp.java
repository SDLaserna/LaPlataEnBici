package services;

import java.util.Map;

import daos.LogDAO;
import daos.LogDAOImp;
import entidades.Log;

public class LogServiceImp implements LogService {
	
	
	private LogDAO logDAO = new LogDAOImp();

	@Override
	public void persistirLog(Log l) {
		this.logDAO.generarLog(l);
	}

//	@Override
//	public List<Log> listarLogs(Object entidad) {
//		return this.logDAO.listarLogs(entidad);
//	}
	
	@Override
	public Map<String,Integer> listarLogs(String entidad) {
		return this.logDAO.listarLogs(entidad);
	}

}
