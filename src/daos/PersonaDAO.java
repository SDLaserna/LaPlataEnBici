package daos;

import entidades.Persona;

public interface PersonaDAO<T> extends GenericDAO<T>{
	public boolean existePersona(String email); 
	public Persona obtenerPersona(String email);

}
