package managedBeans.persona;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpServletRequest;

import services.AdminService;
import services.AdminServiceImp;
import entidades.Administrador;

@ManagedBean
@ViewScoped
public class AdministradorMbView {
	private AdminService adminService=new AdminServiceImp();
	
	public AdministradorMbView(){
		
	}
	
	public String modificar(){
		/* Uso los datos del usuario el cual tiene la sesion
		 * entonces a la hora de modificar recupero los datos de la sesion (los cuales
		 * se sincronizan con los que se ingresan en los input) y lo mando como parametro del método
		 * del service que realiza la modificacion*/
		
		HttpServletRequest httpSR =(HttpServletRequest)FacesContext.getCurrentInstance().getExternalContext().getRequest();
		if(httpSR.getSession().getAttribute("personaSesion")!=null){
			Administrador userOn=(Administrador)httpSR.getSession().getAttribute("personaSesion");
			this.adminService.modificar(userOn);
			FacesMessage mensaje = new FacesMessage("Se modificaron los datos correctamente");
			FacesContext.getCurrentInstance().addMessage("Modificar", mensaje);
			return "successModificar";
		}
		else{
			return "sesionCaducada";
		}
	}
	
	
	
}
