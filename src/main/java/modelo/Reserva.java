package modelo;

import java.util.Date;

public class Reserva {
	protected Cliente cliente;
	protected double precio;
	protected Date fechaReserva;
	protected Date fechaEntrada;
	protected Date fechaSalida;
	protected Alojamiento alojReservado;
	
	
	
	public Reserva(Cliente cliente, double precio, Date fechaReserva, Date fechaEntrada, Date fechaSalida, Alojamiento alojReservado) {
		this.cliente = cliente;
		this.precio = precio;
		this.fechaReserva = fechaReserva;
		this.fechaEntrada = fechaEntrada;
		this.fechaSalida = fechaSalida;
		this.alojReservado = alojReservado;
	}

	public Reserva() {
	}

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	public double getPrecio() {
		return precio;
	}

	public void setPrecio(double precio) {
		this.precio = precio;
	}

	public Date getFechaReserva() {
		return fechaReserva;
	}

	public void setFechaReserva(Date fechaReserva) {
		this.fechaReserva = fechaReserva;
	}

	public Date getFechaEntrada() {
		return fechaEntrada;
	}

	public void setFechaEntrada(Date fechaEntrada) {
		this.fechaEntrada = fechaEntrada;
	}

	public Date getFechaSalida() {
		return fechaSalida;
	}

	public void setFechaSalida(Date fechaSalida) {
		this.fechaSalida = fechaSalida;
	}

	public Alojamiento getAlojReservado() {
		return alojReservado;
	}

	public void setAlojReservado(Alojamiento alojReservado) {
		this.alojReservado = alojReservado;
	}
	
	
	
	
}


