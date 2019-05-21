package modelo;

/**
 * Clase Casa que extiende alojamiento con atributos adicionales
 *
 */
public class Casa extends Alojamiento {
	protected int numBanios=0;
	protected int m2;
	
	/**
	 * Metodo que devuelve el numero de banios de la casa
	 * @return numBanios
	 */
	public int getNumBanios() {
		return numBanios;
	}

	/**
	 * Cuenta el numero de banios en el alojamiento
	 */
	public void setNumBanios() {
		for (Habitacion habitacion : habitaciones) {
			if (habitacion.tipoHabitacion == TipoHabitacion.BANIO)
				this.numBanios++;
		}
	}

	/**
	 * Metodo que devuelve los metros cuadrados de la casa
	 * @return m2
	 */
	public int getM2() {
		return m2;
	}

	/**
	 * Calcula el numero de metros cuadrados en el alojamiento
	 */
	public void setM2() {
		for (Habitacion habitacion : habitaciones)
			m2 += habitacion.getM2();
	}

	/**
	 * Cuenta el numero de camas entre todos los dormitorios del array de habitaciones
	 * @return int numero de camas
	 */
	public int numCamas() {
		int cont = 0;
		if (this.habitaciones != null)
			for (Habitacion hab : this.habitaciones) {
				if (hab.tipoHabitacion == TipoHabitacion.DORMITORIO) {
					if (((Dormitorio) hab).getMobiliario() == null) {
						continue;
					}
					for (Mobiliario mobi : ((Dormitorio) hab).getMobiliario()) {
						if (mobi instanceof Cama) {
							TipoCama tipo=((Cama) mobi).getTipoCama();
							if(tipo==TipoCama.INDIVIDUAL || tipo==TipoCama.INFANTIL) {
								cont++;
							}else if(tipo==TipoCama.MATRIMONIO) {
								cont+=2;
							}
						}
					}
				}
			}
		return cont;
	}
}
