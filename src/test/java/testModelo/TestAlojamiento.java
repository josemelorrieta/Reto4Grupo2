package testModelo;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;

import org.junit.Test;

import modelo.Alojamiento;
import modelo.Direccion;
import modelo.Habitacion;

public class TestAlojamiento {
	
	private Alojamiento alojamientoTest;
	
	private int intTest = 0;
	private String stringTest = "Test";
	private Direccion direccionTest = new Direccion();
	private double doubleTest = 0.99;
	private boolean boolTest = false;
	private Habitacion[] habitacionesTest = {new Habitacion(), new Habitacion()};
	
	@Test
	public void testConstructorVacio() {
		alojamientoTest=new Alojamiento();
		assertEquals(alojamientoTest.getId(), 0);
		assertEquals(alojamientoTest.getNombre(), null);
		assertEquals(alojamientoTest.getDireccion(), null);
		assertEquals(alojamientoTest.getPvpTAlta(), 0, 0.0001);
		assertEquals(alojamientoTest.getPvpTBaja(), 0, 0.0001);
		assertEquals(alojamientoTest.getPvpRecFestivo(), 0, 0.0001);
		assertEquals(alojamientoTest.getPvpM2(), 0, 0.0001);
		assertEquals(alojamientoTest.getImagen(), null);
		assertArrayEquals(alojamientoTest.getHabitaciones(), null);
		assertEquals(alojamientoTest.getPvpTotal(), 0, 0.0001);
		assertEquals(alojamientoTest.isDisponible(), true);
		assertEquals(alojamientoTest.getNumCamas(), 0);
	}
	
	@Test
	public void testId() {
		alojamientoTest = new Alojamiento();
		alojamientoTest.setId(intTest);
		assertEquals(alojamientoTest.getId(), intTest);
	}
	
	@Test
	public void testNombre() {
		alojamientoTest=new Alojamiento();
		alojamientoTest.setNombre(stringTest);
		assertEquals(alojamientoTest.getNombre(), stringTest);	
	}
	
	@Test
	public void testDireccion() {
		alojamientoTest=new Alojamiento();
		alojamientoTest.setDireccion(direccionTest);
		assertEquals(alojamientoTest.getDireccion(), direccionTest);	
	}	
	
	@Test
	public void testPvpTAlta() {
		alojamientoTest=new Alojamiento();
		alojamientoTest.setPvpTAlta(doubleTest);
		assertEquals(alojamientoTest.getPvpTAlta(), doubleTest, 0.0001);	
	}
	
	@Test
	public void testPvpTBaja() {
		alojamientoTest=new Alojamiento();
		alojamientoTest.setPvpTBaja(doubleTest);
		assertEquals(alojamientoTest.getPvpTBaja(), doubleTest, 0.0001);	
	}
	
	@Test
	public void testPvpRecFestivo() {
		alojamientoTest=new Alojamiento();
		alojamientoTest.setPvpRecFestivo(doubleTest);
		assertEquals(alojamientoTest.getPvpRecFestivo(), doubleTest, 0.0001);	
	}
	
	@Test
	public void testPvpM2() {
		alojamientoTest=new Alojamiento();
		alojamientoTest.setPvpM2(doubleTest);
		assertEquals(alojamientoTest.getPvpM2(), doubleTest, 0.0001);	
	}
	
	@Test
	public void testImagen() {
		alojamientoTest = new Alojamiento();
		alojamientoTest.setImagen(stringTest);
		assertEquals(alojamientoTest.getImagen(), stringTest);
	}
	
	@Test
	public void testHabitaciones() {
		alojamientoTest = new Alojamiento();
		alojamientoTest.setHabitaciones(habitacionesTest);
		assertArrayEquals(alojamientoTest.getHabitaciones(), habitacionesTest);
	}
	
	@Test
	public void testPvpTotal() {
		alojamientoTest=new Alojamiento();
		doubleTest = 0;
		//alojamientoTest.setPvpTotal();
		assertEquals(alojamientoTest.getPvpTotal(), doubleTest, 0.0001);	
	}
	
	@Test
	public void testDisponible() {
		alojamientoTest = new Alojamiento();
		alojamientoTest.setDisponible(true);
		assertEquals(alojamientoTest.isDisponible(), boolTest);
	}
	
	@Test
	public void testNumCamas() {
		alojamientoTest = new Alojamiento();
		intTest = 0;
		//alojamientoTest.setNumCamas(intTest);
		assertEquals(alojamientoTest.getNumCamas(), intTest);
	}
}
