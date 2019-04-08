package controlador;

import modelo.Modelo;
import vista.VentanaPpal;

public class Controlador {
	
	private VentanaPpal vis;
	private Modelo mod;
	private ControladorPanelBuscar cBuscar;
	private ControladorPanelPago cPago;
	private ControladorPanelResBusqueda cResBusqueda;
	
	public Controlador(VentanaPpal vista, Modelo modelo) {
		this.vis = vista;
		this.mod = modelo;
		addControladores();
	}

	private void addControladores() {
		cBuscar = new ControladorPanelBuscar(vis.pCenter.pBuscar,this,mod);
		cPago = new ControladorPanelPago(vis.pCenter.pPago, this,mod);
		cResBusqueda = new ControladorPanelResBusqueda(vis.pCenter.pResBusq, vis.pSouth.pBotones, this);
	}
	
	public void trigger(int i) {
		if(i==1) {
			
		}
	}
}
