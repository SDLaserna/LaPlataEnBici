package daos;

import java.util.List;

//import org.hibernate.Session;

import entidades.Usuario;

public class UsuarioDAOImp extends PersonaDAOImp<Usuario> implements UsuarioDAO{

	@Override
	public boolean existeUsuario(String email) {
		List resul = this.entityManager.createQuery("select u from Usuario u where u.email = '"+email+"' and u.activa=0").getResultList();
//		Session a = this.entityManager.unwrap(Session.class);
		return !resul.isEmpty();
	}
	
	public Usuario obtenerUsuario(String email){
		return (Usuario)this.entityManager.createQuery("select u from Usuario u where u.email='"+email+"' and u.activa=0").getResultList().get(0);
	}
	
}
