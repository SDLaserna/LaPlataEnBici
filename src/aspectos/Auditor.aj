package aspectos;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Before;

import services.LogService;
import services.LogServiceImp;


public aspect Auditor {
	
	private LogService logService = new LogServiceImp();
	
/*	pointcut puntoDeInteres: execution(public * CreditCardProcessor.*(..));

	pointcut puntoA: execution(* * * daos.GenericDAOImp.crear(..));
*/
	@Before("execution(* daos.GenericDAOImp.crear(..)) && args(elem)")
	public void logginAlta(JoinPoint joinpoint, Object elem){
		/* new log y llenar los datos*/
		this.logService.persistirLog(l);
	}
	@Before("execution(* daos.GenericDAOImp.borrar(..)) && args(elem)")
	public void logginBaja(JoinPoint joinpoint, Object elem){
		
	}
	@Before("execution(* daos.GenericDAOImp.actualizar(..)) && args(elem)")
	public void logginModificar(JoinPoint joinpoint, Object elem){
		
	}
	
}
