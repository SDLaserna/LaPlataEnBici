package entidades;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="Historial_bicicleta")
public class HistorialBicicleta {
	
	@Id
	@GeneratedValue
	private Long idHistorialbici;
	/*uno a uno*/
	@ManyToOne
	private Bicicleta bicicleta;
	private Date fechaHora;
	private String estado;

	protected HistorialBicicleta() {
	}

	public HistorialBicicleta(Bicicleta bicicleta, Date fechaHora, String estado) {
		super();
		this.setBicicleta(bicicleta);
		this.setFechaHora(fechaHora);
		this.setEstado(estado);
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

	public Long getIdHistorialbici() {
		return idHistorialbici;
	}

	public void setIdHistorialbici(Long idHistorialbici) {
		this.idHistorialbici = idHistorialbici;
	}

}
