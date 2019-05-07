package testModelo;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import modelo.Mobiliario;
import modelo.TipoMobiliario;

public class TestMobiliario {

	private Mobiliario mobiliarioTest;
	private TipoMobiliario tipoMobiliarioTest=TipoMobiliario.DEFAULT;

	@Test
	public void testConstructor() {
		mobiliarioTest = new Mobiliario(tipoMobiliarioTest);
		assertEquals(mobiliarioTest.getNombre(), TipoMobiliario.DEFAULT.toString());
		assertEquals(mobiliarioTest.getTipoMobiliario(), TipoMobiliario.DEFAULT);
		assertEquals(mobiliarioTest.getPrecio(), TipoMobiliario.DEFAULT.getPrecio(),0);
	}
}
