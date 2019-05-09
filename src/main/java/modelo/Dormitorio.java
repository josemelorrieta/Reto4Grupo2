package modelo;

public class Dormitorio extends Habitacion {

	private Mobiliario[] mobiliario;
	private boolean disponible;

	public Dormitorio(int idHab, int m2,Mobiliario[] mobi) {
		super(idHab, m2, TipoHabitacion.DORMITORIO);
		this.mobiliario = mobi;
		this.disponible=true;
		this.calcularPrecio();
	}

	public void setM2(int m2) {
		this.m2 = m2;
		calcularPrecio();
	}
	
	public Mobiliario[] getMobiliario() {
		return mobiliario;
	}

	public void setMobiliario(Mobiliario[] mobiliario) {
		this.mobiliario = mobiliario;
		calcularPrecio();
	}

	public boolean isDisponible() {
		return disponible;
	}

	public void setDisponible(boolean disponible) {
		this.disponible = disponible;
	}

	protected void calcularPrecio() {
		super.calcularPrecio();
		for (Mobiliario mob : this.mobiliario) {
			this.precio += mob.getPrecio();
		}
	}
}
