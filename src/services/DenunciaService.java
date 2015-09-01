package services;

import entidades.Denuncia;

public interface DenunciaService {
	public void persistir(Denuncia d);
	public boolean existeDenunciado(Object id);
}
