package testModelo;

import static org.junit.Assert.*;

import org.junit.Test;

import modelo.Habitacion;
import modelo.Mobiliario;
import modelo.TipoHabitacion;

public class TestHabitacion {
	
	private int metrosCuadradosTest=20;
	private Habitacion habitacionTest;
	private Mobiliario[] arrayMobiliarioTest = {new Mobiliario(),new Mobiliario(),new Mobiliario()};
	private TipoHabitacion tipoHabitacionTest=TipoHabitacion.COCINA;

	@Test
	public void testConstructor() {
		habitacionTest=new Habitacion(metrosCuadradosTest, arrayMobiliarioTest,tipoHabitacionTest);
		assertEquals(habitacionTest.getM2(), metrosCuadradosTest);
		assertArrayEquals(habitacionTest.getArrayMobiliario(), arrayMobiliarioTest);
		assertEquals(habitacionTest.getTipoHabitacion(), tipoHabitacionTest);
	}
	
	@Test
	public void testConstructorVacio() {
		habitacionTest=new Habitacion();
		assertEquals(habitacionTest.getM2(), 0);
		assertArrayEquals(habitacionTest.getArrayMobiliario(), null);
	}
	
	@Test
	public void testSetM2() {
		habitacionTest=new Habitacion();
		habitacionTest.setM2(metrosCuadradosTest);
		assertEquals(habitacionTest.getM2(), metrosCuadradosTest);
	}
	
	@Test
	public void testSetArrayMobiliario() {
		habitacionTest=new Habitacion();
		habitacionTest.setArrayMobiliario(arrayMobiliarioTest);
		assertArrayEquals(habitacionTest.getArrayMobiliario(), arrayMobiliarioTest);
	}
	
	@Test
	public void testSetTipoHabitacion() {
		habitacionTest=new Habitacion();
		habitacionTest.setTipoHabitacion(tipoHabitacionTest);
		assertEquals(habitacionTest.getTipoHabitacion(), tipoHabitacionTest);
	}

}
