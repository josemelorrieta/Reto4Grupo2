package modelo;

import java.util.Date;

/**
 * Clase reserva, guarda el alojamiento elegido, fechas, precio etc
 *
 */
public class Reserva {
	private Cliente cliente;
	private DesglosePrecio desglose;
	private Date fechaReserva;
	private Date fechaEntrada;
	private Date fechaSalida;
	private Alojamiento alojReservado;
	private Dormitorio dormitorioReservado;
	private String codPromocional; 
	private String codPromocionalGenerado;
	
	/**
	 * Crea una reserva nueva
	 */
	public Reserva() {
		// Constructor por defecto
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

	public String getCodPromocional() {
		return codPromocional;
	}
	public void setCodPromocional(String codPromocional) {
		this.codPromocional = codPromocional;
	}

	public String getCodPromocionalGenerado() {
		return codPromocionalGenerado;
	}

	public void setCodPromocionalGenerado(String codPromocionalGenerado) {
		this.codPromocionalGenerado = codPromocionalGenerado;
	}
		
}

