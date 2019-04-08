package controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;

import modelo.Modelo;
import vista.VentanaPpal;
import vista.panelCard.PanelPago;

public class ControladorPanelPago {

	private VentanaPpal vis;
	private Modelo mod;
	private Controlador controlador;
	
	public ControladorPanelPago(VentanaPpal vis,Controlador cont,Modelo mod) {
		this.vis=vis;
		this.controlador=cont;
		this.mod=mod;
		initListeners();
	}

	private void initListeners() {
		for(JButton btn : vis.pCenter.pPago.arrayBtn) {
			btn.addActionListener(new ListenerBotonesDinero());
		}
		
	}
	
	private class ListenerBotonesDinero implements ActionListener{
		@Override
		public void actionPerformed(ActionEvent e) {
			mod.mPago.sumarDinero(vis.pCenter.pPago, (JButton) e.getSource());
		}
	}
}
