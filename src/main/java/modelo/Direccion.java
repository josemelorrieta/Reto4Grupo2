package modelo;

public class Direccion {
	private String calle;
	private int codPostal;
	private String localidad;
	
	public Direccion(String calle, int codPostal, String localidad) {
		this.calle = calle;
		this.codPostal = codPostal;
		this.localidad = localidad;
	}
	
	public Direccion() {
	}
	
	public String getCalle() {
		return calle;
	}
	public void setCalle(String calle) {
		this.calle = calle;
	}
	public int getCodPostal() {
		return codPostal;
	}
	public void setCodPostal(int codPostal) {
		this.codPostal = codPostal;
	}
	public String getLocalidad() {
		return localidad;
	}
	public void setLocalidad(String localidad) {
		this.localidad = localidad;
	}
	
	
}


