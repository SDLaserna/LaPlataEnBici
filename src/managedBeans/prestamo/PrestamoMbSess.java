package managedBeans.prestamo;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpServletRequest;

import entidades.Bicicleta;
import entidades.Denuncia;
import entidades.Estacion;
import entidades.Prestamo;
import entidades.Usuario;
import services.BicicletaService;
import services.BicicletaServiceImp;
import services.DenunciaService;
import services.DenunciaServiceImp;
import services.EstacionService;
import services.EstacionServiceImp;
import services.PrestamoService;
import services.PrestamoServiceImp;

@ManagedBean
@SessionScoped
public class PrestamoMbSess {

	private PrestamoService prestamoService = new PrestamoServiceImp();
	private BicicletaService bicicletaService = new BicicletaServiceImp();
	private EstacionService estacionService = new EstacionServiceImp();
	private DenunciaService denunciaService = new DenunciaServiceImp();
	private List<Prestamo> listaPrestamos = new ArrayList<Prestamo>();
	private List<Bicicleta> listaBicicletas = new ArrayList<Bicicleta>();
	private List<Estacion> listaEstaciones = new ArrayList<Estacion>();
	private Long idEstacion;
	private Long idPrestamo;

	public PrestamoMbSess() {
	}
		
	public String visualizarBicicletasParaPrestar() {
		Map<String, String> params = FacesContext.getCurrentInstance()
				.getExternalContext().getRequestParameterMap();
		String idEstacion = params.get("idEstacion");
		this.setIdEstacion(Long.parseLong(idEstacion));
		this.setListaBicicletas(this.bicicletaService
				.listarBicicletasParaPrestar(this.getIdEstacion()));
		return "successVisualizarBicicletasParaPrestar";
	}

	public String prestarBicicleta() {
		FacesContext facesContext = FacesContext.getCurrentInstance();

		Date fechaActual = new Date();

		HttpServletRequest httpServletRequest = (HttpServletRequest) facesContext
				.getExternalContext().getRequest();
		Usuario usuario = (Usuario) httpServletRequest.getSession()
				.getAttribute("personaSesion");
		Long idUsuario = usuario.getIdPersona();

		List<Prestamo> prestamosIniciados = this.prestamoService
				.prestamosIniciadosDelUsuario(idUsuario);
		if (!prestamosIniciados.isEmpty()) {
			if (prestamosIniciados.size() < 3) {
				if (this.prestamoService.prestamosActualesDelUsuario(idUsuario,
						fechaActual).isEmpty()) {
					FacesMessage mensaje = new FacesMessage(
							FacesMessage.SEVERITY_ERROR,
							"Tiene prestamos vencidos, devuelva las bicicletas para poder retirar otra",
							"Tiene prestamos vencidos, devuelva las bicicletas para poder retirar otra");
					facesContext.addMessage("Seleccion", mensaje);
					return "errorPrestarBicicleta";
				}
			} else {
				FacesMessage mensaje = new FacesMessage(
						FacesMessage.SEVERITY_ERROR,
						"No se pueden retirar mas de 3 bicicletas",
						"No se pueden retirar mas de 3 bicicletas");
				facesContext.addMessage("Seleccion", mensaje);
				return "errorPrestarBicicleta";
			}
		}
		Estacion est = this.estacionService.obtenerEstacion(this
				.getIdEstacion());

		Map<String, String> params = facesContext
				.getExternalContext().getRequestParameterMap();
		String idBicicleta = params.get("idBicicleta");
		Long idLong = Long.parseLong(idBicicleta);
		Bicicleta bici = this.bicicletaService
				.obtenerBicicleta(idLong);

		Prestamo prestamo = new Prestamo(usuario, bici, est,
				fechaActual);
		this.prestamoService.persistir(prestamo);
		bici.setPrestada(true);
		this.bicicletaService.modificar(bici);
		est.setCantEstacionamientosLibres(est.getCantEstacionamientosLibres()+1);
		this.estacionService.modificar(est);

		FacesMessage mensaje = new FacesMessage(
				FacesMessage.SEVERITY_INFO,
				"Se retiro la bicicleta correctamente",
				"Se retiro la bicicleta correctamente");
		facesContext.addMessage("Seleccion", mensaje);
		this.setListaBicicletas(this.bicicletaService
				.listarBicicletasParaPrestar(this.getIdEstacion()));
		return "successPrestarBicicleta";
	}
	
	public String visualizarBicicletasPrestadas() {
		FacesContext facesContext = FacesContext.getCurrentInstance();
		
		HttpServletRequest httpServletRequest = (HttpServletRequest)facesContext.getExternalContext().getRequest();
	    Usuario usuario = (Usuario) httpServletRequest.getSession().getAttribute("personaSesion");
		
	    this.setListaPrestamos(this.prestamoService.prestamosIniciadosDelUsuario(usuario.getIdPersona()));
		return "successVisualizarBicicletasPrestadas";
	}
	
