package modelo;

import java.util.Calendar;

public class Casa extends Alojamiento {
	protected int numBanios;
	protected int m2;
	
	public int getNumBanios() {
		return numBanios;
	}

	public void setNumBanios() {
		for (Habitacion habitacion : habitaciones) {
			if (habitacion.tipoHabitacion == TipoHabitacion.BANIO)
				numBanios++;
		}
	}

	public int getM2() {
		return m2;
	}

	public void setM2() {
		for (Habitacion habitacion : habitaciones)
			m2 += habitacion.getM2();
	}

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
							cont += 1;
						}
					}
				}
			}
		return cont;
	}
}
