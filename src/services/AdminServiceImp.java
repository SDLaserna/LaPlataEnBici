package services;

import daos.AdministradorDAO;
import daos.AdministradorDAOImp;
import entidades.Administrador;

public class AdminServiceImp implements AdminService {
	private AdministradorDAO administradorDAO= new AdministradorDAOImp();

	@Override
	public void persistir(Administrador A) {
		this.administradorDAO.crear(A);

	}

	@Override
	public boolean existeAdministrador(String email) {
		return this.administradorDAO.existeAdministrador(email);
	}

	@Override
	public Administrador obtenerAdministrador(String email) {
		return this.administradorDAO.obtenerAdministrador(email);
	}

}
