package controlador;

import vista.panelCard.PanelInfBotones;
import vista.panelCard.PanelResBusqueda;

public class ControladorPanelResBusqueda {
	private PanelResBusqueda pResBusqueda;
	private PanelInfBotones pInfBotones;
	private Controlador controlador;
	
	public ControladorPanelResBusqueda(PanelResBusqueda panel, PanelInfBotones panelInf,Controlador cont) {
		this.pResBusqueda=panel;
		this.pInfBotones=panelInf;
		this.controlador=cont;
	}
}
