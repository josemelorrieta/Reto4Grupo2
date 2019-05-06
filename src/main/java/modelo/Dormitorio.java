package modelo;

public class Dormitorio extends Habitacion{

	private Mobiliario[] mobiliario;

	public Dormitorio() {
		
	}
	
	public Dormitorio(int idHab, int m2) {
		super(idHab, m2, TipoHabitacion.DORMITORIO);
	}
	
	public Dormitorio(int idHab, int m2, Mobiliario[] mobiliario) {
		super(idHab, m2, TipoHabitacion.DORMITORIO);
		this.mobiliario = mobiliario;
	}
	
	public Mobiliario[] getMobiliario() {
		return mobiliario;
	}

	public void setMobiliario(Mobiliario[] mobiliario) {
		this.mobiliario = mobiliario;
	}
	
	public void precioDormitorio() {
		for(Mobiliario mob:this.mobiliario) {
			this.precio+=mob.getPrecio();
		}
	}
}
