package modelo;

/**
 * Clase Cama que extiende Mobiliario con el enum TipoCama como parametro adicional
 *
 */
public class Cama extends Mobiliario {
	private TipoCama tipoCama;

	/**
	 * Crea un objeto de tipo cama, invoca el super paraa especificar el tipo de mobiliario a CAMA
	 * @param tipoCama enum TipoCama
	 */
	public Cama(TipoCama tipoCama) {
		super(TipoMobiliario.CAMA);
		this.tipoCama = tipoCama;
	}

	public TipoCama getTipoCama() {
		return this.tipoCama;
	}

	public double getPrecio() {
		return this.tipoCama.getPrecio();
	}
}
