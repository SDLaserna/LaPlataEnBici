package services;

import java.util.Map;

import entidades.Log;

public interface LogService {
	void persistirLog(Log l);
//	List<Log> listarLogs(Object entidad);
	Map<String,Integer> listarLogs(String entidad);
}
