package daos;

import java.util.List;
import java.util.Map;

public interface GenericDAO<T> {

	 	long contar(Map<String, Object> params);

	    T crear(T t);

	    void borrar(Object id);

	    boolean encontrar(Object id);

	    T obtener(Object id);
	    
	    T actualizar(T t);
	    
	    public List<T> listar(String entidad);
	    
}
