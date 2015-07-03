package entidades;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;


@Entity
public class Bicicleta {
	@Id
	@GeneratedValue
	private Long idBicicleta;
	private Date fechaIngreso;
	private String estado;
	private boolean activa;
	private boolean prestada;
	
	@ManyToOne
	@JoinColumn(name="estacion")
	private Estacion estacion;

	protected Bicicleta() {
	}

	public Bicicleta(Date fechaIngreso, String estado) {
		super();
		this.setFechaIngreso(fechaIngreso);
		this.setEstado(estado);
		this.setActiva(true);
		this.setPrestada(false);
	}

	public Long getIdBicicleta() {
		return idBicicleta;
	}

	public void setIdBicicleta(Long idBicicleta) {
		this.idBicicleta = idBicicleta;
	}

	public Date getFechaIngreso() {
		return fechaIngreso;
	}

	public void setFechaIngreso(Date fechaIngreso) {
		this.fechaIngreso = fechaIngreso;
	}

	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

	public boolean isActiva() {
		return activa;
	}

	public void setActiva(boolean activa) {
		this.activa = activa;
	}

	public boolean isPrestada() {
		return prestada;
	}

	public void setPrestada(boolean prestada) {
		this.prestada = prestada;
	}

	public Estacion getEstacion() {
		return estacion;
	}

	public void setEstacion(Estacion estacion) {
		this.estacion = estacion;
	}
	
	
}
