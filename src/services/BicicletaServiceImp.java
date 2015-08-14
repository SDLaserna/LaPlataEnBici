package services;

import daos.BicicletaDAO;
import daos.BicicletaDAOImp;
import entidades.Bicicleta;

public class BicicletaServiceImp implements BicicletaService {
	
	private BicicletaDAO bicicletaDAO = new BicicletaDAOImp();

	@Override
	public void persistir(Bicicleta B) {
		this.bicicletaDAO.crear(B);
	}

}
