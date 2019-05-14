package modelo;

public class Alojamiento {
	protected int id;
	protected String nombre;
	protected Direccion direccion;
	protected double precioTAlta;
	protected double precioTBaja;
	protected double precioTFest;
	protected String imagen;
	protected double pvpM2;
	protected boolean disponible;
	protected Habitacion[] habitaciones;
	
	public double precioNoDormitorios() {
		double precio=0;
		for (Habitacion hab : this.habitaciones) {
			if (!(hab instanceof Dormitorio)) {
				precio += hab.calcularPrecio(pvpM2);
			}
		}
		return precio;
	}
	
	public double precioDormitorios() {
		double precio=0;
		for (Habitacion hab : this.habitaciones) {
			if (hab instanceof Dormitorio) {
				precio += hab.calcularPrecio(pvpM2);
			}
		}
		return precio;
	}
	
	

	public double getPvpM2() {
		return pvpM2;
	}

	public void setPvpM2(double pvpM2) {
		this.pvpM2 = pvpM2;
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

	public Habitacion[] getHabitaciones() {
		return habitaciones;
	}

	public void setHabitaciones(Habitacion[] habitaciones) {
		this.habitaciones = habitaciones;
	}

	public void setPrecioTAlta(double precioTAlta) {
		this.precioTAlta = precioTAlta;
	}

	public void setPrecioTBaja(double precioTBaja) {
		this.precioTBaja = precioTBaja;
	}

	public void setPrecioTFest(double precioTFest) {
		this.precioTFest = precioTFest;
	}
	
}
