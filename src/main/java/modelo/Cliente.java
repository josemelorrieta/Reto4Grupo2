package modelo;

public class Cliente {
	protected String nombre;

	public Cliente(String nombre) {
		this.nombre = nombre;
	}

	public Cliente() {
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
}
