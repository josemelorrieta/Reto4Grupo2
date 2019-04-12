package modelo;

public class FechasReserva {
	private int idRsv;
	private String fechaIn;
	private String fechaOut;
	
	public FechasReserva(int idRsv, String fechaIn, String fechaOut) {
		this.idRsv = idRsv;
		this.fechaIn = fechaIn;
		this.fechaOut = fechaOut;
	}

	public int getIdRsv() {
		return idRsv;
	}

	public void setIdRsv(int idRsv) {
		this.idRsv = idRsv;
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
