package services;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import daos.HistorialEstacionDAO;
import daos.HistorialEstacionDAOImp;
import entidades.HistorialEstacion;
import entidades.Log;

public class HistorialEstacionServiceImp implements HistorialEstacionService {
	
	private HistorialEstacionDAO historialEstacionDAO = new HistorialEstacionDAOImp();

	@Override
	public void persisitir(HistorialEstacion he) {
		this.historialEstacionDAO.crear(he);

	}

	@Override
	public Map<String,Integer> historialDeLaEstacion(Long idEstacion) {
				
		List<HistorialEstacion> listaResul = this.historialEstacionDAO.historialDeLaEstacion(idEstacion);
		Map<String,Integer> mapResul = new HashMap<String,Integer>();
		int ec=0;
		int cerradas=0;
		int operativas=0;
		for (HistorialEstacion l : listaResul) {
		    String estado = l.getEstado();
		    switch (estado) {
				case "En Construccion": ec++; break;
				case "Cerrada": cerradas++; break;
				case "Operativa": operativas++; break;
				default:
					break;
			}
		  }		
		mapResul.put("En Contruccion",ec);
		mapResul.put("Cerrada",cerradas);
		mapResul.put("Operativa",operativas);
		
		return mapResul;
	}

}
