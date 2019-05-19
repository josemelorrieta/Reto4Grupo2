package controlador;

import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

import javax.swing.JCheckBox;

import modelo.Apartamento;
import modelo.Casa;
import modelo.Hotel;
import modelo.Modelo;
import vista.panelCard.PanelResBusqueda;


public class ControladorPanelResBusqueda {
	
	private Modelo mod;
	private PanelResBusqueda vis;
	private Controlador cont;
	
	public ControladorPanelResBusqueda(Modelo mod, PanelResBusqueda vis,Controlador cont) {
		this.mod = mod;
		this.vis=vis;
		this.cont = cont;
		//initListeners();
	}
	
	private void initListeners() {
		for(JCheckBox chk:vis.chkTipoAlojamiento)
			chk.addItemListener(new FiltroAlojamientoListener());
//		for(JCheckBox chk:vis.chkServicios)
//			chk.addItemListener(new FiltroServiciosListener());
	}
	
	private class FiltroAlojamientoListener implements ItemListener {

		@Override
		public void itemStateChanged(ItemEvent e) {
			//setResultadosFiltrados();			
		}
	}
	
	private class FiltroServiciosListener implements ItemListener{

		@Override
		public void itemStateChanged(ItemEvent e) {
			
		}
		
	}
	private void setResultadosFiltrados() {
		vis.modelResBusq.clear();
		if(vis.chkHotel.isSelected()) {
			for(Hotel hotel:mod.hotelesBusqueda) {
				if(hotel.isMostrar())
					vis.modelResBusq.addElement(hotel);
			}
		}
		if(vis.chkCasa.isSelected()) {
			for(Casa casa:mod.casasBusqueda) {
				if(casa.isMostrar())
					vis.modelResBusq.addElement(casa);
			}
		}
		if(vis.chkApartamento.isSelected()) {
			for(Apartamento apart:mod.apartBusqueda) {
				if(apart.isMostrar())
					vis.modelResBusq.addElement(apart);
			}
		}
	}
}
