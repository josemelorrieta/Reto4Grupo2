package testModelo;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;

import org.junit.Test;

import modelo.Cama;
import modelo.Habitacion;
import modelo.Mobiliario;
import modelo.TipoHabitacion;

public class TestHabitacion {
	
	private int idHabTest = 1;
	private int metrosCuadradosTest=20;
	private Habitacion habitacionTest;
	private Mobiliario[] arrayMobiliarioTest = {new Mobiliario(),new Mobiliario(),new Mobiliario()};
	private Cama[] arrayCamasTest = {new Cama()};
	private TipoHabitacion tipoHabitacionTest=TipoHabitacion.COCINA;

	@Test
	public void testConstructor() {
		habitacionTest=new Habitacion(idHabTest, metrosCuadradosTest, arrayMobiliarioTest, arrayCamasTest,tipoHabitacionTest);
		assertEquals(habitacionTest.getIdHab(), idHabTest);
		assertEquals(habitacionTest.getM2(), metrosCuadradosTest);
		assertArrayEquals(habitacionTest.getArrayMobiliario(), arrayMobiliarioTest);
		assertArrayEquals(habitacionTest.getArrayCamas(), arrayCamasTest);
		assertEquals(habitacionTest.getTipoHabitacion(), tipoHabitacionTest);
	}
	
	@Test
	public void testConstructorVacio() {
		habitacionTest=new Habitacion();
		assertEquals(habitacionTest.getM2(), 0);
		assertArrayEquals(habitacionTest.getArrayMobiliario(), null);
	}
	
	@Test
	public void testSetId() {
		habitacionTest=new Habitacion();
		habitacionTest.setIdHab(idHabTest);
		assertEquals(habitacionTest.getIdHab(), idHabTest);
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
	public void testSetArrayCamas() {
		habitacionTest=new Habitacion();
		habitacionTest.setArrayCamas(arrayCamasTest);
		assertArrayEquals(habitacionTest.getArrayCamas(), arrayCamasTest);
	}
	
	@Test
	public void testSetTipoHabitacion() {
		habitacionTest=new Habitacion();
		habitacionTest.setTipoHabitacion(tipoHabitacionTest);
		assertEquals(habitacionTest.getTipoHabitacion(), tipoHabitacionTest);
	}

}
