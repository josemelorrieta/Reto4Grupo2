package modelo;

import java.lang.reflect.Array;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import com.google.gson.Gson;

import BaseDatos.ConsultaBD;

public class MetodosBuscar {
	private ConsultaBD bd;
	private Modelo mod;
	
	private Gson gson = new Gson();

	SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");

	public MetodosBuscar(Modelo mod, ConsultaBD bd) {
		this.bd = bd;
		this.mod = mod;
	}

	// Getters y setters
	public ConsultaBD getBd() {
		return bd;
	}

	public void setBd(ConsultaBD bd) {
		this.bd = bd;
	}

	public Modelo getMod() {
		return mod;
	}

	public void setMod(Modelo mod) {
		this.mod = mod;
	}

	/**
	 * Funcion para buscar las localidades en que hay alojamientos en la Base de Datos
	 * 
	 * @return array de localidades
	 */
	public Localidad[] buscarLocalidades() {
		String aux = bd.consultarToGson("SELECT DISTINCT `localidad` FROM `direccion`");
		if (aux != null) {
			Localidad[] localidades = gson.fromJson(aux, Localidad[].class);
			return localidades;
		} else {
			return null;
		}

	}

	public void cargarAlojamientos(String localidad) {
		cargarHoteles(localidad);
		cargarCasas(localidad);
		cargarApartamentos(localidad);
	}

	private void cargarHoteles(String localidad) {
		String json = bd.consultarToGson("SELECT `idHot` 'id',`nombre`,`numEstrellas`,`pvpTAlta` 'precioTAlta',`pvpTBaja` 'precioTBaja',`pvpRecFestivo` 'precioTFest', `imagen` FROM `hotel` WHERE `idDir` IN (SELECT `idDir` FROM `direccion` WHERE `localidad`='" + localidad + "')");
		mod.hotelesBusqueda = gson.fromJson(json, Hotel[].class);
		for (Hotel hotel : mod.hotelesBusqueda) {
			cargarDireccion(hotel);
			cargarHabitaciones(hotel);
			setDisponibilidad(hotel);
		}
	}

	private void cargarCasas(String localidad) {
		String json = bd.consultarToGson("SELECT `idCasa` 'id',`nombre`,`pvpTAlta` 'precioTAlta',`pvpTBaja` 'precioTBaja',`pvpRecFestivo` 'precioTFest', `imagen` FROM `casa` WHERE `idDir` IN (SELECT `idDir` FROM `direccion` WHERE `localidad`='" + localidad + "')");
		mod.casasBusqueda = gson.fromJson(json, Casa[].class);
		for (Casa casa : mod.casasBusqueda) {
			cargarDireccion(casa);
			cargarHabitaciones(casa);
			setDisponibilidad(casa);
		}
	}

	private void cargarApartamentos(String localidad) {
		String json = bd.consultarToGson("SELECT `idApart` 'id',`nombre`,`pvpTAlta` 'precioTAlta',`pvpTBaja` 'precioTBaja',`pvpRecFestivo` 'precioTFest',`piso`, `imagen` FROM `apartamento` WHERE `idDir` IN (SELECT `idDir` FROM `direccion` WHERE `localidad`='" + localidad + "')");
		mod.apartBusqueda = gson.fromJson(json, Apartamento[].class);
		for (Apartamento apart : mod.apartBusqueda) {
			cargarDireccion(apart);
			cargarHabitaciones(apart);
			setDisponibilidad(apart);
		}
	}

	private void cargarDireccion(Hotel hotel) {
		String json = bd.consultarToGson("SELECT `calle`,`codPostal`,`localidad` FROM `direccion` WHERE `idDir` = (SELECT `idDir` FROM `hotel` WHERE `idHot` = " + hotel.getId() + ")");
		Direccion[] dir = gson.fromJson(json, Direccion[].class);
		hotel.setDireccion(dir[0]);
	}

	private void cargarDireccion(Casa casa) {
		String json = bd.consultarToGson("SELECT `calle`,`codPostal`,`localidad` FROM `direccion` WHERE `idDir` = (SELECT `idDir` FROM `casa` WHERE `idCasa` = " + casa.getId() + ")");
		Direccion[] dir = gson.fromJson(json, Direccion[].class);
		casa.setDireccion(dir[0]);
	}

	private void cargarDireccion(Apartamento apart) {
		String json = bd.consultarToGson("SELECT `calle`,`codPostal`,`localidad` FROM `direccion` WHERE `idDir` = (SELECT `idDir` FROM `apartamento` WHERE `idApart` = " + apart.getId() + ")");
		Direccion[] dir = gson.fromJson(json, Direccion[].class);
		apart.setDireccion(dir[0]);
	}

	private void cargarHabitaciones(Hotel hotel) {
		String json = bd.consultarToGson("SELECT `idHab`, `metros` 'm2', 'DORMITORIO' AS `tipoHabitacion` FROM `dormitorio` d, `habhotel` h WHERE d.`idDorm` IN (SELECT `idDorm` FROM `habhotel` WHERE `idHot`=" + hotel.getId() + ") AND d.`idDorm`=h.`idDorm`");
		Dormitorio[] dormitorios = gson.fromJson(json, Dormitorio[].class);
		for (Dormitorio dorm : dormitorios) {
			cargarMobiliarioDormitorioHotel(dorm);
		}
		hotel.setDormitorios(dormitorios);
	}

	private void cargarMobiliarioDormitorioHotel(Dormitorio dormitorio) {
		String json = bd.consultarToGson("SELECT 'CAMATEST' AS `nombre`,`tipoCama` FROM `cama` WHERE `idCama` IN (SELECT `idCama` FROM `camadorm` WHERE `idDorm` IN (SELECT `idDorm` FROM `habhotel` WHERE `idHab`=" + dormitorio.getIdHab() + "))");
		Cama[] camas = gson.fromJson(json, Cama[].class);
		dormitorio.setMobiliario(camas);
	}

