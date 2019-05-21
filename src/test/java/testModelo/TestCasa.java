package testModelo;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;

import org.junit.Test;
import modelo.Casa;

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
