package modelo;

/**
 * Clase Servicio
 * Modelo general de un servicio
 */
public class Servicio {
	public String nombre;
	public double precio;
	public TipoServicio tipo;
	
	/**
	 * Constructor - Crea un nuevo servicio
	 * @param nombre
	 * @param precio
	 */
	public Servicio(String nombre, double precio) {
		this.nombre = nombre;
		this.precio = precio;
		this.tipo = calcularTipo(precio);
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public double getPrecio() {
		return precio;
	}

	public void setPrecio(double precio) {
		this.precio = precio;
		this.tipo = calcularTipo(precio);
	}

	public TipoServicio getTipo() {
		return tipo;
	}

	public void setTipo(TipoServicio tipo) {
		this.tipo = tipo;
	}
	
	/**
	 * Calcula el tipo segun el precio que tenga
	 * @param precio
	 * @return
	 */
	private TipoServicio calcularTipo(double precio) {
		if (precio == 0)
			return TipoServicio.incluido;
		else if (precio > 0)
			return TipoServicio.noIncluido;
		else
			return TipoServicio.noDisponible;
	}
}
