package daos;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.List;
import java.util.Map;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;

public abstract class GenericDAOImp<T> implements GenericDAO<T> {

	//Al ser abstracta la clase, estoy obligado a crear implementaciones especificas para los DAO que extiendan de ac�, 
	//ejemplo "usuarioDAOimp extends genericDAOImp<usuario>"

	private Class<T> type;
	protected EntityManager entityManager;
	
	
	public GenericDAOImp() {
		Type t = getClass().getGenericSuperclass();
		ParameterizedType pt = (ParameterizedType) t;
		type = (Class)pt.getActualTypeArguments()[0]; //obtener el tipo por reflexion
		EntityManagerFactory emf = EMF.getEMF();
		this.entityManager=emf.createEntityManager();
	}
	

	
	@Override
	public long contar(Map<String, Object> params) {
		return 0;
	}

	@Override
	public T crear(T t) {
		/* Que pasaría si yo quiero realizar transacciones fuera del dao, por ejemplo
		 * en un service? como obtengo
		 * el EntityTransaction para poder hacer una especie de metodo transaccional?*/
		EntityTransaction tx = this.entityManager.getTransaction();
		tx.begin();
		this.entityManager.persist(t);
		tx.commit();
		return null;
	}

	@Override
	
	public void borrar(Object id) {
		EntityTransaction tx = this.entityManager.getTransaction();
		tx.begin();
		this.entityManager.remove( this.entityManager.getReference(type, id));  // ver que en una pagina pusieron como parametro "this.entityManager.getReference(type, id);
		tx.commit();
	}

	@Override
	
	public boolean encontrar(Object id) {
		return this.entityManager.contains(id);
		
	}

	@Override
	
	public T actualizar(T t) {
		EntityTransaction tx = this.entityManager.getTransaction();
		tx.begin();
		 this.entityManager.merge(t);
		tx.commit();
		return null;
	}
	
	public T obtener(Object id){
		EntityTransaction tx = this.entityManager.getTransaction();
		tx.begin();
		T resul = (T) this.entityManager.find(type, id);
		tx.rollback();
		return resul;
	}
	
	public List<T> listar(String entidad) {
		return this.entityManager.createQuery("select e from"+" "+entidad+" "+"e").getResultList();//se usa el nombre del objeto, no de la tabla
	}
	
}


