package daos;

import java.util.List;

import entidades.Bicicleta;

public interface BicicletaDAO extends GenericDAO<Bicicleta> {

	public List<Bicicleta> listarBicicletasActivas();
}
