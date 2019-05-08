package testModelo;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;

import org.junit.Test;

import modelo.Habitacion;
import modelo.TipoHabitacion;

public class TestHabitacion {

	private Habitacion habitacionTest;
	
	private int intTest = 1;
	private TipoHabitacion tipoHabitacionTest = TipoHabitacion.DEFAULT;

	@Test
	public void testConstructorVacio() {
		habitacionTest = new Habitacion();
		assertEquals(habitacionTest.getIdHab(), 0);
		assertEquals(habitacionTest.getM2(), 0);
		assertEquals(habitacionTest.getTipoHab(), null);
		assertArrayEquals(habitacionTest.getMobiliario(), null);
		assertEquals(habitacionTest.isDisponible(), true);
		assertEquals(habitacionTest.getPvpTotalMobiliario(), 0, 0.00001);
	}

	@Test
	public void testIdHab() {
		habitacionTest = new Habitacion();
		habitacionTest.setIdHab(intTest);
		assertEquals(habitacionTest.getIdHab(), intTest);
	}

	@Test
	public void testM2() {
		habitacionTest = new Habitacion();
		habitacionTest.setM2(intTest);
		assertEquals(habitacionTest.getM2(), intTest);
	}

	@Test
	public void testTipoHabitacion() {
		habitacionTest = new Habitacion();
		habitacionTest.setTipoHab(tipoHabitacionTest);
		assertEquals(habitacionTest.getTipoHab(), tipoHabitacionTest);
	}

}
