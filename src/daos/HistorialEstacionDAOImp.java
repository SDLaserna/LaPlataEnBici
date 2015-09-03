package daos;

import java.util.List;
import entidades.HistorialEstacion;

public class HistorialEstacionDAOImp extends GenericDAOImp<HistorialEstacion>
		implements HistorialEstacionDAO {

	@Override
	public List<HistorialEstacion> historialDeLaEstacion(Long idEstacion) {

		return this.entityManager.createQuery("select he from HistorialEstacion he where he.estacion="+ idEstacion).getResultList();
	}
}
