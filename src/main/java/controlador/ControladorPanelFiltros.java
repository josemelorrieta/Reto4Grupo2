package controlador;

import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.Arrays;

import javax.swing.JCheckBox;
import javax.swing.JLabel;
import javax.swing.JSpinner;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

import modelo.Modelo;
import vista.panelCard.PanelResBusqueda;

public class ControladorPanelFiltros extends ControladorPanelResBusqueda {
	/**
	 * Declaracion de atributos
	 */
	private boolean[] estadosTipoAloj;
	private boolean[] estadosServ;
	private boolean[] estadosTipoPension;
	private int min, max;
	
	/**
	 * Constructor de la clase
	 * 
	 * @param mod Modelo donde se guarda la informacion
	 * @param vis JPanel que controla
	 */
	public ControladorPanelFiltros(Modelo mod, PanelResBusqueda vis) {
		super(mod,vis);
		this.estadosTipoAloj = new boolean[vis.chkTipoAlojamiento.length];
		this.estadosServ = new boolean[vis.lblArrayServicios.length];
		this.estadosTipoPension = new boolean[vis.chkTipoPension.length];
		initAtributos();
		initListeners();
	}
	
	/**
	 * Metodo para inicializar o resetear los atributos
	 */
	private void initAtributos() {
		for(int i=0;i<estadosTipoAloj.length;i++) {
			estadosTipoAloj[i] = true;
		}
		for(int i=0;i<estadosServ.length;i++) {
			estadosServ[i] = false;
		}
		for(int i=0;i<estadosTipoPension.length;i++) {
			estadosTipoPension[i] = false;
		}
		min = 1;
		max = 5;
	}
	
	/**
	 * Metodo para aniadir listeners a los componentes de la vista
	 */
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
	
	/**
	 * Listener para los filtros del Tipo de Alojamiento
	 */
	private class FiltroAlojamientoListener implements ItemListener {
		@Override
		public void itemStateChanged(ItemEvent e) {
			setEstadosTipoAloj();
			verFiltrosHotel();
			setDatosPanel(estadosTipoAloj);
		}	
	}
	
	/**
	 * Listener para los filtros de los servicios
	 */
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
	
	/**
	 * Listener para el filtro de las estrellas de los hoteles
	 */
	private class FiltroEstrellasHotelListener implements ChangeListener {
		@Override
		public void stateChanged(ChangeEvent e) {
			setFiltroEstrellas();
			if(e.getSource()==vis.spinnerMin)
				validarFiltroEstrellas(min,max,vis.spinnerMin);
			else if(e.getSource()==vis.spinnerMax)
				validarFiltroEstrellas(min,max,vis.spinnerMax);
			
			setFiltroEstrellas();
			mod.mFiltros.filtrarSoloHotel(estadosServ, estadosTipoPension,min, max);
			setDatosPanel(estadosTipoAloj);
		}
	}
	
	/**
	 * Metodo que devuelve el valor de minEstrellas del panel
	 * @return Numero minimo de estrellas
	 */
	private int getMinEstrellas() {
		return (int) vis.spinnerMin.getValue();
	}
	
	/**
	 * Metodo que devuelve el valor de maxEstrellas del panel
	 * @return Numero maximo de estrellas
	 */
	private int getMaxEstrellas() {
		return (int) vis.spinnerMax.getValue();
	}
	
	/**
	 * Metodo que carga las variables min y max de los valores del panel
	 */
	private void setFiltroEstrellas() {
		min = getMinEstrellas();
		max = getMaxEstrellas();
	}
	
	/**
	 * Metodo para validar los spinners. Cuando min>max o max<min cambia el valor
	 * del otro spinner para que esas condiciones no se cumplan.
	 * 
	 * @param min El valor del spinnerMin
	 * @param max El valor del spinnerMax
	 * @param spinnerCambio El componente que ha cambiado 
	 */
	private void validarFiltroEstrellas(int min,int max,JSpinner spinnerCambio) {
		if(spinnerCambio==vis.spinnerMin) {
			if(min>max) 
				vis.spinnerMax.setValue(min);
		}else if(spinnerCambio==vis.spinnerMax) {
			if(max<min)
				vis.spinnerMin.setValue(max);
		}
	}	
	
	/**
	 * Metodo que recoge los estados de los filtros de tipoAlojamiento de la
	 * vista y los guarda en el array estadosTipoAloj
	 */
	private void setEstadosTipoAloj() {
		for(int i=0;i<estadosTipoAloj.length;i++)
			estadosTipoAloj[i] = vis.chkTipoAlojamiento[i].isSelected();
		verFiltrosHotel();
	}
	
	/**
	 * Metodo que recoge los estados de los filtros de los servicios generales 
	 * de la vista y los guarda en el array estadosServ
	 */
	private void setEstadosServ() {
		for(int i=0;i<estadosServ.length;i++)
			estadosServ[i] = vis.lblArrayServicios[i].isEnabled();
	}
	
	/**
	 * Metodo que recoge los estados de los filtros de tipoPension de la vista
	 * y los guarda en el array estadosTipoPension
	 */
	private void setEstadosTipoPension() {
		for(int i=0;i<estadosTipoPension.length;i++)
			estadosTipoPension[i] = vis.chkTipoPension[i].isSelected();
	}
	
	/**
	 * Metodo que comprueba si el filtro es solo de Hoteles. 
	 * 
	 * @return Devuelve true si el filtro es solo de hoteles, muestra los filtros 
	 * de los hoteles y ejecuta el metodo filtrarHoteles.
	 * Devuelve false si el filtro es para todos los alojamientos, oculta los
	 * filtros de los hoteles y ejecuta el metodo filtrar.
	 */
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
