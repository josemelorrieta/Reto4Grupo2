package controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;

import modelo.MetodosPanelPago;
import modelo.Modelo;
import vista.panelCard.PanelPago;

public class ControladorPanelPago {

	private PanelPago pPago;
	private Modelo mod;
	private Controlador controlador;
	
	public ControladorPanelPago(PanelPago panel,Controlador cont,Modelo mod) {
		this.pPago=panel;
		this.controlador=cont;
		this.mod=mod;
		initListeners();
	}

	private void initListeners() {
		for(JButton btn : this.pPago.arrayBtn) {
			btn.addActionListener(new ListenerBotones());
		}
		
	}
	
	private class ListenerBotones implements ActionListener{
		@Override
		public void actionPerformed(ActionEvent e) {
			mod.mPago.sumarDinero(pPago, (JButton) e.getSource());
		}
		
	}
	
}
