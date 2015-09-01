package services;

import java.util.Map;

import entidades.HistorialEstacion;

public interface HistorialEstacionService {

	public void persisitir(HistorialEstacion e);
	public Map<String,Integer> historialDeLaEstacion(Long idEstacion);
}
