package modelo;

public class Hotel extends Alojamiento {
	private int numEstrellas;

	public int numCamas() {
		int cont = 0;
		if (this.habitaciones != null)
			for (Dormitorio dorm : (Dormitorio[]) this.habitaciones) {
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


	public int getNumEstrellas() {
		return numEstrellas;
	}

	public void setNumEstrellas(int estrellas) {
		this.numEstrellas = estrellas;
	}

}
