package testModelo;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import modelo.Cama;
import modelo.Mobiliario;
import modelo.Suite;
import modelo.TipoHabitacion;

public class TestSuite {

	private int idHabTest = 1;
	private int metrosCuadradosTest=20;
	private Suite suiteTest;
	private Mobiliario[] arrayMobiliarioTest = {new Mobiliario(),new Mobiliario(),new Mobiliario()};
	private Cama[] arrayCamasTest = {new Cama()};
	private TipoHabitacion tipoHabitacionTest=TipoHabitacion.SUITE;
	private int intTest=23;

	@Test
	public void testConstructor() {
		suiteTest=new Suite(idHabTest, metrosCuadradosTest, arrayMobiliarioTest, arrayCamasTest, intTest);
		assertEquals(suiteTest.getIdSuite(),intTest);
		assertEquals(suiteTest.getTipoHabitacion(), tipoHabitacionTest);
	}
	
	@Test
	public void testConstructorVacio() {
		suiteTest=new Suite();
		assertEquals(suiteTest.getIdSuite(), 0);
		assertEquals(suiteTest.getTipoHabitacion(), tipoHabitacionTest);
	}
	
	@Test
	public void testIdSuite() {
		suiteTest=new Suite();
		suiteTest.setIdSuite(intTest);
		assertEquals(suiteTest.getIdSuite(), intTest);
	}


}
