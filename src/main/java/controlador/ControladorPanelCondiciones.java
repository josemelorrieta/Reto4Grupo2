package controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import vista.VentanaPpal;

/**
 * Controlador para el panel condiciones
 *
 */
public class ControladorPanelCondiciones {
	
	private VentanaPpal vis;
	
	/**
	 * Constructor para el controlador
	 * @param vis Vista la cual edita
	 */
	public ControladorPanelCondiciones(VentanaPpal vis) {
		this.vis = vis;
		initListeners();
	}
	
	/**
	 * Inicializador para los listeners
	 */
	private void initListeners() {
		vis.pCondiciones.btnCerrar.addActionListener(new ListenerBoton());		
	}
	
	/**
	 * Listener para el boton de confirmacion
	 *
	 */
	private class ListenerBoton implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			vis.pCondiciones.setVisible(false);
		}
		
	}
}