	private void cargarHabitaciones(Casa casa) {
		String tipo = (casa.getClass()).getSimpleName().toLowerCase();

		String json = bd.consultarToGson("SELECT d.`idDorm` 'idHab', `metros` 'm2', 'DORMITORIO' AS `tipoHabitacion` FROM `dormitorio` d, `dorm" + tipo + "` c WHERE d.`idDorm` IN (SELECT `idDorm` FROM `dorm" + tipo + "` WHERE `id"+tipo.substring(0, 1).toUpperCase() + tipo.substring(1)+"`=" + casa.getId() + ") AND d.`idDorm`=c.`idDorm`");
		Habitacion[] habitaciones = gson.fromJson(json, Dormitorio[].class);

		for (Habitacion habit : habitaciones)
			if (habit instanceof Dormitorio)
				cargarMobiliarioDormitorioCasa((Dormitorio) habit, tipo);
		casa.setHabitaciones(habitaciones);
	}

	private void cargarMobiliarioDormitorioCasa(Dormitorio dormitorio, String tipo) {
		String json = bd.consultarToGson("SELECT 'Cama' AS `nombre`, `tipoCama` FROM `cama` WHERE `idCama` IN(SELECT `idCama` FROM `camadorm` WHERE `idDorm`="+ dormitorio.getIdHab() +")");
		Cama[] camas = gson.fromJson(json, Cama[].class);

		json = bd.consultarToGson("SELECT `tipoMob` 'nombre' FROM `mobiliario` WHERE `idMob` IN(SELECT `idMob` FROM `mobdorm` WHERE `idDorm`="+ dormitorio.getIdHab() +")");
		Mobiliario[] mobiliario = gson.fromJson(json, Mobiliario[].class);

		if (mobiliario != null && camas != null) {
			mobiliario = concatenate(mobiliario, camas);
			dormitorio.setMobiliario(mobiliario);
		} else if (camas != null) {
			dormitorio.setMobiliario(camas);
		} else {
			dormitorio.setMobiliario(null);
		}
	}

	/**
	 * Esto si esta sacado de stack overflow :)
	 * 
	 * @param a
	 * @param b
	 * @return
	 */
	public <T> T[] concatenate(T[] a, T[] b) {
		int aLen = a.length;
		int bLen = b.length;

		@SuppressWarnings("unchecked")
		T[] c = (T[]) Array.newInstance(a.getClass().getComponentType(), aLen + bLen);
		System.arraycopy(a, 0, c, 0, aLen);
		System.arraycopy(b, 0, c, aLen, bLen);

		return c;
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
						hotel.getDormitorios()[i].setDisponible(false);
						break;
					} else
						hotel.getDormitorios()[i].setDisponible(true);
				}
			} else {
				hotel.getDormitorios()[i].setDisponible(true);
			}
		}
		hotel.setDisponible(comprobarDisponibilidad(hotel));
	}

	private void setDisponibilidad(Casa casa) {
		Date fechaEntrada = mod.reserva.getFechaEntrada();
		Date fechaSalida = mod.reserva.getFechaSalida();
		Date fechaIn = new Date();
		Date fechaOut = new Date();
		int idHab = 0;

		FechasReserva[] fechasReserva = buscarFechasReservas();

		if (fechasReserva != null) {
			for (int j = 0; j < fechasReserva.length; j++) {
				try {
					fechaIn = sdf.parse(fechasReserva[j].getFechaIn());
					fechaOut = sdf.parse(fechasReserva[j].getFechaOut());
					idHab = fechasReserva[j].getIdHab();
				} catch (ParseException e) {
					e.printStackTrace();
				}
				if (fechaIn.compareTo(fechaSalida) <= 0 && fechaOut.compareTo(fechaEntrada) >= 0 && idHab == casa.getId()) {
					casa.setDisponible(false);
					break;
				} else
					casa.setDisponible(true);
			}
		} else {
			casa.setDisponible(true);
		}
	}

	public static boolean comprobarDisponibilidad(Hotel hotel) {
		int count = 0;
		for (int i = 0; i < hotel.getDormitorios().length; i++) {
			if (hotel.getDormitorios()[i].isDisponible() == false)
				count++;
		}
		if (count == hotel.getDormitorios().length) {
			return false;
		} else
			return true;
	}

	private FechasReserva[] buscarFechasReservas() {
		String json = bd.consultarToGson("SELECT r.`idRsv`, `idHab`, `fechaIn`, `fechaOut` FROM `reserva` r, `rsvhab` h WHERE r.`idRsv`=h.`idRsv`");
		FechasReserva[] fechasReserva = gson.fromJson(json, FechasReserva[].class);

		return fechasReserva;
	}
	
	public Calendar[] buscarFechasFestivos() {
		String json = bd.consultarToGson("SELECT COUNT(*) FROM `festivos`");
		gson = new Gson();
		Global[] fechasBBDD = gson.fromJson(json, Global[].class);
		
		Calendar[] fechas=new Calendar[(int) fechasBBDD[0].getAuxiliar()];
		
		json=bd.consultarToGson("SELECT * FROM `festivos`");
		fechasBBDD = gson.fromJson(json, Global[].class);
		
		for(int i =0;i<fechasBBDD.length;i++) {
			Date fechaAux=(Date) fechasBBDD[i].getAuxiliar();
			Calendar calendarAux=Calendar.getInstance();
			calendarAux.setTime(fechaAux);
			fechas[i]=calendarAux; 
		}

		return fechas;
	}
}
