package modelo;

public class Apartamento extends Casa{
	private int piso;

	public Apartamento() {
		
	}
	
	public Apartamento(int id, String nombre, Direccion direccion, double precioA, double precioB, double precioF, String imagen) {
		super(id, nombre, direccion, precioA, precioB, precioF, imagen);
	}
	
	public Apartamento(int id, String nombre, Direccion direccion, double precioA, double precioB, double precioF, String imagen, int piso) {
		super(id, nombre, direccion, precioA, precioB, precioF, imagen);
		this.piso = piso;
	}
	
	public int getPiso() {
		return piso;
	}

	public void setPiso(int piso) {
		this.piso = piso;
	}
}
