package modelo;

import java.util.Date;

public class Reserva {
	private Cliente cliente;
	private DesglosePrecio desglose;
	private Date fechaReserva;
	private Date fechaEntrada;
	private Date fechaSalida;
	private Alojamiento alojReservado;
	private Dormitorio dormitorioReservado;

	public Reserva() {
		// Constructor por defecto
	}

	public Reserva(Cliente cliente, DesglosePrecio desglose, Date fechaReserva, Date fechaEntrada, Date fechaSalida, Alojamiento alojReservado) {
		this.cliente = cliente;
		this.desglose = desglose;
		this.fechaReserva = fechaReserva;
		this.fechaEntrada = fechaEntrada;
		this.fechaSalida = fechaSalida;
		this.alojReservado = alojReservado;
		this.dormitorioReservado = null;
	}

	public Reserva(Cliente cliente, DesglosePrecio desglose, Date fechaReserva, Date fechaEntrada, Date fechaSalida, Alojamiento alojReservado, Dormitorio dormitorioReservado) {
		this.cliente = cliente;
		this.desglose = desglose;
		this.fechaReserva = fechaReserva;
		this.fechaEntrada = fechaEntrada;
		this.fechaSalida = fechaSalida;
		this.alojReservado = alojReservado;
		this.dormitorioReservado = dormitorioReservado;
	}

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	public DesglosePrecio getDesglose() {
		return desglose;
	}

	public void setDesglose(DesglosePrecio desglose) {
		this.desglose = desglose;
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

	public Dormitorio getDormitorioReservado() {
		return dormitorioReservado;
	}

	public void setDormitorioReservado(Dormitorio dormitorioReservado) {
		this.dormitorioReservado = dormitorioReservado;
	}

}
