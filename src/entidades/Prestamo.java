package entidades;

import java.util.Date;

public class Prestamo {
	private Long idPrestamo;
	/* uno a uno */
	private Usuario usuario;
	/* uno a uno*/
	private Bicicleta bicicleta;
	/* es muchas a muchas o uno a uno en cada estacion¿?*/
	private Estacion estacionPrestamo;
	private Estacion estacionDevolucion;
	private Date fechaPrestamo;
	private Date fechaDevolucion;
	private String estado;
	
	public Prestamo(Usuario usuario, Bicicleta bicicleta,
			Estacion estacionPrestamo, Date fechaPrestamo) {
		super();
		this.setUsuario(usuario);
		this.setBicicleta(bicicleta);
		this.setEstacionPrestamo(estacionPrestamo);
		this.setFechaPrestamo(fechaPrestamo);
		this.setEstado("Iniciado");	
	}

	public Long getIdPrestamo() {
		return idPrestamo;
	}

	public void setIdPrestamo(Long idPrestamo) {
		this.idPrestamo = idPrestamo;
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

	public Estacion getEstacionPrestamo() {
		return estacionPrestamo;
	}

	public void setEstacionPrestamo(Estacion estacionPrestamo) {
		this.estacionPrestamo = estacionPrestamo;
	}

	public Estacion getEstacionDevolucion() {
		return estacionDevolucion;
	}

	public void setEstacionDevolucion(Estacion estacionDevolucion) {
		this.estacionDevolucion = estacionDevolucion;
	}

	public Date getFechaPrestamo() {
		return fechaPrestamo;
	}

	public void setFechaPrestamo(Date fechaPrestamo) {
		this.fechaPrestamo = fechaPrestamo;
	}

	public Date getFechaDevolucion() {
		return fechaDevolucion;
	}

	public void setFechaDevolucion(Date fechaDevolucion) {
		this.fechaDevolucion = fechaDevolucion;
	}

	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

}
