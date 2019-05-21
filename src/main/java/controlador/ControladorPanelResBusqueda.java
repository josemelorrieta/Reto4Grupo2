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
	 * 
	 * @param mod Modelo donde se guarda la informacion
	 * @param vis Vista la cual edita
	 */
	public ControladorPanelResBusqueda(Modelo mod, PanelResBusqueda vis) {
		this.mod = mod;
		this.vis=vis;
	}
	
	/**
	 * Metodo que carga en la vista los alojamientos
	 * 
	 * @param estados Array con el filtro de tipoAlojamiento
	 */
	protected void setDatosPanel(boolean[] estados) {
		vis.modelResBusq.clear();
		setAlojamientos(mod.hotelesBusqueda, estados[0]);
		setAlojamientos(mod.casasBusqueda, estados[1]);
		setAlojamientos(mod.apartBusqueda, estados[2]);
	}
	
	/**
	 * Metodo que carga un array de alojamientos en la vista
	 * 
	 * @param alojamientos Array de alojamientos
	 * @param estado Si estado es true carga el array en la vista
	 */
	private void setAlojamientos(Alojamiento[] alojamientos, boolean estado) {
		if(estado)
			for(Alojamiento aloj : alojamientos)
				if(aloj.isMostrar())
					vis.modelResBusq.addElement(aloj);
	}
	
	/**
	 * Metodo que devuelve el alojamiento seleccionado en la vista
	 * 
	 * @return Alojamiento seleccionado
	 */
	public Alojamiento getAlojamiento() {
		return vis.resultBusq.getSelectedValue();
	}
	
	/**
	 * Metodo que comprueba si hay un alojamiento seleccionado y esta disponible
	 * 
	 * @return true - Si la comprobacion es cierta
	 */
	public boolean isValid() {
		if(!vis.resultBusq.isSelectionEmpty() && vis.resultBusq.getSelectedValue().isDisponible())
			return true;
		else
			return false;
	}
}
