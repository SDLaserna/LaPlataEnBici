package managedBeans.estacion;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

import entidades.Domicilio;
import entidades.Estacion;
import services.EstacionService;
import services.EstacionServiceImp;

@ManagedBean
@SessionScoped
public class EstacionMbSess {
	private EstacionService estacionService = new EstacionServiceImp();
	private List<Estacion> listaEstaciones = new ArrayList<Estacion>();
	private Estacion estacion;
	private Domicilio ubicacion;
	private String nombreActual;

	public EstacionMbSess() {
		this.setEstacion(new Estacion());
		this.ubicacion = new Domicilio();
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
	
	public String visualizarAltaEstacion(){
		this.setEstacion(new Estacion());
		this.ubicacion = new Domicilio();
		return "successVisualizarAltaEstacion";
	}
	
	public String agregarEstacion(){
		if (this.estacionService.existeEstacion(this.getEstacion().getNombre())){
			FacesMessage mensaje = new FacesMessage("El nombre ya se ha registrado, ingrese otro");
			FacesContext.getCurrentInstance().addMessage("Alta", mensaje);
			return "errorAltaEstacion";
		}
		else{
			this.getEstacion().setUbicacion(this.ubicacion);
			this.getEstacion().setCantEstacionamientosLibres(this.getEstacion().getTotalEstacionamientos());
			this.estacionService.persistir(this.getEstacion());
			FacesMessage mensaje = new FacesMessage("La estacion se ha agregado correctamente");
			FacesContext.getCurrentInstance().addMessage("Alta", mensaje);
			this.listarEstaciones();
			return "successAltaEstacion";
			}
	}
	

	public String borradoLogico() {
		Map<String, String> params = FacesContext.getCurrentInstance()
				.getExternalContext().getRequestParameterMap();
		String idEstacion = params.get("idEstacion");
		Long idLong = Long.parseLong(idEstacion);
		Estacion estacionPersistente = this.estacionService
				.obtenerEstacion(idLong);
		this.estacionService.borrarLogicamente(estacionPersistente);
		FacesMessage mensaje = new FacesMessage("La estacion se ha eliminado correctamente");
		FacesContext.getCurrentInstance().addMessage("Alta", mensaje);
		this.setListaEstaciones(this.estacionService.listarActivas());
		return "listarEstaciones";
	}

	public String visualizarModificarEstacion() {
		Map<String, String> params = FacesContext.getCurrentInstance()
				.getExternalContext().getRequestParameterMap();
		String idEstacion = params.get("idEstacion");
		Long idLong = Long.parseLong(idEstacion);
		this.setEstacion(this.estacionService.obtenerEstacion(idLong));
		this.nombreActual = this.getEstacion().getNombre();
		return "successVisualizarModificarEstacion";
	}

	public String modificarEstacion() {
		if (!this.nombreActual.equals(this.getEstacion().getNombre())) {
			if (this.estacionService.existeEstacion(this.getEstacion()
					.getNombre())) {
				FacesMessage mensaje = new FacesMessage(
						"El nombre ya se ha registrado, ingrese otro");
				FacesContext.getCurrentInstance().addMessage("Modificar",
						mensaje);
				return "errorModificarEstacion";
			}
		}
		this.estacionService.modificar(this.getEstacion());
		FacesMessage mensaje = new FacesMessage(
				"Se modificaron los datos correctamente");
		FacesContext.getCurrentInstance().addMessage("Alta", mensaje);
		this.setListaEstaciones(this.estacionService.listarActivas());
		return "successModificarEstacion";
	}

	public String visualizarEstadisticasEstacion() {
		Map<String, String> params = FacesContext.getCurrentInstance()
				.getExternalContext().getRequestParameterMap();
		String idEstacion = params.get("idEstacion");
		Long idLong = Long.parseLong(idEstacion);
		this.setEstacion(this.estacionService.obtenerEstacion(idLong));
		return "successVisualizarEstadisticasEstacion";
	}

	public Estacion getEstacion() {
		return estacion;
	}

	public void setEstacion(Estacion estacion) {
		this.estacion = estacion;
	}
}
