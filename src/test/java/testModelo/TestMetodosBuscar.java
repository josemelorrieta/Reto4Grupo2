package testModelo;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import org.junit.Test;

import com.google.gson.Gson;

import BaseDatos.ConsultaBD;
import modelo.Localidad;
import modelo.MetodosBuscar;
import modelo.Modelo;

public class TestMetodosBuscar {
	
	Modelo mod = new Modelo();
	ConsultaBD bd = mock(ConsultaBD.class);
	Gson gson = mock(Gson.class);
	
	MetodosBuscar metBuscar = new MetodosBuscar(mod, bd);
	
	@Test
	public void metodosBuscar() {
		assertEquals(metBuscar.getBd(), bd);
		assertEquals(metBuscar.getMod(), mod);
	}

	@Test
	public void getBd() {
		assertEquals(metBuscar.getBd(), bd);
	}
	
	@Test
	public void setBd() {
		ConsultaBD bd1 = mock(ConsultaBD.class);
		metBuscar.setBd(bd1);
		assertEquals(metBuscar.getBd(), bd1);
	}
	
	@Test
	public void getMod() {
		assertEquals(metBuscar.getMod(), mod);
	}
	
	@Test
	public void setMod() {
		Modelo mod1 = new Modelo();
		metBuscar.setMod(mod1);
		assertEquals(metBuscar.getMod(), mod1);
	}
	
	@Test
	public void buscarLocalidades() {
		when(bd.consultarToGson("SELECT DISTINCT `localidad` FROM `direccion`")).thenReturn("");
		assertArrayEquals(metBuscar.buscarLocalidades(), null);
		
		String aux = "Bilbao";
		Localidad[] localidades = {new Localidad("Bilbao")};
		when(bd.consultarToGson("SELECT DISTINCT `localidad` FROM `direccion`")).thenReturn("");
		when(gson.fromJson(aux, Localidad[].class)).thenReturn(localidades);
		assertArrayEquals(metBuscar.buscarLocalidades(), localidades);
	}
}
