package modelo;

import com.google.gson.Gson;

import BaseDatos.ConsultaBD;

public enum TipoHabitacion {
	SALA(3), COMEDOR(2), BALCON(3), GARAJE(5), COCINA(7), BANIO(4), DORMITORIO(12), SUITE(2);

	private final double preciom2;

	
	TipoHabitacion(double preciom2) {
		//this.g
		this.preciom2 = preciom2;
	}

	public double getPreciom2() {
		return this.preciom2;
	}
	/**
	public void cargarPrecios(ConsultaBD bd) {
			String json = bd.consultarToGson("");
			Gson gson = new Gson();
			this. = gson.fromJson(json, Apartamento[].class);
			
		
	}
	**/
}
