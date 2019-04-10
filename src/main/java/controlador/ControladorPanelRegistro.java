package controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;

import javax.swing.JPasswordField;
import javax.swing.JTextField;

import com.toedter.calendar.JDateChooser;

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
	}

	private void initListeners() {

	}

	private class ListenerValidacion implements FocusListener {

		@Override
		public void focusGained(FocusEvent arg0) {

		}

		@Override
		public void focusLost(FocusEvent arg0) {
			Object trigger = arg0.getSource();
			if (trigger == vis.pCenter.pRegistro.txtNombre) {
				mod.mRegiLog.validarSoloLetras((JTextField) trigger);
			} else if (trigger == vis.pCenter.pRegistro.txtApellido) {
				mod.mRegiLog.validarSoloLetras((JTextField) trigger);
			} else if (trigger == vis.pCenter.pRegistro.txtDni) {
				mod.mRegiLog.validarDNI((JTextField) trigger);
			} else if (trigger == vis.pCenter.pRegistro.calenNacimiento) {
				mod.mRegiLog.validarFecha(((JDateChooser) trigger).getDate());
			} else if (trigger == vis.pCenter.pRegistro.pwdContra) {
				mod.mRegiLog.seguridadContrasenia(((JPasswordField) trigger).getPassword());
			} else if (trigger == vis.pCenter.pRegistro.pwdRepContra) {
				mod.mRegiLog.constraseniaCoincide(vis.pCenter.pRegistro.pwdContra, (JPasswordField) trigger);
			}
		}

	}
	
	private class ListenerBotones implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) {
			
		}
		
	}
}
