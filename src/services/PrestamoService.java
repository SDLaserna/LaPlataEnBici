package services;

import java.util.Date;
import java.util.List;

import entidades.Prestamo;

public interface PrestamoService {
	public void persistir(Prestamo p);
	public List<Prestamo> prestamosActualesDelUsuario(Long idUsuario, Date fecha);

}
