package entidades;

import java.util.Date;

public abstract class Persona {
	private Long id;
	private String dni;
	private String apellido;
	private String nombre;
	private Date fechaNacimiento;
	private String sexo;
	private String email;
	private String clave;
	private boolean activa ;
	/* uno a uno domicilio*/
	private Domicilio domicilio;
	
	public Persona(String dni, String apellido, String nombre, Date fechaNacimiento, String sexo, Domicilio domicilio, String email, String clave) {
		super();
		this.setDni(dni);
		this.setApellido(apellido);
		this.setNombre(nombre);
		this.setFechaNacimiento(fechaNacimiento);
		this.setDomicilio(domicilio);
		this.setSexo(sexo);
		this.setEmail(email);
		this.setClave(clave);
		this.setActiva(true);
	}
	
	public String getDni() {
		return dni;
	}
	public void setDni(String dni) {
		this.dni = dni;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getApellido() {
		return apellido;
	}
	public void setApellido(String apellido) {
		this.apellido = apellido;
	}
	public Date getFechaNacimiento() {
		return fechaNacimiento;
	}
	public void setFechaNacimiento(Date fechaNacimiento) {
		this.fechaNacimiento = fechaNacimiento;
	}
	public String getSexo() {
		return sexo;
	}
	public void setSexo(String sexo) {
		this.sexo = sexo;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}

	public String getClave() {
		return clave;
	}
	public void setClave(String clave) {
		this.clave = clave;
	}
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public boolean isActiva() {
		return activa;
	}
	public void setActiva(boolean activa) {
		this.activa = activa;
	}
	public Domicilio getDomicilio() {
		return domicilio;
	}
	public void setDomicilio(Domicilio domicilio) {
		this.domicilio = domicilio;
	}
}
