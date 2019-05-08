package modelo;

import java.util.Date;

public class Reserva {
	
	private Cliente cliente;
	private double precio;
	private Date fechaReserva;
	private Date fechaEntrada;
	private Date fechaSalida;
	private Alojamiento alojReservado;
	private Habitacion dormitorioReservado;
	
	public Reserva() {
		// Constructor por defecto
	}
	
	public Reserva(Cliente cliente, double precio, Date fechaReserva, Date fechaEntrada, Date fechaSalida, Alojamiento alojReservado) {
		this.cliente = cliente;
		this.precio = precio;
		this.fechaReserva = fechaReserva;
		this.fechaEntrada = fechaEntrada;
		this.fechaSalida = fechaSalida;
		this.alojReservado = alojReservado;
	}

	public Reserva(Cliente cliente, double precio, Date fechaReserva, Date fechaEntrada, Date fechaSalida, Alojamiento alojReservado, Habitacion dormitorioReservado) {
		this.cliente = cliente;
		this.precio = precio;
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

	public Habitacion getDormitorioReservado() {
		return dormitorioReservado;
	}
	public void setDormitorioReservado(Habitacion dormitorioReservado) {
		this.dormitorioReservado = dormitorioReservado;
	}
	
	public Object[] toObjectArray() {
		Object[] objeto = {0, this.cliente.getDni(), this.fechaReserva, this.fechaEntrada, this.fechaSalida, this.precio};
		return objeto;
	}
	
	
}


