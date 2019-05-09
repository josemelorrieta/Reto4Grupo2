package modelo;

public class Mobiliario {
	
	protected String nombre;
	protected TipoMobiliario tipoMobiliario;

	public Mobiliario(TipoMobiliario mobiliario) {
		this.tipoMobiliario=mobiliario;
		this.nombre=this.tipoMobiliario.nombreToString();
	}

	public String getNombre() {
		return nombre;
	}
	
	public TipoMobiliario getTipoMobiliario() {
		return tipoMobiliario;
	}

	public double getPrecio() {
		return tipoMobiliario.getPrecio();
	}
}
