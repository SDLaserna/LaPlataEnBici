package daos;

import java.util.Date;
import java.util.List;

import entidades.Prestamo;

public interface PrestamoDAO extends GenericDAO<Prestamo> {
	public boolean existeDeudor(Object id);
	public List<Prestamo> prestamosActualesDelUsuario(Long idUsuario, Date fecha);
	public List<Prestamo> prestamosIniciadosDelUsuario(Long idUsuario);

}
