package testModelo;

import static org.junit.Assert.assertEquals;

import java.util.Date;

import org.junit.Test;

import modelo.Alojamiento;
import modelo.Cliente;
import modelo.DesglosePrecio;
import modelo.Dormitorio;
import modelo.Reserva;

public class TestReserva {
	
	private Reserva reservaTest;
	private String stringTest = "Test1";
	private Cliente clienteTest = new Cliente(stringTest);
	private Date fechaTest = null;
	private double doubleTest = 20;
	private Alojamiento alojTest = new Alojamiento();
	private Dormitorio dormTest = new Dormitorio();
	private DesglosePrecio desgloseTest = new DesglosePrecio();
	private String codPromoTest = "AAAAA";
	
	@Test
	public void testConstructorVacio() {
		reservaTest=new Reserva();
		reservaTest.setDesglose(desgloseTest);
		assertEquals(reservaTest.getCliente(), null);
		assertEquals(reservaTest.getDesglose(), desgloseTest);
		assertEquals(reservaTest.getFechaReserva(), null);
		assertEquals(reservaTest.getFechaEntrada(), null);
		assertEquals(reservaTest.getFechaSalida(), null);
		assertEquals(reservaTest.getAlojReservado(), null);
		assertEquals(reservaTest.getDormitorioReservado(), null);
	}
	
	@Test
	public void testConstructorAlojamiento() {
		reservaTest=new Reserva(clienteTest, desgloseTest, fechaTest, fechaTest, fechaTest,alojTest);
		assertEquals(reservaTest.getCliente(), clienteTest);
		assertEquals(reservaTest.getDesglose(), desgloseTest);
		assertEquals(reservaTest.getFechaReserva(), fechaTest);
		assertEquals(reservaTest.getFechaEntrada(), fechaTest);
		assertEquals(reservaTest.getFechaSalida(), fechaTest);
		assertEquals(reservaTest.getAlojReservado(), alojTest);
	}
	
	@Test
	public void testConstructorDormitorio() {
		reservaTest=new Reserva(clienteTest, desgloseTest, fechaTest, fechaTest, fechaTest,alojTest,dormTest);
		assertEquals(reservaTest.getCliente(), clienteTest);
		assertEquals(reservaTest.getDesglose(), desgloseTest);
		assertEquals(reservaTest.getFechaReserva(), fechaTest);
		assertEquals(reservaTest.getFechaEntrada(), fechaTest);
		assertEquals(reservaTest.getFechaSalida(), fechaTest);
		assertEquals(reservaTest.getAlojReservado(), alojTest);
		assertEquals(reservaTest.getDormitorioReservado(), dormTest);
	}
	
	@Test
	public void testCliente() {
		reservaTest=new Reserva();
		reservaTest.setCliente(clienteTest);
		assertEquals(reservaTest.getCliente(), clienteTest);
	}
	
	@Test
	public void testPrecio() {
		reservaTest=new Reserva();
		reservaTest.setDesglose(desgloseTest);
		assertEquals(reservaTest.getDesglose(), desgloseTest);
	}
	
	@Test
	public void testFechaReserva() {
		reservaTest=new Reserva();
		reservaTest.setFechaReserva(fechaTest);
		assertEquals(reservaTest.getFechaReserva(), null);
	}
	@Test
	public void testFechaEntrada() {
		reservaTest=new Reserva();
		reservaTest.setFechaEntrada(fechaTest);
		assertEquals(reservaTest.getFechaEntrada(), null);
	}
	@Test
	public void testFechaSalida() {
		reservaTest=new Reserva();
		reservaTest.setFechaSalida(fechaTest);
		assertEquals(reservaTest.getFechaSalida(), null);
	}
	@Test
	public void testAlojamientoReservado() {
		reservaTest=new Reserva();
		reservaTest.setAlojReservado(alojTest);
		assertEquals(reservaTest.getAlojReservado(), alojTest);
	}	
	@Test
	public void testHabitacionReservada() {
		reservaTest = new Reserva();
		reservaTest.setDormitorioReservado(dormTest);
		assertEquals(reservaTest.getDormitorioReservado(), dormTest);
	}

	@Test
	public void testCodPromocional() {
		reservaTest = new Reserva();
		reservaTest.setCodPromocional(codPromoTest);
		assertEquals(reservaTest.getCodPromocional(), codPromoTest);
	}
}
