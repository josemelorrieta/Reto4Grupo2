package modelo;

public class Cama extends Mobiliario {
	private TipoCama tipoCama;
	
	public Cama() {
		
	}
	
	public Cama(String nombre, TipoCama tipoCama) {
		super(nombre);
		this.setTipoCama(tipoCama);
	}

	public TipoCama getTipoCama() {
		return tipoCama;
	}

	public void setTipoCama(TipoCama tipoCama) {
		this.tipoCama = tipoCama;
	}
}
