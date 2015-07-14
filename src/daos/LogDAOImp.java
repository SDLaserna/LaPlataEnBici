package daos;

import entidades.Log;

public class LogDAOImp extends GenericDAOImp<Log> implements LogDAO {

	@Override
	public void generarLog(Log l) {
		this.crearLog(l);
	}


}
