package managedBeans.bicicleta;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

import entidades.Bicicleta;
import entidades.Estacion;
import entidades.HistorialBicicleta;
import services.BicicletaService;
import services.BicicletaServiceImp;
import services.EstacionService;
import services.EstacionServiceImp;
import services.HistorialBicicletaService;
import services.HistorialBicicletaServiceImp;

@ManagedBean
@SessionScoped
public class BicicletaMbSess {

	private Bicicleta bicicleta;
	private BicicletaService bicicletaService = new BicicletaServiceImp();
	private EstacionService estacionService = new EstacionServiceImp();
	private HistorialBicicletaService historialBicicletaService = new HistorialBicicletaServiceImp();
	private List<Estacion> listaEstaciones = new ArrayList<Estacion>();
	private List<Bicicleta> listaBicicletas = new ArrayList<Bicicleta>();
	private List<HistorialBicicleta> listaHistorialBicicleta = new ArrayList<HistorialBicicleta>();
	private Long idEstacion;

	public BicicletaMbSess() {
		this.bicicleta = new Bicicleta(new Date(), "Apta para el uso");
	}

	public String visualizarAltaBici() {
		this.setBicicleta(new Bicicleta(new Date(), "Apta para el uso"));
		List<Estacion> est = this.estacionService.listarActivas();
		this.setListaEstaciones(est);
		return "successVisualizarAltaBici";
	}

	public String agregarBicicleta() {
		Bicicleta bici = new Bicicleta(new Date(), "Apta para el uso");
		bici.setActiva(true);
		bici.setColor(this.getBicicleta().getColor());
		bici.setDescrip(this.getBicicleta().getDescrip());
		bici.setMarca(this.getBicicleta().getMarca());
		bici.setPrestada(false);
		bici.setRodado(this.getBicicleta().getRodado());
		Estacion est = this.estacionService.obtenerEstacion(this
				.getIdEstacion());
		bici.setEstacion(est);
		this.bicicletaService.persistir(bici);
		est.setCantEstacionamientosLibres(est.getCantEstacionamientosLibres()-1);
		this.estacionService.modificar(est);
		FacesMessage mensaje = new FacesMessage(
				"La bicicleta se ha agregado correctamente");
		FacesContext.getCurrentInstance().addMessage("Alta", mensaje);
		this.visualizarListarBicicletas();
		return "success";
	}

	public String visualizarListarBicicletas() {
		this.setListaBicicletas(this.bicicletaService.listarBicicletasActivas());
		return "successVisualizarListarBicicletas";
	}

	public String visualizarModificarBici() {
		Map<String, String> params = FacesContext.getCurrentInstance()
				.getExternalContext().getRequestParameterMap();
		String idBicicleta = params.get("idBicicleta");
		Long idLong = Long.parseLong(idBicicleta);
		this.setBicicleta(this.bicicletaService.obtenerBicicleta(idLong));
		this.setIdEstacion(this.getBicicleta().getEstacion().getIdEstacion());
		List<Estacion> est = this.estacionService.listarActivas();
		this.setListaEstaciones(est);
		return "successVisualizarModificarBici";
	}

	public String modificarBicicleta() {
		Estacion est = this.estacionService.obtenerEstacion(this
				.getIdEstacion());
		this.getBicicleta().setEstacion(est);
		this.bicicletaService.modificar(this.getBicicleta());
		FacesMessage mensaje = new FacesMessage(
				"Se modificaron los datos correctamente");
		FacesContext.getCurrentInstance().addMessage("Alta", mensaje);
		this.visualizarListarBicicletas();
		return "successModificarBicicleta";
	}

	public String borradoLogico() {
		Map<String, String> params = FacesContext.getCurrentInstance()
				.getExternalContext().getRequestParameterMap();
		String idBicicleta = params.get("idBicicleta");
		Long idLong = Long.parseLong(idBicicleta);
		Bicicleta bicicletaPersistente = this.bicicletaService
				.obtenerBicicleta(idLong);
		this.bicicletaService.borrarLogicamente(bicicletaPersistente);
		FacesMessage mensaje = new FacesMessage(
				"La bicicleta se ha eliminado correctamente");
		FacesContext.getCurrentInstance().addMessage("Alta", mensaje);
		this.setListaBicicletas(this.bicicletaService.listarBicicletasActivas());
		return "listarBicicletas";
	}
	
	public String visualizarDisponibilidad() {
		Map<String, String> params = FacesContext.getCurrentInstance()
				.getExternalContext().getRequestParameterMap();
		String idBicicleta = params.get("idBicicleta");
		Long idLong = Long.parseLong(idBicicleta);
		this.setListaHistorialBicicleta(this.historialBicicletaService.historialDeLaBicicleta(idLong));
		return "successVisualizarDisponibilidad";
	}
	
	public List<Estacion> getListaEstaciones() {
		return listaEstaciones;
	}

	public void setListaEstaciones(List<Estacion> listaEstaciones) {
		this.listaEstaciones = listaEstaciones;
	}

	public Bicicleta getBicicleta() {
		return bicicleta;
	}

	public void setBicicleta(Bicicleta bicicleta) {
		this.bicicleta = bicicleta;
	}

	public Long getIdEstacion() {
		return idEstacion;
	}

	public void setIdEstacion(Long idEstacion) {
		this.idEstacion = idEstacion;
	}

	public List<Bicicleta> getListaBicicletas() {
		return listaBicicletas;
	}

	public void setListaBicicletas(List<Bicicleta> listaBicicletas) {
		this.listaBicicletas = listaBicicletas;
	}

	public List<HistorialBicicleta> getListaHistorialBicicleta() {
		return listaHistorialBicicleta;
	}

	public void setListaHistorialBicicleta(List<HistorialBicicleta> listaHistorialBicicleta) {
		this.listaHistorialBicicleta = listaHistorialBicicleta;
	}

}
