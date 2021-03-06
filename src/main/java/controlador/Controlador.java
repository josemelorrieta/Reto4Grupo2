package controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;

import modelo.Casa;
import modelo.DesglosePrecio;
import modelo.Dormitorio;
import modelo.Hotel;
import modelo.Modelo;
import vista.VentanaPpal;

/**
 * Controlador principal del programa, con modelo, vista y otros controladores
 * menores
 *
 */
public class Controlador {

	private VentanaPpal vis;
	private Modelo mod;
	private ControladorPanelBuscar cBuscar;
	private ControladorPanelPago cPago;
	private ControladorPanelFiltros cResBusqueda;
	private ControladorPanelRegistro cRegistro;
	private ControladorPanelLogin cLogin;
	private ControladorPanelCondiciones cCondiciones;
	private ControladorPanelResumenPago cResumenPago;
	private ControladorPanelResumenReserva cResumenRes;
	private ControladorPanelAcompaniante cAcompaniante;
	private ControladorPanelServicios cServicios;
	private ControladorPanelSelHab cSelHabitacion;

	/**
	 * Constructor del controlador
	 * 
	 * @param vista  Vista la cual controla
	 * @param modelo Modelo del cual recoge datos y los procesa
	 */
	public Controlador(VentanaPpal vista, Modelo modelo) {
		this.vis = vista;
		this.mod = modelo;
		addControladores();
		initListeners();
	}

	/**
	 * Inicializacion de controladores menores
	 */
	private void addControladores() {
		cBuscar = new ControladorPanelBuscar(vis, this, mod);
		cPago = new ControladorPanelPago(vis, mod);
		cResBusqueda = new ControladorPanelFiltros(mod, vis.pCenter.pResBusq);
		cRegistro = new ControladorPanelRegistro(vis, this, mod);
		cLogin = new ControladorPanelLogin(vis, this, mod);
		cCondiciones = new ControladorPanelCondiciones(vis);
		cResumenRes = new ControladorPanelResumenReserva(vis, mod);
		cResumenPago = new ControladorPanelResumenPago(mod, vis.pCenter.pResumenPago);
		cAcompaniante = new ControladorPanelAcompaniante(vis, this, mod);
		cServicios = new ControladorPanelServicios(vis, mod);
		cSelHabitacion = new ControladorPanelSelHab(vis);
	}

	/**
	 * Inicializacion de listeners para los botones de siguente/volver
	 */
	private void initListeners() {
		vis.pBotones.btnSiguiente.addActionListener(new ListenerBotonesInferiores());
		vis.pBotones.btnVolver.addActionListener(new ListenerBotonesInferiores());
	}

