package managedBeans.persona;

import java.util.Random;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;

import services.UsuarioService;
import services.UsuarioServiceImp;
import entidades.Domicilio;
import entidades.Usuario;

@ManagedBean
@RequestScoped
/*Por cada click en el boton registrar, manda un request y se crea una conexion.
 *Si por ejemplo pongo applicationScoped, me pisa al mismo usuario */
public class UsuarioMbReq {
	private Usuario usuario;
	private Domicilio domicilio;
	private UsuarioService usuarioService=new UsuarioServiceImp();
	
	final String alphabet = "0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZ";
    final int N = alphabet.length();
	
	
	public UsuarioMbReq(){
		this.setUsuario(new Usuario());
		this.setDomicilio(new Domicilio());
	}
	

	public Domicilio getDomicilio() {
		return domicilio;
	}

	public void setDomicilio(Domicilio domicilio) {
		this.domicilio = domicilio;
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}
	
	private String randomizer(){
		Random r = new Random();
		String valorRandom = "";
		for (int i = 0; i < 8; i++) {
			valorRandom=valorRandom+alphabet.charAt(((Integer)r.nextInt(N))); 
		}
		return valorRandom;
		
	}
	
	public String registrar(){
		/* cambiamos existeUsuario por existePersona */
		if (this.usuarioService.existePersona(this.getUsuario().getEmail())){
			FacesMessage mensaje = new FacesMessage("El Email ya se ha registrado, ingrese otro");
			FacesContext.getCurrentInstance().addMessage("Registro", mensaje);
			return "error";
		}
		else{
			this.getUsuario().setDomicilio(this.getDomicilio());
			String claveGenerada=this.randomizer();
			this.getUsuario().setClave(claveGenerada);
			this.usuarioService.persistir(this.getUsuario());
			FacesMessage mensaje = new FacesMessage("Te registrate correctamente, se te ha generado una contrasenia");
			FacesContext.getCurrentInstance().addMessage("Registro", mensaje);
			return "success";
			}
	}
	
}
