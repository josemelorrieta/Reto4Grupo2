package modelo;

public class FechasReserva {
	private int idRsv;
	private int id;
	private String fechaIn;
	private String fechaOut;
	
	public FechasReserva(int idRsv, int idHab, String fechaIn, String fechaOut) {
		this.idRsv = idRsv;
		this.id=idHab;
		this.fechaIn = fechaIn;
		this.fechaOut = fechaOut;
	}

	public int getIdRsv() {
		return idRsv;
	}

	public void setIdRsv(int idRsv) {
		this.idRsv = idRsv;
	}

	public int getId() {
		return id;
	}

	public void setId(int idHab) {
		this.id = idHab;
	}

	public String getFechaIn() {
		return fechaIn;
	}

	public void setFechaIn(String fechaIn) {
		this.fechaIn = fechaIn;
	}

	public String getFechaOut() {
		return fechaOut;
	}

	public void setFechaOut(String fechaOut) {
		this.fechaOut = fechaOut;
	}
	
}
