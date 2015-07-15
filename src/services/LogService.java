package services;

import java.util.List;

import entidades.Log;

public interface LogService {
	void persistirLog(Log l);
//	List<Log> listarLogs(Object entidad);
	List<Log> listarLogs(String entidad);
}
