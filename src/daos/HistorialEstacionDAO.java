package daos;

import java.util.List;
import entidades.HistorialEstacion;

public interface HistorialEstacionDAO extends GenericDAO<HistorialEstacion> {
	public List<HistorialEstacion> historialDeLaEstacion(Long idEstacion);
	
}
