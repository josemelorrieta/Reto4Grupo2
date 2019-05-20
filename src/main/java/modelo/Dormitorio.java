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
		disponible = false;
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

	/**
	 * Cuenta el numero de camas entre todos los dormitorios del array de
	 * habitaciones
	 * 
	 * @return int numero de camas
	 */
	public int capacidad() {
		int cont = 0;
		for (Mobiliario mobi : this.mobiliario) {
			if (mobi instanceof Cama) {
				TipoCama tipo=((Cama) mobi).getTipoCama();
				if(tipo==TipoCama.INDIVIDUAL || tipo==TipoCama.INFANTIL) {
					cont++;
				}else if(tipo==TipoCama.MATRIMONIO) {
					cont+=2;
				}
			}
		}
		return cont;
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
