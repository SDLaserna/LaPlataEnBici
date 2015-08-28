package entidades;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.xml.bind.annotation.XmlTransient;

import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.CascadeType;


@Entity
public class Estacion {
	@Id
	@GeneratedValue
	private Long idEstacion;
	private String nombre;
	private Long totalEstacionamientos;
	private Long cantEstacionamientosLibres;
	private String estado;
	private boolean activa;
	@OneToOne
	@Cascade(value = { CascadeType.ALL })
	private Domicilio ubicacion;
	
	/* cero a muchas bicicletas*/
	@OneToMany(mappedBy="estacion")
	private List<Bicicleta> bicicletas;
	
	public Estacion() {
		this.setActiva(true);
	}

	public Estacion(String nombre, Long total,
			Long cantEstacionamientosLibres, String estado,
			Domicilio ubicacion) {
		super();
		this.setBicicletas(new ArrayList<Bicicleta>());
		this.setNombre(nombre);
		this.setTotalEstacionamientos(total);
		this.setCantEstacionamientosLibres(cantEstacionamientosLibres);
		this.setEstado(estado);
		this.setUbicacion(ubicacion);
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

	@XmlTransient
	public List<Bicicleta> getBicicletas() {
		return bicicletas;
	}

	public void setBicicletas(List<Bicicleta> bicicletas) {
		this.bicicletas = bicicletas;
	}

	public void agregarBicicleta(Bicicleta bicicleta) {
		this.getBicicletas().add(bicicleta);
	}

	public Long getTotalEstacionamientos() {
		return totalEstacionamientos;
	}

	public void setTotalEstacionamientos(Long totalEstacionamientos) {
		this.totalEstacionamientos = totalEstacionamientos;
	}

}
