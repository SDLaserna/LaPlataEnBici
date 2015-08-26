package managedBeans.estacion;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;

import services.EstacionService;
import services.EstacionServiceImp;
import entidades.Domicilio;
import entidades.Estacion;

@ManagedBean
@RequestScoped
public class EstacionMbReq {
	private String coor;
	private Estacion estacion;
	private Domicilio ubicacion;
	private EstacionService estacionService=new EstacionServiceImp();
	private List<Estacion> listaEstaciones = new ArrayList<Estacion>();

	public EstacionMbReq(){
	this.setEstacion(new Estacion());
	this.setUbicacion(new Domicilio());
	this.getEstacion().setUbicacion(this.getUbicacion());}

	
	public String visualizarAltaEstacion(){
		return "successVisualizarAltaEstacion";
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
	
	
	public String agregarEstacion(){
		if (this.estacionService.existeEstacion(this.getEstacion().getNombre())){
			FacesMessage mensaje = new FacesMessage("El nombre ya se ha registrado, ingrese otro");
			FacesContext.getCurrentInstance().addMessage("Alta", mensaje);
			return "errorAltaEstacion";
		}
		else{
			this.getEstacion().setUbicacion(this.ubicacion);
			this.getEstacion().setCantEstacionamientosLibres(this.getEstacion().getTotalEstacionamientos());
			int index= this.getCoor().indexOf(",");
			String latitud=this.getCoor().substring(1, index);
			String longitud=this.getCoor().substring(index+1, this.getCoor().length()-1);
			this.getEstacion().getUbicacion().setLatitud(latitud);
			this.getEstacion().getUbicacion().setLongitud(longitud);
			this.estacionService.persistir(this.getEstacion());
			FacesMessage mensaje = new FacesMessage("La estacion se ha agregado correctamente");
			FacesContext.getCurrentInstance().addMessage("Alta", mensaje);
			this.listarEstaciones();
			return "successAltaEstacion";
			}
	}
	
	public String listarEstaciones() {
		this.setListaEstaciones(this.estacionService.listarActivas());
		return "listarEstaciones";
	}
	
	
	public Estacion getEstacion() {
		return estacion;
	}

	public void setEstacion(Estacion estacion) {
		this.estacion = estacion;
	}

	public Domicilio getUbicacion() {
		return ubicacion;
	}

	public void setUbicacion(Domicilio ubicacion) {
		this.ubicacion = ubicacion;
	}


	public List<Estacion> getListaEstaciones() {
		return listaEstaciones;
	}


	public void setListaEstaciones(List<Estacion> listaEstaciones) {
		this.listaEstaciones = listaEstaciones;
	}


	public String getCoor() {
		return coor;
	}


	public void setCoor(String coor) {
		this.coor = coor;
	}
}
