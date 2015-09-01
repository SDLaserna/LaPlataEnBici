package daos;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import entidades.HistorialEstacion;

public class HistorialEstacionDAOImp extends GenericDAOImp<HistorialEstacion>
		implements HistorialEstacionDAO {

	@Override
	public Map<String, Integer> historialDeLaEstacion(Long idEstacion) {
		Map<String, Integer> mapResul = new HashMap<String, Integer>();

		List<HistorialEstacion> listaResul = (List<HistorialEstacion>) this.entityManager
				.createQuery(
						"select he from HistorialEstacion he where he.estacion="
								+ idEstacion).getResultList();

		for (HistorialEstacion he : listaResul) {
			String estado = he.getEstado();
			Integer cantidad = new Integer(0);
			mapResul.put(estado, cantidad);
		}

		for (HistorialEstacion he : listaResul) {
			String estado = he.getEstado();
			Integer cantidad = mapResul.get(estado) + new Integer(1);
			mapResul.put(estado, cantidad);
		}
		return mapResul;
	}
}
