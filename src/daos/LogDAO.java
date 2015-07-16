package daos;


import java.util.Map;

import entidades.Log;


public interface LogDAO extends GenericDAO<Log>{
	
	void generarLog(Log l);
//	List<Log> listarLogs(Object IdEntidad);
	Map<String,Integer> listarLogs(String tipoEntidad);
}
