package modelo;

public class Cliente {
	private String nombre;

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
