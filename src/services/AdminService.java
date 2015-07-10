package services;

import entidades.Administrador;

public interface AdminService {
	
	public void persistir(Administrador A);
	public boolean existeAdministrador(String email);
	public Administrador obtenerAdministrador(String email);
	public void modificar(Administrador a);

}
