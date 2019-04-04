package controlador;

import modelo.Modelo;
import vista.VentanaPpal;

public class Controlador {
	
	private VentanaPpal vis;
	private Modelo mod;
	private ControladorPanelBuscar cBotones;
	
	public Controlador(VentanaPpal vista, Modelo modelo) {
		this.vis = vista;
		this.mod = modelo;
		addControladores();
	}

	private void addControladores() {
		cBotones = new ControladorPanelBuscar(vis.pCenter.pBuscar);
	}
		
}
