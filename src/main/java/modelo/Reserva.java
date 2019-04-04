package modelo;

import java.util.Date;

public class Reserva {
	private Cliente cliente;
	private double precio;
	private Date fechaReserva;
	private Date fechaEntrada;
	private Date fechaSalida;
	
	
	
	public Reserva() {
	}

	public Reserva(Cliente cliente, double precio, Date fechaReserva, Date fechaEntrada, Date fechaSalida) {
		this.cliente = cliente;
		this.precio = precio;
		this.fechaReserva = fechaReserva;
		this.fechaEntrada = fechaEntrada;
		this.fechaSalida = fechaSalida;
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
	
	
	
	
}

