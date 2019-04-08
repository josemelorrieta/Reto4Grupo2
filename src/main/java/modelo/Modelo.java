package modelo;

import BaseDatos.ConsultaBD;

public class Modelo {
	
	private ConsultaBD bd;
	
	private Hotel hotel;
	private Reserva reserva;
	private Hotel[] hotelesBusqueda;
	
	public Modelo() {
		hotel = new Hotel();
		reserva = new Reserva();
	}
	
	public void cargarHoteles(String localidad) {
		Object[] aux = bd.consultarToArray("SELECT `nombre`,`numEstrellas`,`pvpTAlta`,`pvpTBaja`,`pvpRecFestivo` FROM `hotel` WHERE `idDir` IN (SELECT `idDir` FROM `direccion` WHERE `localidad`='"+localidad+"')");
		hotelesBusqueda = new Hotel[aux.length];
		for(int i=0;i<aux.length;i++) {

			//hotelesBusqueda[i] = new Hotel(aux[i],null,null,0,0,0,0);

			

		}
	}

	public Hotel[] getHotelesBusqueda() {
		return hotelesBusqueda;
	}

	public void setHotelesBusqueda(Hotel[] hotelesBusqueda) {
		this.hotelesBusqueda = hotelesBusqueda;
	}
	
}

