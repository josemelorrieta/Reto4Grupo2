package modelo;

import java.util.Calendar;

public class Casa extends Alojamiento {
	protected Habitacion[] habitaciones;
	protected int numBanios;
	protected int m2;

	public Casa() {

	}

	public Casa(int id, String nombre, Direccion direccion, double precioA, double precioB, double precioF, String imagen, boolean disponible) {
		super(id, nombre, direccion, precioA, precioB, precioF, imagen, disponible);
	}

	public Casa(int id, String nombre, Direccion direccion, double precioA, double precioB, double precioF, String imagen, boolean disponible, Habitacion[] habitaciones, int numBanios, int m2) {
		super(id, nombre, direccion, precioA, precioB, precioF, imagen, disponible);
		this.habitaciones = habitaciones;
		setNumBanios();
		setM2();
	}

	public Habitacion[] getHabitaciones() {
		return habitaciones;
	}

	public void setHabitaciones(Habitacion[] habitaciones) {
		this.habitaciones = habitaciones;
	}

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

	/**
	 * Calcula el precio de la 
	 * @param casa
	 * @param index
	 * @return
	 */
	public double calcularPrecioCasa(int indexHab) {
		Calendar fechaAct= Calendar.getInstance();
		double precio=0;
		
		for (Habitacion hab : habitaciones) {
			precio+=hab.getPrecio();
		}
		
		if(fechaAct.get(Calendar.MONTH)>Calendar.MAY && fechaAct.get(Calendar.MONTH)<Calendar.OCTOBER) {
			precio+=this.precioTAlta;
		}else {
			precio+=this.precioTBaja;
		}
		
		return 0;
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
