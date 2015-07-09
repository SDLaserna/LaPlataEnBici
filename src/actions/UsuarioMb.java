package actions;

import java.util.Random;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpServletRequest;

import services.UsuarioService;
import services.UsuarioServiceImp;
import entidades.Domicilio;
import entidades.Usuario;

@ManagedBean
@RequestScoped
/*Por cada click en el botón registrar, manda un request y se crea una conexion.
 *Si por ejemplo pongo applicationScoped, me pisa al mismo usuario */
public class UsuarioMb {

	
	private Usuario usuario;
	private Domicilio domicilio;
	private UsuarioService usuarioService=new UsuarioServiceImp();
	
	public UsuarioMb(){
		this.setUsuario(new Usuario());
		this.setDomicilio(new Domicilio());
	}
	
	final String alphabet = "0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZ";
    final int N = alphabet.length();
    
    private String randomizer(){
    	Random r = new Random();
    	String valorRandom = "";
		for (int i = 0; i < 8; i++) {
			valorRandom=valorRandom+alphabet.charAt(((Integer)r.nextInt(N))); 
			}
		return valorRandom;
			
    }
    
	public Usuario getUsuario() {
		return usuario;
	}
	

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	public Domicilio getDomicilio() {
		return domicilio;
	}

	public void setDomicilio(Domicilio domicilio) {
		this.domicilio = domicilio;
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
			FacesMessage mensaje = new FacesMessage("Te registrate correctamente, se te ha generado una contrase�a");
			FacesContext.getCurrentInstance().addMessage("Registro", mensaje);
			return "success";
			}
	}
	
	public String modificar(){
		/* Uso los datos del usuario el cual tiene la sesion
		 * entonces a la hora de modificar recupero los datos de la sesion (los cuales
		 * se sincronizan con los que se ingresan en los input) y lo mando como parámetro del método
		 * del service que realiza la modificacion*/
		
		HttpServletRequest httpSR =(HttpServletRequest)FacesContext.getCurrentInstance().getExternalContext().getRequest();
		if(httpSR.getSession().getAttribute("personaSesion")!=null){
			Usuario userOn=(Usuario)httpSR.getSession().getAttribute("personaSesion");
			this.usuarioService.modificar(userOn);
			FacesMessage mensaje = new FacesMessage("Se modificaron los datos correctamente");
			FacesContext.getCurrentInstance().addMessage("Modificar", mensaje);
			return "successModificar";
		}
		else{
			return "sesionCaducada";
		}
	}
	
	
}
