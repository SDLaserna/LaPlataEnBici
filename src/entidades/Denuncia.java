package entidades;

import java.util.Date;

public class Denuncia {
	private Long idDenuncia;
	/*uno a uno*/
	private Usuario usuario;
	/*uno a uno*/
	private Bicicleta bicicleta;
	private Date fechaHora;
	private String comentario;
	
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
