package modelo;

/**
 * Clase Dormitrio que extiende habitacion
 *
 */
public class Dormitorio extends Habitacion {

	private Mobiliario[] mobiliario;
	private boolean disponible;

	/**
	 * Constructor vacio para inicializar la disponibilidad en false
	 */
	public Dormitorio() {
		disponible=false;
	}
	
	/**
	 * Calcula el precio del dormitorio teniendo en cuenta el mobiliario
	 */
	public double calcularPrecio(double precioM2) {
		super.calcularPrecio(precioM2);
		for (Mobiliario mob : this.mobiliario) {
			this.precio += mob.getPrecio();
		}
		return this.precio;
	}

	
	public Mobiliario[] getMobiliario() {
		return mobiliario;
	}

	public void setMobiliario(Mobiliario[] mobiliario) {
		this.mobiliario = mobiliario;
	}

	public boolean isDisponible() {
		return disponible;
	}

	public void setDisponible(boolean disponible) {
		this.disponible = disponible;
	}


}
