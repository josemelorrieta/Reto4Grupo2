package controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;

import modelo.Modelo;
import vista.VentanaPpal;

/**
 * Controlador para el panel pago
 *
 */
public class ControladorPanelPago {

	private VentanaPpal vis;
	private Modelo mod;

	/**
	 * Constructor para el controlador
	 * @param vis Vista la cual edita
	 * @param mod Modelo donde se guarda la informacion
	 */
	public ControladorPanelPago(VentanaPpal vis, Modelo mod) {
		this.vis = vis;
		this.mod = mod;
		initListeners();
	}

	/**
	 * Inicializador para los listeners
	 */
	private void initListeners() {
		for (JButton btn : vis.pCenter.pPago.arrayBtn) {
			btn.addActionListener(new ListenerBotonesDinero());
		}

	}

	/**
	 * Listeners para los botones de las monedas
	 *
	 */
	private class ListenerBotonesDinero implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent e) {
			mod.mPago.sumarDinero(vis.pCenter.pPago, ((JButton) e.getSource()).getText(), mod);
		}
	}

}
