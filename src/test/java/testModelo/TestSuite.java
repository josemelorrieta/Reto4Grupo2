package testModelo;

import static org.junit.Assert.*;

import org.junit.Test;

import modelo.Suite;
import modelo.TipoHabitacion;
import modelo.Mobiliario;

public class TestSuite {

	private int metrosCuadradosTest=20;
	private Suite suiteTest;
	private Mobiliario[] arrayMobiliarioTest = {new Mobiliario(),new Mobiliario(),new Mobiliario()};
	private TipoHabitacion tipoHabitacionTest=TipoHabitacion.SUITE;
	private int intTest=23;

	@Test
	public void testConstructor() {
		suiteTest=new Suite(metrosCuadradosTest, arrayMobiliarioTest,intTest);
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
