package modelo;

/**
 * Clase con metodos para filtrar servicios
 *
 */
public class MetodosFiltros {

	private Modelo mod;
	
	public MetodosFiltros(Modelo mod) {
		this.mod = mod;
	}

	public void filtrarTipoAlojamiento() {
		
	}
	
	/**
	 * Actualiza la vista con la informacion del modelo para mostrar la disponibilidad de servicio
	 * @param estados array de booleanos que indican disponibilidad
	 */
	public void filtrarServicios(boolean[] estados) {
		for(Hotel hot:mod.hotelesBusqueda) {
			hot.setMostrar(true);
			for(int i=0;i<estados.length;i++)
				if(hot.servicios[i].getTipo() == TipoServicio.noDisponible)
					hot.setMostrar(false);
		}
		for(Casa casa:mod.casasBusqueda) {
			casa.setMostrar(true);
			for(int i=0;i<estados.length;i++)	
				if(casa.servicios[i].getTipo() == TipoServicio.noDisponible)
					casa.setMostrar(false);
		}
		for(Apartamento apart:mod.apartBusqueda) {
			apart.setMostrar(true);
			for(int i=0;i<estados.length;i++)
				if(apart.servicios[i].getTipo() == TipoServicio.noDisponible)
					apart.setMostrar(false);
		}
	}
		
}
