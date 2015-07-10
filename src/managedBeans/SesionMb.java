package managedBeans;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpServletRequest;

import entidades.Persona;

@ManagedBean
@RequestScoped
public class SesionMb {
	private Persona usuario;
	private String rol;
    private final HttpServletRequest httpServletRequest;
    private final FacesContext faceContext;
     
    public SesionMb() 
    {
        faceContext=FacesContext.getCurrentInstance();
        httpServletRequest=(HttpServletRequest)faceContext.getExternalContext().getRequest();
        if(httpServletRequest.getSession().getAttribute("personaSesion")!=null)
        {
            usuario=(Persona)httpServletRequest.getSession().getAttribute("personaSesion");
            rol=(String) httpServletRequest.getSession().getAttribute("rol");
        }
    }
     
    public String cerrarSession()
    {
/*		Es suficiente con poner invalidate
 *         httpServletRequest.getSession().removeAttribute("personaSesion");*/
        httpServletRequest.getSession().invalidate();
        return "logout";
    }
 
    public Persona getUsuario() {
        return usuario;
    }
 
    public void setUsuario(Persona usuario) {
        this.usuario = usuario;
    }

	public String getRol() {
		return rol;
	}

	public void setRol(String rol) {
		this.rol = rol;
	}    
}
