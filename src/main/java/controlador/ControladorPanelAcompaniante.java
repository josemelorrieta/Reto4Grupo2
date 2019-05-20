package controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;

import javax.swing.JTextField;

import modelo.Cliente;
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
	 * @param vis Vista la cual edita
	 * @param cont Controlador principal en caso de que necesite acceder a algun otro metodo
	 * @param mod Modelo donde se guarda la informacion
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
			if (trigger == vis.pCenter.pAcompaniante.btnAniadir && mod.mRegiLog.comprobarDatos(mod.mRegiLog.comprobarAcompaniante)) {
				Cliente acompaniante = new Cliente(vis.pCenter.pAcompaniante.txtDni.getText(), vis.pCenter.pAcompaniante.txtNombre.getText(), vis.pCenter.pAcompaniante.txtApellido.getText());
				vis.pCenter.pAcompaniante.modeloAcompaniante.addElement(acompaniante.getNombre() + " " + acompaniante.getApellidos());
				mod.acompaniantes.add(acompaniante);
			}
		}

	}
}
