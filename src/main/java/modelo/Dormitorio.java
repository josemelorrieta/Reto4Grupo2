package modelo;

public class Dormitorio extends Habitacion{

	private Mobiliario[] mobiliario;

	public Dormitorio() {
		
	}
	
	public Dormitorio(int idHab, int m2, TipoHabitacion tipoHabitacion) {
		super(idHab, m2, tipoHabitacion);
	}
	
	public Dormitorio(int idHab, int m2, TipoHabitacion tipoHabitacion, Mobiliario[] mobiliario) {
		super(idHab, m2, tipoHabitacion);
		this.mobiliario = mobiliario;
	}
	
	public Mobiliario[] getMobiliario() {
		return mobiliario;
	}

	public void setMobiliario(Mobiliario[] mobiliario) {
		this.mobiliario = mobiliario;
	}
}
