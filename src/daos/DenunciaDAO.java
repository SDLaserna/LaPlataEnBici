package daos;

import java.util.List;

import entidades.Denuncia;

public interface DenunciaDAO extends GenericDAO<Denuncia> {

	public boolean existeDenunciado(Object id);
	public List<Denuncia> listarDenunciasParaBici(Long idBici);
}
