package testModelo;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;

import org.junit.Test;

import modelo.Cama;
import modelo.Casa;
import modelo.Dormitorio;
import modelo.Habitacion;
import modelo.Mobiliario;
import modelo.TipoCama;
import modelo.TipoMobiliario;

public class TestCasa {

	private Casa casaTest;

	@Test
	public void testConstructorVacio() {
		casaTest = new Casa();
		assertArrayEquals(casaTest.getHabitaciones(), null);
		assertEquals(casaTest.getNumBanios(), 0);
		assertEquals(casaTest.getM2(), 0);
	}


}
