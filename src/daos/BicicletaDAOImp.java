package daos;

import java.util.List;

import entidades.Bicicleta;

public class BicicletaDAOImp extends GenericDAOImp<Bicicleta> implements BicicletaDAO{

	@Override
	public List<Bicicleta> listarBicicletasActivas() {
		return this.entityManager.createQuery("select b from Bicicleta b where b.activa=1").getResultList();
	}
	
	public List<Bicicleta> bicicletasParaPrestar(Long idEstacion) {
		return this.entityManager.createQuery("select b from Bicicleta b where b.activa=1 and b.estacion=" + idEstacion + " and b.estado = 'Apta para el uso' and b.prestada=0").getResultList();
	}

}
