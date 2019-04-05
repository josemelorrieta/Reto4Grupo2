package controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import modelo.Modelo;
import vista.panelBorder.PanelCenter;
import vista.panelCard.PanelBuscar;


public class ControladorPanelBuscar{

	private PanelBuscar pBuscar;
	private Controlador controlador;
	private Modelo mod;
	
	public ControladorPanelBuscar(PanelBuscar panel,Controlador cont,Modelo mod){
		this.pBuscar=panel;
		this.controlador=cont;
		this.mod = mod;
		initListeners();
	}
	
	private void initListeners() {
		this.pBuscar.btnBuscar.addActionListener(new ListenerBotones());
	}

	private class ListenerBotones implements ActionListener{
		@Override
		public void actionPerformed(ActionEvent e) {
			//mod.cargarHoteles(pBuscar.cbxBuscar.getSelectedItem().toString());
			mod.cargarHoteles("Bilbao");
			System.out.println(mod.getHotelesBusqueda()[0].getNombre());
			((PanelCenter) pBuscar.getParent()).changePanel("3");
		}
		
	}
	

}
