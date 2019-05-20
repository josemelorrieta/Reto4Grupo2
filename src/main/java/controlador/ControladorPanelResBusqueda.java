package controlador;

import modelo.Alojamiento;
import modelo.Modelo;
import vista.panelCard.PanelResBusqueda;


/**
 * Controlador para el panel resultado busqueda
 *
 */
public class ControladorPanelResBusqueda {
	
	protected Modelo mod;
	protected PanelResBusqueda vis;
	
	/**
	 * Constructor para el controlador
	 * @param mod Modelo donde se guarda la informacion
	 * @param vis Vista la cual edita
	 * @param cont Controlador principal en caso de que necesite acceder a algun otro metodo
	 */
	public ControladorPanelResBusqueda(Modelo mod, PanelResBusqueda vis) {
		this.mod = mod;
		this.vis=vis;
	}
	
	protected void setDatosPanel(boolean[] estados) {
		vis.modelResBusq.clear();
		setAlojamientos(mod.hotelesBusqueda, estados[0]);
		setAlojamientos(mod.casasBusqueda, estados[1]);
		setAlojamientos(mod.apartBusqueda, estados[2]);
	}
	
	protected void setDatosPanel(boolean estado) {
		vis.modelResBusq.clear();
		setAlojamientos(mod.hotelesBusqueda, estado);
		setAlojamientos(mod.casasBusqueda, estado);
		setAlojamientos(mod.apartBusqueda, estado);
	}
	
	protected void setDatosPanel(boolean[] estados, String localidad) {
		setLblLocalidad(localidad);
		vis.modelResBusq.clear();
		setAlojamientos(mod.hotelesBusqueda, estados[0]);
		setAlojamientos(mod.casasBusqueda, estados[1]);
		setAlojamientos(mod.apartBusqueda, estados[2]);
	}
	
	protected void setDatosPanel(boolean estado, String localidad) {
		setLblLocalidad(localidad);
		vis.modelResBusq.clear();
		setAlojamientos(mod.hotelesBusqueda, estado);
		setAlojamientos(mod.casasBusqueda, estado);
		setAlojamientos(mod.apartBusqueda, estado);
	}
	
	private void setLblLocalidad(String localidad) {
		vis.lblLocBusq.setText("Resultados para " + localidad);
		//vis.resultBusq.ensureIndexIsVisible(0);
	}
	
	private void setAlojamientos(Alojamiento[] alojamientos, boolean estado) {
		if(estado)
			for(Alojamiento aloj : alojamientos)
				if(aloj.isMostrar())
					vis.modelResBusq.addElement(aloj);
	}
		
	public Alojamiento getAlojamiento() {
		return vis.resultBusq.getSelectedValue();
	}
	
	public boolean isValid() {
		if(!vis.resultBusq.isSelectionEmpty() && vis.resultBusq.getSelectedValue().isDisponible())
			return true;
		else
			return false;
	}
}
