package modelo;

public class Cama extends Mobiliario {
	private TipoCama tipoCama;
	
	public Cama(TipoCama tipoCama) {
		super(TipoMobiliario.CAMA);
		this.tipoCama=tipoCama;
	}

	public TipoCama getTipoCama() {
		return tipoCama;
	}
	
	public double getPrecio() {
		return tipoCama.getPrecio();
	}
}
