package modelo;

public class Habitacion {
	
	protected int idHab;
	protected int m2;
	protected TipoHabitacion tipoHabitacion;
	protected double precio;
	
	public Habitacion() {
		
	}
	
	public Habitacion(int idHab, int m2, TipoHabitacion tipoHabitacion) {
		this.idHab = idHab;
		this.m2 = m2;
		this.tipoHabitacion=tipoHabitacion;
		this.precio=tipoHabitacion.getPreciom2()*m2;
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

	public TipoHabitacion getTipoHabitacion() {
		return tipoHabitacion;
	}

	public void setTipoHabitacion(TipoHabitacion tipoHabitacion) {
		this.tipoHabitacion = tipoHabitacion;
	}

	public double getPrecio() {
		return precio;
	}

	public void setPrecio(double precio) {
		this.precio = precio;
	}

	

}
