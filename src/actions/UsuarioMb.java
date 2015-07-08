package actions;

import java.util.Random;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

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
	
	final String alphabet = "0123456789ABCDEFGHIJKLMNÑOPQRSTUVWXYZ";
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
			return "error";
		}
		else{
			this.getUsuario().setDomicilio(this.getDomicilio());
			String claveGenerada=this.randomizer();
			this.getUsuario().setClave(claveGenerada);
			this.usuarioService.persistir(this.getUsuario());
			return "success";
			}
	}
	
	
}
