package services;

import java.util.List;

import entidades.HistorialBicicleta;

public interface HistorialBicicletaService {
	
	public void persisitir(HistorialBicicleta hb);
	public List<HistorialBicicleta> historialDeLaBicicleta(Long idBicicleta);

}
