package managedBeans.estacion;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

import entidades.Estacion;
import services.EstacionService;
import services.EstacionServiceImp;

@ManagedBean
@SessionScoped
public class EstacionMbSess {
	private EstacionService estacionService=new EstacionServiceImp();
	private List<Estacion> listaEstaciones=new ArrayList<Estacion>();
	private Estacion estacion;
	
	public EstacionMbSess(){
	}
	
	public List<Estacion> getListaEstaciones() {
		return listaEstaciones;
	}

	public void setListaEstaciones(List<Estacion> listaEstaciones) {
		this.listaEstaciones = listaEstaciones;
	}

	public String listarEstaciones() {
		this.setListaEstaciones(this.estacionService.listarActivas());
		return "listarEstaciones";
	}

	public String borradoLogico(){
		Map<String,String> params =FacesContext.getCurrentInstance().getExternalContext().getRequestParameterMap();
		String idEstacion = params.get("idEstacion");
		Long idLong=Long.parseLong(idEstacion);	
		Estacion estacionPersistente=this.estacionService.obtenerEstacion(idLong);
		this.estacionService.borrarLogicamente(estacionPersistente);
		this.setListaEstaciones(this.estacionService.listarActivas());
		return "listarEstaciones";
	}
	
	public String visualizarModificarEstacion(){
		Map<String,String> params =FacesContext.getCurrentInstance().getExternalContext().getRequestParameterMap();
		String idEstacion = params.get("idEstacion");
		Long idLong=Long.parseLong(idEstacion);
		this.setEstacion(this.estacionService.obtenerEstacion(idLong));
		return "success";
	}
	
	public String modificarEstacion(){
		this.estacionService.modificar(this.getEstacion());
		FacesMessage mensaje = new FacesMessage("Se modificaron los datos correctamente");
		FacesContext.getCurrentInstance().addMessage("Modificar", mensaje);
		this.setListaEstaciones(this.estacionService.listarActivas());
		return "successModificar";
	}
	
	public String visualizarEstadisticasEstacion(){
		Map<String,String> params =FacesContext.getCurrentInstance().getExternalContext().getRequestParameterMap();
		String idEstacion = params.get("idEstacion");
		Long idLong=Long.parseLong(idEstacion);
		this.setEstacion(this.estacionService.obtenerEstacion(idLong));
		return "verEstadisticas";
	}
	
	public Estacion getEstacion() {
		return estacion;
	}

	public void setEstacion(Estacion estacion) {
		this.estacion = estacion;
	}
}
