package aspectos;

import java.util.Date;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;

import services.HistorialBicicletaService;
import services.HistorialBicicletaServiceImp;
import services.HistorialEstacionService;
import services.HistorialEstacionServiceImp;
import entidades.Bicicleta;
import entidades.Estacion;
import entidades.HistorialBicicleta;
import entidades.HistorialEstacion;

@Aspect
public class Historiador {

	private HistorialEstacionService historialEstacionService = new HistorialEstacionServiceImp();
	private HistorialBicicletaService historialBicicletaService = new HistorialBicicletaServiceImp();
	
	@After("execution(* services.EstacionService.persistir(..)) && args(elem) || "
			+ "execution(* services.EstacionService.borrarLogicamente(..)) && args(elem) ||"
			+ " execution(* services.EstacionService.modificar(..)) && args(elem)")
	public void historialAgregarEstacion(JoinPoint joinpoint, Estacion elem){
		System.out.println(elem.getNombre());
			HistorialEstacion hest= new HistorialEstacion(elem, new Date(), elem.getEstado());
			this.historialEstacionService.persisitir(hest);
	}
	
	@After("execution(* services.BicicletaService.persistir(..)) && args(elem) || "
			+ "execution(* services.BicicletaService.borrarLogicamente(..)) && args(elem) ||"
			+ " execution(* services.BicicletaService.modificar(..)) && args(elem)")
	public void historialAgregarBicicleta(JoinPoint joinpoint, Bicicleta elem){
			HistorialBicicleta hbici= new HistorialBicicleta(elem, new Date(), elem.getEstado());
			this.historialBicicletaService.persisitir(hbici);
	}
}
