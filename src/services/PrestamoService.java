package services;

import java.util.Date;
import java.util.List;

import entidades.Prestamo;

public interface PrestamoService {
	public boolean existeDeudor(Object id);
	public void persistir(Prestamo p);
	public List<Prestamo> prestamosActualesDelUsuario(Long idUsuario, Date fecha);
	public List<Prestamo> prestamosIniciadosDelUsuario(Long idUsuario);
	public Prestamo obtenerPrestamo(Object id);
	public void modificar(Prestamo p);

}
