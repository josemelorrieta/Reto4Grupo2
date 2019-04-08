package modelo;

import java.lang.reflect.Type;
import java.util.List;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import modelo.Localidad;
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
//		Localidad[] localidades = gson.fromJson(aux, tipoListaLocalidades);
		//Localidad[] localidadesBusqueda = (Localidad[]) localidades.toArray();
		return localidades;
	}
}
