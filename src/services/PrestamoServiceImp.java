package services;

import java.util.Date;
import java.util.List;

import daos.PrestamoDAO;
import daos.PrestamoDAOImp;
import entidades.Prestamo;

public class PrestamoServiceImp implements PrestamoService {
	private PrestamoDAO prestamoDAO= new PrestamoDAOImp();

	@Override
	public void persistir(Prestamo p) {
		this.prestamoDAO.crear(p);
	}

	@Override
	public List<Prestamo> prestamosActualesDelUsuario(Long idUsuario, Date fecha) {
		return this.prestamoDAO.prestamosActualesDelUsuario(idUsuario, fecha);
	}

	@Override
	public List<Prestamo> prestamosIniciadosDelUsuario(Long idUsuario) {
		return this.prestamoDAO.prestamosIniciadosDelUsuario(idUsuario);
	}

	@Override
	public Prestamo obtenerPrestamo(Object id) {
		return this.prestamoDAO.obtener(id);
	}

	@Override
	public void modificar(Prestamo p) {
		this.prestamoDAO.actualizar(p);
	}

	@Override
	public boolean existeDeudor(Object id) {
		return this.prestamoDAO.existeDeudor(id);
	}
	

}
