package testModelo;

import static org.junit.Assert.*;

import java.util.Date;

import org.junit.Test;

import modelo.Cliente;
import modelo.Sexo;

public class TestCliente {
	
	private Cliente clienteTest;
	private String dniTest = "Test";
	private String nombreTest = "Test";
	private String apellidosTest = "Test";
	private Date fechaNacTest = new Date(12333);
	private Sexo sexoTest = Sexo.Otros;
	private String passwdTest = "Test";

	@Test
	public void testConstructorVacio() {
		clienteTest = new Cliente();
		assertEquals(clienteTest.getNombre(), null);
	}
	
	@Test
	public void testConstructor() {
		clienteTest = new Cliente(nombreTest);
		assertEquals(clienteTest.getNombre(), nombreTest);
	}
	
	@Test
	public void testConstructorParametros() {
		clienteTest = new Cliente(dniTest,nombreTest,apellidosTest,fechaNacTest,sexoTest,passwdTest);
		assertEquals(clienteTest.getDni(), dniTest);
		assertEquals(clienteTest.getNombre(), nombreTest);
		assertEquals(clienteTest.getApellidos(), apellidosTest);
		assertEquals(clienteTest.getFechaNac(), fechaNacTest);
		assertEquals(clienteTest.getSexo(), sexoTest);
		assertEquals(clienteTest.getPassword(), passwdTest);
	}
	
	@Test
	public void testDni() {
		clienteTest = new Cliente();
		clienteTest.setDni(dniTest);
		assertEquals(clienteTest.getDni(), dniTest);
	}
	
	@Test
	public void testNombre() {
		clienteTest = new Cliente();
		clienteTest.setNombre(nombreTest);
		assertEquals(clienteTest.getNombre(), nombreTest);
	}

	@Test
	public void testApellidos() {
		clienteTest = new Cliente();
		clienteTest.setApellidos(apellidosTest);
		assertEquals(clienteTest.getApellidos(), apellidosTest);
	}
	
	@Test
	public void testFechaNac() {
		clienteTest = new Cliente();
		clienteTest.setFechaNac(fechaNacTest);
		assertEquals(clienteTest.getFechaNac(), fechaNacTest);
	}
	
	@Test
	public void testSexo() {
		clienteTest = new Cliente();
		clienteTest.setSexo(sexoTest);
		assertEquals(clienteTest.getSexo(), sexoTest);
	}
	
	@Test
	public void testPassword() {
		clienteTest = new Cliente();
		clienteTest.setPassword(passwdTest);
		assertEquals(clienteTest.getPassword(), passwdTest);
	}
}
