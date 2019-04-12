package modelo;

import java.util.Date;

import com.google.gson.Gson;

import BaseDatos.ConsultaBD;

public class MetodosBuscar {
	private ConsultaBD bd;
	private Gson gson = new Gson();
	private Modelo mod;
	
	public MetodosBuscar(Modelo mod, ConsultaBD bd) {
		this.bd=bd;
		this.mod=mod;
	}
	
	public Localidad[] buscarLocalidades() {
		String aux = bd.consultarToGson("SELECT DISTINCT `localidad` FROM `direccion`");
		if (aux != null) {
			final Gson gson = new Gson();
			Localidad[] localidades = gson.fromJson(aux, Localidad[].class);
			return localidades;
		} else {
			return null;
		}

	}
	
	public void cargarHoteles(String localidad) {
		String json = bd.consultarToGson("SELECT `idHot` 'id',`nombre`,`numEstrellas`,`pvpTAlta` 'precioTAlta',`pvpTBaja` 'precioTBaja',`pvpRecFestivo` 'precioTFest', `imagen` FROM `hotel` WHERE `idDir` IN (SELECT `idDir` FROM `direccion` WHERE `localidad`='"+localidad+"')");
		gson = new Gson();
		mod.hotelesBusqueda = gson.fromJson(json, Hotel[].class);
		for(Hotel hotel:mod.hotelesBusqueda) {
			cargarHotelDireccion(hotel);
			cargarHotelHabitaciones(hotel);
			setDisponibilidad(hotel);
		}
	}

	private void cargarHotelDireccion(Hotel hotel) {
		String json = bd.consultarToGson("SELECT `calle`,`codPostal`,`localidad` FROM `direccion` WHERE `idDir` = (SELECT `idDir` FROM `hotel` WHERE `idHot` = " + hotel.getId() + ")");
		gson = new Gson();
		Direccion[] dir = gson.fromJson(json, Direccion[].class);
		hotel.setDireccion(dir[0]);
	}
	
	private void cargarHotelHabitaciones(Hotel hotel) {
		String json = bd.consultarToGson("SELECT `idHab`, `metros` 'm2', 'DORMITORIO' AS `tipoHabitacion` FROM `dormitorio` d, `habhotel` h WHERE d.`idDorm` IN (SELECT `idDorm` FROM `habhotel` WHERE `idHot`=" + hotel.getId() + ") AND d.`idDorm`=h.`idDorm`");
		gson = new Gson();
		//Habitacion[] habit = gson.fromJson(json, Habitacion[].class);
		Dormitorio[] dormitorios = gson.fromJson(json, Dormitorio[].class);
		for (Dormitorio dormitorio : dormitorios)
			cargarCamasHabit(dormitorio);
		//hotel.setArrayHabitaciones(habit);
		hotel.setDormitorios(dormitorios);
	}
	
	private void cargarCamasHabit(Dormitorio dormitorio) {
		String json = bd.consultarToGson("SELECT `tipoCama` FROM `cama` WHERE `idCama` IN (SELECT `idCama` FROM `camadorm` WHERE `idDorm` IN (SELECT `idDorm` FROM `habhotel` WHERE `idHab`=" + dormitorio.getIdHab() + "))");
		gson = new Gson();
		Cama[] camas = gson.fromJson(json, Cama[].class);
		//habitacion.setArrayCamas(camasHabit);
		dormitorio.setMobiliario(camas);
	}
	
	private void setDisponibilidad(Hotel hotel) {
		Date fechaEntrada = mod.reserva.getFechaEntrada();
		Date fechaSalida = mod.reserva.getFechaSalida();

		FechasReserva[] fechasReserva = buscarFechasReservas();
		
		System.out.println("");
//		for (Dormitorio dormitorio : hotel.getDormitorios()) {
//			FechasReserva[] fechasReserva = buscarFechasReservas();
//			for (int i=0;i<fechasReserva.length;i++) {
//				if (fechasReserva[i].getFechaIn().compareTo(fechaSalida) <= 0 && fechasReserva[i].getFechaOut().compareTo(fechaEntrada)>=0) {
//					
//				}
//			}
//		}
		
	}
	
	private FechasReserva[] buscarFechasReservas() {
		String json = bd.consultarToGson("SELECT `idRsv`, `fechaIn`, `fechaOut` FROM `reserva`");
		gson = new Gson();
		FechasReserva[] fechasReserva = gson.fromJson(json, FechasReserva[].class);
		
		return fechasReserva;
	}
}
