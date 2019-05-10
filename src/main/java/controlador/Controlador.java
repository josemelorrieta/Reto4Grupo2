package controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;

import modelo.Dormitorio;
import modelo.Hotel;
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
	private ControladorPanelCondiciones cCondiciones;

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
		cCondiciones = new ControladorPanelCondiciones(vis);
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
					if (!vis.pCenter.pResBusq.resultBusq.isSelectionEmpty() && vis.pCenter.pResBusq.resultBusq.getSelectedValue().isDisponible()) {
						
						mod.aloj1 = vis.pCenter.pResBusq.resultBusq.getSelectedValue();
						if(mod.aloj1 instanceof Hotel) {
							vis.pCenter.pSelHab.setResultHab((Dormitorio[]) ((Hotel) mod.aloj1).getHabitaciones());
							vis.pCenter.nextPanel();
						}else {
							vis.pCenter.changePanel("4");
							cPago.pasarPrecioAPanelPago(mod, vis);
						}
					}
					break;
				case 3:	
					if(!vis.pCenter.pSelHab.resultHab.isSelectionEmpty() && vis.pCenter.pSelHab.resultHab.getSelectedValue().isDisponible()) {
						vis.pCenter.nextPanel();
						mod.reserva.setDormitorioReservado((Dormitorio)vis.pCenter.pSelHab.resultHab.getSelectedValue());
						cPago.pasarPrecioAPanelPago(mod, vis);
					}
					break;
				case 4:
					mod.clienteRegis = mod.mRegiLog.login(vis.pCenter.pLogin);
					if (mod.clienteRegis != null) {
						vis.pCenter.changePanel("6");
					}
					break;
				case 5:
					if (mod.mRegiLog.comprobarDatos()) {
						mod.clienteRegis = mod.mRegiLog.registro(vis.pCenter.pRegistro);
						if (mod.clienteRegis != null) {
							if(mod.bd.insertGenerico(mod.clienteRegis.toArray(), "cliente")) {
								vis.pCenter.nextPanel();;
								mod.mRegiLog.limpiar(vis.pCenter.pRegistro);
							} else {
								JOptionPane.showMessageDialog(vis.pCenter, "Error al guardar el cliente en la base de datos", "¡Error!", JOptionPane.ERROR_MESSAGE);
							}
						}
					} else {
						JOptionPane.showMessageDialog(vis.pCenter, "Debe rellenar todos los campos", "¡Atención!", JOptionPane.WARNING_MESSAGE);
					}
					break;
				case 6:
					vis.pCenter.nextPanel();
					break;
				case 7:
					if (mod.isPagoExitoso()) {
						vis.pCenter.nextPanel();
						mod.mPago.limpiar(vis.pCenter.pPago);
						mod.mRegiLog.limpiar(vis.pCenter.pLogin);
						mod.mRegiLog.limpiar(vis.pCenter.pRegistro);
						mod.setPagoExitoso(false);
						mod.mPago.imprimirBillete(mod.reserva);
						vis.pBotones.setBotonesVisible(false);
					}
					break;
				case 8:
					vis.pCenter.firstPanel();
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
					if(!(mod.aloj1 instanceof Hotel)) {
						vis.pCenter.changePanel("2");
					}else {
						vis.pCenter.prevPanel();
						mod.mRegiLog.limpiar(vis.pCenter.pRegistro);
					}
					break;
				case 5:
					vis.pCenter.prevPanel();
					break;
				case 6:
					vis.pCenter.changePanel("4");
					//mod.mPago.limpiar(vis.pCenter.pPago);
					break;
				case 7:
					vis.pCenter.prevPanel();
					}
				break;
			}
		}
	}
}
