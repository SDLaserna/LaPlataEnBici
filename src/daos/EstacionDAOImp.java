package daos;

import java.util.List;

import entidades.Estacion;

public class EstacionDAOImp extends GenericDAOImp<Estacion> implements EstacionDAO{
	
	public boolean existeEstacion(String nombre) {
		List resul = this.entityManager.createQuery("select e from Estacion e where e.nombre = '"+nombre+"' and e.activa=1").getResultList();
		return !resul.isEmpty();
	}
	
	public List<Estacion> listarEstacionesActivas(){
		return this.entityManager.createQuery("select e from Estacion e where e.activa=1").getResultList();
		
	}

	@Override
	public Estacion obtenerEstacionDeNombre(String nombreEstacion) {
		return (Estacion) this.entityManager.createQuery("select e from Estacion e where e.nombre = "+nombreEstacion).getResultList().get(0);
	}

}
