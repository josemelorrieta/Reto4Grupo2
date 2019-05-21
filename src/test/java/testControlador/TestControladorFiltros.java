package testControlador;

import static org.junit.Assert.*;
import static org.mockito.Mockito.*;
import org.junit.Test;

import controlador.ControladorPanelFiltros;
import modelo.Modelo;
import vista.panelCard.PanelResBusqueda;

public class TestControladorFiltros {

	private ControladorPanelFiltros cTest;
	private Modelo modTest = new Modelo();
	private PanelResBusqueda visTest = new PanelResBusqueda();
	
	@Test
	public void testConstructor() {
		PanelResBusqueda visMock = mock(PanelResBusqueda.class);
		when(visMock.chkTipoAlojamiento.length).thenReturn(3);
		when(visMock.lblArrayServicios.length).thenReturn(3);
		when(visMock.chkTipoPension.length).thenReturn(3);
		cTest = new ControladorPanelFiltros(modTest, visMock);
		assertEquals(cTest.getModelo(), modTest);
		assertEquals(cTest.getVista(), visTest);
		assertEquals(cTest.getEstadosTipoAloj().length, 3);
		assertEquals(cTest.getEstadosServ().length, 3);
		assertEquals(cTest.getEstadosTipoPension().length, 3);
	}

	@Test
	public void test() {
		
	}
}
