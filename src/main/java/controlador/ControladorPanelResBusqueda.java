package controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import vista.panelBorder.PanelCenter;
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
		initListeners();
	}

	private void initListeners() {
		this.pInfBotones.btnSiguiente.addActionListener(new ListenerBotones());
		this.pInfBotones.btnVolver.addActionListener(new ListenerBotones());
		
	}
	
	private class ListenerBotones implements ActionListener{
		@Override
		public void actionPerformed(ActionEvent e) {
			String accion = e.getActionCommand();
			switch (accion) {
				case "SIGUIENTE": ((PanelCenter) pResBusqueda.getParent()).changePanel("3");break;
				case "VOLVER": ((PanelCenter) pResBusqueda.getParent()).changePanel("1");break;
			}
		}
		
	}
}
