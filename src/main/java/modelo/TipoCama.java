package modelo;

import com.google.gson.Gson;

import BaseDatos.ConsultaBD;

public enum TipoCama {
	INDIVIDUAL(), MATRIMONIO(), INFANTIL(),DEFAULT("");

	private final double precio;
	private ConsultaBD bd = new ConsultaBD();
	private Gson gson;

	TipoCama() {
		this.precio = consultarPrecio();
	}
	TipoCama(String def) {
		this.precio = 0;
	}

	public double getPrecio() {
		return this.precio;
	}

	private double consultarPrecio() {
		String json = bd.consultarToGson("SELECT `precio` 'auxiliar' FROM `cama` WHERE `tipoCama` = '" + this.toString() + "'");
		gson = new Gson();
		Global[] precio = gson.fromJson(json, Global[].class);
		return (double) precio[0].getAuxiliar();
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
