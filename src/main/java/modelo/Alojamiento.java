package modelo;

public class Alojamiento {
	private String nombre;
	private Direccion ubicacion;
	private Habitacion[] arrayHabitaciones;
	
	public Alojamiento(String nombre, Direccion ubicacion, Habitacion[] arrayHabitaciones) {
		this.nombre = nombre;
		this.ubicacion = ubicacion;
		this.arrayHabitaciones = arrayHabitaciones;
	}
	public Alojamiento() {
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public Direccion getUbicacion() {
		return ubicacion;
	}
	public void setUbicacion(Direccion ubicacion) {
		this.ubicacion = ubicacion;
	}
	public Habitacion[] getArrayHabitaciones() {
		return arrayHabitaciones;
	}
	public void setArrayHabitaciones(Habitacion[] arrayHabitaciones) {
		this.arrayHabitaciones = arrayHabitaciones;
	}
	
	
}
