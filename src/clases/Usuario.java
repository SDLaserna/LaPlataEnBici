package clases;

import java.util.Date;

public class Usuario {
	private String user;
	private String pass;
	private String rol;
	private String dni;
	private String nombres;
	private String apellido;
	private Date fnac;
	private String sexo;
	private String email;
	public String getDni() {
		return dni;
	}
	public void setDni(String dni) {
		this.dni = dni;
	}
	public String getNombres() {
		return nombres;
	}
	public void setNombres(String nombres) {
		this.nombres = nombres;
	}
	public String getApellido() {
		return apellido;
	}
	public void setApellido(String apellido) {
		this.apellido = apellido;
	}
	public Date getFnac() {
		return fnac;
	}
	public void setFnac(Date fnac) {
		this.fnac = fnac;
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
	public String getUser() {
		return user;
	}
	public void setUser(String user) {
		this.user = user;
	}
	public String getPass() {
		return pass;
	}
	public void setPass(String pass) {
		this.pass = pass;
	}
	public String getRol() {
		return rol;
	}
	public void setRol(String rol) {
		this.rol = rol;
	}
	public Usuario(String user, String pass, String rol) {
		super();
		this.setUser(user);
		this.setPass(pass);
		this.setRol(rol);
	}

}
