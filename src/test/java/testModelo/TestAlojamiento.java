package testModelo;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;

import org.junit.Test;

import modelo.Alojamiento;
import modelo.Direccion;
import modelo.Habitacion;

public class TestAlojamiento {
	
	private Alojamiento alojamientoTest;
	private Direccion direccionTest = new Direccion();
	private String stringTest1="Test1";
	private Double doubleTest= 20.0;
	private Habitacion[] arrayHabitacionTest = {new Habitacion(),new Habitacion(),new Habitacion()};

	@Test
	public void testConstructor() {
		alojamientoTest=new Alojamiento(stringTest1, direccionTest, arrayHabitacionTest, doubleTest, doubleTest, doubleTest);
		assertEquals(alojamientoTest.getNombre(), stringTest1);
		assertEquals(alojamientoTest.getUbicacion(), direccionTest);
		assertArrayEquals(alojamientoTest.getArrayHabitaciones(), arrayHabitacionTest);
		assertEquals(alojamientoTest.getPrecioTAlta(), doubleTest);
		assertEquals(alojamientoTest.getPrecioTBaja(), doubleTest);
		assertEquals(alojamientoTest.getPrecioTFest(), doubleTest);
}
	
	@Test
	public void testConstructorVacio() {
		alojamientoTest=new Alojamiento();
		assertEquals(alojamientoTest.getNombre(), null);
		assertEquals(alojamientoTest.getUbicacion(), null);
		assertArrayEquals(alojamientoTest.getArrayHabitaciones(), null);
	}
	
	@Test
	public void testSetNombre() {
		alojamientoTest=new Alojamiento();
		assertEquals(alojamientoTest.getNombre(), null);
		alojamientoTest.setNombre(stringTest1);
		assertEquals(alojamientoTest.getNombre(), stringTest1);	
	}
	
	@Test
	public void testSetUbicacion() {
		alojamientoTest=new Alojamiento();
		assertEquals(alojamientoTest.getUbicacion(), null);
		alojamientoTest.setUbicacion(direccionTest);
		assertEquals(alojamientoTest.getUbicacion(), direccionTest);	
	}
	
	@Test
	public void testSetArrayHabitaciones() {
		alojamientoTest=new Alojamiento();
		assertArrayEquals(alojamientoTest.getArrayHabitaciones(), null);
		alojamientoTest.setArrayHabitaciones(arrayHabitacionTest);
		assertArrayEquals(alojamientoTest.getArrayHabitaciones(), arrayHabitacionTest);	
	}
	
	
	@Test
	public void testSetPrecioTAlta() {
		alojamientoTest=new Alojamiento();
		assertEquals(alojamientoTest.getPrecioTAlta(), null);
		alojamientoTest.setPrecioTAlta(doubleTest);
		assertEquals(alojamientoTest.getPrecioTAlta(), doubleTest);	
	}
	
	@Test
	public void testSetPrecioTBaja() {
		alojamientoTest=new Alojamiento();
		assertEquals(alojamientoTest.getPrecioTBaja(), null);
		alojamientoTest.setPrecioTBaja(doubleTest);
		assertEquals(alojamientoTest.getPrecioTBaja(), doubleTest);	
	}
	
	@Test
	public void testSetPrecioTFest() {
		alojamientoTest=new Alojamiento();
		assertEquals(alojamientoTest.getPrecioTFest(), null);
		alojamientoTest.setPrecioTFest(doubleTest);
		assertEquals(alojamientoTest.getPrecioTFest(), doubleTest);	
	}

}
