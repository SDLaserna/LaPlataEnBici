package managedBeans.persona;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpServletRequest;

import services.UsuarioService;
import services.UsuarioServiceImp;
import entidades.Usuario;

@ManagedBean
@ViewScoped
public class UsuarioMbView {
	private UsuarioService usuarioService=new UsuarioServiceImp();
	
	public UsuarioMbView(){
		
	}
	
	public String modificar(){
		/* Uso los datos del usuario el cual tiene la sesion
		 * entonces a la hora de modificar recupero los datos de la sesion (los cuales
		 * se sincronizan con los que se ingresan en los input) y lo mando como parámetro del método
		 * del service que realiza la modificacion*/
		
		HttpServletRequest httpSR =(HttpServletRequest)FacesContext.getCurrentInstance().getExternalContext().getRequest();
		if(httpSR.getSession().getAttribute("personaSesion")!=null){
			Usuario userOn=(Usuario)httpSR.getSession().getAttribute("personaSesion");
			this.usuarioService.modificar(userOn);
			FacesMessage mensaje = new FacesMessage("Se modificaron los datos correctamente");
			FacesContext.getCurrentInstance().addMessage("Modificar", mensaje);
			return "successModificar";
		}
		else{
			return "sesionCaducada";
		}
	}
	

}
