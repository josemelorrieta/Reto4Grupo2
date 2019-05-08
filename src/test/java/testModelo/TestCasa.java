package testModelo;

import static org.junit.Assert.*;

import org.junit.Test;

import modelo.Casa;

public class TestCasa {

	private Casa casaTest;
	
	private int intTest = 0;
	private double doubleTest = 20.0;

	@Test
	public void testConstructorVacio() {
		casaTest = new Casa();
		assertEquals(casaTest.getNumBanios(), 0);
		assertEquals(casaTest.getM2(), 0);
		assertEquals(casaTest.getPrecioBase(), 0, 0.00001);
	}

	@Test
	public void testNumBanios() {
		
	}
	
	@Test
	public void testM2() {
		
	}
	
	@Test
	public void testPrecioBase() {
		
	}
}
