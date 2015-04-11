package clases;

public class Usuario {
	private String user;
	private String pass;
	private String rol;
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
