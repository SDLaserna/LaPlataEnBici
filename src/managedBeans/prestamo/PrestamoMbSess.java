package managedBeans.prestamo;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpServletRequest;

import entidades.Prestamo;
import entidades.Usuario;
import services.PrestamoService;
import services.PrestamoServiceImp;

@ManagedBean
@SessionScoped
public class PrestamoMbSess {

	private PrestamoService prestamoService = new PrestamoServiceImp();
	private List<Prestamo> listaPrestamos = new ArrayList<Prestamo>();

	public PrestamoMbSess() {
	}
		
	public String visualizarBicicletasPrestadas() {
		FacesContext facesContext = FacesContext.getCurrentInstance();
		
		Date fechaActual = new Date();
	    
		HttpServletRequest httpServletRequest = (HttpServletRequest)facesContext.getExternalContext().getRequest();
	    Usuario usuario = (Usuario) httpServletRequest.getSession().getAttribute("personaSesion");
		
	    this.setListaPrestamos(this.prestamoService.prestamosActualesDelUsuario(usuario.getIdPersona(), fechaActual));
		return "successVisualizarBicicletasPrestadas";
	}
	
	public String devolverBicicleta(){
		return "";
	}
	
	public String denunciarBicicleta(){
		return "";
	}

	public List<Prestamo> getListaPrestamos() {
		return listaPrestamos;
	}

	public void setListaPrestamos(List<Prestamo> listaPrestamos) {
		this.listaPrestamos = listaPrestamos;
	}

}
