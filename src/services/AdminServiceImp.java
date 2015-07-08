package services;

import daos.AdministradorDAO;
import entidades.Administrador;

public class AdminServiceImp implements AdminService {
	private AdministradorDAO administradorDAO;

	@Override
	public void persistir(Administrador A) {
		this.administradorDAO.crear(A);

	}

	@Override
	public boolean existeAdministrador(String email) {
		return false;
	}

	@Override
	public Administrador obtenerAdministrador(String email) {
		// TODO Auto-generated method stub
		return null;
	}

}
