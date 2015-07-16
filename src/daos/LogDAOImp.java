package daos;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import entidades.Log;

public class LogDAOImp extends GenericDAOImp<Log> implements LogDAO {

	@Override
	public void generarLog(Log l) {
		this.crearLog(l);
	}

//	@Override
//	public List<Log> listarLogs(Object entidad) {
//		return this.entityManager.createQuery("select l.operacion, count(l.operacion) as cantidad from Log l where l.tipoEntidad= "+entidad.getClass().getSimpleName()+" group by l.operacion").getResultList();
//	}

	@Override
	public Map<String,Integer> listarLogs(String tipoEntidad) {
		//Uso map para calcular por cada operacion su cantidad 
		//sin tener que estar creando una nueva clase 
		Map<String,Integer> mapResul = new HashMap<String,Integer>();
		
		List<Log> listaResul = (List<Log>)this.entityManager.createQuery("select l from Log l where l.tipoEntidad= '" + tipoEntidad + "'").getResultList();
		
		//recorro dos veces la lista xq en la primera es para inicializar en 0 la cantidad por 
		//cada operacion y en la segunda le voy sumando de a 1 la cantidad mas la que tenia 
		for (Log l : listaResul) {
		    String operacion = l.getOperacion();
		    Integer cantidad = new Integer(0);
		    mapResul.put(operacion,cantidad);
		  }
		
		for (Log l : listaResul) {
		    String operacion = l.getOperacion();
		    Integer cantidad = mapResul.get(operacion) + new Integer(1);
		    mapResul.put(operacion,cantidad);
		  }
		return mapResul;
	}
	
}


