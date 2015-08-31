package daos;

import java.util.List;

import entidades.HistorialBicicleta;

public class HistorialBicicletaDAOImp extends GenericDAOImp<HistorialBicicleta> implements HistorialBicicletaDAO{
	@Override
	public List<HistorialBicicleta> historialDeLaBicicleta(Long idBicicleta) {
		return this.entityManager.createQuery("select hb from HistorialBicicleta hb where hb.bicicleta=" + idBicicleta).getResultList();
	}
}
