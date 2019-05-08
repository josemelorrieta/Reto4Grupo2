package modelo;

import java.util.Calendar;
import java.util.Date;

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
		precio += res.getDormitorioReservado().getPrecio();

		return precio;
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
