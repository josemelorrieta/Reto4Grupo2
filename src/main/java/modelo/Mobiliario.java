package modelo;

public class Mobiliario {
	
	protected String nombre;
	protected double pvpMob;

	public String getNombre() {
		return nombre;
	}
	
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public double getPvpMob() {
		return pvpMob;
	}

	public void setPvpMob(double precioMob) {
		this.pvpMob = precioMob;
	}
}
