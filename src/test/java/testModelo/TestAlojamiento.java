package testModelo;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;

import org.junit.Test;

import modelo.Alojamiento;
import modelo.Direccion;
import modelo.Habitacion;

public class TestAlojamiento {
	
	private Alojamiento alojamientoTest;
	private int idTest = 1;
	private Direccion direccionTest = new Direccion();
	private String stringTest = "Test1";
	private Double doubleTest = 20.0;
	private Habitacion[] arrayHabitacionTest = {new Habitacion(),new Habitacion(),new Habitacion()};

	@Test
	public void testConstructor() {
		alojamientoTest=new Alojamiento(idTest, stringTest, direccionTest, arrayHabitacionTest, doubleTest, doubleTest, doubleTest, stringTest);
		assertEquals(alojamientoTest.getId(), idTest);
		assertEquals(alojamientoTest.getNombre(), stringTest);
		assertEquals(alojamientoTest.getUbicacion(), direccionTest);
		assertArrayEquals(alojamientoTest.getArrayHabitaciones(), arrayHabitacionTest);
		assertEquals(alojamientoTest.getPrecioTAlta(), doubleTest);
		assertEquals(alojamientoTest.getPrecioTBaja(), doubleTest);
		assertEquals(alojamientoTest.getPrecioTFest(), doubleTest);
		assertEquals(alojamientoTest.getImagen(), stringTest);
}
	
	@Test
	public void testConstructorVacio() {
		alojamientoTest=new Alojamiento();
		assertEquals(alojamientoTest.getId(), 0);
		assertEquals(alojamientoTest.getNombre(), null);
		assertEquals(alojamientoTest.getUbicacion(), null);
		assertArrayEquals(alojamientoTest.getArrayHabitaciones(), null);
		assertEquals(alojamientoTest.getPrecioTAlta(), 0, 0.0001);
		assertEquals(alojamientoTest.getPrecioTBaja(), 0, 0.0001);
		assertEquals(alojamientoTest.getPrecioTFest(), 0, 0);
		assertEquals(alojamientoTest.getImagen(), null);
	}
	
	@Test
	public void testId() {
		alojamientoTest = new Alojamiento();
		alojamientoTest.setId(idTest);
		assertEquals(alojamientoTest.getId(), idTest);
	}
	@Test
	public void testNombre() {
		alojamientoTest=new Alojamiento();
		alojamientoTest.setNombre(stringTest);
		assertEquals(alojamientoTest.getNombre(), stringTest);	
	}
	
	@Test
	public void testUbicacion() {
		alojamientoTest=new Alojamiento();
		alojamientoTest.setUbicacion(direccionTest);
		assertEquals(alojamientoTest.getUbicacion(), direccionTest);	
	}
	
	@Test
	public void testArrayHabitaciones() {
		alojamientoTest=new Alojamiento();
		alojamientoTest.setArrayHabitaciones(arrayHabitacionTest);
		assertArrayEquals(alojamientoTest.getArrayHabitaciones(), arrayHabitacionTest);	
	}
	
	@Test
	public void testPrecioTAlta() {
		alojamientoTest=new Alojamiento();
		alojamientoTest.setPrecioTAlta(doubleTest);
		assertEquals(alojamientoTest.getPrecioTAlta(), doubleTest);	
	}
	
	@Test
	public void testPrecioTBaja() {
		alojamientoTest=new Alojamiento();
		alojamientoTest.setPrecioTBaja(doubleTest);
		assertEquals(alojamientoTest.getPrecioTBaja(), doubleTest);	
	}
	
	@Test
	public void testPrecioTFest() {
		alojamientoTest=new Alojamiento();
		alojamientoTest.setPrecioTFest(doubleTest);
		assertEquals(alojamientoTest.getPrecioTFest(), doubleTest);	
	}

	@Test
	public void testImagen() {
		alojamientoTest = new Alojamiento();
		alojamientoTest.setImagen(stringTest);
		assertEquals(alojamientoTest.getImagen(), stringTest);
	}
}
