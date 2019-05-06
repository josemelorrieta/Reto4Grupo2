package testModelo;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;

import org.junit.Test;

import BaseDatos.ConsultaBD;
import modelo.Cliente;
import modelo.Hotel;
import modelo.MetodosPanelPago;
import modelo.Reserva;

public class TestMetodosPanelPago {
	private ConsultaBD bd = new ConsultaBD(); 

	private MetodosPanelPago metPago=new MetodosPanelPago(bd);
	private double doubleTest=24.5673;
	private int intTest=2;
	private String stringNum1Test="50";
	private String stringNum2Test="-10";
	private float floatTest=50f;
	private ArrayList<String> stringCambiosEsperado= new ArrayList<String>(Arrays.asList("500 €: 1", "200 €: 1", "100 €: 1", "50 €: 1", "20 €: 1", "10 €: 1", "5 €: 1", "2 €: 1", "1 €: 1", "0.50 €: 1", "0.20 €: 1", "0.10 €: 1", "0.05 €: 1", "0.02 €: 1", "0.01 €: 1"));
	private String[] arrayStringEsperado = {"20.00","50.00"};
	private Reserva reservaTest=new Reserva(new Cliente("Pepe"), 40, new Date(), new Date(), new Date(), new Hotel(1,"JunjoHoteles", null, 0, 0, 0, null,true,null, 0));
	
	@Test
	public void testRedondear() {
		assertEquals(metPago.redondear(doubleTest, intTest), 24.57,0.0001);
		assertEquals(metPago.redondear(-doubleTest, intTest), -24.57,0.0001);
		assertEquals(metPago.redondear(0, intTest), 0,0.0001);
	}
	
	@Test
	public void doubleAString() {
		assertEquals(metPago.doubleAString(doubleTest), "24.57");
	}
	
	@Test
	public void stringADouble() {
		assertEquals(metPago.stringADouble(stringNum1Test), 50.0, 0.001);
	}
	
	@Test
	public void testStringAFloat() {
		assertEquals(metPago.stringAFloat(stringNum1Test),50,0);
	}
	
	@Test
	public void testFloatAString2Dec() {
		assertEquals(metPago.floatAString2Dec(floatTest),"50.00");
	}
	
	@Test
	public void testCambios() {
		assertEquals(metPago.Cambios("888.88"),stringCambiosEsperado);
		assertEquals(metPago.Cambios("0"),new ArrayList<String>());
	}
	
	@Test
	public void testComprobarPago() {
		assertEquals(metPago.comprobarPago(stringNum1Test),false);
		assertEquals(metPago.comprobarPago(stringNum2Test),true);
	}

	@Test
	public void testOperarDinero() {
		assertArrayEquals(metPago.operarDinero("50", "20", "30"),arrayStringEsperado);
	}
	
	@Test
	public void testImprimirBillete() {
		metPago.imprimirBillete(reservaTest);
	}
	

}
