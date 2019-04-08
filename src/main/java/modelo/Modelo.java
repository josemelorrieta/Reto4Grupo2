package modelo;

import java.lang.reflect.Type;
import java.util.List;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import BaseDatos.ConsultaBD;

public class Modelo {
	
	private ConsultaBD bd;
	
	private Hotel hotel;
	private Reserva reserva;
	private Hotel[] hotelesBusqueda;
	
	public Modelo() {
		hotel = new Hotel();
		reserva = new Reserva();
	}
	
	public void cargarHoteles(String localidad) {
		String aux = bd.consultarToGson("SELECT `nombre`,`numEstrellas`,`pvpTAlta`,`pvpTBaja`,`pvpRecFestivo` FROM `hotel` WHERE `idDir` IN (SELECT `idDir` FROM `direccion` WHERE `localidad`='"+localidad+"')");
		final Gson gson = new Gson();
		Type tipoListaHoteles = new TypeToken<List<Hotel>>(){}.getType();
		final List<Hotel> hoteles = gson.fromJson(aux, tipoListaHoteles);
		Hotel[] hotelesBusqueda = (Hotel[]) hoteles.toArray();

	}

	public Hotel[] getHotelesBusqueda() {
		return hotelesBusqueda;
	}

	public void setHotelesBusqueda(Hotel[] hotelesBusqueda) {
		this.hotelesBusqueda = hotelesBusqueda;
	}
	
}

