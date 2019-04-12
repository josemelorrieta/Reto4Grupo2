package modelo;

public class Casa extends Alojamiento{
	protected Habitacion[] habitaciones;
	protected int numBanios;
	protected int m2;
	
	public Casa() {
		
	}
	
	public Casa(int id, String nombre, Direccion direccion, double precioA, double precioB, double precioF, String imagen) {
		super(id, nombre, direccion, precioA, precioB, precioF, imagen);
	}
	
	public Casa(int id, String nombre, Direccion direccion, double precioA, double precioB, double precioF, String imagen, Habitacion[] habitaciones, int numBanios, int m2) {
		super(id, nombre, direccion, precioA, precioB, precioF, imagen);
		this.habitaciones = habitaciones;
		this.numBanios = numBanios;
		this.m2 = m2;
	}

	public Habitacion[] getHabitaciones() {
		return habitaciones;
	}

	public void setHabitaciones(Habitacion[] habitaciones) {
		this.habitaciones = habitaciones;
	}

	public int getNumBanios() {
		return numBanios;
	}

	public void setNumBanios(int numBanios) {
		this.numBanios = numBanios;
	}

	public int getM2() {
		return m2;
	}

	public void setM2(int m2) {
		this.m2 = m2;
	}
	
}
