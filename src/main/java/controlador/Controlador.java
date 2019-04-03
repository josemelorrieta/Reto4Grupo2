package controlador;

import vista.VentanaPpal;

public class Controlador {
	
	private VentanaPpal vista;
	private ControladorPanelBuscar cBotones;
	
	public Controlador(VentanaPpal vista) {
		this.vista = vista;
		addControladores();
	}

	private void addControladores() {
		cBotones = new ControladorPanelBuscar(vista.pCenter.pBuscar);
	}
		
}
