package modelo;

public class Alojamiento {
	protected int id;
	protected String nombre;
	protected Direccion direccion;
	protected double precioTAlta;
	protected double precioTBaja;
	protected double precioTFest;
	protected String imagen;
	protected boolean disponible;

	public Alojamiento() {
		this.disponible = true;
	}
	
	public Alojamiento(int id, String nombre, Direccion direccion, double precioA, double precioB, double precioF, String imagen, boolean disponible) {
		this.id = id;
		this.nombre = nombre;
		this.direccion = direccion;
		this.precioTAlta = precioA;
		this.precioTBaja = precioB;
		this.precioTFest = precioF;
		this.imagen = imagen;
		this.disponible = disponible;
	}

	public int getId() {
		return id;
	}
	
	public void setId(int id) {
		this.id = id;
	}
	
	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public Direccion getDireccion() {
		return direccion;
	}

	public void setDireccion(Direccion direccion) {
		this.direccion = direccion;
	}

	public Double getPrecioTAlta() {
		return precioTAlta;
	}

	public void setPrecioTAlta(Double precioTAlta) {
		this.precioTAlta = precioTAlta;
	}

	public Double getPrecioTBaja() {
		return precioTBaja;
	}

	public void setPrecioTBaja(Double precioTBaja) {
		this.precioTBaja = precioTBaja;
	}

	public Double getPrecioTFest() {
		return precioTFest;
	}

	public void setPrecioTFest(Double precioTFest) {
		this.precioTFest = precioTFest;
	}

	public String getImagen() {
		return imagen;
	}

	public void setImagen(String imagen) {
		this.imagen = imagen;
	}

	public boolean isDisponible() {
		return disponible;
	}

	public void setDisponible(boolean disponible) {
		this.disponible = disponible;
	}
	
}
