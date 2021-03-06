package modelo;

/**
 * Clase Alojamiento abstracta con informacion generica
 *
 */
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
	protected Servicio[] servicios;
	protected boolean mostrar;
	
	/**
	 * Constructor por defecto
	 */
	public Alojamiento() {
		setMostrar(true);
	}
	
	/**
	 * Calcula el precio de las habitaciones que no sean dormitorios
	 * @return precio precio de las habitaciones que no son dormitorio del alojamiento
	 */
	public double precioNoDormitorios() {
		double precio=0;
		for (Habitacion hab : this.habitaciones) {
			if (!(hab instanceof Dormitorio)) {
				precio += hab.calcularPrecio(pvpM2);
			}
		}
		return precio;
	}
	
	/**
	 * Calcula el precio de las habitaciones que sean dormitorios
	 * @return precio precio de las habitaciones que son dormitorios del alojamiento
	 */
	public double precioDormitorios() {
		double precio=0;
		for (Habitacion hab : this.habitaciones) {
			if (hab instanceof Dormitorio) {
				precio += hab.calcularPrecio(pvpM2);
			}
		}
		return precio;
	}

	/**
	 * Metodo que devuelve el ID del alojamiento
	 * @return id id del alojamiento
	 */
	public int getId() {
		return id;
	}
	
	/**
	 * Metodo que cambia el ID del alojamiento
	 * @param id id nueva para el alojamiento
	 */
	public void setId(int id) {
		this.id = id;
	}
	
	/**
	 * Metodo que devuelve el nombre del alojamiento
	 * @return nombre nombre del alojamiento
	 */
	public String getNombre() {
		return nombre;
	}

	/**
	 * Metodo que cambia el nombre del alojamiento
	 * @param nombre nuevo nombre para el alojamiento
	 */
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	/**
	 * Metodo que devuelve la direccion del alojamiento
	 * @return direccion direccion del alojamiento
	 */
	public Direccion getDireccion() {
		return direccion;
	}

	/**
	 * Metodo que cambia la direccion del alojamiento
	 * @param direccion nueva direccion para el alojamiento
	 */
	public void setDireccion(Direccion direccion) {
		this.direccion = direccion;
	}

	/**
	 * Metodo que devuelve el precio de la temporada alta del alojamiento
	 * @return precioTAlta precio de la temporada alta
	 */
	public Double getPrecioTAlta() {
		return precioTAlta;
	}

	/**
	 * Metodo que cambia el precio de la temporada alta del alojamiento
	 * @param precioTAlta nuevo precio para la temporada alta
	 */
	public void setPrecioTAlta(double precioTAlta) {
		this.precioTAlta = precioTAlta;
	}

	/**
	 * Metodo que devuelve el precio de la temporada baja del alojamiento
	 * @return precioTBaja precio de la temporada Baja
	 */
	public Double getPrecioTBaja() {
		return precioTBaja;
	}

	/**
	 * Metodo que cambia el precio de la temporada baja del alojamiento
	 * @param precioTBaja nuevo precio para la temporada baja
	 */
	public void setPrecioTBaja(double precioTBaja) {
		this.precioTBaja = precioTBaja;
	}

	/**
	 * Metodo que devuelve el precio de dias festivos del alojamiento
	 * @return precioTFest precio para los dias festivos
	 */
	public Double getPrecioTFest() {
		return precioTFest;
	}

	/**
	 * Metodo que cambia el precio de dias festivos del alojamiento
	 * @param precioTFest nuevo precio para los dias festivos
	 */
	public void setPrecioTFest(double precioTFest) {
		this.precioTFest = precioTFest;
	}

	/**
	 * Metodo que devuelve el nombre de la imagen del alojamiento
	 * @return imagen nombre de la imagen
	 */
	public String getImagen() {
		return imagen;
	}

	/**
	 * Metodo que cambia el nombre de la imagen del alojamiento
	 * @param imagen nuevo nombre de la imagen del alojamiento 
	 */
	public void setImagen(String imagen) {
		this.imagen = imagen;
	}

	/**
	 * Metodo que devuelve el precio por m2 del alojamiento
	 * @return pvpM2 precio por m2 del alojamiento
	 */
	public double getPvpM2() {
		return pvpM2;
	}
	
	/**
	 * Metodo que cambia el precio por m2 del alojamiento
	 * @param pvpM2 nuevo precio por m2
	 */
	public void setPvpM2(double pvpM2) {
		this.pvpM2 = pvpM2;
	}

	/**
	 * Metodo que devuelve la disponibilidad del alojamiento
	 * @return true si esta disponible
	 */
	public boolean isDisponible() {
		return disponible;
	}

	/**
	 * Metodo que cambia la disponibilidad del alojamiento
	 * @param disponible nuevo estado de disponibilidad
	 */
	public void setDisponible(boolean disponible) {
		this.disponible = disponible;
	}

	/**
	 * Metodo que devuelve las habitaciones del alojamiento
	 * @return habitaciones arra de habitaciones del alojamiento
	 */
	public Habitacion[] getHabitaciones() {
		return habitaciones;
	}

	/**
	 * Metodo que cambia las habitaciones del alojamiento
	 * @param habitaciones nuevo array de habitaciones para el alojamiento 
	 */
	public void setHabitaciones(Habitacion[] habitaciones) {
		this.habitaciones = habitaciones;
	}

	/**
	 * Metodo que devuelve los servicios del alojamiento
	 * @return servicios array de servicios del alojamiento
	 */
	public Servicio[] getServicios() {
		return servicios;
	}

	/**
	 * Metodo que cambia los servicios del alojamiento
	 * @param servicios nuevo array de servicios
	 */
	public void setServicios(Servicio[] servicios) {
		this.servicios = servicios;
	}

	/**
	 * Metodo que devuelve si el alojamiento debe mostrarse en la vista
	 * @return true si debe mostrarse
	 */
	public boolean isMostrar() {
		return mostrar;
	}

	/**
	 * Metodo que cambia si el alojamiento debe mostrarse en la vista
	 * @param mostrar nuevo estado para mostrar o no el alojamiento
	 */
	public void setMostrar(boolean mostrar) {
		this.mostrar = mostrar;
	}
	
}
