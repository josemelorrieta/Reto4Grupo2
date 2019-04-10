package modelo;

import com.google.gson.Gson;

import BaseDatos.ConsultaBD;

public class MetodosBuscar {
	private ConsultaBD bd;
	private Gson gson = new Gson();
	private Modelo mod;
	
	public MetodosBuscar(Modelo mod, ConsultaBD bd) {
		this.bd=bd;
		this.mod=mod;
	}
	
	public Localidad[] buscarLocalidades() {
		String aux = bd.consultarToGson("SELECT DISTINCT `localidad` FROM `direccion`");
		if (aux != null) {
			final Gson gson = new Gson();
			Localidad[] localidades = gson.fromJson(aux, Localidad[].class);
			return localidades;
		} else {
			return null;
		}

	}
	
	public void cargarHoteles(String localidad) {
		String json = bd.consultarToGson("SELECT `idHot` 'id',`nombre`,`numEstrellas` 'estrellas',`pvpTAlta` 'precioTAlta',`pvpTBaja` 'precioTBaja',`pvpRecFestivo` 'precioTFest', `imagen` FROM `hotel` WHERE `idDir` IN (SELECT `idDir` FROM `direccion` WHERE `localidad`='"+localidad+"')");
		gson = new Gson();
		mod.hotelesBusqueda = gson.fromJson(json, Hotel[].class);
		for(Hotel hotel:mod.hotelesBusqueda) {
			hotel.setUbicacion(new Direccion("", 34533, localidad));
			cargarHotelDireccion(hotel);
			//cargarHotelHabitaciones(hotel);
		}
	}

	private void cargarHotelDireccion(Hotel hotel) {
		String json = bd.consultarToGson("SELECT `calle`,`codPostal`,`localidad` FROM `direccion` WHERE `idDir` = (SELECT `idDir` FROM `hotel` WHERE `idHot` = " + hotel.getId() + ")");
		gson = new Gson();
		Direccion[] dir = gson.fromJson(json, Direccion[].class);
		hotel.setUbicacion(dir[0]);
	}
}
