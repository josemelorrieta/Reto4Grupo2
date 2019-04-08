package modelo;

import com.google.gson.Gson;

import BaseDatos.ConsultaBD;

public class MetodosBuscar {
	private ConsultaBD bd;
	
	public MetodosBuscar(ConsultaBD bd) {
		this.bd=bd;
	}
	
	public Localidad[] buscarLocalidades() {
		String aux = bd.consultarToGson("SELECT DISTINCT `localidad` FROM `direccion`");
		final Gson gson = new Gson();
		Localidad[] localidades = gson.fromJson(aux, Localidad[].class);
		return localidades;
	}
}
