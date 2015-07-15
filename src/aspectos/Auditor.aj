package aspectos;

import java.util.Date;

import javax.persistence.EntityManagerFactory;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;

import daos.EMF;
import entidades.Log;
import services.LogService;
import services.LogServiceImp;

@Aspect
public aspect Auditor {
	
	private LogService logService = new LogServiceImp();
	
/*	pointcut puntoDeInteres: execution(public * CreditCardProcessor.*(..));

	pointcut puntoA: execution(* * * daos.GenericDAOImp.crear(..));
*/
	@After("execution(* daos.GenericDAOImp.crear(..)) && args(elem)")
	public void loggingAlta(JoinPoint joinpoint, Object elem){
		this.prepararLog("Alta", joinpoint);
	}
	@Before("execution(* daos.GenericDAOImp.borrar(..)) && args(elem)")
	public void loggingBaja(JoinPoint joinpoint, Object elem){
		this.prepararLog("Baja", joinpoint);
	}
	@Before("execution(* daos.GenericDAOImp.actualizar(..)) && args(elem)")
	public void loggingModificar(JoinPoint joinpoint, Object elem){
			this.prepararLog("Actualizacion", joinpoint);
	}
	
	public void prepararLog(String tipo, Object elem){
		Log log = new Log();
		log.setFecha(new Date());
		EntityManagerFactory e = EMF.getEMF();
		Object id = e.getPersistenceUnitUtil().getIdentifier(elem);
		log.setIdEntidad((Long)id);
		//log.setOperacion("Operacion: "+tipo);
		log.setOperacion(tipo);
		log.setTipoEntidad(elem.getClass().getSimpleName());	
		this.logService.persistirLog(log);
	}
	
}
