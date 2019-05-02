package testModelo;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import modelo.Habitacion;
import modelo.TipoHabitacion;

public class TestHabitacion {
	
	private Habitacion habitacionTest;
	private int intTest = 1;
	private TipoHabitacion tipoHabitacionTest=TipoHabitacion.COCINA;

	@Test
	public void testConstructorVacio() {
		habitacionTest=new Habitacion();
		assertEquals(habitacionTest.getM2(), 0);
	}
	@Test
	public void testConstructorParametros() {
		habitacionTest=new Habitacion(intTest, intTest, tipoHabitacionTest);
		assertEquals(habitacionTest.getIdHab(), intTest);
		assertEquals(habitacionTest.getM2(), intTest);
		assertEquals(habitacionTest.getTipoHabitacion(), tipoHabitacionTest);
	}
	
	@Test
	public void testId() {
		habitacionTest=new Habitacion();
		habitacionTest.setIdHab(intTest);
		assertEquals(habitacionTest.getIdHab(), intTest);
	}
	
	@Test
	public void testM2() {
		habitacionTest=new Habitacion();
		habitacionTest.setM2(intTest);
		assertEquals(habitacionTest.getM2(), intTest);
	}
	
	@Test
	public void testTipoHabitacion() {
		habitacionTest=new Habitacion();
		habitacionTest.setTipoHabitacion(tipoHabitacionTest);
		assertEquals(habitacionTest.getTipoHabitacion(), tipoHabitacionTest);
	}

}
