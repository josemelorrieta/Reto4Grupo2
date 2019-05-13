package modelo;

import java.util.Calendar;
import java.util.Date;

import BaseDatos.ConsultaBD;

public class Modelo {
	
	public ConsultaBD bd;
	
	public Alojamiento aloj1;
	public Reserva reserva;
	public Cliente clienteRegis;
	public Hotel[] hotelesBusqueda;
	public Casa[] casasBusqueda;
	public Apartamento[] apartBusqueda;
	public Calendar[] festivos;
	public MetodosBuscar mBuscar;
	public MetodosPanelPago mPago;
	public MetodosPanelRegistroYLogin mRegiLog;
	private boolean pagoExitoso=false;
	public DesglosePrecio desglosePrecio;
	
	public Modelo() {
		aloj1 = new Alojamiento();
		reserva = new Reserva();
		bd = new ConsultaBD();
		addMetodos();
		festivos=mBuscar.buscarFechasFestivos();
	}
	
	public void addMetodos() {
		mBuscar=new MetodosBuscar(this, bd);
		mPago=new MetodosPanelPago(bd);
		mRegiLog=new MetodosPanelRegistroYLogin(this, bd);
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
}

