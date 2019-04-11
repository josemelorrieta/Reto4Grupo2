package controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.SpinnerNumberModel;

import com.toedter.calendar.JDateChooser;

import modelo.Cliente;
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
		vis.pCenter.pRegistro.txtNombre.addFocusListener(new ListenerValidacion());
		vis.pCenter.pRegistro.txtApellido.addFocusListener(new ListenerValidacion());
		vis.pCenter.pRegistro.txtDni.addFocusListener(new ListenerValidacion());
		vis.pCenter.pRegistro.calenNacimiento.addPropertyChangeListener(new calendarListener());
		vis.pCenter.pRegistro.pwdContra.addFocusListener(new ListenerValidacion());
		vis.pCenter.pRegistro.pwdRepContra.addFocusListener(new ListenerValidacion());
	}

	private class ListenerValidacion implements FocusListener {

		@Override
		public void focusGained(FocusEvent arg0) {

		}

		@Override
		public void focusLost(FocusEvent arg0) {
			Object trigger = arg0.getSource();
			if (trigger == vis.pCenter.pRegistro.txtNombre) {
				mod.mRegiLog.comprobacion[0] = mod.mRegiLog.validarSoloLetras((JTextField) trigger);
			} else if (trigger == vis.pCenter.pRegistro.txtApellido) {
				mod.mRegiLog.comprobacion[1] = mod.mRegiLog.validarSoloLetras((JTextField) trigger);
			} else if (trigger == vis.pCenter.pRegistro.txtDni) {
				mod.mRegiLog.comprobacion[2] = mod.mRegiLog.validarDNI((JTextField) trigger);
			} else if (trigger == vis.pCenter.pRegistro.pwdContra) {
				mod.mRegiLog.comprobacion[4] = mod.mRegiLog.seguridadContrasenia(((JPasswordField) trigger).getPassword());
			} else if (trigger == vis.pCenter.pRegistro.pwdRepContra) {
				mod.mRegiLog.comprobacion[5] = mod.mRegiLog.constraseniaCoincide(vis.pCenter.pRegistro.pwdContra, (JPasswordField) trigger);
			}
		}
	}

	private class calendarListener implements PropertyChangeListener {

		@Override
		public void propertyChange(PropertyChangeEvent e) {
			Object trigger = e.getSource();
			if (trigger == vis.pCenter.pRegistro.calenNacimiento) {
				mod.mRegiLog.comprobacion[3] = mod.mRegiLog.validarFecha(((JDateChooser) trigger).getDate());
			}
		}

	}
}
