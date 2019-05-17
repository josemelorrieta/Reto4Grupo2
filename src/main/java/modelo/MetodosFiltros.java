package modelo;

public class MetodosFiltros {

	private Modelo mod;
	
	public MetodosFiltros(Modelo mod) {
		this.mod = mod;
	}

	public void filtrarTipoAlojamiento() {
		
	}
	
	public void filtrarServicios(boolean[] estados) {
		for(Hotel hot:mod.hotelesBusqueda)
			for(int i=0;i<estados.length;i++)
				if(hot.servicios[i] == Servicio.noDisponible)
					hot.setMostrar(false);
		for(Casa casa:mod.casasBusqueda)
			for(int i=0;i<estados.length;i++)
				if(casa.servicios[i] == Servicio.noDisponible)
					casa.setMostrar(false);
		for(Apartamento apart:mod.apartBusqueda)
			for(int i=0;i<estados.length;i++)
				if(apart.servicios[i] == Servicio.noDisponible)
					apart.setMostrar(false);
	}
		
}
