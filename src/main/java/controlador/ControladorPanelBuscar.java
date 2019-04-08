package controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

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
		cargarLocalidades();
		vis.pSouth.pBotones.setVisible(false);
	}
	
	public void cargarLocalidades() {
		Localidad[] localidades = mod.mBuscar.buscarLocalidades();
		if(localidades!=null) {
			for(Localidad localidad : localidades)
				vis.pCenter.pBuscar.cbxBuscar.addItem(localidad.getLocalidad());
		}
	}

}
