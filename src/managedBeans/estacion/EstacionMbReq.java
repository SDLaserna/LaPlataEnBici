package managedBeans.estacion;

import java.util.ArrayList;
import java.util.List;

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
}
