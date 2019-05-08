package testModelo;

import static org.junit.Assert.*;

import org.junit.Test;

import modelo.Cama;

public class TestCama {

	private Cama camaTest;
	
	private String stringTest = "Test";

	@Test
	public void testConstructor() {
		camaTest = new Cama();
		assertEquals(camaTest.getNombre(), null);
	}
	
	@Test
	public void testTipoCama() {
		camaTest = new Cama();
		camaTest.setNombre(stringTest);
		assertEquals(camaTest.getTipoCama(), stringTest);
	}

}
