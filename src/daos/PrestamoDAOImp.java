package daos;

import java.util.Date;
import java.util.List;

import entidades.Prestamo;

public class PrestamoDAOImp extends GenericDAOImp<Prestamo> implements PrestamoDAO{
	
	public List<Prestamo> prestamosActualesDelUsuario(Long idUsuario, Date fecha){
		java.sql.Date fechaSql = new java.sql.Date(fecha.getTime());
		return this.entityManager.createQuery("select p from Prestamo p where p.fechaPrestamo='" + fechaSql +"' and p.usuario=" + idUsuario + " and p.estado= 'Iniciado'").getResultList();
	}

	@Override
	public List<Prestamo> prestamosIniciadosDelUsuario(Long idUsuario) {
		return this.entityManager.createQuery("select p from Prestamo p where p.usuario=" + idUsuario + " and p.estado= 'Iniciado'").getResultList();
	}

}
