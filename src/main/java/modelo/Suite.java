package modelo;

public class Suite extends Habitacion {
	private int idSuite;

	public Suite(int idHab, int m2, Mobiliario[] arrayMobiliario, Cama[] arrayCamas, int idSuite) {
		super(idHab, m2, arrayMobiliario, arrayCamas, TipoHabitacion.SUITE);
		this.idSuite = idSuite;
	}

	public Suite() {
		this.tipoHabitacion=TipoHabitacion.SUITE;
	}

	public int getIdSuite() {
		return idSuite;
	}

	public void setIdSuite(int idSuite) {
		this.idSuite = idSuite;
	}

}
