package daos;

import java.util.List;

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
	public List<Log> listarLogs(String tipoEntidad) {
		//return this.entityManager.createQuery("select l.operacion, count(l.operacion) as cantidad from Log l where l.tipoEntidad= '" + tipoEntidad + "' group by l.operacion").getResultList();
		return this.entityManager.createQuery("select l from Log l where l.tipoEntidad= '" + tipoEntidad + "' group by l.operacion").getResultList();
	}
	
}
