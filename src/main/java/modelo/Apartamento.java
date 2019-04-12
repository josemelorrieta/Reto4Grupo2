package modelo;

public class Apartamento extends Casa{
	private int piso;

	public Apartamento() {
		
	}
	
	public Apartamento(int id, String nombre, Direccion direccion, double precioA, double precioB, double precioF, String imagen,boolean disponible) {
		super(id, nombre, direccion, precioA, precioB, precioF, imagen, disponible);
	}
	
	public Apartamento(int id, String nombre, Direccion direccion, double precioA, double precioB, double precioF, String imagen, boolean disponible,int piso) {
		super(id, nombre, direccion, precioA, precioB, precioF, imagen, disponible);
		this.piso = piso;
	}
	
	public int getPiso() {
		return piso;
	}

	public void setPiso(int piso) {
		this.piso = piso;
	}
}
