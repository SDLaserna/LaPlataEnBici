package daos;

import java.util.Map;

import entidades.HistorialEstacion;

public interface HistorialEstacionDAO extends GenericDAO<HistorialEstacion> {
	public Map<String,Integer> historialDeLaEstacion(Long idEstacion);
	
}
