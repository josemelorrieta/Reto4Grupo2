package controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import vista.VentanaPpal;
import vista.panelBorder.PanelCenter;

public class ControladorPanelResBusqueda {
	private VentanaPpal vis;
	private Controlador controlador;
	
	public ControladorPanelResBusqueda(VentanaPpal vis,Controlador cont) {
		this.vis=vis;
		this.controlador=cont;
		initListeners();
	}

	private void initListeners() {
		vis.pSouth.pBotones.btnSiguiente.addActionListener(new ListenerBotones());
		vis.pSouth.pBotones.btnVolver.addActionListener(new ListenerBotones());
		
	}
	
	private class ListenerBotones implements ActionListener{
		@Override
		public void actionPerformed(ActionEvent e) {
			String accion = e.getActionCommand();
			switch (accion) {
				case "SIGUIENTE": ((PanelCenter) vis.pCenter).changePanel("3");break;
				case "VOLVER": ((PanelCenter) vis.pCenter).changePanel("1");
								vis.pSouth.pBotones.setVisible(false);
								break;
			}
		}
		
	}
}
