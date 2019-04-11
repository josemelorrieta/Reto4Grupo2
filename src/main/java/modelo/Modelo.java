package modelo;

import BaseDatos.ConsultaBD;

public class Modelo {
	
	public ConsultaBD bd;
	
	public Hotel hotel1;
	public Reserva reserva;
	public Cliente clienteRegis;
	public Hotel[] hotelesBusqueda;
	public MetodosBuscar mBuscar;
	public MetodosPanelPago mPago;
	public MetodosPanelRegistroYLogin mRegiLog;
	private boolean pagoExitoso=false;
	
	public Modelo() {
		hotel1 = new Hotel();
		reserva = new Reserva();
		bd = new ConsultaBD();
		addMetodos();
	}
	
	public void addMetodos() {
		mBuscar=new MetodosBuscar(this, bd);
		mPago=new MetodosPanelPago();
		mRegiLog=new MetodosPanelRegistroYLogin();
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

