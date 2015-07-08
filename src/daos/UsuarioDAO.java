package daos;

import entidades.Usuario;

public interface UsuarioDAO extends PersonaDAO<Usuario>{

	public boolean existeUsuario(String email);
	public Usuario obtenerUsuario(String email);
}
