package controlador;

import modelo.Modelo;
import vista.VentanaPpal;

public class Controlador {
	
	private VentanaPpal vis;
	private Modelo mod;
	private ControladorPanelBuscar cBuscar;
	private ControladorPanelPago cPago;
	
	public Controlador(VentanaPpal vista, Modelo modelo) {
		this.vis = vista;
		this.mod = modelo;
		addControladores();
	}

	private void addControladores() {
		cBuscar = new ControladorPanelBuscar(vis.pCenter.pBuscar,this);
		cPago = new ControladorPanelPago(vis.pCenter.pPago, this);
	}
		
}
