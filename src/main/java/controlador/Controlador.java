package controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import modelo.Cliente;
import modelo.Modelo;
import vista.VentanaPpal;

public class Controlador {

	private VentanaPpal vis;
	private Modelo mod;
	private ControladorPanelBuscar cBuscar;
	private ControladorPanelPago cPago;
	private ControladorPanelResBusqueda cResBusqueda;
	private ControladorPanelRegistro cRegistro;

	public Controlador(VentanaPpal vista, Modelo modelo) {
		this.vis = vista;
		this.mod = modelo;
		addControladores();
		initListeners();
	}

	private void addControladores() {
		cBuscar = new ControladorPanelBuscar(vis, this, mod);
		cPago = new ControladorPanelPago(vis, this, mod);
		cResBusqueda = new ControladorPanelResBusqueda(vis, this);
		cRegistro = new ControladorPanelRegistro(vis, this, mod);
	}

	private void initListeners() {
		vis.pBotones.btnSiguiente.addActionListener(new ListenerBotonesInferiores());
		vis.pBotones.btnVolver.addActionListener(new ListenerBotonesInferiores());
	}

	private class ListenerBotonesInferiores implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent e) {
			String accion = e.getActionCommand();
			switch (accion) {
			case "SIGUIENTE":
				switch (vis.pCenter.currentIndex) {
				case 2:
					if (!vis.pCenter.pResBusq.resultBusq.isSelectionEmpty()) {
						vis.pCenter.changePanel("3");
						mod.hotel1 = vis.pCenter.pResBusq.resultBusq.getSelectedValue();
						mod.mPago.pasarPrecioAPanelPago(vis);
					}
					break;
				case 3:
					if (mod.mRegiLog.comprobarDatos()) {
						mod.clienteRegis = new Cliente();
						mod.bd.insertGenerico(mod.clienteRegis.toArray(), "cliente");
						vis.pCenter.changePanel("4");
					}
					break;
				case 4:
					if (mod.isPagoExitoso()) {
						vis.pCenter.changePanel("1");
						vis.pCenter.pPago.limpiar();
						mod.setPagoExitoso(false);
						mod.mPago.crearReserva(mod);
						mod.mPago.imprimirBillete(mod.reserva);
						vis.pBotones.setBotonesVisible(false);
					}
					break;
				}
				break;
			case "VOLVER":
				vis.pCenter.prevPanel();
				if (vis.pCenter.currentIndex == 1) {
					vis.pBotones.setBotonesVisible(false);
				}
				break;
			}
		}
	}
}
