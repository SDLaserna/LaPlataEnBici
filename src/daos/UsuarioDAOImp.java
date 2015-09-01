package daos;

import java.util.List;

//import org.hibernate.Session;



import javax.persistence.EntityTransaction;

import entidades.Usuario;

public class UsuarioDAOImp extends PersonaDAOImp<Usuario> implements UsuarioDAO{

	@Override
	public boolean existeUsuario(String email) {
		List resul = this.entityManager.createQuery("select u from Usuario u where u.email = '"+email+"' and u.activa=1").getResultList();
//		Session a = this.entityManager.unwrap(Session.class);
		return !resul.isEmpty();
	}
	
	public Usuario obtenerUsuario(String email){
		return (Usuario)this.entityManager.createQuery("select u from Usuario u where u.email='"+email+"' and u.activa=1").getResultList().get(0);
	}

	@Override
	public void borrarPermanenteUsuario(Usuario u) {
		Class<? extends Usuario> type = u.getClass();
		EntityTransaction tx = this.entityManager.getTransaction();
		tx.begin();
		this.entityManager.remove( this.entityManager.getReference(type, u.getIdPersona()));  // ver que en una pagina pusieron como parametro "this.entityManager.getReference(type, id);
		tx.commit();
	}
	
}
