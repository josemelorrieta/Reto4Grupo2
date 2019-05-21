package controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import modelo.Casa;
import modelo.Cliente;
import modelo.Hotel;
import modelo.Modelo;
import vista.VentanaPpal;

/**
 * Controlador para el panel de acompaniante
 *
 */
public class ControladorPanelAcompaniante {

	private VentanaPpal vis;
	private Modelo mod;
	private Controlador controlador;

	/**
	 * Constructor para el controlador
	 * 
	 * @param vis  Vista la cual edita
	 * @param cont Controlador principal en caso de que necesite acceder a algun
	 *             otro metodo
	 * @param mod  Modelo donde se guarda la informacion
	 */
	public ControladorPanelAcompaniante(VentanaPpal vis, Controlador cont, Modelo mod) {
		this.vis = vis;
		this.controlador = cont;
		this.mod = mod;
		initListeners();
	}

	/**
	 * Inicializa los listeners requeridos para el panel
	 */
	private void initListeners() {
		vis.pCenter.pAcompaniante.txtNombre.addFocusListener(new ListenerValidacion());
		vis.pCenter.pAcompaniante.txtApellido.addFocusListener(new ListenerValidacion());
		vis.pCenter.pAcompaniante.txtDni.addFocusListener(new ListenerValidacion());
		vis.pCenter.pAcompaniante.btnAniadir.addActionListener(new ListenerBoton());
		vis.pCenter.pAcompaniante.listAcompaniante.addMouseListener(new ListenerLista());
	}

	/**
	 * Listeners para validacion de informacion
	 *
	 */
	private class ListenerValidacion implements FocusListener {

		@Override
		public void focusGained(FocusEvent arg0) {

		}

		@Override
		public void focusLost(FocusEvent arg0) {
			Object trigger = arg0.getSource();
			if (trigger == vis.pCenter.pAcompaniante.txtNombre) {
				mod.mRegiLog.comprobarAcompaniante[0] = mod.mRegiLog.validarSoloLetras((JTextField) trigger, vis.pCenter.pAcompaniante.lblValiNombre);
			} else if (trigger == vis.pCenter.pAcompaniante.txtApellido) {
				mod.mRegiLog.comprobarAcompaniante[1] = mod.mRegiLog.validarSoloLetras((JTextField) trigger, vis.pCenter.pAcompaniante.lblValiApellido);
			} else if (trigger == vis.pCenter.pAcompaniante.txtDni) {
				mod.mRegiLog.comprobarAcompaniante[2] = mod.mRegiLog.validarDNI((JTextField) trigger, vis.pCenter.pAcompaniante.lblValiDni);
			}
		}
	}

	/**
	 * Listeners para el boton de aniadir cliente
	 *
	 */
	private class ListenerBoton implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			Object trigger = e.getSource();
			if (mod.reserva.getAlojReservado() instanceof Hotel) {
				if (vis.pCenter.pAcompaniante.listAcompaniante.getModel().getSize() >= mod.reserva.getDormitorioReservado().capacidad() - 1) {
					JOptionPane.showMessageDialog(vis.pCenter, "Capacidad insuficiente", "¡Atención!", JOptionPane.WARNING_MESSAGE);
				} else {
					if (trigger == vis.pCenter.pAcompaniante.btnAniadir && mod.mRegiLog.comprobarDatos(mod.mRegiLog.comprobarAcompaniante)) {
						meterClientes();
					}
				}
			} else {
				if (vis.pCenter.pAcompaniante.listAcompaniante.getModel().getSize() >= ((Casa) mod.reserva.getAlojReservado()).numCamas() - 1) {
					JOptionPane.showMessageDialog(vis.pCenter, "Capacidad insuficiente", "¡Atención!", JOptionPane.WARNING_MESSAGE);
				} else {
					if (trigger == vis.pCenter.pAcompaniante.btnAniadir && mod.mRegiLog.comprobarDatos(mod.mRegiLog.comprobarAcompaniante)) {
						meterClientes();
					}
				}
			}
		}
	}

	/**
	 * Mete el usuario en la base de datos
	 */
	public void meterClientes() {
		Cliente acompaniante;
		try {
			acompaniante = new Cliente(mod.mRegiLog.encripta(vis.pCenter.pAcompaniante.txtDni.getText()), mod.mRegiLog.encripta(vis.pCenter.pAcompaniante.txtNombre.getText()), mod.mRegiLog.encripta(vis.pCenter.pAcompaniante.txtApellido.getText()));
		} catch (Exception e1) {
			acompaniante=null;
		}
		boolean repetido = false;
		for (Cliente cli : mod.acompaniantes) {
			if (cli.getDni().equals(acompaniante.getDni())) {
				repetido = true;
			}
		}
		if (!repetido) {
			try {
				vis.pCenter.pAcompaniante.modeloAcompaniante.addElement(mod.mRegiLog.desencripta(acompaniante.getNombre()) + " " + mod.mRegiLog.desencripta(acompaniante.getApellidos()));
			} catch (Exception e) {
				e.printStackTrace();
			}
			mod.mRegiLog.registrarClienteExtra(acompaniante);
			mod.acompaniantes.add(acompaniante);
		} else {
			JOptionPane.showMessageDialog(vis.pCenter, "Usuario ya añadido", "¡Atención!", JOptionPane.WARNING_MESSAGE);
		}
	}
	
	/**
	 * Listener para borra cliente de la lista
	 */
	private class ListenerLista implements MouseListener {

		@Override
		public void mouseClicked(MouseEvent e) {
			JList<String> list = (JList<String>) e.getSource();
			if (list == vis.pCenter.pAcompaniante.listAcompaniante) {
				int index = list.locationToIndex(e.getPoint());
				if (e.getClickCount() == 2 && vis.pCenter.pAcompaniante.modeloAcompaniante.size() > 0) {
					vis.pCenter.pAcompaniante.modeloAcompaniante.remove(index);
					mod.mRegiLog.borrarClienteExtra(mod.acompaniantes.get(index).getDni());
					mod.acompaniantes.remove(index);
				}
			}
		}

		@Override
		public void mouseEntered(MouseEvent e) {
		}

		@Override
		public void mouseExited(MouseEvent e) {
		}

		@Override
		public void mousePressed(MouseEvent e) {
		}

		@Override
		public void mouseReleased(MouseEvent e) {
		}

	}
}
