package controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
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
		initListeners();
	}

	private void addControladores() {
		cBuscar = new ControladorPanelBuscar(vis.pCenter.pBuscar,vis.pSouth.pBotones,this,mod);
		cPago = new ControladorPanelPago(vis.pCenter.pPago, this,mod);
		cResBusqueda = new ControladorPanelResBusqueda(vis.pCenter.pResBusq, vis.pSouth.pBotones, this);
	}
	
	
	private void initListeners() {
		vis.pSouth.pBotones.btnSiguiente.addActionListener(new ListenerBotonesInferiores());
		vis.pSouth.pBotones.btnVolver.addActionListener(new ListenerBotonesInferiores());
	}
	
	private class ListenerBotonesInferiores implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent e) {
			String accion = e.getActionCommand();
			switch (accion) {
				case "SIGUIENTE": vis.pCenter.nextPanel(); ;break;
				case "VOLVER": vis.pCenter.prevPanel(); ;break;
			}
		}
	}
}
