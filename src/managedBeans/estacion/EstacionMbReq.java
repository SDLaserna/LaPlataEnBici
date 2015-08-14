package managedBeans.estacion;

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
	
	public EstacionMbReq(){
		this.setEstacion(new Estacion());
		this.setDomicilio(new Domicilio());
	}
	

	public Domicilio getDomicilio() {
		return ubicacion;
	}

	public void setDomicilio(Domicilio domicilio) {
		this.ubicacion = domicilio;
	}

	public Estacion getEstacion() {
		return this.estacion;
	}

	public void setEstacion(Estacion estacion) {
		this.estacion = estacion;
	}
	
	public String registrar(){
		if (this.estacionService.existeEstacion(this.getEstacion().getNombre())){
			FacesMessage mensaje = new FacesMessage("El nombre ya se ha registrado, ingrese otro");
			FacesContext.getCurrentInstance().addMessage("Registro", mensaje);
			return "errorRegistro";
		}
		else{
			this.getEstacion().setUbicacion(this.getDomicilio());
			this.getEstacion().setCantEstacionamientosLibres(this.getEstacion().getTotalEstacionamientos());
			this.estacionService.persistir(this.getEstacion());
			FacesMessage mensaje = new FacesMessage("La estacion se ha registrado correctamente");
			FacesContext.getCurrentInstance().addMessage("Registro", mensaje);
			return "successRegistro";
			}
	}
	
}
