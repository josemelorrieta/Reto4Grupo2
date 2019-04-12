package controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;

import javax.swing.JPasswordField;
import javax.swing.JTextField;

import modelo.Modelo;
import vista.VentanaPpal;

public class ControladorPanelRegistro {
	private VentanaPpal vis;
	private Modelo mod;
	private Controlador controlador;

	public ControladorPanelRegistro(VentanaPpal vis, Controlador cont, Modelo mod) {
		this.vis = vis;
		this.controlador = cont;
		this.mod = mod;
		initListeners();
		mod.mRegiLog.limitarFechaNacimiento(vis.pCenter.pRegistro.calenNacimiento);
	}

	private void initListeners() {
		vis.pCenter.pRegistro.txtNombre.addFocusListener(new ListenerValidacion());
		vis.pCenter.pRegistro.txtApellido.addFocusListener(new ListenerValidacion());
		vis.pCenter.pRegistro.txtDni.addFocusListener(new ListenerValidacion());
		vis.pCenter.pRegistro.pwdContra.addFocusListener(new ListenerValidacion());
		vis.pCenter.pRegistro.pwdRepContra.addFocusListener(new ListenerValidacion());
		vis.pCenter.pRegistro.contraOn0.addActionListener(new ListenerBoton());
		vis.pCenter.pRegistro.contraOn1.addActionListener(new ListenerBoton());
	}

	private class ListenerValidacion implements FocusListener {

		@Override
		public void focusGained(FocusEvent arg0) {

		}

		@Override
		public void focusLost(FocusEvent arg0) {
			Object trigger = arg0.getSource();
			if (trigger == vis.pCenter.pRegistro.txtNombre) {
				mod.mRegiLog.comprobacionRegistro[0] = mod.mRegiLog.validarSoloLetras((JTextField) trigger, vis.pCenter.pRegistro.lblValiNombre);
			} else if (trigger == vis.pCenter.pRegistro.txtApellido) {
				mod.mRegiLog.comprobacionRegistro[1] = mod.mRegiLog.validarSoloLetras((JTextField) trigger, vis.pCenter.pRegistro.lblValiApellido);
			} else if (trigger == vis.pCenter.pRegistro.txtDni) {
				mod.mRegiLog.comprobacionRegistro[2] = mod.mRegiLog.validarDNI((JTextField) trigger, vis.pCenter.pRegistro.lblValiDni);
			} else if (trigger == vis.pCenter.pRegistro.pwdContra) {
				mod.mRegiLog.comprobacionRegistro[3] = mod.mRegiLog.seguridadContrasenia(((JPasswordField) trigger), vis.pCenter.pRegistro.lblValiContra);
			} else if (trigger == vis.pCenter.pRegistro.pwdRepContra) {
				mod.mRegiLog.comprobacionRegistro[4] = mod.mRegiLog.constraseniaCoincide(vis.pCenter.pRegistro.pwdContra, (JPasswordField) trigger, vis.pCenter.pRegistro.lblValiContraCoinciden);
			}
		}
	}

	private class ListenerBoton implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			Object trigger = e.getSource();
			if (trigger == vis.pCenter.pRegistro.contraOn0 || trigger == vis.pCenter.pRegistro.contraOn1) {
				mod.mRegiLog.visibilidadContrasenia(vis.pCenter.pRegistro,false);
			}

		}

	}
}
