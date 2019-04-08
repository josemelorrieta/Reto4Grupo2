package controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import modelo.Localidad;
import modelo.Modelo;
import vista.VentanaPpal;


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
		initListeners();
	}
	
	private void initListeners() {
		vis.pCenter.pBuscar.btnBuscar.addActionListener(new ListenerBotones());
	}

	public void cargarLocalidades() {
		Localidad[] localidades = mod.mBuscar.buscarLocalidades();
		if(localidades!=null) {
			for(Localidad localidad : localidades)
				vis.pCenter.pBuscar.cbxBuscar.addItem(localidad.getLocalidad());
		}
	}


	private class ListenerBotones implements ActionListener{
		@Override
		public void actionPerformed(ActionEvent e) {
			mod.cargarHoteles(vis.pCenter.pBuscar.cbxBuscar.getSelectedItem().toString());
			vis.pCenter.pResBusq.setResultBusqueda(mod.hotelesBusqueda);
			vis.pSouth.pBotones.setVisible(true);
			vis.pCenter.nextPanel();
		}
	}

}
