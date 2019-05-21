package modelo;

/**
 * Clase Direccion para guardar informacion relativa a la ubicacion del alojamiento
 * @author IN1DM3B_08
 *
 */
public class Direccion {
	private String calle;
	private int codPostal;
	private String localidad;
	
	/**
	 * Constructor con informacion de la direccion
	 * @param calle string 
	 * @param codPostal string 
	 * @param localidad string
	 */
	public Direccion(String calle, int codPostal, String localidad) {
		this.calle = calle;
		this.codPostal = codPostal;
		this.localidad = localidad;
	}
	
	/**
	 * Constructor vacio
	 */
	public Direccion() {
	}
	
	/**
	 * Metodo que devuelve la calle de la direccion
	 * @return calle
	 */
	public String getCalle() {
		return calle;
	}
	
	/**
	 * Metodo que cambia la calle de la direccion
	 * @param calle
	 */
	public void setCalle(String calle) {
		this.calle = calle;
	}
	
	/**
	 * Metodo que devuelve el codigo postal de la direccion
	 * @return codPostal
	 */
	public int getCodPostal() {
		return codPostal;
	}
	
	/**
	 * Metodo que cambia el codigo postal de la direccion
	 * @param codPostal
	 */
	public void setCodPostal(int codPostal) {
		this.codPostal = codPostal;
	}
	
	/**
	 * Metodo que devuelve la localidad de la direccion
	 * @return localidad
	 */
	public String getLocalidad() {
		return localidad;
	}
	
	/**
	 * Metodo que cambia la localidad de la direccion
	 * @param localidad
	 */
	public void setLocalidad(String localidad) {
		this.localidad = localidad;
	}
	
	
}


