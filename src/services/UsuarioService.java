package services;

import entidades.Usuario;

public interface UsuarioService {

	public void persistir(Usuario U);
	public boolean existeUsuario(String email);
	public boolean existePersona(String email);
	public Usuario obtenerUsuario(String email);
}
