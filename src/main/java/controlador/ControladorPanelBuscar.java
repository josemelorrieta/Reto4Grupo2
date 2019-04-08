package controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import modelo.Localidad;
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
		cargarLocalidades();
		vis.pSouth.pBotones.setVisible(false);
	}
	
	private void initListeners() {
		vis.pCenter.pBuscar.btnBuscar.addActionListener(new ListenerBotones());
	}

	private class ListenerBotones implements ActionListener{
		@Override
		public void actionPerformed(ActionEvent e) {
			//mod.cargarHoteles(pBuscar.cbxBuscar.getSelectedItem().toString());
			//mod.cargarHoteles("Bilbao");
			((PanelCenter) vis.pCenter).changePanel("2");
			vis.pSouth.pBotones.setVisible(true);
		}
		
	}
	
	public void cargarLocalidades() {
		vis.pCenter.pBuscar.cbxBuscar.addItem("Bilbao");
//		Localidad[] localidades = mod.mBuscar.buscarLocalidades();
//		if(localidades!=null) {
//			for(Localidad localidad : localidades)
//				pBuscar.cbxBuscar.addItem(localidad.getLocalidad());
//		}
	}

}
