package daos;

import java.util.List;

import entidades.Denuncia;

public class DenunciaDAOImp extends GenericDAOImp<Denuncia> implements DenunciaDAO{

	@Override
	public boolean existeDenunciado(Object id) {
		return !this.entityManager.createQuery("select d from Denuncia d where d.usuario.id="+id.toString()).getResultList().isEmpty();
	}

	@Override
	public List<Denuncia> listarDenunciasParaBici(Long idBici) {
		return this.entityManager.createQuery("select d from Denuncia d where d.bicicleta.id="+idBici.toString()).getResultList();
	}

}
