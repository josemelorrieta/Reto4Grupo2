package controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;

import modelo.Alojamiento;
import modelo.Casa;
import modelo.Hotel;
import modelo.Modelo;
import vista.VentanaPpal;

public class ControladorPanelPago {

	private VentanaPpal vis;
	private Modelo mod;
	private Controlador controlador;

	public ControladorPanelPago(VentanaPpal vis, Controlador cont, Modelo mod) {
		this.vis = vis;
		this.controlador = cont;
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
		Alojamiento aloj = vis.pCenter.pResBusq.resultBusq.getSelectedValue();
		if (aloj instanceof Hotel) {
			vis.pCenter.pPago.textAPagar.setText(mod.mPago.doubleAString( ((Hotel)aloj).calcularPrecioBaseHotel(mod.festivos,mod.reserva)));
		} else {
			vis.pCenter.pPago.textAPagar.setText(mod.mPago.doubleAString( ((Casa)aloj).calcularPrecioBaseCasa(mod.festivos,mod.reserva)));
		}
	}
}
