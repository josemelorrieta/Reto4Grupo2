package controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import modelo.Modelo;
import vista.VentanaPpal;
import vista.panelBorder.PanelCenter;
import vista.panelCard.PanelBuscar;


public class ControladorPanelBuscar{

	private VentanaPpal vis;
	private Controlador controlador;
	private Modelo mod;
	
	public ControladorPanelBuscar(VentanaPpal vis,Controlador cont,Modelo mod){
		this.vis=vis;
		this.controlador=cont;
		this.mod = mod;
		initListeners();
	}
	
	private void initListeners() {
		vis.pCenter.pBuscar.btnBuscar.addActionListener(new ListenerBotones());
	}

	private class ListenerBotones implements ActionListener{
		@Override
		public void actionPerformed(ActionEvent e) {
			//mod.cargarHoteles(pBuscar.cbxBuscar.getSelectedItem().toString());
			//mod.cargarHoteles("Bilbao");
			vis.pCenter.pResBusq.setResultBusqueda(mod.hotelesBusqueda);
			//System.out.println(mod.getHotelesBusqueda()[0].getNombre());
			vis.pCenter.nextPanel();
		}
		
	}
	

}
