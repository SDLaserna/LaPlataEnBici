package daos;

import java.util.List;

import entidades.Estacion;

public interface EstacionDAO extends GenericDAO<Estacion> {
	
	public boolean existeEstacion(String nombre);
	public List<Estacion> listarEstacionesActivas();
	public Estacion obtenerEstacionDeNombre(String nombreEstacion);
	public List<Estacion> listarEstacionesOperativas();
}
