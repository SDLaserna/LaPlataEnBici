package entidades;

import java.util.ArrayList;

public class Estacion {
	private Long idEstacion;
	private String nombre;
	private Long cantBicicleta;
	private Long cantEstacionamientosLibres;
	private String estado;
	/* uno a uno domicilio*/
	private Domicilio ubicacion;
	private boolean activa;
	/* cero a muchas bicicletas*/
	private ArrayList<Bicicleta> bicicletas =new ArrayList<Bicicleta>();
	
	public Estacion(String nombre, Long cantBicicleta,
			Long cantEstacionamientosLibres, String estado,
			Domicilio ubicacion, ArrayList<Bicicleta> bicicletas) {
		super();
		this.setNombre(nombre);
		this.setCantBicicleta(cantBicicleta);
		this.setCantEstacionamientosLibres(cantEstacionamientosLibres);
		this.setEstado(estado);
		this.setUbicacion(ubicacion);
		this.setBicicletas(bicicletas);
		this.setActiva(true);
	}

	public Long getIdEstacion() {
		return idEstacion;
	}

	public void setIdEstacion(Long idEstacion) {
		this.idEstacion = idEstacion;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public Long getCantBicicleta() {
		return cantBicicleta;
	}

	public void setCantBicicleta(Long cantBicicleta) {
		this.cantBicicleta = cantBicicleta;
	}

	public Long getCantEstacionamientosLibres() {
		return cantEstacionamientosLibres;
	}

	public void setCantEstacionamientosLibres(Long cantEstacionamientosLibres) {
		this.cantEstacionamientosLibres = cantEstacionamientosLibres;
	}

	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

	public Domicilio getUbicacion() {
		return ubicacion;
	}

	public void setUbicacion(Domicilio ubicacion) {
		this.ubicacion = ubicacion;
	}

	public boolean isActiva() {
		return activa;
	}

	public void setActiva(boolean activa) {
		this.activa = activa;
	}

	public ArrayList<Bicicleta> getBicicletas() {
		return bicicletas;
	}

	public void setBicicletas(ArrayList<Bicicleta> bicicletas) {
		this.bicicletas = bicicletas;
	}
	public void agregarBicicleta(Bicicleta bicicleta) {
		this.getBicicletas().add(bicicleta);
	}

}
