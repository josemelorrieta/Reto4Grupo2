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
		Hotel[] aux = (Hotel[])bd.consultarToArray("SELECT `nombre`,`numEstrellas`,`pvpTAlta`,`pvpTBaja`,`pvpRecFestivo` FROM `hotel` WHERE `idDir` IN (SELECT `idDir` FROM `direccion` WHERE `localidad`='"+localidad+"')");
		hotelesBusqueda = new Hotel[aux.length];
		for(int i=0;i<aux.length;i++) {
			hotelesBusqueda[i] = new Hotel(aux[i].nombre,null,null,aux[i].precioTAlta,aux[i].precioTBaja,aux[i].precioTFest,aux[i].getEstrellas());
		}
	}
	
}
