package testModelo;

import static org.junit.Assert.*;

import org.junit.Test;

import modelo.Alojamiento;
import modelo.Cama;
import modelo.Casa;
import modelo.Direccion;
import modelo.Dormitorio;
import modelo.Habitacion;
import modelo.Mobiliario;
import modelo.TipoCama;
import modelo.TipoMobiliario;

public class TestCasa {

	private Casa casaTest;
	private int intTest = 2;
	private String stringTest = "Test1";
	private Direccion direccionTest = new Direccion();
	private double doubleTest = 20.0;
	private boolean boolTest = true;

	private Mobiliario[] arrayMobiliarioTest= {new Cama(TipoCama.INDIVIDUAL),new Mobiliario(TipoMobiliario.ARMARIO)};
	private Habitacion[] arrayHabTest = {new Habitacion(),new Habitacion(),new Dormitorio(2, 20, arrayMobiliarioTest)};

	@Test
	public void testConstructorVacio() {
		casaTest = new Casa();
		assertArrayEquals(casaTest.getHabitaciones(), null);
		assertEquals(casaTest.getNumBanios(), 0);
		assertEquals(casaTest.getM2(), 0);
	}

	@Test
	public void testConstructor1() {
		casaTest = new Casa(intTest, stringTest, direccionTest, doubleTest, doubleTest, doubleTest, stringTest, boolTest);
		assertArrayEquals(casaTest.getHabitaciones(), null);
		assertEquals(casaTest.getNumBanios(), 0);
		assertEquals(casaTest.getM2(), 0);
	}

	@Test
	public void testConstructor2() {
		casaTest = new Casa(intTest, stringTest, direccionTest, doubleTest, doubleTest, doubleTest, stringTest, boolTest);
		assertArrayEquals(casaTest.getHabitaciones(), null);
		assertEquals(casaTest.getNumBanios(), 0);
		assertEquals(casaTest.getM2(), 0);
	}

}
