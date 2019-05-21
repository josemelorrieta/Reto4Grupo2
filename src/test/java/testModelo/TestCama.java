package testModelo;

import static org.junit.Assert.*;

import org.junit.Test;

import modelo.Cama;
import modelo.TipoCama;
import modelo.TipoMobiliario;

public class TestCama {

	private Cama camaTest;
	private TipoMobiliario tipoMobiliarioTest=TipoMobiliario.CAMA;
	private TipoCama tipoCamaTest=TipoCama.DEFAULT;

	@Test
	public void testConstructor() {
		camaTest = new Cama(tipoCamaTest);
		assertEquals(camaTest.getNombre(), TipoMobiliario.CAMA.toString());
		assertEquals(camaTest.getTipoMobiliario(), TipoMobiliario.CAMA);
		assertEquals(camaTest.getTipoCama(), TipoCama.DEFAULT);
	}
	
	@Test
	public void testGetPrecio() {
		camaTest = new Cama(tipoCamaTest);
		assertEquals(camaTest.getPrecio(), TipoMobiliario.DEFAULT.getPrecio(),0);
	}

}
