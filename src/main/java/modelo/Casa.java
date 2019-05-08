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

	public Casa(int id, String nombre, Direccion direccion, double precioA, double precioB, double precioF, String imagen, boolean disponible, Habitacion[] habitaciones) {
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
	 * Calcula el precio base de la casa
	 * 
	 * @param festivos array de fechas festivas
	 * @return el precio base de la casa, se le debe sumar el precio individual de
	 *         cada habitacion reservada, tiene en cuenta las habitaciones que no
	 *         sean dormitorios
	 */
	public double calcularPrecioBaseCasa(Calendar[] festivos,Reserva res) {
		Calendar fechaEntrada = Calendar.getInstance();
		Calendar fechaSalida = Calendar.getInstance();

		fechaEntrada.setTime(res.getFechaEntrada());
		fechaSalida.setTime(res.getFechaSalida());

		double precio = 0, precioTemp = 0;

		if (fechaEntrada.get(Calendar.MONTH) > Calendar.MAY && fechaEntrada.get(Calendar.MONTH) < Calendar.OCTOBER) {
			precioTemp = this.precioTAlta;
		} else {
			precioTemp = this.precioTBaja;
		}
		precio += precioTemp;

		fechaSalida.add(Calendar.DAY_OF_MONTH, 1);
		fechaEntrada.add(Calendar.DAY_OF_MONTH, -1);

		if (festivos != null) {
			for (Calendar fest : festivos) {
				if (fest.before(fechaSalida) && fest.after(fechaEntrada)) {
					precio += precioTemp * 1.75;
				}
			}
		}
		for (Habitacion hab : habitaciones) {
			if (!(hab instanceof Dormitorio)) {
				precio += hab.getPrecio();
			}
		}
		return precio;
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
