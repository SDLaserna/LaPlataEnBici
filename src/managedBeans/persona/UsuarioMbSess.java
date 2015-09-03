package managedBeans.persona;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpServletRequest;

import services.DenunciaService;
import services.DenunciaServiceImp;
import services.PrestamoService;
import services.PrestamoServiceImp;
import services.UsuarioService;
import services.UsuarioServiceImp;
import entidades.Usuario;

@ManagedBean
@SessionScoped
public class UsuarioMbSess {
	private UsuarioService usuarioService=new UsuarioServiceImp();
	private List<Usuario> listaUsuarios=new ArrayList<Usuario>();
	private List<Usuario> listaUsuariosInhabilitados=new ArrayList<Usuario>();
	private DenunciaService denunciaService=new DenunciaServiceImp();
	private PrestamoService prestamoService=new PrestamoServiceImp();
	
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
	
	public String borradoDefinitivo(){
		Map<String,String> params =FacesContext.getCurrentInstance().getExternalContext().getRequestParameterMap();
		String idUser = params.get("idUsuario");
		Long idLong=Long.parseLong(idUser);	
		Usuario userPersistente=this.usuarioService.obtenerUsuario(idLong);
		if(this.denunciaService.existeDenunciado(idLong) || 
				this.prestamoService.existeDeudor(idLong)){
			FacesMessage mensaje = new FacesMessage("El usuario contiene deudas o denuncias, se recomienda borrar temporalmente");
			FacesContext.getCurrentInstance().addMessage("borradoDefinitivo", mensaje);
		}
		else{
			this.usuarioService.borrarDefinitivo(userPersistente); /*Se lo mando asi para que el borrar del JPA pueda hacer reflexion y saber la entidad a la que me quiero referir, si le mando un Long solo me dice java.lang.IllegalArgumentException: class java.lang.Long is not an entity*/
		}
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
