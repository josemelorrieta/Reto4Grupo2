package modelo;

import java.lang.reflect.Type;
import java.util.List;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import BaseDatos.ConsultaBD;

public class Modelo {
	
	public ConsultaBD bd;
	
	public Hotel hotel;
	public Reserva reserva;
	public Hotel[] hotelesBusqueda;
	public MetodosBuscar mBuscar;
	public MetodosPanelPago mPago;
	
	
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
		String aux = bd.consultarToGson("SELECT `nombre`,`numEstrellas`,`pvpTAlta`,`pvpTBaja`,`pvpRecFestivo` FROM `hotel` WHERE `idDir` IN (SELECT `idDir` FROM `direccion` WHERE `localidad`='"+localidad+"')");
		final Gson gson = new Gson();
		Type tipoListaHoteles = new TypeToken<List<Hotel>>(){}.getType();
		final List<Hotel> hoteles = gson.fromJson(aux, tipoListaHoteles);
		Hotel[] hotelesBusqueda = ((Hotel[])hoteles.toArray());
		for(Hotel hotel:hotelesBusqueda) {
			hotel.getUbicacion().setLocalidad(localidad);
		}
	}

	public Hotel[] getHotelesBusqueda() {
		return hotelesBusqueda;
	}

	public void setHotelesBusqueda(Hotel[] hotelesBusqueda) {
		this.hotelesBusqueda = hotelesBusqueda;
	}
	
}

