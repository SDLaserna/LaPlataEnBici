package services;

import java.util.List;

import entidades.Bicicleta;


public interface BicicletaService {
	
	public void persistir(Bicicleta B);
	public List<Bicicleta> listarBicicletasActivas();
	public List<Bicicleta> listarBicicletasParaPrestar(Long idEstacion);
	public void borrarLogicamente(Bicicleta B);
	public Bicicleta obtenerBicicleta(Long idBicicleta);
	public void modificar(Bicicleta B);


}
