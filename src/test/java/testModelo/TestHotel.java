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
	private String stringTest1="Test1";
	private Double doubleTest= 20.0;
	private Suite[] arrayHabitacionTest = {new Suite(),new Suite(),new Suite()};
	private int intTest=20;

	@Test
	public void testConstructor() {
		hotelTest=new Hotel(stringTest1, direccionTest, arrayHabitacionTest,doubleTest,doubleTest,doubleTest,intTest);
		assertEquals(hotelTest.getNombre(), stringTest1);
		assertEquals(hotelTest.getUbicacion(), direccionTest);
		assertArrayEquals(hotelTest.getArrayHabitaciones(), arrayHabitacionTest);
		assertEquals(hotelTest.getEstrellas(), intTest);
	}
	
	@Test
	public void testConstructorSuper() {
		hotelTest=new Hotel(stringTest1, direccionTest, arrayHabitacionTest,doubleTest,doubleTest,doubleTest);
		assertEquals(hotelTest.getNombre(), stringTest1);
		assertEquals(hotelTest.getUbicacion(), direccionTest);
		assertArrayEquals(hotelTest.getArrayHabitaciones(), arrayHabitacionTest);
		assertEquals(hotelTest.getEstrellas(), 0);
	}
	
	@Test
	public void testConstructorVacio() {
		hotelTest=new Hotel();
		assertEquals(hotelTest.getNombre(), null);
		assertEquals(hotelTest.getUbicacion(), null);
		assertArrayEquals(hotelTest.getArrayHabitaciones(), null);
		assertEquals(hotelTest.getEstrellas(), 0);

	}
	
	@Test
	public void testSetNombre() {
		hotelTest=new Hotel();
		assertEquals(hotelTest.getEstrellas(), 0);
		hotelTest.setEstrellas(intTest);
		assertEquals(hotelTest.getEstrellas(), intTest);	
	}


}
