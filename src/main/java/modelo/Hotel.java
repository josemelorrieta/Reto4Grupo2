package modelo;

import java.util.Calendar;

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

	public double calcularPrecioBaseHotel(Calendar[] festivos, Reserva res) {
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
		precio += res.getDormitorioReservado().calcularPrecio(res.getAlojReservado().getPvpM2());

		return precio;
	}


	public int getNumEstrellas() {
		return numEstrellas;
	}

	public void setNumEstrellas(int estrellas) {
		this.numEstrellas = estrellas;
	}

}
