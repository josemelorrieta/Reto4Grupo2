package modelo;

import com.google.gson.Gson;

import BaseDatos.ConsultaBD;

/**
 * Enum - Saca los mobiliarios de la base de datos
 *
 */
public enum TipoMobiliario {

	ARMARIO(),MESITA_DE_NOCHE(),LAMPARA(),CAMA(""),DEFAULT("");

	private final double precio;

	/**
	 * Constructor que consulta el precio en la base de datos
	 */
	TipoMobiliario() {
		this.precio = consultarPrecio();
	}
	
	/**
	 * Constructor por defecto
	 * @param aux
	 */
	TipoMobiliario(String aux){
		this.precio=0;
	}

	public double getPrecio() {
		return this.precio;
	}

	/**
	 * Consulta el precio en la base de datos
	 */
	private double consultarPrecio() {
		ConsultaBD bd = new ConsultaBD();
		Gson gson= new Gson();
		String json = bd.consultarToGson("SELECT `precio` 'auxiliar' FROM `mobiliario` WHERE `tipoMob` = '" + super.toString() + "'");
		Global[] precio = gson.fromJson(json, Global[].class);
		return (double) precio[0].getAuxiliar();
	}
	
	/**
	 * Devuelve el nombre del enum en formato de impresion
	 * @return
	 */
	public String nombreToString() {
		String aux= super.toString();
		aux=aux.substring(0, 1).toUpperCase() + aux.substring(1);
		return aux;
	}
}
