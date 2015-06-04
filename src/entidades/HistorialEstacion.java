package entidades;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="Historial_estacion")
public class HistorialEstacion {
	@Id
	@GeneratedValue
	private Long idHistorial;
	/* uno a uno */
	@ManyToOne
	private Estacion estacion;
	private Date fechaHora;
	private String estado;
	
	protected HistorialEstacion() {
	}

	public HistorialEstacion(Estacion estacion, Date fechaHora, String estado) {
		super();
		this.setEstacion(estacion);
		this.setFechaHora(fechaHora);
		this.setEstado(estado);
	}

	public Long getIdHistorial() {
		return idHistorial;
	}

	public void setIdHistorial(Long idHistorial) {
		this.idHistorial = idHistorial;
	}

	public Estacion getEstacion() {
		return estacion;
	}

	public void setEstacion(Estacion estacion) {
		this.estacion = estacion;
	}

	public Date getFechaHora() {
		return fechaHora;
	}

	public void setFechaHora(Date fechaHora) {
		this.fechaHora = fechaHora;
	}

	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}
}
