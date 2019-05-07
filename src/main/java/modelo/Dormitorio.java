package modelo;

public class Dormitorio extends Habitacion {

	private Mobiliario[] mobiliario;
	private boolean disponible;

	public Dormitorio(int idHab, int m2) {
		super(idHab, m2, TipoHabitacion.DORMITORIO);
		this.mobiliario = mobiliario;
		precioDormitorio();
	}

	public void setM2(int m2) {
		this.m2 = m2;
		precioDormitorio();
	}
	
	public Mobiliario[] getMobiliario() {
		return mobiliario;
	}

	public void setMobiliario(Mobiliario[] mobiliario) {
		this.mobiliario = mobiliario;
		precioDormitorio();
	}

	public boolean isDisponible() {
		return disponible;
	}

	public void setDisponible(boolean disponible) {
		this.disponible = disponible;
	}

	private void precioDormitorio() {
		this.precio = tipoHabitacion.getPreciom2() * m2;
		for (Mobiliario mob : this.mobiliario) {
			this.precio += mob.getPrecio();
		}
	}
}
