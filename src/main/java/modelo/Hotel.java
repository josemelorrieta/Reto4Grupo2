package modelo;

public class Hotel extends Alojamiento {
	private int estrellas;

	public Hotel(int id, String nombre, Direccion ubicacion, Suite[] arrayHabitaciones, Double precioA, Double precioB, Double precioF, String imagen) {
		super(id, nombre, ubicacion, arrayHabitaciones, precioA, precioB, precioF, imagen);
	}

	public Hotel(int id, String nombre, Direccion ubicacion, Suite[] arrayHabitaciones, Double precioA, Double precioB, Double precioF, String imagen, int estrellas) {
		super(id, nombre, ubicacion, arrayHabitaciones, precioA, precioB, precioF, imagen);
		this.estrellas = estrellas;
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
