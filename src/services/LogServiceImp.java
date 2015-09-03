package services;

import java.util.HashMap;
import java.util.List;
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
	
	@Override
	public Map<String,Integer> listarLogs(String entidad) {
		
		List<Log> listaResul = this.logDAO.listarLogs(entidad);
		Map<String,Integer> mapResul = new HashMap<String,Integer>();
		int altas=0;
		int bajas=0;
		int modif=0;
		for (Log l : listaResul) {
		    String operacion = l.getOperacion();
		    switch (operacion) {
				case "Alta": altas++; break;
				case "Baja": bajas++; break;
				case "Actualizacion": modif++; break;
				default:
					break;
			}
		  }		
		mapResul.put("Alta",altas);
		mapResul.put("Baja",bajas);
		mapResul.put("Actualizacion",modif);
		
		return mapResul;
	}

}
