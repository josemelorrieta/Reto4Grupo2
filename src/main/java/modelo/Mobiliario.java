package modelo;

/**
 * Clase Mobiliario
 *
 */
public class Mobiliario {
	
	protected String nombre;
	protected TipoMobiliario tipoMobiliario;

	/**
	 * Constructor para un nuevo objeto tipo mobiliario
	 * @param mobiliario tipo de mobiliario
	 */
	public Mobiliario(TipoMobiliario mobiliario) {
		this.tipoMobiliario=mobiliario;
		this.nombre=this.tipoMobiliario.nombreToString();
	}

	/**
	 * Metodo que devuelve el nombre del mobiliario
	 * @return nombre del mobiliario
	 */
	public String getNombre() {
		return nombre;
	}
	
	/**
	 * Metodo que devuelve el tipo de mobiliario
	 * @return tipo de mobiliario
	 */
	public TipoMobiliario getTipoMobiliario() {
		return tipoMobiliario;
	}

	/**
	 * Metodo que devuelbe el precio del mobiliario
	 * @return precio del mobiliario
	 */
	public double getPrecio() {
		return tipoMobiliario.getPrecio();
	}
}
