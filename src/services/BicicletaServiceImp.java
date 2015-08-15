package services;

import java.util.List;

import daos.BicicletaDAO;
import daos.BicicletaDAOImp;
import entidades.Bicicleta;

public class BicicletaServiceImp implements BicicletaService {
	
	private BicicletaDAO bicicletaDAO = new BicicletaDAOImp();

	@Override
	public void persistir(Bicicleta B) {
		this.bicicletaDAO.crear(B);
	}

	@Override
	public List<Bicicleta> listarBicicletasActivas() {
		return this.bicicletaDAO.listarBicicletasActivas();
	}

	@Override
	public void borrarLogicamente(Bicicleta B) {
		B.setActiva(false);
		this.bicicletaDAO.actualizar(B);
		
	}

	@Override
	public Bicicleta obtenerBicicleta(Long idBicicleta) {
		return this.bicicletaDAO.obtener(idBicicleta);
	}

	@Override
	public void modificar(Bicicleta B) {
		this.bicicletaDAO.actualizar(B);
		
	}

}
