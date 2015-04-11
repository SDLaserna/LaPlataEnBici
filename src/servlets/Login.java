package servlets;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebInitParam;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import clases.Usuario;

@WebServlet(
        urlPatterns = "/login",
        initParams =
        {
            @WebInitParam(name = "usuario", value = "cande"),
            @WebInitParam(name = "password", value = "321"),
            @WebInitParam(name = "rol", value = "usuario"),
            @WebInitParam(name = "usuarioB", value = "sergio"),
            @WebInitParam(name = "passwordB", value = "123"),
            @WebInitParam(name = "rolB", value = "administrador")
        }
)
public class Login extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private List<Usuario> users= new ArrayList<Usuario>();
	
	 public List<Usuario> getUsers() {
			return users;
	}


	public void setUsers(List<Usuario> users) {
		this.users = users;
	}
	
	public Login() {
	}

	public void init(ServletConfig config) throws ServletException {
		super.init(config);
		String user = this.getInitParameter("usuario");
		String pass=this.getInitParameter("password");
		String rol=this.getInitParameter("rol");
		Usuario usuario = new Usuario(user,pass,rol);
		this.getUsers().add(usuario);
		user = this.getInitParameter("usuarioB");
		pass=this.getInitParameter("passwordB");
		rol=this.getInitParameter("rolB");
		usuario = new Usuario(user,pass,rol);
		this.getUsers().add(usuario);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String user = request.getParameter("inputUser");
		String pass = request.getParameter("inputPass");
		
		if(!this.getUsers().isEmpty()){
			Iterator<Usuario> it = this.getUsers().iterator();
			while(it.hasNext()){
				Usuario usuario = it.next();
				if(usuario.getUser().equals(user)){
					if(usuario.getPass().equals(pass)){
						if(usuario.getRol().equals("administrador")){
							response.sendRedirect("/LaPlataEnBici/administrador.jsp");
						}
						else{
							if(usuario.getRol().equals("usuario")){
								response.sendRedirect("/LaPlataEnBici/usuario.jsp");
							}
							
						}
					}
				}
			}
		}
	}


}
