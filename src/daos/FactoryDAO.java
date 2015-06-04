package daos;

public class FactoryDAO {
	
	public static UsuarioDAOImp getUsuarioDAO() {
		return new UsuarioDAOImp();
	}

}

