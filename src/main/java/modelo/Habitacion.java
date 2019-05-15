package modelo;

public class Habitacion {

	protected int idHab;
	protected int m2;
	protected TipoHabitacion tipoHabitacion;
	protected double precio = 0;

	public Habitacion() {
		this.tipoHabitacion = TipoHabitacion.DEFAULT;
	}

	public double calcularPrecio(double precioM2) {
		this.precio = precioM2 * m2;
		return this.precio;
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

	public void setPrecio(double precio) {
		this.precio = precio;
	}
	
	public double getPrecio() {
		return this.precio;
	}
	

}
