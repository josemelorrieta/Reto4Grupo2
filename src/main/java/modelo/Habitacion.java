package modelo;

public class Habitacion {
	protected int m2;
	protected Mobiliario[] arrayMobiliario;
	protected TipoHabitacion tipoHabitacion;
	
	public Habitacion(int m2, Mobiliario[] arrayMobiliario,TipoHabitacion tipoHabitacion) {
		this.m2 = m2;
		this.arrayMobiliario = arrayMobiliario;
		this.tipoHabitacion=tipoHabitacion;
	}
	
	public Habitacion() {
	}

	public int getM2() {
		return m2;
	}
	public void setM2(int m2) {
		this.m2 = m2;
	}
	public Mobiliario[] getArrayMobiliario() {
		return arrayMobiliario;
	}
	public void setArrayMobiliario(Mobiliario[] arrayMobiliario) {
		this.arrayMobiliario = arrayMobiliario;
	}
	
	public TipoHabitacion getTipoHabitacion() {
		return tipoHabitacion;
	}

	public void setTipoHabitacion(TipoHabitacion tipoHabitacion) {
		this.tipoHabitacion = tipoHabitacion;
	}

	

}
