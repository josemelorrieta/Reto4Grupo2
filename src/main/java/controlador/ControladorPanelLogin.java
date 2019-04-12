package controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import javax.swing.JTextField;

import modelo.Modelo;
import vista.VentanaPpal;

public class ControladorPanelLogin {
	private VentanaPpal vis;
	private Modelo mod;
	private Controlador controlador;

	public ControladorPanelLogin(VentanaPpal vis, Controlador cont, Modelo mod) {
		this.vis = vis;
		this.controlador = cont;
		this.mod = mod;
		initListeners();
		mod.mRegiLog.limitarFechaNacimiento(vis.pCenter.pRegistro.calenNacimiento);
	}

	private void initListeners() {
		vis.pCenter.pLogin.btnRegistro.addActionListener(new ListenerBoton());
		vis.pCenter.pLogin.contraOn0.addActionListener(new ListenerBoton());
		vis.pCenter.pLogin.txtDni.addFocusListener(new ListenerValidacion());
	}

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

	private class ListenerValidacion implements FocusListener {

		@Override
		public void focusGained(FocusEvent arg0) {

		}

		@Override
		public void focusLost(FocusEvent arg0) {
			Object trigger = arg0.getSource();
			if (trigger == vis.pCenter.pLogin.txtDni) {
				mod.mRegiLog.comprobacionLogin = mod.mRegiLog.validarDNI((JTextField) trigger, vis.pCenter.pRegistro.lblValiDni);
			}
		}
	}
}
