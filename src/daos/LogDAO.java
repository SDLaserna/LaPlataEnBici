package daos;


import java.util.List;

import entidades.Log;


public interface LogDAO extends GenericDAO<Log>{
	
	void generarLog(Log l);
//	List<Log> listarLogs(Object IdEntidad);
	List<Log> listarLogs(String tipoEntidad);
}
