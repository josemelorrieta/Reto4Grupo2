package modelo;

import com.google.gson.Gson;

import BaseDatos.ConsultaBD;

public enum TipoHabitacion {
	SALA(), COMEDOR(), BALCON(), GARAJE(), COCINA(), BANIO(), DORMITORIO(), SUITE();

	
	private final double preciom2;
	private ConsultaBD bd = new ConsultaBD();
	private Gson gson;

	
	TipoHabitacion() {
		this.preciom2 = 2;//consultarPrecio();
	}

	public double getPreciom2() {
		return this.preciom2;
	}
	
	private double consultarPrecio() {
		String json = bd.consultarToGson("SELECT `precio` 'auxiliar' FROM `tipohabitacion` WHERE `tipoHabitacion` = '"+this.toString()+"'");
		gson = new Gson();
		Global[] precio = gson.fromJson(json, Global[].class);
		return (double)precio[0].getAuxiliar();
	}

	public String toString() {
		return super.toString().replaceAll("_", " ").toUpperCase();
	}
	
	public String nombreToString() {
		String aux= super.toString();
		aux=aux.substring(0, 1).toUpperCase() + aux.substring(1);
		return aux;
	}
}
