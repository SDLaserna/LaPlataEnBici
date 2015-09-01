package daos;

import entidades.Denuncia;

public interface DenunciaDAO extends GenericDAO<Denuncia> {

	public boolean existeDenunciado(Object id);
}
