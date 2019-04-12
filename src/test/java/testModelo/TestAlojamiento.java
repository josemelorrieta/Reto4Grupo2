package testModelo;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import modelo.Alojamiento;
import modelo.Direccion;

public class TestAlojamiento {
	
	private Alojamiento alojamientoTest;
	private int intTest = 1;
	private Direccion direccionTest = new Direccion();
	private String stringTest = "Test1";
	private double doubleTest = 20.0;

	@Test
	public void testConstructor() {
		alojamientoTest=new Alojamiento(intTest, stringTest, direccionTest, doubleTest, doubleTest, doubleTest, stringTest);
		assertEquals(alojamientoTest.getId(), intTest);
		assertEquals(alojamientoTest.getNombre(), stringTest);
		assertEquals(alojamientoTest.getDireccion(), direccionTest);
		assertEquals(alojamientoTest.getPrecioTAlta(), doubleTest, 0.0001);
		assertEquals(alojamientoTest.getPrecioTBaja(), doubleTest, 0.0001);
		assertEquals(alojamientoTest.getPrecioTFest(), doubleTest, 0.0001);
		assertEquals(alojamientoTest.getImagen(), stringTest);
	}
	
	@Test
	public void testConstructorVacio() {
		alojamientoTest=new Alojamiento();
		assertEquals(alojamientoTest.getId(), 0);
		assertEquals(alojamientoTest.getNombre(), null);
		assertEquals(alojamientoTest.getDireccion(), null);
		assertEquals(alojamientoTest.getPrecioTAlta(), 0, 0.0001);
		assertEquals(alojamientoTest.getPrecioTBaja(), 0, 0.0001);
		assertEquals(alojamientoTest.getPrecioTFest(), 0, 0.0001);
		assertEquals(alojamientoTest.getImagen(), null);
	}
	
	@Test
	public void testId() {
		alojamientoTest = new Alojamiento();
		alojamientoTest.setId(intTest);
		assertEquals(alojamientoTest.getId(), intTest);
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
		alojamientoTest.setDireccion(direccionTest);
		assertEquals(alojamientoTest.getDireccion(), direccionTest);	
	}	
	@Test
	public void testPrecioTAlta() {
		alojamientoTest=new Alojamiento();
		alojamientoTest.setPrecioTAlta(doubleTest);
		assertEquals(alojamientoTest.getPrecioTAlta(), doubleTest, 0.0001);	
	}
	
	@Test
	public void testPrecioTBaja() {
		alojamientoTest=new Alojamiento();
		alojamientoTest.setPrecioTBaja(doubleTest);
		assertEquals(alojamientoTest.getPrecioTBaja(), doubleTest, 0.0001);	
	}
	
	@Test
	public void testPrecioTFest() {
		alojamientoTest=new Alojamiento();
		alojamientoTest.setPrecioTFest(doubleTest);
		assertEquals(alojamientoTest.getPrecioTFest(), doubleTest, 0.0001);	
	}

	@Test
	public void testImagen() {
		alojamientoTest = new Alojamiento();
		alojamientoTest.setImagen(stringTest);
		assertEquals(alojamientoTest.getImagen(), stringTest);
	}
}
