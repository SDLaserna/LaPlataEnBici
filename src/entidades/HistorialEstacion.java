package entidades;

import java.util.Date;

public class HistorialEstacion {
	private Long idHistorial;
	/* uno a uno */
	private Estacion estacion;
	private Date fechaHora;
	private String estado;
	
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
