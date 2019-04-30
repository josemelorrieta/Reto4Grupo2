package controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import modelo.Modelo;
import vista.VentanaPpal;

public class Controlador {

	private VentanaPpal vis;
	private Modelo mod;
	private ControladorPanelBuscar cBuscar;
	private ControladorPanelPago cPago;
	private ControladorPanelResBusqueda cResBusqueda;
	private ControladorPanelRegistro cRegistro;
	private ControladorPanelLogin cLogin;

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
		cLogin = new ControladorPanelLogin(vis, this, mod);
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
						mod.reserva.setAlojReservado(mod.hotel1);
						mod.reserva.setPrecio(vis.pCenter.pResBusq.resultBusq.getSelectedValue().getPrecioTAlta());
						mod.mPago.pasarPrecioAPanelPago(vis);
					}
					break;
				case 3:
					mod.clienteRegis = mod.mRegiLog.login(vis.pCenter.pLogin);
					if (mod.clienteRegis != null) {
						vis.pCenter.changePanel("5");
						mod.reserva.setCliente(mod.clienteRegis);
					}
					break;
				case 4:
					if (mod.mRegiLog.comprobarDatos()) {
						mod.clienteRegis = mod.mRegiLog.registro(vis.pCenter.pRegistro);
						if (mod.clienteRegis != null) {
							mod.bd.insertGenerico(mod.clienteRegis.toArray(), "cliente");
							vis.pCenter.changePanel("5");
							mod.mRegiLog.limpiar(vis.pCenter.pRegistro);
						}
					}
					break;
				case 5:
					if (mod.isPagoExitoso()) {
						vis.pCenter.changePanel("1");
						mod.mPago.limpiar(vis.pCenter.pPago);
						mod.mRegiLog.limpiar(vis.pCenter.pLogin);
						mod.mRegiLog.limpiar(vis.pCenter.pRegistro);
						mod.setPagoExitoso(false);
						mod.mPago.crearReserva(mod);
						mod.mPago.imprimirBillete(mod.reserva);
						vis.pBotones.setBotonesVisible(false);
					}
					break;
				}
				break;
			case "VOLVER":
				switch (vis.pCenter.currentIndex) {
				case 2:
					vis.pCenter.prevPanel();
					vis.pBotones.setBotonesVisible(false);
					break;
				case 3:
					vis.pCenter.prevPanel();
					//mod.mRegiLog.limpiar(vis.pCenter.pLogin);
					break;
				case 4:
					vis.pCenter.prevPanel();
					mod.mRegiLog.limpiar(vis.pCenter.pRegistro);
					break;
				case 5:
					vis.pCenter.changePanel("3");
					//mod.mPago.limpiar(vis.pCenter.pPago);
					break;
				}
				break;
			}
		}
	}
}
