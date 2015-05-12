package entidades;

public class Domicilio {
	private Long idDomicilio;
	private String calle;
	private Long numero;
	private String localidad;
	private String longitud;
	private String latitud;
	
	public Domicilio(String calle, Long numero, String localidad,
			String longitud, String latitud) {
		super();
		this.setCalle(calle);
		this.setNumero(numero);
		this.setLocalidad(localidad);
		this.setLongitud(longitud);
		this.setLatitud(latitud);
	}
	public Domicilio(String calle, Long numero, String localidad) {
		super();
		this.setCalle(calle);
		this.setNumero(numero);
		this.setLocalidad(localidad);
	}
	
	public Long getIdDomicilio() {
		return idDomicilio;
	}
	public void setIdDomicilio(Long idDomicilio) {
		this.idDomicilio = idDomicilio;
	}
	public String getCalle() {
		return calle;
	}
	public void setCalle(String calle) {
		this.calle = calle;
	}
	public Long getNumero() {
		return numero;
	}
	public void setNumero(Long numero) {
		this.numero = numero;
	}
	public String getLocalidad() {
		return localidad;
	}
	public void setLocalidad(String localidad) {
		this.localidad = localidad;
	}
	public String getLongitud() {
		return longitud;
	}
	public void setLongitud(String longitud) {
		this.longitud = longitud;
	}
	public String getLatitud() {
		return latitud;
	}
	public void setLatitud(String latitud) {
		this.latitud = latitud;
	}
}
