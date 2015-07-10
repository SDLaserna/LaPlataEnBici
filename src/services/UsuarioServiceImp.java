package services;

import java.util.List;

import daos.UsuarioDAO;
import daos.UsuarioDAOImp;
import entidades.Usuario;

public class UsuarioServiceImp implements UsuarioService {

	private UsuarioDAO usuarioDAO=new UsuarioDAOImp();
	
	@Override
	public void persistir(Usuario U) {
		this.usuarioDAO.crear(U);

	}
	
	public Usuario obtenerUsuario(String email){
		return this.usuarioDAO.obtenerUsuario(email);
	}
	
	@Override
	public boolean existeUsuario(String email) {
		return this.usuarioDAO.existeUsuario(email);
	}
	
	/* Utilizamos los usuarios comunes para definir métodos que se refieren a 
	 * las personas ya que a veces necesitamos preguntar por el total incluyendo 
	 * usuarios comunes y admins y la clase Persona es abstracta para hacer un service
	 * de persona*/
	
	
	public boolean existePersona(String email){
		return this.usuarioDAO.existePersona(email);
	}

	@Override
	public void modificar(Usuario u) {
		this.usuarioDAO.actualizar(u);
	}

	@Override
	public List<Usuario> listarUsuarios() {
		return this.usuarioDAO.listar("Usuario");
	}

	@Override
	public void borrarLogicamente(Usuario u) {
		u.setActiva(true);
		this.usuarioDAO.actualizar(u);
		
	}

	@Override
	public Usuario obtenerUsuario(Object id) {
		return this.usuarioDAO.obtener(id);
	}
	
	public List<Usuario> listarActivos(){
		return this.usuarioDAO.listarPersonasActivas("Usuario");
	}
}
