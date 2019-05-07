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

	private Dormitorio dormitorioTest;
	private int intTest = 1;
	private int intTest1 = 10;
	private TipoHabitacion tipoHabitacionTest = TipoHabitacion.DORMITORIO;
	private Mobiliario[] arrayMobiliarioTest= {new Cama(TipoCama.INDIVIDUAL),new Mobiliario(TipoMobiliario.ARMARIO)};
	private boolean boolTest=true;
	
	@Test
	public void testConstructor1() {
		dormitorioTest=new Dormitorio(intTest, intTest, arrayMobiliarioTest);
		assertArrayEquals(dormitorioTest.getMobiliario(), arrayMobiliarioTest);
		assertEquals(dormitorioTest.getTipoHabitacion(), boolTest);
		assertEquals(dormitorioTest.isDisponible(), boolTest);
		assertEquals(dormitorioTest.getPrecio(), (dormitorioTest.getTipoHabitacion().getPreciom2()*dormitorioTest.getM2())+arrayMobiliarioTest[0].getPrecio()+arrayMobiliarioTest[1].getPrecio(),0);
	}
	
	@Test
	public void testSetM2() {
		dormitorioTest=new Dormitorio(intTest, intTest, arrayMobiliarioTest);
		dormitorioTest.setM2(intTest1);
		assertEquals(dormitorioTest.getPrecio(), (dormitorioTest.getTipoHabitacion().getPreciom2()*dormitorioTest.getM2())+arrayMobiliarioTest[0].getPrecio()+arrayMobiliarioTest[1].getPrecio(),0);
	}

}
