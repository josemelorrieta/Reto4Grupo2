package testModelo;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import modelo.Mobiliario;

public class TestMobiliario {

	private Mobiliario mobiliarioTest;
	
	private String stringTest = "Test";
	private double doubleTest = 2.3;

	@Test
	public void testConstructor() {
		mobiliarioTest = new Mobiliario();
		assertEquals(mobiliarioTest.getNombre(), null);
		assertEquals(mobiliarioTest.getPvpMob(), 0, 0.00001);
	}
	
	@Test
	public void testNombre() {
		mobiliarioTest = new Mobiliario();
		mobiliarioTest.setNombre(stringTest);
		assertEquals(mobiliarioTest.getNombre(), stringTest);
	}
	
	@Test
	public void testPvpMob() {
		mobiliarioTest = new Mobiliario();
		mobiliarioTest.setPvpMob(doubleTest);
		assertEquals(mobiliarioTest.getPvpMob(), doubleTest, 0.00001);
	}
}
