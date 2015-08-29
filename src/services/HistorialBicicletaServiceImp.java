package services;

import daos.HistorialBicicletaDAO;
import daos.HistorialBicicletaDAOImp;
import entidades.HistorialBicicleta;

public class HistorialBicicletaServiceImp implements HistorialBicicletaService {
	
	private HistorialBicicletaDAO historialBicicletaDAO = new HistorialBicicletaDAOImp();
	
	@Override
	public void persisitir(HistorialBicicleta hb) {
		this.historialBicicletaDAO.crear(hb);
	}

}
