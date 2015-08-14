package managedBeans.bicicleta;

import java.util.Date;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import entidades.Bicicleta;
import entidades.Estacion;
import services.BicicletaService;
import services.EstacionService;

@ManagedBean
@SessionScoped
public class BicicletaMbSess {

	private String rodado;
	private String color;
	private String marca;
	private String estacion;
	private String descrip;
	private BicicletaService bicicletaService;
	private EstacionService estacionService;
	
	public String agregarBicicleta(){
		Bicicleta bici = new Bicicleta(new Date(), "Apta para el uso");
		bici.setActiva(true);
		bici.setColor(this.getColor());
		bici.setDescrip(this.getDescrip());
		bici.setMarca(this.getMarca());
		bici.setPrestada(false);
		bici.setRodado(this.getRodado());
		Estacion est = this.estacionService.obtenerEstacionNombre(this.getEstacion());
		bici.setEstacion(est);
		this.bicicletaService.persistir(bici);
		return "success";
	}
	
	public String getRodado() {
		return rodado;
	}
	public void setRodado(String rodado) {
		this.rodado = rodado;
	}
	public String getColor() {
		return color;
	}
	public void setColor(String color) {
		this.color = color;
	}
	public String getMarca() {
		return marca;
	}
	public void setMarca(String marca) {
		this.marca = marca;
	}
	public String getEstacion() {
		return estacion;
	}
	public void setEstacion(String estacion) {
		this.estacion = estacion;
	}
	public String getDescrip() {
		return descrip;
	}
	public void setDescrip(String descrip) {
		this.descrip = descrip;
	}
	
}
