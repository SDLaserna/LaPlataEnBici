package servlets;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebInitParam;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import daos.EMF;
import daos.FactoryDAO;
import daos.UsuarioDAOImp;
import entidades.Administrador;
import entidades.Domicilio;
import entidades.Persona;
import entidades.Usuario;

@WebServlet(
        urlPatterns = "/login",
        initParams =
        {
            @WebInitParam(name = "usuario", value = "user@asd.com"),
            @WebInitParam(name = "password", value = "user"),
            @WebInitParam(name = "usuarioB", value = "admin@asd.com"),
            @WebInitParam(name = "passwordB", value = "admin"),
        }
)
public class Login extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private List<Persona> users= new ArrayList<Persona>();
	
	 public List<Persona> getUsers() {
			return users;
	}


	public void setUsers(List<Persona> users) {
		this.users = users;
	}
	
	public Login() {
		
	}

	public void init(ServletConfig config) throws ServletException {
		/*super.init(config);
		String user = this.getInitParameter("usuario");
		String pass=this.getInitParameter("password");
		Long num= new Long(234);
		Date fNaci= new Date();
		Domicilio domi = new Domicilio("unacalle",num,"La Plata");
		Persona usuario = new Usuario("3512356","gonc","cand",fNaci,"fem",domi,user,pass);
		this.getUsers().add(usuario);
		user = this.getInitParameter("usuarioB");
		pass=this.getInitParameter("passwordB");
		usuario = new Administrador("3812356","laser","serg",fNaci,"mascu",domi,user,pass);
		this.getUsers().add(usuario);
		EntityManagerFactory emf = EMF.getEMF();
		EntityManager em = emf.createEntityManager();
    	EntityTransaction tx = em.getTransaction();
		
		Domicilio dom= new Domicilio("calle 12", (long) 12, "La Plata");
		Usuario usr=new Usuario("123", "Laserna", "Sergio", new Date(), "Masculino", dom, "sergio@mail.com", "123");
		tx.begin();
		/*UsuarioDAOImp ud = FactoryDAO.getUsuarioDAO();
		ud.crear(usr);
		usr.setNombre("Nombre Actualizado");
		ud.actualizar(usr);*/
//		Long id=(long) 1;
//		System.out.println(ud.obtener(id).getDni());
//		ud.borrar(id);*/
		/*em.persist(dom);//aca hay q persistir con este em y no con el ud xq nunca lo creamos
		tx.commit();*/
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String user = request.getParameter("inputUser");
		String pass = request.getParameter("inputPass");
		
		if(!this.getUsers().isEmpty()){
			Iterator<Persona> it = this.getUsers().iterator();
			boolean encontrado = false;
			while(it.hasNext()){
				Persona usuario = it.next();
				String nameClass = usuario.getClass().getName();
				if(usuario.getEmail().equals(user)){
					if(usuario.getClave().equals(pass)){
						if(nameClass.equals("entidades.Administrador")){
							encontrado= true;
							RequestDispatcher dispatcher=request.getRequestDispatcher("/adminBase");
							if (dispatcher!=null) dispatcher.forward(request,response);
						}
						else{
							if(nameClass.equals("entidades.Usuario")){
								encontrado= true;
								RequestDispatcher dispatcher=request.getRequestDispatcher("/userBase");
								if (dispatcher!=null) dispatcher.forward(request,response);
							}
						}
					}
				}
			}
			if(!it.hasNext() && !encontrado){
				RequestDispatcher dispatcher=request.getRequestDispatcher("/inicio");
				if (dispatcher!=null) dispatcher.forward(request,response);
			}	
		}
		else{
			RequestDispatcher dispatcher=request.getRequestDispatcher("/inicio");
			if (dispatcher!=null) dispatcher.forward(request,response); }
		
	}


}
