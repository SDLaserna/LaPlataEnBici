package services;

import daos.HistorialEstacionDAO;
import daos.HistorialEstacionDAOImp;
import entidades.HistorialEstacion;

public class HistorialEstacionServiceImp implements HistorialEstacionService {
	
	private HistorialEstacionDAO historialEstacionDAO = new HistorialEstacionDAOImp();

	@Override
	public void persisitir(HistorialEstacion he) {
		this.historialEstacionDAO.crear(he);

	}

}
