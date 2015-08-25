package daos;

import java.util.List;

import entidades.Persona;


public abstract class PersonaDAOImp<T> extends GenericDAOImp<T> implements PersonaDAO<T>{

	public boolean existePersona(String email){
		return !this.entityManager.createQuery("select p from Persona p where p.email = '"+email+"' and p.activa = 1").getResultList().isEmpty();
	}
	
	public Persona obtenerPersona(String email){
		/* Posibilidad de tener que verificar si es nulo al hacer getResultList */
		return (Persona) this.entityManager.createQuery("select p from Persona p where p.email = '"+ email+"' and p.activa = 1").getResultList().get(0);
	}
	
	public List<T> listarPersonasActivas(String entidad){
		return this.entityManager.createQuery("select e from "+ entidad +" e where e.activa=1").getResultList();
		
	}
}
