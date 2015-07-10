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
	private String claveActual="";
	private String claveNueva1="";
	private String claveNueva2="";
	private UsuarioService usuarioService=new UsuarioServiceImp();
	
	public UsuarioMbView(){
		
	}
	
	public String modificar(){
		/* Uso los datos del usuario el cual tiene la sesion
		 * entonces a la hora de modificar recupero los datos de la sesion (los cuales
		 * se sincronizan con los que se ingresan en los input) y lo mando como parametro del método
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
	
	public String modificarClave(){
		HttpServletRequest httpSR =(HttpServletRequest)FacesContext.getCurrentInstance().getExternalContext().getRequest();
		if(httpSR.getSession().getAttribute("personaSesion")!=null){
			Usuario userOn=(Usuario)httpSR.getSession().getAttribute("personaSesion");
			if(this.getClaveActual().equals(userOn.getClave())){
				if(this.getClaveNueva1().equals(this.getClaveNueva2())){
					userOn.setClave(this.getClaveNueva1());
					this.usuarioService.modificar(userOn);
					FacesMessage mensaje = new FacesMessage("La clave se modifico correctamente");
					FacesContext.getCurrentInstance().addMessage("Modificar", mensaje);
					return "successModificar";
				}else{
					FacesMessage mensaje = new FacesMessage("Las nuevas claves no son iguales");
					FacesContext.getCurrentInstance().addMessage("Modificar", mensaje);
					return "errorModificar";
				}
			}else{
				FacesMessage mensaje = new FacesMessage("La clave actual es incorrecta");
				FacesContext.getCurrentInstance().addMessage("Modificar", mensaje);
				return "errorModificar";
			}
		}
		else{
			return "sesionCaducada";
		}
	}
	
	public String getClaveActual() {
		return claveActual;
	}

	public void setClaveActual(String claveActual) {
		this.claveActual = claveActual;
	}

	public String getClaveNueva1() {
		return claveNueva1;
	}

	public void setClaveNueva1(String claveNueva1) {
		this.claveNueva1 = claveNueva1;
	}

	public String getClaveNueva2() {
		return claveNueva2;
	}

	public void setClaveNueva2(String claveNueva2) {
		this.claveNueva2 = claveNueva2;
	}
	

}
