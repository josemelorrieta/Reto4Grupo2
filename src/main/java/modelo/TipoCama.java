package modelo;

import com.google.gson.Gson;

import BaseDatos.ConsultaBD;

/**
 * Enum TipoCama 
 * TipoCama que indica el tipo de las camas
 */
public enum TipoCama {
	INDIVIDUAL(), MATRIMONIO(), INFANTIL(),DEFAULT("");

	private final double precio;
	private ConsultaBD bd = new ConsultaBD();
	private Gson gson;

	/**
	 * Constructor del enum, consulta el precio en la base de datos
	 */
	TipoCama() {
		this.precio = consultarPrecio();
	}
	/**
	 * Constructor por defecto
	 * @param def 
	 */
	TipoCama(String def) {
		this.precio = 0;
	}

	public double getPrecio() {
		return this.precio;
	}

	/**
	 * Consulta el precio en la base de datos
	 * @return 
	 */
	private double consultarPrecio() {
		String json = bd.consultarToGson("SELECT `precio` 'auxiliar' FROM `cama` WHERE `tipoCama` = '" + this.toString() + "'");
		gson = new Gson();
		Global[] precio = gson.fromJson(json, Global[].class);
		return (double) precio[0].getAuxiliar();
	}
	
	/**
	 * Metodo toString
	 */
	public String toString() {
		return super.toString().replaceAll("_", " ").toUpperCase();
	}
	
	/**
	 * Saca el nombre del enum con formato de impresion
	 * @return string nombre
	 */
	public String nombreToString() {
		String aux= super.toString();
		aux=aux.substring(0, 1).toUpperCase() + aux.substring(1);
		return aux;
	}
}
