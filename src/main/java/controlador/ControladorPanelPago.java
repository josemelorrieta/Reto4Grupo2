package controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;

import modelo.Modelo;
import vista.VentanaPpal;

public class ControladorPanelPago {

	private VentanaPpal vis;
	private Modelo mod;

	public ControladorPanelPago(VentanaPpal vis, Modelo mod) {
		this.vis = vis;
		this.mod = mod;
		initListeners();
	}

	private void initListeners() {
		for (JButton btn : vis.pCenter.pPago.arrayBtn) {
			btn.addActionListener(new ListenerBotonesDinero());
		}

	}

	private class ListenerBotonesDinero implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent e) {
			mod.mPago.sumarDinero(vis.pCenter.pPago, ((JButton) e.getSource()).getText(), mod);
		}
	}

	/**
	 * Metodo que se invoca cuando el usuario decide pasar de panel y proceder al
	 * pago, le pasa el precio al panel de pago
	 * 
	 * @param vis
	 */
	public void pasarPrecioAPanelPago(Modelo mod, VentanaPpal vis) {
		vis.pCenter.pPago.textAPagar.setText(String.valueOf(mod.mPago.dosDec.format(mod.desglosePrecio.getTotal())));
	}
}
