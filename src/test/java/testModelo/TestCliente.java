package testModelo;

import static org.junit.Assert.*;

import org.junit.Test;

import modelo.Cliente;

public class TestCliente {
	
	private Cliente clienteTest;
	private String stringTest1="Test1";
	private String stringTest2="Test2";


	@Test
	public void testConstructor() {
		clienteTest = new Cliente(stringTest1);
		assertEquals(clienteTest.getNombre(), stringTest1);
	}
	
	@Test
	public void testConstructorVacio() {
		clienteTest = new Cliente();
		assertEquals(clienteTest.getNombre(), null);
	}
	
	@Test
	public void testSetNombre() {
		clienteTest = new Cliente(stringTest1);
		assertEquals(clienteTest.getNombre(), stringTest1);
		clienteTest.setNombre(stringTest2);
		assertEquals(clienteTest.getNombre(), stringTest2);
	}

}
