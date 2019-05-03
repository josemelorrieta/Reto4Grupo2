package modelo;

public class Mobiliario {
	
	protected String nombre;
	protected double precio;

	public Mobiliario() {
	
	}
	
	public Mobiliario(String nombre) {
		this.nombre = nombre;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	
	
}
