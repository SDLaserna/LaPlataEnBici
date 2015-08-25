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
	

}
