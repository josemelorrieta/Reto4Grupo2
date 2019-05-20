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
	 * @param mobiliario
	 */
	public Mobiliario(TipoMobiliario mobiliario) {
		this.tipoMobiliario=mobiliario;
		this.nombre=this.tipoMobiliario.nombreToString();
	}

	public String getNombre() {
		return nombre;
	}
	
	public TipoMobiliario getTipoMobiliario() {
		return tipoMobiliario;
	}

	public double getPrecio() {
		return tipoMobiliario.getPrecio();
	}
}
