package modelo;

public class Habitacion {
	protected int idHab;
	protected int m2;
	protected Mobiliario[] arrayMobiliario;
	protected Cama[] arrayCamas;
	protected TipoHabitacion tipoHabitacion;
	
	public Habitacion(int idHab, int m2, Mobiliario[] arrayMobiliario, Cama[] arrayCamas,TipoHabitacion tipoHabitacion) {
		this.idHab = idHab;
		this.m2 = m2;
		this.arrayMobiliario = arrayMobiliario;
		this.arrayCamas = arrayCamas;
		this.tipoHabitacion=tipoHabitacion;
	}
	
	public Habitacion() {
	}

	public int getIdHab() {
		return idHab;
	}

	public void setIdHab(int idHab) {
		this.idHab = idHab;
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
	
	public Cama[] getArrayCamas() {
		return arrayCamas;
	}

	public void setArrayCamas(Cama[] arrayCamas) {
		this.arrayCamas = arrayCamas;
	}

	public TipoHabitacion getTipoHabitacion() {
		return tipoHabitacion;
	}

	public void setTipoHabitacion(TipoHabitacion tipoHabitacion) {
		this.tipoHabitacion = tipoHabitacion;
	}

	

}
