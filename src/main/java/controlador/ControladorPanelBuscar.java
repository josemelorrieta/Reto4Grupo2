package controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import vista.panelCard.PanelBuscar;


public class ControladorPanelBuscar {

	private PanelBuscar pBuscar;
	
	public ControladorPanelBuscar(PanelBuscar panel){
		this.pBuscar=panel;
		initListeners();
	}
	
	private void initListeners() {
		this.pBuscar.btnBuscar.addActionListener(new ListenerBotones());
	}

	private class ListenerBotones implements ActionListener{
		@Override
		public void actionPerformed(ActionEvent e) {
			
			
		}
		
	}
	

}
