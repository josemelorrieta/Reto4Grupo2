package modelo;

public class Alojamiento {
	protected int id;
	protected String nombre;
	protected Direccion ubicacion;
	protected Habitacion[] arrayHabitaciones;
	protected Double precioTAlta;
	protected Double precioTBaja;
	protected Double precioTFest;
	protected String imagen;

	public Alojamiento() {
		//Constructor por defecto
	}
	
	public Alojamiento(String nombre, Direccion ubicacion, Habitacion[] arrayHabitaciones, Double precioA, Double precioB, Double precioF) {
		this.nombre = nombre;
		this.ubicacion = ubicacion;
		this.arrayHabitaciones = arrayHabitaciones;
		this.precioTAlta = precioA;
		this.precioTBaja = precioB;
		this.precioTFest = precioF;
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

	public Direccion getUbicacion() {
		return ubicacion;
	}

	public void setUbicacion(Direccion ubicacion) {
		this.ubicacion = ubicacion;
	}

	public Habitacion[] getArrayHabitaciones() {
		return arrayHabitaciones;
	}

	public void setArrayHabitaciones(Habitacion[] arrayHabitaciones) {
		this.arrayHabitaciones = arrayHabitaciones;
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

	
}
