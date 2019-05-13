package modelo;

public class Dormitorio extends Habitacion {

	private Mobiliario[] mobiliario;
	private boolean disponible;

	public Dormitorio() {
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

	protected double calcularPrecio(double precioM2) {
		super.calcularPrecio(precioM2);
		for (Mobiliario mob : this.mobiliario) {
			this.precio += mob.getPrecio();
		}
		return this.precio;
	}
}
