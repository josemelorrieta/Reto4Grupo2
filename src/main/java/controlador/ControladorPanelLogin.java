package controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import javax.swing.JTextField;

import modelo.Modelo;
import vista.VentanaPpal;

/**
 * Controlador para el login
 *
 */
public class ControladorPanelLogin {
	private VentanaPpal vis;
	private Modelo mod;
	private Controlador controlador;

	/**
	 * Constructor para el controlador
	 * @param vis Vista la cual edita
	 * @param cont Controlador principal en caso de que necesite acceder a algun otro metodo
	 * @param mod Modelo donde se guarda la informacion
	 */
	public ControladorPanelLogin(VentanaPpal vis, Controlador cont, Modelo mod) {
		this.vis = vis;
		this.controlador = cont;
		this.mod = mod;
		initListeners();
		mod.mRegiLog.limitarFechaNacimiento(vis.pCenter.pRegistro.calenNacimiento);
	}

	/**
	 * Inicializador para los listeners
	 */
	private void initListeners() {
		vis.pCenter.pLogin.btnRegistro.addActionListener(new ListenerBoton());
		vis.pCenter.pLogin.contraOn0.addActionListener(new ListenerBoton());
		vis.pCenter.pLogin.txtDni.addFocusListener(new ListenerValidacion());
	}

	/**
	 * Listener para los botones del panel
	 *
	 */
	private class ListenerBoton implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			Object trigger = e.getSource();
			if (trigger == vis.pCenter.pLogin.btnRegistro) {
				vis.pCenter.nextPanel();
				mod.mRegiLog.limpiar(vis.pCenter.pLogin);
			}else if(trigger==vis.pCenter.pLogin.contraOn0) {
				mod.mRegiLog.visibilidadContrasenia(vis.pCenter.pLogin, false);
			}
		}
	}

	/**
	 * Listeners para la validacion de informacion
	 *
	 */
	private class ListenerValidacion implements FocusListener {

		@Override
		public void focusGained(FocusEvent arg0) {

		}

		@Override
		public void focusLost(FocusEvent arg0) {
			Object trigger = arg0.getSource();
			if (trigger == vis.pCenter.pLogin.txtDni) {
				mod.mRegiLog.comprobacionLogin = mod.mRegiLog.validarDNI((JTextField) trigger, vis.pCenter.pLogin.lblValiDni);
			}
		}
	}
}
