package modelo;

/**
 * Clase con metodos para filtrar servicios
 *
 */
public class MetodosFiltros {

	private Modelo mod;

	/**
	 * Constructor que recibe el modelo para aplicar los filtros
	 * @param mod
	 */
	public MetodosFiltros(Modelo mod) {
		this.mod = mod;
	}

	/**
	 * Metodo que filtra los alojamientos en funcion de los filtros de los servicios seleccionados
	 * @param estadosServ array de booleanos con la seleccion de los filtros basicos
	 * @param estadosTipoPension array de booleanos con la seleccion de los filtros de tipo pension
	 */
	public void filtrar(boolean[] estadosServ, boolean[] estadosTipoPension) {	
		boolean[] estados = new boolean[estadosServ.length + estadosTipoPension.length];
		System.arraycopy(estadosServ, 0, estados, 0, estadosServ.length);
		System.arraycopy(estadosTipoPension, 0, estados, estadosServ.length, estadosTipoPension.length);
		resetFiltro(mod.hotelesBusqueda);
		resetFiltro(mod.casasBusqueda);
		resetFiltro(mod.apartBusqueda);
		filtrarServicios(mod.hotelesBusqueda, estados);
		filtrarServicios(mod.casasBusqueda, estadosServ);
		filtrarServicios(mod.apartBusqueda, estadosServ);	
	}
	
	/**
	 * Metodo que filtra los alojamientos en funcion de los filtros de los servicios seleccionados y ademas 
	 * aplica un filtro sobre el umbral de estrellas seleccionado
	 * @param estadosServ array de booleanos con la seleccion de los filtros basicos
	 * @param estadosTipoPension array de booleanos con la seleccion de los filtros de tipo pension
	 * @param min numEstrellas minimo
	 * @param max numEstrellas maximo
	 */
	public void filtrarSoloHotel(boolean[] estadosServ, boolean[] estadosTipoPension, int min,int max) {
		filtrar(estadosServ, estadosTipoPension);
		filtrarEstrellasHotel(min, max);
	}
	
	/**
	 * Metodo que resetea los filtros de los alojamientos
	 * @param alojamientos Array de alojamientos a resetear
	 */
	private void resetFiltro(Alojamiento[] alojamientos) {
		for(Alojamiento aloj:alojamientos)
			aloj.setMostrar(true);
	}
	
	/**
	 * Metodo que filtra los alojamientos en funcion de los filtros de servicios seleccionados
	 * @param alojamientos Array de alojamientos a filtrar
	 * @param estados Array de estados de los filtros a aplicar
	 */
	private void filtrarServicios(Alojamiento[] alojamientos, boolean[] estados) {
		for (Alojamiento aloj : alojamientos) {
			for (int i = 0; i < estados.length; i++) {
				if (estados[i])
					if (aloj.servicios[i].tipo == TipoServicio.noDisponible) {
						aloj.setMostrar(false);
					}
			}
		}
	}
	
	/**
	 * Metodo que filtra los hoteles en funcion del minimo y maximo seleccionados
	 * @param min numEstrellas minimo
	 * @param max numEstrellas maximo
	 */
	public void filtrarEstrellasHotel(int min, int max) {
		for(Hotel hot:mod.hotelesBusqueda) {
			if(hot.getNumEstrellas()<min || hot.getNumEstrellas()>max)
				hot.setMostrar(false);
		}
	}

}