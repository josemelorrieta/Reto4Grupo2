package testModelo;

import static org.junit.Assert.*;

import java.util.Date;

import org.junit.Test;

import modelo.Cliente;
import modelo.Reserva;

public class TestReserva {
	
	private String stringTest1="Test1";
	private Cliente clienteTest=new Cliente(stringTest1);
	private Date fechaTest=null;
	private double doubleTest=20;
	private Reserva reservaTest;

	@Test
	public void testConstructor() {
		reservaTest=new Reserva(clienteTest, doubleTest, fechaTest, fechaTest, fechaTest);
		assertEquals(reservaTest.getCliente(), clienteTest);
		assertEquals(reservaTest.getPrecio(), doubleTest,0);
		assertEquals(reservaTest.getFechaReserva(), fechaTest);
		assertEquals(reservaTest.getFechaEntrada(), fechaTest);
		assertEquals(reservaTest.getFechaSalida(), fechaTest);
	}
	
	@Test
	public void testConstructorVacio() {
		reservaTest=new Reserva();
		assertEquals(reservaTest.getCliente(), null);
		assertEquals(reservaTest.getPrecio(), 0,0);
		assertEquals(reservaTest.getFechaReserva(), null);
		assertEquals(reservaTest.getFechaEntrada(), null);
		assertEquals(reservaTest.getFechaSalida(), null);
	}
	
	@Test
	public void testSetCliente() {
		reservaTest=new Reserva();
		reservaTest.setCliente(clienteTest);
		assertEquals(reservaTest.getCliente(), clienteTest);
	}
	
	@Test
	public void testSetPrecio() {
		reservaTest=new Reserva();
		reservaTest.setPrecio(doubleTest);
		assertEquals(reservaTest.getPrecio(), doubleTest,0);
	}
	
	@Test
	public void testSetFechaReserva() {
		reservaTest=new Reserva();
		reservaTest.setFechaReserva(fechaTest);
		assertEquals(reservaTest.getFechaReserva(), null);
	}
	@Test
	public void testSetFechaEntrada() {
		reservaTest=new Reserva();
		reservaTest.setFechaEntrada(fechaTest);
		assertEquals(reservaTest.getFechaEntrada(), null);
	}
	@Test
	public void testSetFechaSalida() {
		reservaTest=new Reserva();
		reservaTest.setFechaSalida(fechaTest);
		assertEquals(reservaTest.getFechaSalida(), null);
	}

}
