package controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import vista.VentanaPpal;

public class ControladorPanelCondiciones {
	
	private VentanaPpal vis;
	
	public ControladorPanelCondiciones(VentanaPpal vis) {
		this.vis = vis;
		initListeners();
	}
	
	private void initListeners() {
		vis.pCondiciones.btnCerrar.addActionListener(new ListenerBoton());		
	}
	
	private class ListenerBoton implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			vis.pCondiciones.setVisible(false);
		}
		
	}
}
