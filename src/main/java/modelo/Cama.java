package modelo;

public class Cama extends Mobiliario {
	private TipoCama tipoCama;
	
	public Cama() {
		
	}
	
	public Cama(String nombre, TipoCama tipoCama) {
		super(nombre);
		this.tipoCama = tipoCama;
	}
}
