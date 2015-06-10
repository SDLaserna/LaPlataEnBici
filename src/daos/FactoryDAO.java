package daos;

public class FactoryDAO {
	
	public static UsuarioDAOImp getUsuarioDAO() {
		return new UsuarioDAOImp();
	}
	
	public static AdministradorDAOImp getAdministradorDAO(){
		return new AdministradorDAOImp();
	}

	public static BicicletaDAOImp getBicicletaDAO(){
		return new BicicletaDAOImp();
	}
	
	public static DenunciaDAOImp getDenunciaDAO(){
		return new DenunciaDAOImp();
	}
	
	public static DomicilioDAOImp getDomicilioDAO(){
		return new DomicilioDAOImp();
	}
	
	public static EstacionDAOImp getEstacionDAO(){
		return new EstacionDAOImp();
	}
	
	public static HistorialBicicletaDAOImp getHistorialBicicletaDAO(){
		return new HistorialBicicletaDAOImp();
	}

	public static HistorialEstacionDAOImp getHistorialEstacionDAO(){
		return new HistorialEstacionDAOImp();
	}
	
	public static PrestamoDAOImp getPrestamoDAO(){
		return new PrestamoDAOImp();
	}

}

