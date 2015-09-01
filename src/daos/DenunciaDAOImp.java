package daos;

import entidades.Denuncia;

public class DenunciaDAOImp extends GenericDAOImp<Denuncia> implements DenunciaDAO{

	@Override
	public boolean existeDenunciado(Object id) {
		return !this.entityManager.createQuery("select d from Denuncia d where d.usuario.id="+id.toString()).getResultList().isEmpty();
	}

}
