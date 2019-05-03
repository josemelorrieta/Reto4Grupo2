package modelo;

public class Cama extends Mobiliario {
	private TipoCama tipoCama;
	
	public Cama() {
		
	}
	
	public Cama(TipoCama tipoCama) {
		super("Cama");
		this.setTipoCama(tipoCama);
	}

	public TipoCama getTipoCama() {
		return tipoCama;
	}

	public void setTipoCama(TipoCama tipoCama) {
		this.tipoCama = tipoCama;
	}
}
