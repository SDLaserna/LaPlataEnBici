package daos;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.List;
import java.util.Map;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

public abstract class GenericDAOImp<T> implements GenericDAO<T> {

	//Al ser abstracta la clase, estoy obligado a crear implementaciones especificas para los DAO que extiendan de ac�, 
	//ejemplo "usuarioDAOimp extends genericDAOImp<usuario>"

	private Class<T> type;
	private EntityManager entityManager;
	
	
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
		this.entityManager.persist(t);
		return null;
	}

	@Override
	
	public void borrar(Object id) {
		this.entityManager.remove( this.entityManager.getReference(type, id));  // ver que en una pagina pusieron como parametro "this.entityManager.getReference(type, id);
	}

	@Override
	
	public boolean encontrar(Object id) {
		return this.entityManager.contains(id);
		
	}

	@Override
	
	public T actualizar(T t) {
		return this.entityManager.merge(t);
		
	}
	
	public T obtener(Object id){
		return (T) this.entityManager.find(type, id);
	}
	
	public List<T> listar(String entidad) {
		return this.entityManager.createQuery("select e from"+" "+entidad+" "+"e").getResultList();//se usa el nombre del objeto, no de la tabla
	}
	
}


