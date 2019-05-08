package testModelo;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;
import org.junit.Test;

import modelo.Hotel;

public class TestHotel {

	private Hotel hotelTest;
	
	private int intTest = 20;
		
	@Test
	public void testConstructorVacio() {
		hotelTest = new Hotel();
		assertEquals(hotelTest.getNumEstrellas(), intTest);
	}
	
	@Test
	public void testNumEstrellas() {
		hotelTest = new Hotel();
		hotelTest.setNumEstrellas(intTest);
		assertEquals(hotelTest.getNumEstrellas(), intTest);
	}
	
	@Test
	public void testPrecioBase() {
		hotelTest = new Hotel();

	}
	
	@Test
	public void testPvpTotalHab() {
		hotelTest = new Hotel();

	}
}