	public String visualizarEstacionarBicicleta(){
		Map<String, String> params = FacesContext.getCurrentInstance()
				.getExternalContext().getRequestParameterMap();
		String idPrestamo = params.get("idPrestamo");
		this.setIdPrestamo(Long.parseLong(idPrestamo));
		this.setListaEstaciones(this.estacionService.listarEstacionesOperativas());
		return "successVisualizarEstacionarBicicleta";
	}
	
	public String devolverBicicleta(){
		Map<String, String> params = FacesContext.getCurrentInstance()
				.getExternalContext().getRequestParameterMap();
		String idEstacion = params.get("idEstacion");
		this.setIdEstacion(Long.parseLong(idEstacion));
		Estacion est = this.estacionService.obtenerEstacion(this
				.getIdEstacion());
		Date fechaActual = new Date();
		
		Prestamo prestamo = this.prestamoService.obtenerPrestamo(this.getIdPrestamo());
		prestamo.setEstacionDevolucion(est);
		prestamo.setFechaDevolucion(fechaActual);
		
		DateFormat df = new SimpleDateFormat("dd/MM/yyyy");
		String fechaPrestamoStr = df.format(prestamo.getFechaPrestamo());
		String fechaActualStr = df.format(fechaActual);
		
		String estado = "";
		if(fechaActualStr.equals(fechaPrestamoStr)){
			estado = "Devuelto a tiempo";
		}else{
			estado = "Devuelto a destiempo";
		}
		
        prestamo.setEstado(estado);
		this.prestamoService.modificar(prestamo);
		
		est.setCantEstacionamientosLibres(est.getCantEstacionamientosLibres()-1);
		this.estacionService.modificar(est);
		
		Bicicleta bici = prestamo.getBicicleta();
		bici.setPrestada(false);
		bici.setEstacion(est);
		this.bicicletaService.modificar(bici);
		
		FacesContext facesContext = FacesContext.getCurrentInstance();
		FacesMessage mensaje = new FacesMessage(
				FacesMessage.SEVERITY_INFO,
				"Has " + estado + " la bicicleta",
				"Has " + estado + " la bicicleta");
		facesContext.addMessage("Seleccion", mensaje);

		HttpServletRequest httpServletRequest = (HttpServletRequest)facesContext.getExternalContext().getRequest();
	    Usuario usuario = (Usuario) httpServletRequest.getSession().getAttribute("personaSesion");
		
	    this.setListaPrestamos(this.prestamoService.prestamosIniciadosDelUsuario(usuario.getIdPersona()));
		return "successDevolverBicicleta";
	}
	
	public String denunciarBicicleta(){
		FacesContext facesContext = FacesContext.getCurrentInstance();

		HttpServletRequest httpServletRequest = (HttpServletRequest) facesContext
				.getExternalContext().getRequest();
		Usuario usuario = (Usuario) httpServletRequest.getSession()
				.getAttribute("personaSesion");
		
		Map<String, String> params = facesContext
				.getExternalContext().getRequestParameterMap();
		String idPrestamo = params.get("idPrestamo");
		this.setIdPrestamo(Long.parseLong(idPrestamo));
		
		Prestamo prestamo = this.prestamoService.obtenerPrestamo(this.getIdPrestamo());
		
		Bicicleta bici = prestamo.getBicicleta();
		
		Date fechaActual = new Date();
		
		Denuncia denuncia = new Denuncia(usuario,bici,fechaActual,"");
		this.denunciaService.persistir(denuncia);
		
		bici.setEstado("Denunciada");
		this.bicicletaService.modificar(bici);
		
		FacesMessage mensaje = new FacesMessage(
				FacesMessage.SEVERITY_INFO,
				"La denuncia a la bicicleta por mal estado se realizo correctamente",
				"La denuncia a la bicicleta por mal estado se realizo correctamente");
		facesContext.addMessage("Seleccion", mensaje);
		return "successDenunciarBicicleta";
	}

	public List<Prestamo> getListaPrestamos() {
		return listaPrestamos;
	}

	public void setListaPrestamos(List<Prestamo> listaPrestamos) {
		this.listaPrestamos = listaPrestamos;
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

	public List<Estacion> getListaEstaciones() {
		return listaEstaciones;
	}

	public void setListaEstaciones(List<Estacion> listaEstaciones) {
		this.listaEstaciones = listaEstaciones;
	}

	public Long getIdPrestamo() {
		return idPrestamo;
	}

	public void setIdPrestamo(Long idPrestamo) {
		this.idPrestamo = idPrestamo;
	}

}
