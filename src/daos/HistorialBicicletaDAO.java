package daos;

import java.util.List;

import entidades.HistorialBicicleta;

public interface HistorialBicicletaDAO extends GenericDAO<HistorialBicicleta> {
	public List<HistorialBicicleta> historialDeLaBicicleta (Long idBicicleta);
}
