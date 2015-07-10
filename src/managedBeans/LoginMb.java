package managedBeans;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpServletRequest;

import entidades.Administrador;
import entidades.Usuario;
import services.AdminService;
import services.AdminServiceImp;
import services.UsuarioService;
import services.UsuarioServiceImp;

@ManagedBean
@RequestScoped
public class LoginMb {

	private String password;
	private String email;
	private UsuarioService usuarioService;
	private AdminService adminService;
	private final HttpServletRequest httpServletRequest;
	
	public LoginMb(){
		this.httpServletRequest=(HttpServletRequest)FacesContext.getCurrentInstance().getExternalContext().getRequest();
		this.usuarioService = new UsuarioServiceImp();
		this.adminService= new AdminServiceImp();
	}
	
	public String logueo() {
		String resultado = "inicializado";
		try {

			if (this.usuarioService.existePersona(this.getEmail())) {
				if (this.usuarioService.existeUsuario(this.getEmail())) {
					Usuario usuario = this.usuarioService.obtenerUsuario(this
							.getEmail());
					if (usuario.getClave().equals(this.getPassword())) {
						this.httpServletRequest.getSession().setAttribute(
								"personaSesion", usuario);
						this.httpServletRequest.getSession().setAttribute(
								"rol", "user");
						resultado = "successUsuario";
					} else {
						FacesMessage mensaje = new FacesMessage(
								"Contrasenia incorrecta");
						FacesContext.getCurrentInstance().addMessage("loginForm",
								mensaje);
						resultado = "login";
					}
				} else {
					if (this.adminService.existeAdministrador(this.getEmail())) {
						Administrador admin = this.adminService
								.obtenerAdministrador(this.getEmail());
						if (admin.getClave().equals(this.getPassword())) {
							this.httpServletRequest.getSession().setAttribute(
									"personaSesion", admin);
							this.httpServletRequest.getSession().setAttribute(
									"rol", "admin");
							resultado = "successAdministrador";
						} else {
							FacesMessage mensaje = new FacesMessage(
									"Clave incorrecta");
							FacesContext.getCurrentInstance().addMessage("loginForm",
									mensaje);
							resultado = "login";
						}
					} else {
						FacesMessage mensaje = new FacesMessage("Email inexistente ");
						FacesContext.getCurrentInstance().addMessage("loginForm", mensaje);
						resultado = "login";
					}
				}

			} else {
				FacesMessage mensaje = new FacesMessage("Email inexistente");
				FacesContext.getCurrentInstance().addMessage("loginForm", mensaje);
				resultado = "login";
			}
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("entre a la exception");
		}
		return resultado;
	}
	
	
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
}
