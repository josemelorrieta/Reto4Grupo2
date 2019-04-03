package modelo;

public class Hotel extends Alojamiento {
	private int estrellas;

	public Hotel(String nombre, Direccion ubicacion, Habitacion[] arrayHabitaciones, int estrellas) {
		super(nombre, ubicacion, arrayHabitaciones);
		this.estrellas = estrellas;
	}

	public Hotel(String nombre, Direccion ubicacion, Habitacion[] arrayHabitaciones) {
		super(nombre, ubicacion, arrayHabitaciones);
	}

	public Hotel() {

	}

	public int getEstrellas() {
		return estrellas;
	}

	public void setEstrellas(int estrellas) {
		this.estrellas = estrellas;
	}
}
