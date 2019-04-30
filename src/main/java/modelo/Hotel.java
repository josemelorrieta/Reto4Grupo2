package modelo;

public class Hotel extends Alojamiento {
	private Dormitorio[] dormitorios;
	private int numEstrellas;
	public boolean[] dormDisponibles;
	
	public Hotel() {
		
	}

	public Hotel(int id, String nombre, Direccion direccion, double precioA, double precioB, double precioF, String imagen, boolean disponible, Dormitorio[] dormitorios, int numEstrellas, boolean[] dormDisponibles) {
		super(id, nombre, direccion, precioA, precioB, precioF, imagen, disponible);
		this.dormitorios = dormitorios;
		this.numEstrellas = numEstrellas;
		this.dormDisponibles = dormDisponibles;
	}

	public Dormitorio[] getDormitorios() {
		return dormitorios;
	}

	public void setDormitorios(Dormitorio[] dormitorios) {
		this.dormitorios = dormitorios;
	}

	public int getNumEstrellas() {
		return numEstrellas;
	}

	public void setNumEstrellas(int estrellas) {
		this.numEstrellas = estrellas;
	}

	public boolean[] getDormDisponibles() {
		return dormDisponibles;
	}

	public void setDormDisponibles(boolean[] dormDisponibles) {
		this.dormDisponibles = dormDisponibles;
	}
}
