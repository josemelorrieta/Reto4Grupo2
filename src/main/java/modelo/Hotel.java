package modelo;

public class Hotel extends Alojamiento {
	private Dormitorio[] dormitorios;
	private int numEstrellas;

	public Hotel() {

	}

	public Hotel(int id, String nombre, Direccion direccion, double precioA, double precioB, double precioF, String imagen, boolean disponible, Dormitorio[] dormitorios, int numEstrellas) {
		super(id, nombre, direccion, precioA, precioB, precioF, imagen, disponible);
		this.dormitorios = dormitorios;
		this.numEstrellas = numEstrellas;
	}

	public int numCamas() {
		int cont = 0;
		if (this.dormitorios != null)
			for (Dormitorio dorm : this.dormitorios) {
				if (dorm.getMobiliario() == null)
					continue;
				for (Mobiliario mobi : dorm.getMobiliario()) {
					if (mobi instanceof Cama) {
						cont += 1;
					}
				}
			}
		return cont;
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

}
