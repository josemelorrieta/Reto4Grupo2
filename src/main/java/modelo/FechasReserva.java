package modelo;

/**
 * Objeto FechasReserva para guardar informacion de las fechas reservadas con informacion de la base de datos
 *
 */
public class FechasReserva {
	private int idRsv;
	private int id;
	private String fechaIn;
	private String fechaOut;
	
	/**
	 * Constructor para guardar informacion de una reserva 
	 * @param idRsv id de la reserva
	 * @param idHab id de la habitacion reservada
	 * @param fechaIn fecha entrada
	 * @param fechaOut fecha salida
	 */
	public FechasReserva(int idRsv, int idHab, String fechaIn, String fechaOut) {
		this.idRsv = idRsv;
		this.id=idHab;
		this.fechaIn = fechaIn;
		this.fechaOut = fechaOut;
	}

	/**
	 * Metodo que devuelve el ID de la reserva
	 * @return idRsv
	 */
	public int getIdRsv() {
		return idRsv;
	}

	/**
	 * Metodo que cambia el ID de la reserva
	 * @param idRsv nuevo id para la reserva
	 */
	public void setIdRsv(int idRsv) {
		this.idRsv = idRsv;
	}

	/**
	 * Metodo que devuelve el ID de la habitacion reservada
	 * @return id
	 */
	public int getId() {
		return id;
	}

	/**
	 * Metodo que cambia el ID de la habitacion reservada
	 * @param idHab nuevo id para la habitacion reservada
	 */
	public void setId(int idHab) {
		this.id = idHab;
	}

	/**
	 * Metodo que devuelve la fecha de entrada
	 * @return fechaIn
	 */
	public String getFechaIn() {
		return fechaIn;
	}

	/**
	 * Metodo que cambia la fecha de entrada
	 * @param fechaIn nueva fecha de entrada de la reserva
	 */
	public void setFechaIn(String fechaIn) {
		this.fechaIn = fechaIn;
	}

	/**
	 * Metodo que devuelve la fecha de salida
	 * @return fechaOut
	 */
	public String getFechaOut() {
		return fechaOut;
	}

	/**
	 * Metodo que cambia la fecha de salida
	 * @param fechaOut nueva fecha de salida para la reserva
	 */
	public void setFechaOut(String fechaOut) {
		this.fechaOut = fechaOut;
	}
	
}
