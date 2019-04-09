package testModelo;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import modelo.Direccion;

public class TestDireccion {

	private Direccion direccionTest;
	private String stringTest1="Test1";
	private int intTest=20;
	private String stringTest2="Test2";


	@Test
	public void testConstructor() {
		direccionTest = new Direccion(stringTest1,intTest,stringTest2);
		assertEquals(direccionTest.getCalle(), stringTest1);
		assertEquals(direccionTest.getCodPostal(), intTest);
		assertEquals(direccionTest.getLocalidad(), stringTest2);
	}
	
	@Test
	public void testConstructorVacio() {
		direccionTest = new Direccion();
		assertEquals(direccionTest.getCalle(), null);
		assertEquals(direccionTest.getCodPostal(), 0);
		assertEquals(direccionTest.getLocalidad(), null);
	}
	
	@Test
	public void testSetCalle() {
		direccionTest = new Direccion();
		assertEquals(direccionTest.getCalle(), null);
		direccionTest.setCalle(stringTest1);
		assertEquals(direccionTest.getCalle(), stringTest1);
	}
	
	@Test
	public void testSetCodPostal() {
		direccionTest = new Direccion();
		assertEquals(direccionTest.getCodPostal(), 0);
		direccionTest.setCodPostal(intTest);
		assertEquals(direccionTest.getCodPostal(), intTest);
	}
	
	@Test
	public void testSetLocalidad() {
		direccionTest = new Direccion();
		assertEquals(direccionTest.getLocalidad(), null);
		direccionTest.setLocalidad(stringTest1);
		assertEquals(direccionTest.getLocalidad(), stringTest1);
	}

}
