package modelo;

/**
 * Clase Habitacion modelo de las habitaciones en el programa
 *
 */
public class Habitacion {

	protected int idHab;
	protected int m2;
	protected TipoHabitacion tipoHabitacion;
	protected double precio = 0;

	/**
	 * Constructor vacio
	 */
	public Habitacion() {
		this.tipoHabitacion = TipoHabitacion.DEFAULT;
	}

	/**
	 * Calcula el precio de la habitacion
	 * @param precioM2 double precio por metro cuadrado
	 * @return double precio de habitacion
	 */
	public double calcularPrecio(double precioM2) {
		this.precio = precioM2 * m2;
		return this.precio;
	}

	/**
	 * Metodo que devuelve el ID de la habitacion
	 * @return idHab
	 */
	public int getIdHab() {
		return idHab;
	}

	/**
	 * Metodo que cambia el ID de la habitacion
	 * @param idHab
	 */
	public void setIdHab(int idHab) {
		this.idHab = idHab;
	}

	/**
	 * Metodo que devuelve los metros cuadrados de la habitacion
	 * @return m2
	 */
	public int getM2() {
		return m2;
	}

	/**
	 * Metodo que cambia los metros cuadrados de la habitacion
	 * @param m2
	 */
	public void setM2(int m2) {
		this.m2 = m2;
	}

	/**
	 * Metodo que devuelve el tipo de la habitacion
	 * @return tipoHabitacion
	 */
	public TipoHabitacion getTipoHabitacion() {
		return tipoHabitacion;
	}

	/**
	 * Metodo que cambia el tipo de la habitacion
	 * @param tipoHabitacion
	 */
	public void setTipoHabitacion(TipoHabitacion tipoHabitacion) {
		this.tipoHabitacion = tipoHabitacion;
	}

	/**
	 * Metodo que cambia el precio de la habitacion
	 * @param precio
	 */
	public void setPrecio(double precio) {
		this.precio = precio;
	}
	
	/**
	 * Metodo que devuelve el precio de la habitacion
	 * @return precio
	 */
	public double getPrecio() {
		return this.precio;
	}
	

}
