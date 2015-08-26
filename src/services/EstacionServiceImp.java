package services;

import java.util.List;

import daos.EstacionDAO;
import daos.EstacionDAOImp;
import entidades.Estacion;
import entidades.Usuario;

public class EstacionServiceImp implements EstacionService {
	private EstacionDAO estacionDAO= new EstacionDAOImp();

	public void persistir(Estacion e) {
		this.estacionDAO.crear(e);

	}
	
	public boolean existeEstacion(String nombre) {
		return this.estacionDAO.existeEstacion(nombre);
	}

	public void modificar(Estacion e) {
		this.estacionDAO.actualizar(e);

	}
	
	public Estacion obtenerEstacion(Object id) {
		return this.estacionDAO.obtener(id);
	}
	
	public List<Estacion> listarEstaciones() {
		return this.estacionDAO.listar("Estacion");
	}
	
	public List<Estacion> listarActivas(){
		return this.estacionDAO.listarEstacionesActivas();
	}
	
	public void borrarLogicamente(Estacion e) {
		/* esto estaba en true, lo pongo en false para que al sincronizar ande */
		e.setActiva(false);
		e.setEstado("eliminado");
		this.estacionDAO.actualizar(e);		
	}

	@Override
	public Estacion obtenerEstacionNombre(String nombreEstacion) {
		return this.estacionDAO.obtenerEstacionDeNombre(nombreEstacion);
	}

}
