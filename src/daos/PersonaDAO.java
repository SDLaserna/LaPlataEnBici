package daos;

import java.util.List;

import entidades.Persona;

public interface PersonaDAO<T> extends GenericDAO<T>{
	public boolean existePersona(String email); 
	public Persona obtenerPersona(String email);
	public List<T> listarPersonasActivas(String entidad);
	public List<T> listarPersonasInActivas(String entidad);
	
}
