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
	
	public void filtrarSoloHotel(boolean[] estadosServ, boolean[] estadosTipoPension, int min,int max) {
		filtrar(estadosServ, estadosTipoPension);
		filtrarEstrellasHotel(min, max);
	}
	
	private void resetFiltro(Alojamiento[] alojamientos) {
		for(Alojamiento aloj:alojamientos)
			aloj.setMostrar(true);
	}
	
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
	
	public void filtrarEstrellasHotel(int min, int max) {
		for(Hotel hot:mod.hotelesBusqueda) {
			if(hot.getNumEstrellas()<min || hot.getNumEstrellas()>max)
				hot.setMostrar(false);
		}
	}

}