	/**
	 * Listeners para los botones de siguente/volver
	 *
	 */
	private class ListenerBotonesInferiores implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent e) {
			String accion = e.getActionCommand();
			switch (accion) {
			case "SIGUIENTE":
				switch (vis.pCenter.currentIndex) {
				case 2:
					if (!vis.pCenter.pResBusq.resultBusq.isSelectionEmpty() && vis.pCenter.pResBusq.resultBusq.getSelectedValue().isDisponible()) {
						mod.reserva.setAlojReservado(vis.pCenter.pResBusq.resultBusq.getSelectedValue());
						if (mod.reserva.getAlojReservado() instanceof Hotel) {
							cSelHabitacion.setResultHab(((Hotel) mod.reserva.getAlojReservado()).getMatrix(), mod.tiposDorm);
							vis.pCenter.pSelHab.resultHab.ensureIndexIsVisible(0);
							vis.pCenter.nextPanel();
						} else {
							vis.pCenter.changePanel("4");
						}
						cServicios.inicializarDatosAloj();
					}
					break;
				case 3:
					if (!vis.pCenter.pSelHab.resultHab.isSelectionEmpty() && vis.pCenter.pSelHab.resultHab.getSelectedValue().isDisponible()) {
						vis.pCenter.nextPanel();
						mod.reserva.setDormitorioReservado((Dormitorio) vis.pCenter.pSelHab.resultHab.getSelectedValue());
					}
					break;
				case 4:
					vis.pCenter.nextPanel();
					break;
				case 5:
					// DESGLOSES Y DATOS DEL PAGO
					calcularDesglosePrecio();
					mod.reserva.setDesglose(mod.desglosePrecio);
					cResumenRes.actualizarResumenReserva();
					mod.clienteRegis = mod.mRegiLog.login(vis.pCenter.pLogin);
					if (mod.clienteRegis != null) {
						mod.reserva.setCliente(mod.clienteRegis);
						vis.pCenter.changePanel("7");
					}
					break;
				case 6:
					if (mod.mRegiLog.comprobarDatos(mod.mRegiLog.comprobacionRegistro)) {
						mod.clienteRegis = mod.mRegiLog.registro(vis.pCenter.pRegistro);
						if (mod.clienteRegis != null) {
							if (mod.bd.insertGenerico(mod.clienteRegis.toArray(), "cliente")) {
								vis.pCenter.nextPanel();
								mod.mRegiLog.limpiar(vis.pCenter.pRegistro);
								mod.reserva.setCliente(mod.clienteRegis);
							} else {
								JOptionPane.showMessageDialog(vis.pCenter, "Error al guardar el cliente en la base de datos", "¡Error!", JOptionPane.ERROR_MESSAGE);
							}
						}
					} else {
						JOptionPane.showMessageDialog(vis.pCenter, "Debe rellenar todos los campos", "¡Atención!", JOptionPane.WARNING_MESSAGE);
					}
					break;
				case 7:
					if (vis.pCenter.pResumenRes.chckbxCondiciones.isSelected()) {
						vis.pCenter.pPago.textAPagar.setText(mod.mPago.dosDec.format(mod.reserva.getDesglose().getTotal()));
						cResumenPago.insertarDatos();
						if (mod.reserva.getAlojReservado() instanceof Hotel) {
							if (mod.reserva.getDormitorioReservado().capacidad() == 1) {
								vis.pCenter.changePanel("9");
							} else {
								vis.pCenter.nextPanel();
							}
						} else {
							if (((Casa) mod.reserva.getAlojReservado()).numCamas() == 1) {
								vis.pCenter.changePanel("9");
							} else {
								vis.pCenter.nextPanel();
							}
						}
						vis.pCenter.pResumenRes.chckbxCondiciones.setSelected(false);
					} else {
						JOptionPane.showMessageDialog(vis, "Debe aceptar las condiciones para proceder al pago", "INFO", JOptionPane.INFORMATION_MESSAGE);
					}
					vis.pCenter.pPago.textAPagar.setText(mod.mPago.dosDec.format(mod.reserva.getDesglose().getTotal()));
					break;
				case 8:
					// CONDICION PARA LIMITAR PERSONAS POR HACER
					vis.pCenter.changePanel("9");
					break;
				case 9:
					if (mod.isPagoExitoso()) {
						vis.pCenter.nextPanel();
						mod.mPago.limpiar(vis.pCenter.pPago);
						mod.mRegiLog.limpiar(vis.pCenter.pLogin);
						mod.mRegiLog.limpiar(vis.pCenter.pRegistro);
						mod.setPagoExitoso(false);
						mod.reserva.setCodPromocionalGenerado(mod.mRegiLog.generarCodigoPromocional(mod.reserva.getAlojReservado(), mod.clienteRegis.getDni()));
						cResumenPago.insertarDatos();
						if (mod.mPago.guardarReserva(mod.reserva)) {
							mod.mPago.guardarClientesExtra(mod.mPago.ultimoNumReserva(), mod.acompaniantes);
							mod.mPago.imprimirBillete(mod.reserva);
							JOptionPane.showMessageDialog(vis, "Reserva guardada correctamente", "INFO", JOptionPane.INFORMATION_MESSAGE);
						} else
							JOptionPane.showMessageDialog(vis, "¡Error al guardar la reserva!", "¡ATENCIÓN!", JOptionPane.ERROR_MESSAGE);
					}
					break;
				case 10:
					vis.pBotones.setBotonesVisible(false);
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
					// mod.mRegiLog.limpiar(vis.pCenter.pLogin);
					break;
				case 4:
					if (!(mod.reserva.getAlojReservado() instanceof Hotel)) {
						vis.pCenter.changePanel("2");
					} else {
						vis.pCenter.prevPanel();
						mod.mRegiLog.limpiar(vis.pCenter.pRegistro);
					}
					break;
				case 5:
					vis.pCenter.prevPanel();
					break;
				case 6:
					vis.pCenter.prevPanel();
					// mod.mPago.limpiar(vis.pCenter.pPago);
					break;
				case 7:
					vis.pCenter.changePanel("5");
					break;
				case 8:
					vis.pCenter.prevPanel();
					break;
				case 9:
					vis.pCenter.prevPanel();
					break;
				}
			}
		}
	}

	/**
	 * Crea un nuevo objeto DesglosePrecio para guardar informacion relevante con
	 * las elecciones del cliente
	 */
	public void calcularDesglosePrecio() {
		if (mod.reserva.getAlojReservado() instanceof Hotel)
			mod.desglosePrecio = new DesglosePrecio(mod.reserva.getAlojReservado(), mod.reserva.getFechaEntrada(), mod.reserva.getFechaSalida(), mod.reserva.getDormitorioReservado(), mod.festivos, cServicios.calcularPrecioExtras());
		else
			mod.desglosePrecio = new DesglosePrecio(mod.reserva.getAlojReservado(), mod.reserva.getFechaEntrada(), mod.reserva.getFechaSalida(), null, mod.festivos, cServicios.calcularPrecioExtras());
	}
}
