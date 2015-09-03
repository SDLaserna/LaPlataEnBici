package services;

import java.util.List;

import entidades.Usuario;

public interface UsuarioService {

	public void persistir(Usuario U); 
	public boolean existeUsuario(String email);
	public boolean existePersona(String email);
	public Usuario obtenerUsuario(String email);
	public void modificar(Usuario u);
	public List<Usuario> listarUsuarios();
	public void borrarLogicamente(Usuario u);
	public Usuario obtenerUsuario(Object id);
	public List<Usuario> listarActivos();
	public List<Usuario> listarInActivos();
	public void habilitar(Usuario u);
	public void borrarDefinitivo(Usuario u);
}
