package testModelo;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import org.junit.Test;

import BaseDatos.ConsultaBD;
import modelo.Alojamiento;
import modelo.Hotel;
import modelo.MetodosBuscar;
import modelo.Modelo;

public class TestMetodosBuscar {
	
	Modelo mod = new Modelo();
	ConsultaBD bd = mock(ConsultaBD.class);
	
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
		when(bd.consultarToGson("SELECT DISTINCT `localidad` 'auxiliar' FROM `direccion`")).thenReturn("[{\"auxiliar\":\"Bilbao\"}]");
		String[] localidades = {"Bilbao", "Zaragoza"};
		String[] localidadesBBDD = metBuscar.buscarLocalidades();
		assertEquals(localidadesBBDD[0], localidades[0]);
		
		when(bd.consultarToGson("SELECT DISTINCT `localidad` 'auxiliar' FROM `direccion`")).thenReturn(null);
		assertArrayEquals(metBuscar.buscarLocalidades(), null);
	}
	
	@Test
	public void cargarDireccion() {
		Hotel hotel = new Hotel();
		hotel.setId(1);
		when(bd.consultarToGson("SELECT `calle`,`codPostal`,`localidad` FROM `direccion` WHERE `idDir` = (SELECT `idDir` FROM `hotel` WHERE `idHot` = " + hotel.getId() + ")")).thenReturn("[{\"calle\":\"Plaza Moyua\",\"codPostal\":40002,\"localidad\":\"Bilbao\"}]");
		//assertEquals(metBuscar.cargarDireccion(hotel, "Hotel", "idApart").getLocalidad(), "Bilbao" );
	}
	
	@Test
	public void cargarHabitaciones() {
		Hotel hotel = new Hotel();
		hotel.setId(1);
		when(bd.consultarToGson("SELECT `idHab`, `metros` 'm2', 'DORMITORIO' AS `tipoHabitacion` FROM `dormitorio` d, `habhotel` h WHERE d.`idDorm` IN (SELECT `idDorm` FROM `habhotel` WHERE `idHot`=" + hotel.getId() + ") AND d.`idDorm`=h.`idDorm`")).thenReturn("[{\"idHab\":1,\"m2\":20,\"tipoHabitacion\":\"DORMITORIO\"}]");
		
		//assertEquals(metBuscar.cargarHabitaciones(hotel)[0].getIdHab(), 1 );
	}
	
	@Test
	public void cargarHoteles() {
		MetodosBuscar metBuscarMock = mock(MetodosBuscar.class);
		String localidad = "Bilbao";
		String tabla = "hotel";
		String id = "idHot";
		Alojamiento aloj = new Hotel();
		aloj.setId(1);
		when(bd.consultarToGson("SELECT `idHot` 'id',`nombre`,`numEstrellas`,`pvpTAlta` 'precioTAlta',`pvpTBaja` 'precioTBaja',`pvpRecFestivo` 'precioTFest', `pvpM2`, `imagen` FROM `hotel` WHERE `idDir` IN (SELECT `idDir` FROM `direccion` WHERE `localidad`='" + localidad + "')")).thenReturn("[{\"id\":1,\"nombre\":\"Hotel Meliá\",\"numEstrellas\":5,\"precioTAlta\":49.9,\"precioTBaja\":29.95,\"precioTFest\":8.95,\"imagen\":\"melia_bilbao\"}]");
		when(bd.consultarToGson("SELECT `calle`,`codPostal`,`localidad` FROM `direccion` WHERE `idDir` = (SELECT `idDir` FROM `" + tabla + "` WHERE `" + id + "` = " + aloj.getId() + ")")).thenReturn("[{\"calle\":\"Gran Via\",\"codPostal\":48001,\"localidad\":\"Bilbao\"}]");
		metBuscar.cargarHoteles(localidad);
		assertEquals(mod.hotelesBusqueda[0].getId(), 1);
		
	}
}
