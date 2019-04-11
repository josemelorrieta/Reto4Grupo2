package testModelo;

import static org.junit.Assert.*;

import java.util.Date;

import org.junit.Test;

import modelo.Alojamiento;
import modelo.Cliente;
import modelo.Habitacion;
import modelo.Reserva;

public class TestReserva {
	
	private Reserva reservaTest;
	private String stringTest1="Test1";
	private Cliente clienteTest=new Cliente(stringTest1);
	private Date fechaTest=null;
	private double doubleTest=20;
	private Alojamiento alojTest=new Alojamiento();
	private Habitacion habTest = new Habitacion();
	
	@Test
	public void testConstructorVacio() {
		reservaTest=new Reserva();
		assertEquals(reservaTest.getCliente(), null);
		assertEquals(reservaTest.getPrecio(), 0,0);
		assertEquals(reservaTest.getFechaReserva(), null);
		assertEquals(reservaTest.getFechaEntrada(), null);
		assertEquals(reservaTest.getFechaSalida(), null);
		assertEquals(reservaTest.getAlojReservado(), null);
		assertEquals(reservaTest.getHabitacionReservada(), null);
	}
	
	@Test
	public void testConstructorAlojamiento() {
		reservaTest=new Reserva(clienteTest, doubleTest, fechaTest, fechaTest, fechaTest,alojTest);
		assertEquals(reservaTest.getCliente(), clienteTest);
		assertEquals(reservaTest.getPrecio(), doubleTest,0);
		assertEquals(reservaTest.getFechaReserva(), fechaTest);
		assertEquals(reservaTest.getFechaEntrada(), fechaTest);
		assertEquals(reservaTest.getFechaSalida(), fechaTest);
		assertEquals(reservaTest.getAlojReservado(), alojTest);
	}
	
	@Test
	public void testConstructorHabitacion() {
		reservaTest=new Reserva(clienteTest, doubleTest, fechaTest, fechaTest, fechaTest,habTest);
		assertEquals(reservaTest.getCliente(), clienteTest);
		assertEquals(reservaTest.getPrecio(), doubleTest,0);
		assertEquals(reservaTest.getFechaReserva(), fechaTest);
		assertEquals(reservaTest.getFechaEntrada(), fechaTest);
		assertEquals(reservaTest.getFechaSalida(), fechaTest);
		assertEquals(reservaTest.getHabitacionReservada(), habTest);
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
	@Test
	public void testSetAlojReservado() {
		reservaTest=new Reserva();
		reservaTest.setAlojReservado(alojTest);
		assertEquals(reservaTest.getAlojReservado(), alojTest);
	}	
	@Test
	public void testHabitacionReservada() {
		reservaTest = new Reserva();
		reservaTest.setHabitacionReservada(habTest);
		assertEquals(reservaTest.getHabitacionReservada(), habTest);
	}

}
