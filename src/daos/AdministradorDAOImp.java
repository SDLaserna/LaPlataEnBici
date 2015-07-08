package daos;

import java.util.List;

import entidades.Administrador;

public class AdministradorDAOImp extends PersonaDAOImp<Administrador> implements AdministradorDAO {

	@Override
	public boolean existeAdministrador(String email) {
		List resul =this.entityManager.createQuery("select a from Administrador a where a.email = '"+ email+"' and a.activa=0").getResultList();
		return !resul.isEmpty();
	}

	@Override
	public Administrador obtenerAdministrador(String email) {
		return (Administrador)this.entityManager.createQuery("select a from Administrador a where a.email = '"+ email+"' and a.activa=0").getResultList().get(0);
	}

}
