package testModelo;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import modelo.Mobiliario;

public class TestMobiliario {

	private Mobiliario mobiliarioTest;
	private String stringTest1="Test1";
	private String stringTest2="Test2";


	@Test
	public void testConstructor() {
		mobiliarioTest = new Mobiliario(stringTest1);
		assertEquals(mobiliarioTest.getNombre(), stringTest1);
	}
	
	@Test
	public void testConstructorVacio() {
		mobiliarioTest = new Mobiliario();
		assertEquals(mobiliarioTest.getNombre(), null);
	}
	
	@Test
	public void testSetNombre() {
		mobiliarioTest = new Mobiliario();
		assertEquals(mobiliarioTest.getNombre(), null);
		mobiliarioTest.setNombre(stringTest2);
		assertEquals(mobiliarioTest.getNombre(), stringTest2);
	}

}
