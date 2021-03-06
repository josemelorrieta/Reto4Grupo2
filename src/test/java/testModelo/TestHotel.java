package testModelo;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import modelo.Direccion;
import modelo.Hotel;

public class TestHotel {

	private Hotel hotelTest;
	private int intTest = 20;
	private String stringTest = "Test1";
	private Direccion direccionTest = new Direccion();
	private double doubleTest = 20.0;
	private boolean boolTest = true;
		
	@Test
	public void testConstructorVacio() {
		hotelTest=new Hotel();
		assertEquals(hotelTest.getId(), 0);
		assertEquals(hotelTest.getNombre(), null);
		assertEquals(hotelTest.getDireccion(), null);
		assertEquals(hotelTest.getPrecioTAlta(), 0, 0.0001);
		assertEquals(hotelTest.getPrecioTBaja(), 0, 0.0001);
		assertEquals(hotelTest.getPrecioTFest(), 0, 0.0001);
		assertEquals(hotelTest.getImagen(), null);
		assertEquals(hotelTest.isDisponible(), true);
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
	public void testDireccion() {
		hotelTest=new Hotel();
		hotelTest.setDireccion(direccionTest);
		assertEquals(hotelTest.getDireccion(), direccionTest);	
	}
	
	@Test
	public void testPrecioTAlta() {
		hotelTest=new Hotel();
		hotelTest.setPrecioTAlta(doubleTest);
		assertEquals(hotelTest.getPrecioTAlta(), doubleTest, 0.0001);	
	}
	
	@Test
	public void testPrecioTBaja() {
		hotelTest=new Hotel();
		hotelTest.setPrecioTBaja(doubleTest);
		assertEquals(hotelTest.getPrecioTBaja(), doubleTest, 0.0001);	
	}
	
	@Test
	public void testPrecioTFest() {
		hotelTest=new Hotel();
		hotelTest.setPrecioTFest(doubleTest);
		assertEquals(hotelTest.getPrecioTFest(), doubleTest, 0.0001);	
	}

	@Test
	public void testImagen() {
		hotelTest=new Hotel();
		hotelTest.setImagen(stringTest);
		assertEquals(hotelTest.getImagen(), stringTest);
	}

	@Test
	public void testDisponible() {
		hotelTest = new Hotel();
		hotelTest.setDisponible(true);
		assertEquals(hotelTest.isDisponible(), boolTest);
	}
	
}
