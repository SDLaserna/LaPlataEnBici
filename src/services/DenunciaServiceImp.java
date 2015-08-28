package services;

import daos.DenunciaDAO;
import daos.DenunciaDAOImp;
import entidades.Denuncia;

public class DenunciaServiceImp implements DenunciaService {
	
	private DenunciaDAO denunciaDAO = new DenunciaDAOImp();

	@Override
	public void persistir(Denuncia d) {
		this.denunciaDAO.crear(d);
	}

}
