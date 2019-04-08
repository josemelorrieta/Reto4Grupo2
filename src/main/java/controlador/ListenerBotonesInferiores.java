package controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;

import vista.VentanaPpal;

public class ListenerBotonesInferiores implements ActionListener {
	@Override
	public void actionPerformed(ActionEvent e) {
		String accion = e.getActionCommand();
		switch (accion) {
			case "SIGUIENTE": ((VentanaPpal)((JButton) e.getSource()).getParent().getParent().getParent().getParent().getParent().getParent()).pCenter.nextPanel(); ;break;
			case "VOLVER": ((VentanaPpal)((JButton) e.getSource()).getParent().getParent().getParent().getParent().getParent().getParent()).pCenter.prevPanel(); ;break;
		}
	}
}
