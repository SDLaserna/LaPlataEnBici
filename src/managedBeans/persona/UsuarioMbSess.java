package managedBeans.persona;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpServletRequest;

import services.UsuarioService;
import services.UsuarioServiceImp;
import entidades.Usuario;

@ManagedBean
@SessionScoped
public class UsuarioMbSess {
	private UsuarioService usuarioService=new UsuarioServiceImp();
	private List<Usuario> listaUsuarios=new ArrayList<Usuario>();
	private List<Usuario> listaUsuariosInhabilitados=new ArrayList<Usuario>();
	
	public UsuarioMbSess(){
	}
	
	public List<Usuario> getListaUsuarios() {
		return listaUsuarios;
	}

	public void setListaUsuarios(List<Usuario> listaUsuarios) {
		this.listaUsuarios = listaUsuarios;
	}

	public String listarUsuarios() {
		this.setListaUsuarios(this.usuarioService.listarActivos());
		return "listarUsuarios";
	}
	
	public String listarUsuariosInhabilitados() {
		this.setListaUsuariosInhabilitados(this.usuarioService.listarInActivos());
		return "listarUsuariosInhabilitados";
	}
	
	public String habilitacion(){
		Map<String,String> params =FacesContext.getCurrentInstance().getExternalContext().getRequestParameterMap();
		String idUser = params.get("idUsuario");
		Long idLong=Long.parseLong(idUser);	
		Usuario userPersistente=this.usuarioService.obtenerUsuario(idLong);
		this.usuarioService.habilitar(userPersistente);
		this.setListaUsuariosInhabilitados(this.usuarioService.listarInActivos());
		return "listarUsuariosInhabilitados";
	}

	public String borradoLogico(){
		Map<String,String> params =FacesContext.getCurrentInstance().getExternalContext().getRequestParameterMap();
		String idUser = params.get("idUsuario");
		Long idLong=Long.parseLong(idUser);	
		Usuario userPersistente=this.usuarioService.obtenerUsuario(idLong);
		this.usuarioService.borrarLogicamente(userPersistente);
		this.setListaUsuarios(this.usuarioService.listarActivos());
		return "listarUsuarios";
	}

	public List<Usuario> getListaUsuariosInhabilitados() {
		return listaUsuariosInhabilitados;
	}

	public void setListaUsuariosInhabilitados(
			List<Usuario> listaUsuariosInhabilitados) {
		this.listaUsuariosInhabilitados = listaUsuariosInhabilitados;
	}
}
