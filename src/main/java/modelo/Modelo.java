package modelo;

import com.google.gson.Gson;

import BaseDatos.ConsultaBD;

public class Modelo {
	
	public ConsultaBD bd;
	
	public Hotel hotel1;
	public Reserva reserva;
	public Hotel[] hotelesBusqueda;
	public MetodosBuscar mBuscar;
	public MetodosPanelPago mPago;
	private Gson gson = new Gson();
	private boolean pagoExitoso=false;
	
	public Modelo() {
		hotel1 = new Hotel();
		reserva = new Reserva();
		bd = new ConsultaBD();
		addMetodos();
	}
	
	public void addMetodos() {
		mBuscar=new MetodosBuscar(bd);
		mPago=new MetodosPanelPago();
	}
	
	public void cargarHoteles(String localidad) {
		String json = bd.consultarToGson("SELECT `idHot` 'id',`nombre`,`numEstrellas` 'estrellas',`pvpTAlta` 'precioTAlta',`pvpTBaja` 'precioTBaja',`pvpRecFestivo` 'precioTFest' FROM `hotel` WHERE `idDir` IN (SELECT `idDir` FROM `direccion` WHERE `localidad`='"+localidad+"')");
		gson = new Gson();
		hotelesBusqueda = gson.fromJson(json, Hotel[].class);
		for(Hotel hotel:hotelesBusqueda) {
			hotel.setUbicacion(new Direccion("", 34533, localidad));
			cargarHotelDireccion(hotel);
		}
	}

	private void cargarHotelDireccion(Hotel hotel) {
		String json = bd.consultarToGson("SELECT `calle`,`codPostal`,`localidad` FROM `direccion` WHERE `idDir` = (SELECT `idDir` FROM `hotel` WHERE `idHot` = " + hotel.getId() + ")");
		gson = new Gson();
		Direccion[] dir = gson.fromJson(json, Direccion[].class);
		hotel.setUbicacion(dir[0]);
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

