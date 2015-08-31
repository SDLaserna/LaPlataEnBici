package services;

import java.util.List;

import daos.HistorialBicicletaDAO;
import daos.HistorialBicicletaDAOImp;
import entidades.HistorialBicicleta;

public class HistorialBicicletaServiceImp implements HistorialBicicletaService {
	
	private HistorialBicicletaDAO historialBicicletaDAO = new HistorialBicicletaDAOImp();
	
	@Override
	public void persisitir(HistorialBicicleta hb) {
		this.historialBicicletaDAO.crear(hb);
	}

	@Override
	public List<HistorialBicicleta> historialDeLaBicicleta(Long idBicicleta) {
		return this.historialBicicletaDAO.historialDeLaBicicleta(idBicicleta);
	}

}
