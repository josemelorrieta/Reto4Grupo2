package modelo;

import java.util.ArrayList;
import java.util.Calendar;

import BaseDatos.ConsultaBD;
import util.FuncionesGenerales;

/**
 * Clase model, guarda toda la informacion necesaria para ejecucion del programa
 *
 */
public class Modelo {

	public ConsultaBD bd;
	public Reserva reserva;
	public Cliente clienteRegis;
	public ArrayList<Cliente> acompaniantes = new ArrayList<Cliente>();
	public Hotel[] hotelesBusqueda;
	public Casa[] casasBusqueda;
	public Apartamento[] apartBusqueda;
	public Calendar[] festivos;
	public Dormitorio[] tiposDorm;
	public String[] tiposDormString;
	public MetodosBuscar mBuscar;
	public MetodosPanelPago mPago;
	public MetodosPanelRegistroYLogin mRegiLog;
	public MetodosFiltros mFiltros;
	private boolean pagoExitoso = false;
	public DesglosePrecio desglosePrecio;

	/**
	 * Constructor - Crea un nuevo modelo
	 */
	public Modelo() {
		reserva = new Reserva();
		bd = new ConsultaBD();
		addMetodos();
		festivos = mBuscar.buscarFechasFestivos(FuncionesGenerales.sdf);
		tiposDormString = mBuscar.tiposDormitorio();
		tiposDorm = mBuscar.crearModeloDormitorios(mBuscar.crearModeloCamas(tiposDormString));
	}

	/**
	 * Inicializa los metodos en el modelo
	 */
	public void addMetodos() {
		mBuscar = new MetodosBuscar(this, bd);
		mPago = new MetodosPanelPago(bd);
		mRegiLog = new MetodosPanelRegistroYLogin(this, bd);
		mFiltros = new MetodosFiltros(this);
	}

	public Hotel[] getHotelesBusqueda() {
		return hotelesBusqueda;
	}

	public void setHotelesBusqueda(Hotel[] hotelesBusqueda) {
		this.hotelesBusqueda = hotelesBusqueda;
	}

	public boolean isPagoExitoso() {
		return pagoExitoso;
	}

	public void setPagoExitoso(boolean pagoExitoso) {
		this.pagoExitoso = pagoExitoso;
	}

	/**
	 * Limpia la reserva
	 */
	public void limpiar() {
		reserva = new Reserva();
		clienteRegis = null;
		acompaniantes.clear();
		desglosePrecio = null;
		pagoExitoso = false;
	}
}
