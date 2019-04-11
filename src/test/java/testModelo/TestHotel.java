package testModelo;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;
import org.junit.Test;
import modelo.Direccion;
import modelo.Hotel;
import modelo.Suite;

public class TestHotel {

	private Hotel hotelTest;
	private Direccion direccionTest = new Direccion();
	private String stringTest="Test1";
	private Double doubleTest= 20.0;
	private Suite[] arrayHabitacionTest = {new Suite(),new Suite(),new Suite()};
	private int intTest=20;
	
	@Test
	public void testConstructorVacio() {
		hotelTest=new Hotel();
		assertEquals(hotelTest.getId(), 0);
		assertEquals(hotelTest.getNombre(), null);
		assertEquals(hotelTest.getUbicacion(), null);
		assertArrayEquals(hotelTest.getArrayHabitaciones(), null);
		assertEquals(hotelTest.getPrecioTAlta(), null);
		assertEquals(hotelTest.getPrecioTBaja(), null);
		assertEquals(hotelTest.getPrecioTFest(), null);
		assertEquals(hotelTest.getImagen(), null);
		assertEquals(hotelTest.getEstrellas(), 0);
	}
	
	@Test
	public void testConstructorSuper() {
		hotelTest=new Hotel(intTest, stringTest, direccionTest, arrayHabitacionTest,doubleTest,doubleTest,doubleTest,stringTest,intTest);
		assertEquals(hotelTest.getId(), intTest);
		assertEquals(hotelTest.getNombre(), stringTest);
		assertEquals(hotelTest.getUbicacion(), direccionTest);
		assertArrayEquals(hotelTest.getArrayHabitaciones(), arrayHabitacionTest);
		assertEquals(hotelTest.getPrecioTAlta(), doubleTest, 0.00001);
		assertEquals(hotelTest.getPrecioTBaja(), doubleTest, 0.00001);
		assertEquals(hotelTest.getPrecioTFest(), doubleTest, 0.00001);
		assertEquals(hotelTest.getImagen(), stringTest);
		assertEquals(hotelTest.getEstrellas(), intTest);
	}
	
	@Test
	public void testId() {
		hotelTest=new Hotel();
		hotelTest.setId(intTest);
		assertEquals(hotelTest.getId(), intTest);
	}
	
	@Test
	public void testNombre() {
		hotelTest=new Hotel();
		hotelTest.setNombre(stringTest);
		assertEquals(hotelTest.getNombre(), stringTest);	
	}
	
	@Test
	public void testUbicacion() {
		hotelTest=new Hotel();
		hotelTest.setUbicacion(direccionTest);
		assertEquals(hotelTest.getUbicacion(), direccionTest);	
	}
	
	@Test
	public void testArrayHabitaciones() {
		hotelTest=new Hotel();
		hotelTest.setArrayHabitaciones(arrayHabitacionTest);
		assertArrayEquals(hotelTest.getArrayHabitaciones(), arrayHabitacionTest);	
	}
	
	@Test
	public void testPrecioTAlta() {
		hotelTest=new Hotel();
		hotelTest.setPrecioTAlta(doubleTest);
		assertEquals(hotelTest.getPrecioTAlta(), doubleTest);	
	}
	
	@Test
	public void testPrecioTBaja() {
		hotelTest=new Hotel();
		hotelTest.setPrecioTBaja(doubleTest);
		assertEquals(hotelTest.getPrecioTBaja(), doubleTest);	
	}
	
	@Test
	public void testPrecioTFest() {
		hotelTest=new Hotel();
		hotelTest.setPrecioTFest(doubleTest);
		assertEquals(hotelTest.getPrecioTFest(), doubleTest);	
	}

	@Test
	public void testImagen() {
		hotelTest=new Hotel();
		hotelTest.setImagen(stringTest);
		assertEquals(hotelTest.getImagen(), stringTest);
	}

}
