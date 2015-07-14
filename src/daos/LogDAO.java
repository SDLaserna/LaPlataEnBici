package daos;

import entidades.Log;


public interface LogDAO extends GenericDAO<Log>{
	
	void generarLog(Log l);
	
}
