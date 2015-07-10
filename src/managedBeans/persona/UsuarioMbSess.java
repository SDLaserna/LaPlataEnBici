package managedBeans.persona;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

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
	
	public UsuarioMbSess(){
		
	}
	
	public List<Usuario> getListaUsuarios() {
		return listaUsuarios;
	}

	public void setListaUsuarios(List<Usuario> listaUsuarios) {
		this.listaUsuarios = listaUsuarios;
	}

	public String listarUsuarios() {
		this.setListaUsuarios(this.usuarioService.listarUsuarios());
		return "listarUsuarios";
	}

	public String borradoLogico(){
		System.out.print("Estoy en el metodo borrar del usuarioMb");

		return "listarUsuarios";
	}
}
