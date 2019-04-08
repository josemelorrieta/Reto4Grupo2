package modelo;

public class Hotel extends Alojamiento {
	private int estrellas;

	public Hotel(String nombre, Direccion ubicacion, Suite[] arrayHabitaciones, Double precioA, Double precioB, Double precioF) {
		super(nombre, ubicacion, arrayHabitaciones, precioA, precioB, precioF);
	}

	public Hotel(String nombre, Direccion ubicacion, Suite[] arrayHabitaciones, Double precioA, Double precioB, Double precioF, int estrellas) {
		super(nombre, ubicacion, arrayHabitaciones, precioA, precioB, precioF);
		this.estrellas = estrellas;
	}

	
	//const temporal
	public Hotel(String nombre, Double precioTAlta, Double precioTBaja, Double precioTFest, int estrellas) {
		super(nombre, precioTAlta, precioTBaja, precioTFest);
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
