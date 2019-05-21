package controlador;

import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.Arrays;

import javax.swing.JCheckBox;
import javax.swing.JLabel;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

import modelo.Modelo;
import vista.panelCard.PanelResBusqueda;

public class ControladorPanelFiltros extends ControladorPanelResBusqueda {
	private boolean[] estadosTipoAloj;
	private boolean[] estadosServ;
	private boolean[] estadosTipoPension;
	private int min, max;
	
	public ControladorPanelFiltros(Modelo mod, PanelResBusqueda vis) {
		super(mod,vis);
		this.estadosTipoAloj = new boolean[vis.chkTipoAlojamiento.length];
		this.estadosServ = new boolean[vis.lblArrayServicios.length];
		this.estadosTipoPension = new boolean[vis.chkTipoPension.length];
		initArraysBoolean();
		initListeners();
	}
	
	private void initArraysBoolean() {
		for(int i=0;i<estadosTipoAloj.length;i++) {
			estadosTipoAloj[i] = true;
		}
		for(int i=0;i<estadosServ.length;i++) {
			estadosServ[i] = false;
		}
		for(int i=0;i<estadosTipoPension.length;i++) {
			estadosTipoPension[i] = false;
		}
	}
	
	private void initListeners() {
		for(JCheckBox chk:vis.chkTipoAlojamiento) 
			chk.addItemListener(new FiltroAlojamientoListener());
		for(JLabel lbl:vis.lblArrayServicios)
			lbl.addMouseListener(new FiltroServiciosListener());
		for(JCheckBox chk:vis.chkTipoPension)
			chk.addItemListener(new FiltroServiciosListener());
		vis.spinnerMin.addChangeListener(new FiltroEstrellasHotelListener());
		vis.spinnerMax.addChangeListener(new FiltroEstrellasHotelListener());
	}
	
	private class FiltroAlojamientoListener implements ItemListener {
		@Override
		public void itemStateChanged(ItemEvent e) {
			setEstadosTipoAloj();
			verFiltrosHotel();
			setDatosPanel(estadosTipoAloj);
		}	
	}
	
	private class FiltroServiciosListener implements MouseListener, ItemListener {
		@Override
		public void mouseClicked(MouseEvent e) {
			JLabel trigger = (JLabel) e.getSource();
			if(trigger.isEnabled())
				trigger.setEnabled(false);
			else
				trigger.setEnabled(true);
			setEstadosServ();
			verFiltrosHotel();
			setDatosPanel(estadosTipoAloj);
		}
		@Override
		public void mouseEntered(MouseEvent arg0) {	
		}
		@Override
		public void mouseExited(MouseEvent arg0) {	
		}
		@Override
		public void mousePressed(MouseEvent e) {	
		}
		@Override
		public void mouseReleased(MouseEvent e) {
		}
		
		@Override
		public void itemStateChanged(ItemEvent e) {
			setEstadosTipoPension();
			mod.mFiltros.filtrarSoloHotel(estadosServ, estadosTipoPension, min, max);
			setDatosPanel(estadosTipoAloj);
		}	
	}
	
	private class FiltroEstrellasHotelListener implements ChangeListener {
		@Override
		public void stateChanged(ChangeEvent e) {
			setFiltroEstrellas();
			if(e.getSource()==vis.spinnerMin)
				validarFiltroEstrellas(min,max,"min");
			else if(e.getSource()==vis.spinnerMax)
				validarFiltroEstrellas(min,max,"max");
			
			setFiltroEstrellas();
			mod.mFiltros.filtrarSoloHotel(estadosServ, estadosTipoPension,min, max);
			setDatosPanel(estadosTipoAloj);
		}
	}
	
	private int getMinEstrellas() {
		return (int) vis.spinnerMin.getValue();
	}
	
	private int getMaxEstrellas() {
		return (int) vis.spinnerMax.getValue();
	}
	private void setFiltroEstrellas() {
		min = getMinEstrellas();
		max = getMaxEstrellas();
	}
	
	private void validarFiltroEstrellas(int min,int max,String valorCambio) {
		if(valorCambio.equals("min")) {
			if(min>max) 
				vis.spinnerMax.setValue(min);
		}else if(valorCambio.equals("max")) {
			if(max<min)
				vis.spinnerMin.setValue(max);
		}
	}	
	
	private void setEstadosTipoAloj() {
		for(int i=0;i<estadosTipoAloj.length;i++)
			estadosTipoAloj[i] = vis.chkTipoAlojamiento[i].isSelected();
		verFiltrosHotel();
	}
	
	private void setEstadosServ() {
		for(int i=0;i<estadosServ.length;i++)
			estadosServ[i] = vis.lblArrayServicios[i].isEnabled();
	}
	
	private void setEstadosTipoPension() {
		for(int i=0;i<estadosTipoPension.length;i++)
			estadosTipoPension[i] = vis.chkTipoPension[i].isSelected();
	}
	
	private boolean verFiltrosHotel() {
		boolean[] aux = {true,false,false};
		if(Arrays.equals(estadosTipoAloj, aux)) {
			vis.panelFiltrosHotel.setVisible(true);
			setFiltroEstrellas();
			mod.mFiltros.filtrarSoloHotel(estadosServ, estadosTipoPension, min, max);
			return true;
		}else {
			vis.panelFiltrosHotel.setVisible(false);
			mod.mFiltros.filtrar(estadosServ, estadosTipoPension);
			return false;
		}
	}
}
