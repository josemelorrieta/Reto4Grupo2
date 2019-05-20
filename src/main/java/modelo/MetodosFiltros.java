package modelo;

import java.util.ArrayList;

import vista.panelCard.PanelResBusqueda;

/**
 * Clase con metodos para filtrar servicios
 *
 */
public class MetodosFiltros {

	private Modelo mod;

	// HOTEL, CASA, APARTAMENTO
	public boolean[] filtroTipoAloj = { false, false, false };
	// WIFI,PARKING,RESTAURANTE,GIMNASIO, PISCINA, A/C, BAR, SPA
	public boolean[] filtroServicios = { false, false, false, false, false, false, false, false };
	// AD, MP, PC
	public boolean[] filtroPension = { false, false, false };
	public int[] filtroEstrellas = { 1, 5 };

	public MetodosFiltros(Modelo mod) {
		this.mod = mod;
	}

	/**
	 * Actualiza la vista con la informacion del modelo para mostrar la
	 * disponibilidad de servicio
	 * 
	 * @param estados array de booleanos que indican disponibilidad
	 */
	public void filtrar(PanelResBusqueda panel, boolean[] filtroTipoAloj, boolean[] filtroServicios, boolean[] filtroPension, int[] filtroEstrellas) {
		ArrayList<Alojamiento> listaAlojamientosOriginal = new ArrayList<Alojamiento>();
		ArrayList<Alojamiento> listaAlojamientos = new ArrayList<Alojamiento>();

		for (int index = 0; index < panel.modelResBusq.size(); index++) {
			listaAlojamientosOriginal.add(panel.modelResBusq.get(index));
		}

		// Filtrar estrellas
		if (filtroEstrellas[0] == 1 && filtroEstrellas[2] == 5) {
			// Filtrar tipoAloj
			if (filtroTipoAloj[0] == false && filtroTipoAloj[1] == false && filtroTipoAloj[2] == false || filtroTipoAloj[0] == true && filtroTipoAloj[1] == true && filtroTipoAloj[2] == true) {
				listaAlojamientos.addAll(listaAlojamientosOriginal);
			} else {
				if (filtroTipoAloj[0] == true) {
					for (Alojamiento hot : listaAlojamientosOriginal) {
						if(hot instanceof Hotel) {
							listaAlojamientos.add(hot);
						}
					}
				}
				if (filtroTipoAloj[1] == true) {
					for (Alojamiento casa : listaAlojamientosOriginal) {
						if(casa instanceof Casa) {
							listaAlojamientos.add(casa);
						}
					}
				}
				if (filtroTipoAloj[2] == true) {
					for (Alojamiento apart : listaAlojamientosOriginal) {
						if(apart instanceof Apartamento) {
							listaAlojamientos.add(apart);
						}
					}
				}
			}
		} else {
			listaAlojamientos.addAll(listaAlojamientosOriginal);
		}
		
		//Filtrar servicios
	}

//		for (Hotel hot : mod.hotelesBusqueda) {
//			hot.setMostrar(true);
//			for (int i = 0; i < estados.length; i++)
//				if (hot.servicios[i].getTipo() == TipoServicio.noDisponible)
//					hot.setMostrar(false);
//		}
//		for (Casa casa : mod.casasBusqueda) {
//			casa.setMostrar(true);
//			for (int i = 0; i < estados.length; i++)
//				if (casa.servicios[i].getTipo() == TipoServicio.noDisponible)
//					casa.setMostrar(false);
//		}
//		for (Apartamento apart : mod.apartBusqueda) {
//			apart.setMostrar(true);
//			for (int i = 0; i < estados.length; i++)
//				if (apart.servicios[i].getTipo() == TipoServicio.noDisponible)
//					apart.setMostrar(false);
//		}

}