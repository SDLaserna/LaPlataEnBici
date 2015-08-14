package services;

import java.util.List;

import entidades.Estacion;

public interface EstacionService {
	
	public void persistir(Estacion e);
	public boolean existeEstacion(String nombre);
	public void modificar(Estacion e);
	public Estacion obtenerEstacion(Object id);
	public List<Estacion> listarEstaciones();
	public List<Estacion> listarActivas();
	public void borrarLogicamente(Estacion e);
	public Estacion obtenerEstacionNombre(String nombreEstacion);

}
