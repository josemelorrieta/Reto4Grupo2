package testModelo;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import modelo.Habitacion;
import modelo.TipoHabitacion;

public class TestHabitacion {

	private Habitacion habitacionTest;
	private int intTest = 1;
	private TipoHabitacion tipoHabitacionTest = TipoHabitacion.DEFAULT;

	@Test
	public void testConstructor() {
		habitacionTest = new Habitacion();
		assertEquals(habitacionTest.getM2(), 0);
		assertEquals(habitacionTest.getTipoHabitacion(), TipoHabitacion.DEFAULT);
	}

	@Test
	public void testId() {
		habitacionTest = new Habitacion();
		habitacionTest.setIdHab(intTest);
		assertEquals(habitacionTest.getIdHab(), intTest);
	}

	@Test
	public void testGetPrecio() {
		habitacionTest = new Habitacion();
		assertEquals(habitacionTest.calcularPrecio(2), 0, 0);
	}

	@Test
	public void testSetM2() {
		habitacionTest = new Habitacion();
		habitacionTest.setM2(intTest);
		assertEquals(habitacionTest.getM2(), intTest);
		assertEquals(habitacionTest.calcularPrecio(2), 2,0);
	}

	@Test
	public void testTipoHabitacion() {
		habitacionTest = new Habitacion();
		habitacionTest.setTipoHabitacion(tipoHabitacionTest);
		assertEquals(habitacionTest.getTipoHabitacion(), tipoHabitacionTest);
	}
	
	@Test
	public void testSetPrecio() {
		habitacionTest = new Habitacion();
		habitacionTest.setPrecio(10);
		assertEquals(habitacionTest.getPrecio(), 10, 0);
	}

}
