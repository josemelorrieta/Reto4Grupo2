package modelo;

public class Suite extends Habitacion {
	private int idSuite;

	public Suite(int m2, Mobiliario[] arrayMobiliario, int idSuite) {
		super(m2, arrayMobiliario, TipoHabitacion.SUITE);
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
