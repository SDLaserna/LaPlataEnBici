package daos;

import entidades.Administrador;

public interface AdministradorDAO extends PersonaDAO<Administrador>{
	
	public boolean existeAdministrador(String email);
	public Administrador obtenerAdministrador(String email);

}
