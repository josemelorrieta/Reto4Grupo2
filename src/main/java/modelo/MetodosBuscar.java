package modelo;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import com.google.gson.Gson;

import BaseDatos.ConsultaBD;

public class MetodosBuscar {
	private ConsultaBD bd;
	private Gson gson = new Gson();
	private Modelo mod;

	SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");

	public MetodosBuscar(Modelo mod, ConsultaBD bd) {
		this.bd = bd;
		this.mod = mod;
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
		String json = bd.consultarToGson("SELECT `idHot` 'id',`nombre`,`numEstrellas`,`pvpTAlta` 'precioTAlta',`pvpTBaja` 'precioTBaja',`pvpRecFestivo` 'precioTFest', `imagen` FROM `hotel` WHERE `idDir` IN (SELECT `idDir` FROM `direccion` WHERE `localidad`='" + localidad + "')");
		gson = new Gson();
		mod.hotelesBusqueda = gson.fromJson(json, Hotel[].class);
		for (Hotel hotel : mod.hotelesBusqueda) {
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
		// Habitacion[] habit = gson.fromJson(json, Habitacion[].class);
		Dormitorio[] dormitorios = gson.fromJson(json, Dormitorio[].class);
		for (Dormitorio dormitorio : dormitorios)
			cargarCamasHabit(dormitorio);
		// hotel.setArrayHabitaciones(habit);
		hotel.setDormitorios(dormitorios);
		boolean[] dormitoriosDisp = new boolean[dormitorios.length];
		for (int i = 0; i < dormitoriosDisp.length; i++) {
			dormitoriosDisp[i] = true;
		}
		hotel.setDormDisponibles(dormitoriosDisp);
	}

	private void cargarCamasHabit(Dormitorio dormitorio) {
		String json = bd.consultarToGson("SELECT `tipoCama` FROM `cama` WHERE `idCama` IN (SELECT `idCama` FROM `camadorm` WHERE `idDorm` IN (SELECT `idDorm` FROM `habhotel` WHERE `idHab`=" + dormitorio.getIdHab() + "))");
		gson = new Gson();
		Cama[] camas = gson.fromJson(json, Cama[].class);
		// habitacion.setArrayCamas(camasHabit);
		dormitorio.setMobiliario(camas);
	}

	private void setDisponibilidad(Hotel hotel) {
		Date fechaEntrada = mod.reserva.getFechaEntrada();
		Date fechaSalida = mod.reserva.getFechaSalida();
		Date fechaIn = new Date();
		Date fechaOut = new Date();
		int idHab = 0;

		FechasReserva[] fechasReserva = buscarFechasReservas();

		for (int i = 0; i < hotel.getDormitorios().length; i++) {
			if (fechasReserva != null) {
				for (int j = 0; j < fechasReserva.length; j++) {
					try {
						fechaIn = sdf.parse(fechasReserva[j].getFechaIn());
						fechaOut = sdf.parse(fechasReserva[j].getFechaOut());
						idHab = fechasReserva[j].getIdHab();
					} catch (ParseException e) {
						e.printStackTrace();
					}
					if (fechaIn.compareTo(fechaSalida) <= 0 && fechaOut.compareTo(fechaEntrada) >= 0 && idHab == hotel.getDormitorios()[i].getIdHab()) {
						hotel.getDormDisponibles()[i] = false;
						break;
					}
				}
			} else {
				hotel.getDormDisponibles()[i] = true;
			}
		}
	}
	
	private void setDisponibilidad2(Hotel hotel) {
		Date fechaEntrada = mod.reserva.getFechaEntrada();
		Date fechaSalida = mod.reserva.getFechaSalida();
		Date fechaIn = new Date();
		Date fechaOut = new Date();
		
		
	}

	private FechasReserva[] buscarFechasReservas() {
		String json = bd.consultarToGson("SELECT r.`idRsv`, `idHab`, `fechaIn`, `fechaOut` FROM `reserva` r, `rsvhab` h WHERE r.`idRsv`=h.`idRsv`");
		gson = new Gson();
		FechasReserva[] fechasReserva = gson.fromJson(json, FechasReserva[].class);

		return fechasReserva;
	}
}
