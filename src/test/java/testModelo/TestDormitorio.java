package testModelo;

import static org.junit.Assert.*;

import org.junit.Test;

import modelo.Cama;
import modelo.Dormitorio;
import modelo.Habitacion;
import modelo.Mobiliario;
import modelo.TipoCama;
import modelo.TipoHabitacion;
import modelo.TipoMobiliario;

public class TestDormitorio {

	private Dormitorio dormitorioTest = new Dormitorio();
	private Mobiliario[] arrayMobiliarioTest = { new Cama(TipoCama.INDIVIDUAL), new Mobiliario(TipoMobiliario.ARMARIO) };
	private boolean boolTest = true;

//	@Test
//	public void testConstructor1() {
//		Mobiliario[] arrayMobiliarioTest = { new Cama(TipoCama.INDIVIDUAL), new Mobiliario(TipoMobiliario.ARMARIO) };
//
//		dormitorioTest = new Dormitorio(intTest, intTest, arrayMobiliarioTest);
//		assertArrayEquals(dormitorioTest.getMobiliario(), arrayMobiliarioTest);
//		assertEquals(dormitorioTest.getTipoHabitacion(), boolTest);
//		assertEquals(dormitorioTest.isDisponible(), boolTest);
//		assertEquals(dormitorioTest.getPrecio(),
//				(dormitorioTest.getTipoHabitacion().getPreciom2() * dormitorioTest.getM2())
//						+ arrayMobiliarioTest[0].getPrecio() + arrayMobiliarioTest[1].getPrecio(),
//				0);
//	}

	/**
	 * @Test public void testSetM2() { dormitorioTest=new Dormitorio(intTest,
	 *       intTest, arrayMobiliarioTest); dormitorioTest.setM2(intTest1);
	 *       assertEquals(dormitorioTest.getPrecio(),
	 *       (dormitorioTest.getTipoHabitacion().getPreciom2()*dormitorioTest.getM2())+arrayMobiliarioTest[0].getPrecio()+arrayMobiliarioTest[1].getPrecio(),0);
	 *       }
	 **/
	
	@Test()
	public void testSetMobiliario() {
		dormitorioTest.setMobiliario(arrayMobiliarioTest);
		
		assertArrayEquals(dormitorioTest.getMobiliario(), arrayMobiliarioTest);
	}
	
	@Test
	public void testIsDisponible() {
		dormitorioTest.setDisponible(true);
		
		assertEquals (dormitorioTest.isDisponible(), true);
	}
	
	@Test
	public void testCalcularPrecio() {
		double precioTest = arrayMobiliarioTest[0].getPrecio() + arrayMobiliarioTest[1].getPrecio();
		assertEquals(dormitorioTest.calcularPrecio(0), precioTest, 0.01);
	}

}
