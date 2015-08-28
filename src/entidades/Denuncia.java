package entidades;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class Denuncia {
	@Id
	@GeneratedValue
	private Long idDenuncia;
	/*uno a uno*/
	@ManyToOne
	private Usuario usuario;
	/*uno a uno*/
	@ManyToOne
	private Bicicleta bicicleta;
	private Date fechaHora;
	private String comentario;
	
	public Denuncia() {
	}

	public Denuncia(Usuario usuario, Bicicleta bicicleta, Date fechaHora,
			String comentario) {
		super();
		this.setUsuario(usuario);
		this.setBicicleta(bicicleta);
		this.setFechaHora(fechaHora);
		this.setComentario(comentario);
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
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

	public String getComentario() {
		return comentario;
	}

	public void setComentario(String comentario) {
		this.comentario = comentario;
	}

	public Long getIdDenuncia() {
		return idDenuncia;
	}

	public void setIdDenuncia(Long idDenuncia) {
		this.idDenuncia = idDenuncia;
	}

}
