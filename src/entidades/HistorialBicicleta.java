package entidades;

import java.util.Date;

public class HistorialBicicleta {
	private Long idHistorial;
	/*uno a uno*/
	private Bicicleta bicicleta;
	private Date fechaHora;
	private String estado;

	public HistorialBicicleta(Bicicleta bicicleta, Date fechaHora, String estado) {
		super();
		this.setBicicleta(bicicleta);
		this.setFechaHora(fechaHora);
		this.setEstado(estado);
	}

	public Long getIdHistorial() {
		return idHistorial;
	}

	public void setIdHistorial(Long idHistorial) {
		this.idHistorial = idHistorial;
	}

	public Bicicleta getBicicleta() {
		return bicicleta;
	}

	public void setBicicleta(Bicicleta bicicleta) {
		this.bicicleta = bicicleta;
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
