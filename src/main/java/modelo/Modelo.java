package modelo;

import com.google.gson.Gson;

import BaseDatos.ConsultaBD;

public class Modelo {
	
	public ConsultaBD bd;
	
	public Hotel hotel;
	public Reserva reserva;
	public Hotel[] hotelesBusqueda;
	public MetodosBuscar mBuscar;
	public MetodosPanelPago mPago;
	
	private boolean pagoExitoso=false;
	
	
	public Modelo() {
		hotel = new Hotel();
		reserva = new Reserva();
		bd = new ConsultaBD();
		addMetodos();
	}
	
	public void addMetodos() {
		mBuscar=new MetodosBuscar(bd);
		mPago=new MetodosPanelPago();
	}
	
	public void cargarHoteles(String localidad) {
		String aux = bd.consultarToGson("SELECT `nombre`,`numEstrellas` 'estrellas',`pvpTAlta` 'precioTAlta',`pvpTBaja` 'precioTBaja',`pvpRecFestivo` 'precioTFest' FROM `hotel` WHERE `idDir` IN (SELECT `idDir` FROM `direccion` WHERE `localidad`='"+localidad+"')");
		final Gson gson = new Gson();
		hotelesBusqueda = gson.fromJson(aux, Hotel[].class);
		for(Hotel hotel:hotelesBusqueda) {
			hotel.setUbicacion(new Direccion("", 34533, localidad));
		}
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

