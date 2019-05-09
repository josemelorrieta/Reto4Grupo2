package modelo;

public class Habitacion {
	
	protected int idHab;
	protected int m2;
	protected TipoHabitacion tipoHabitacion;
	protected double precio=0;

	public Habitacion() {
		this.tipoHabitacion=TipoHabitacion.DEFAULT;
	}
	
	public Habitacion(int idHab, int m2, TipoHabitacion tipoHabitacion) {
		this.idHab = idHab;
		this.m2 = m2;
		this.tipoHabitacion=tipoHabitacion;
		calcularPrecio();
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
		this.precio=tipoHabitacion.getPreciom2()*m2;
	}

	public TipoHabitacion getTipoHabitacion() {
		return tipoHabitacion;
	}
	
	protected void calcularPrecio() {
		this.precio=tipoHabitacion.getPreciom2()*m2;
	}

	public void setTipoHabitacion(TipoHabitacion tipoHabitacion) {
		this.tipoHabitacion = tipoHabitacion;
		calcularPrecio();
	}

	public double getPrecio() {
		return precio;
	}
}
