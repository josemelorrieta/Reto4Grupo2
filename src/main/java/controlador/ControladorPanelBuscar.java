package controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import vista.panelBorder.PanelCenter;
import vista.panelCard.PanelBuscar;


public class ControladorPanelBuscar{

	private PanelBuscar pBuscar;
	private Controlador controlador;
	
	public ControladorPanelBuscar(PanelBuscar panel,Controlador cont){
		this.pBuscar=panel;
		this.controlador=cont;
		initListeners();
	}
	
	private void initListeners() {
		this.pBuscar.btnBuscar.addActionListener(new ListenerBotones());
	}

	private class ListenerBotones implements ActionListener{
		@Override
		public void actionPerformed(ActionEvent e) {
			((PanelCenter) pBuscar.getParent()).changePanel("2");
		}
		
	}
	

}
