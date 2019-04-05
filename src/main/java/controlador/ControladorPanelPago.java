package controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;

import modelo.MetodosPanelPago;
import vista.panelCard.PanelPago;

public class ControladorPanelPago {

	private PanelPago pPago;
	private MetodosPanelPago mPago;
	private Controlador controlador;
	
	public ControladorPanelPago(PanelPago panel,Controlador cont) {
		this.pPago=panel;
		this.controlador=cont;
		this.mPago=new MetodosPanelPago();
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
			mPago.sumarDinero(pPago, (JButton) e.getSource());
		}
		
	}
	
}
