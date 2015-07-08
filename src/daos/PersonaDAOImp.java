package daos;

import entidades.Persona;


public abstract class PersonaDAOImp<T> extends GenericDAOImp<T> implements PersonaDAO<T>{

	public boolean existePersona(String email){
		return !this.entityManager.createQuery("select p from Persona p where p.email = '"+email+"' and p.activa = 0").getResultList().isEmpty();
	}
	
	public Persona obtenerPersona(String email){
		/* Posibilidad de tener que verificar si es nulo al hacer getResultList */
		return (Persona) this.entityManager.createQuery("select p from Persona p where p.email = '"+ email+"' and p.activa = 0").getResultList().get(0);
	}
}
