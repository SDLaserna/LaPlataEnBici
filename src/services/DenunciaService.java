package services;

import java.util.List;

import entidades.Denuncia;

public interface DenunciaService {
	public void persistir(Denuncia d);
	public boolean existeDenunciado(Object id);
	public List<Denuncia> listarDenuncias(Long idBici);
}
