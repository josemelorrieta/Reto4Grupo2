package modelo;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Date;
import java.util.Vector;

import com.google.gson.Gson;

import BaseDatos.ConsultaBD;
import util.FuncionesGenerales;

public class MetodosBuscar {
	private ConsultaBD bd;
	private Modelo mod;

	private Gson gson = new Gson();

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
	 * Funcion para buscar las localidades en que hay alojamientos en la Base de
	 * Datos
	 * 
	 * @return array de localidades
	 */
	public String[] buscarLocalidades() {
		String aux = bd.consultarToGson("SELECT DISTINCT `localidad` 'auxiliar' FROM `direccion`");
		if (aux != null) {
			Global[] localidadesGlobal = gson.fromJson(aux, Global[].class);
			String[] localidades = new String[localidadesGlobal.length];
			for (int i = 0; i < localidadesGlobal.length; i++) {
				localidades[i] = (String) localidadesGlobal[i].getAuxiliar();
			}
			return localidades;
		} else {
			return null;
		}

	}

	/**
	 * Cargar los alojamientos segun la localidad seleccionada
	 * 
	 * @param localidad Valor seleccionado por el cliente en la pantalla inicial
	 */
	public void cargarAlojamientos(String localidad) {
		cargarHoteles(localidad);
		cargarCasas(localidad);
		cargarApartamentos(localidad);
	}

	/**
	 * Carga los hoteles para la localidad seleccionada
	 * 
	 * @param localidad
	 */
	public void cargarHoteles(String localidad) {
		String json = bd.consultarToGson("SELECT `idHot` 'id',`nombre`,`numEstrellas`,`pvpTAlta` 'precioTAlta',`pvpTBaja` 'precioTBaja',`pvpRecFestivo` 'precioTFest', `pvpM2`, `imagen` FROM `hotel` WHERE `idDir` IN (SELECT `idDir` FROM `direccion` WHERE `localidad`='" + localidad + "')");
		mod.hotelesBusqueda = gson.fromJson(json, Hotel[].class);
		for (Hotel hotel : mod.hotelesBusqueda) {
			cargarDireccion(hotel, "hotel", "idHot");
			cargarHabitaciones(hotel);
			setDisponibilidad(hotel,FuncionesGenerales.sdf);
			hotel.setServicios(setServicios(hotel));
		}
	}

	/**
	 * Carga las casas para la localidad seleccionada
	 * 
	 * @param localidad
	 */
	private void cargarCasas(String localidad) {
		String json = bd.consultarToGson("SELECT `idCasa` 'id',`nombre`,`pvpTAlta` 'precioTAlta',`pvpTBaja` 'precioTBaja',`pvpRecFestivo` 'precioTFest', `pvpM2`, `imagen` FROM `casa` WHERE `idDir` IN (SELECT `idDir` FROM `direccion` WHERE `localidad`='" + localidad + "')");
		mod.casasBusqueda = gson.fromJson(json, Casa[].class);
		for (Casa casa : mod.casasBusqueda) {
			cargarDireccion(casa, "casa", "idCasa");
			cargarHabitaciones(casa);
			setDisponibilidad(casa,FuncionesGenerales.sdf);
			casa.setServicios(setServicios(casa));
		}
	}

	/**
	 * Carga los apartamentos para la localidad seleccionada
	 * 
	 * @param localidad
	 */
	private void cargarApartamentos(String localidad) {
		String json = bd.consultarToGson("SELECT `idApart` 'id',`nombre`,`pvpTAlta` 'precioTAlta',`pvpTBaja` 'precioTBaja',`pvpRecFestivo` 'precioTFest', `pvpM2`, `piso`, `imagen` FROM `apartamento` WHERE `idDir` IN (SELECT `idDir` FROM `direccion` WHERE `localidad`='" + localidad + "')");
		mod.apartBusqueda = gson.fromJson(json, Apartamento[].class);
		for (Apartamento apart : mod.apartBusqueda) {
			cargarDireccion(apart, "Apartamento", "idApart");
			cargarHabitaciones(apart);
			setDisponibilidad(apart,FuncionesGenerales.sdf);
			apart.setServicios(setServicios(apart));
		}
	}

	/**
	 * Carga la direccion del alojamiento pasado como parametro para hoteles, casas y apartamentos
	 * 
	 * @param aloj Alojamiento al que se le quiere guardar su direccion
	 * @param tabla Nombre de la tabla de la base de datos para distinguir entre alojamientos (hotel, casa, apartamento)
	 * @param id Nombre del campo id en la base de datos segun el tipo de alojamiento (idHot, idCasa, idApart)
	 */
	public void cargarDireccion(Alojamiento aloj, String tabla, String id) {
		String json = bd.consultarToGson("SELECT `calle`,`codPostal`,`localidad` FROM `direccion` WHERE `idDir` = (SELECT `idDir` FROM `" + tabla + "` WHERE `" + id + "` = " + aloj.getId() + ")");
		Direccion[] dir = gson.fromJson(json, Direccion[].class);
		aloj.setDireccion(dir[0]);
	}

	/**
	 * Carga las habitaciones de un hotel
	 * 
	 * @param hotel hotel al que se le van a cargar las habitaciones
	 */
	private void cargarHabitaciones(Hotel hotel) {
		String json = bd.consultarToGson("SELECT `idHab`, `metros` 'm2', 'DORMITORIO' AS `tipoHabitacion` FROM `dormitorio` d, `habhotel` h WHERE d.`idDorm` IN (SELECT `idDorm` FROM `habhotel` WHERE `idHot`=" + hotel.getId() + ") AND d.`idDorm`=h.`idDorm`");
		Dormitorio[] dormitorios = gson.fromJson(json, Dormitorio[].class);
		for (Dormitorio dorm : dormitorios) {
			cargarMobiliarioDormitorioHotel(dorm);
		}
		hotel.setHabitaciones(dormitorios);
	}

	/**
	 * Carga las habitaciones de una casa
	 * 
	 * @param casa Casa a la que se le van a cargar las habitaciones 
	 */
	private void cargarHabitaciones(Casa casa) {
		String tipo = (casa.getClass()).getSimpleName().toLowerCase();
		String json = bd.consultarToGson("SELECT d.`idDorm` 'idHab', `metros` 'm2', 'DORMITORIO' AS `tipoHabitacion` FROM `dormitorio` d, `dorm" + tipo + "` c WHERE d.`idDorm` IN (SELECT `idDorm` FROM `dorm" + tipo + "` WHERE `id" + tipo.substring(0, 1).toUpperCase() + tipo.substring(1) + "`=" + casa.getId() + ") AND d.`idDorm`=c.`idDorm`");
		Dormitorio[] dormitorios = gson.fromJson(json, Dormitorio[].class);
		for (Dormitorio dorm : dormitorios)
			cargarMobiliarioDormitorioCasa(dorm);

		json = bd.consultarToGson("SELECT d.`idNDorm` 'idHab', `metros` 'm2', `tipoHab` 'tipoHabitacion' FROM `noDormitorio` d, `nDorm" + tipo + "` c WHERE d.`idNDorm` IN (SELECT `idNDorm` FROM `nDorm" + tipo + "` WHERE `id" + tipo.substring(0, 1).toUpperCase() + tipo.substring(1) + "`=" + casa.getId() + ") AND d.`idNDorm`=c.`idNDorm`");
		Habitacion[] noDormitorios = gson.fromJson(json, Habitacion[].class);

		if (dormitorios != null && noDormitorios != null) {
			noDormitorios = FuncionesGenerales.concatenate(noDormitorios, dormitorios);
			casa.setHabitaciones(noDormitorios);
		} else if (dormitorios != null) {
			casa.setHabitaciones(dormitorios);
		} else {
			casa.setHabitaciones(null);
		}
	}

	/**
	 * Carga las habitaciones de un hotel en una matriz separados segun el tipo de
	 * dormitorio
	 * 
	 * @param hotel hotel del cual se buscan las habitaciones
	 * @return matrix de dormitorios
	 */
	private Vector<Vector<Dormitorio>> matrizHabitaciones(Hotel hotel) {
		String json = bd.consultarToGson("SELECT DISTINCT `tipoDorm` as 'auxiliar' FROM `habhotel` ORDER BY ASC");
		Global[] tiposDormGlobal = gson.fromJson(json, Global[].class);
		String[] tiposDorm = new String[tiposDormGlobal.length];
		int i = 0;
		for (Global global : tiposDormGlobal) {
			tiposDorm[i] = (String) global.getAuxiliar();
			i++;
		}

		Vector<Vector<Dormitorio>> matrix = new Vector<Vector<Dormitorio>>();

		for (String tipo : tiposDorm) {
			json = bd.consultarToGson("SELECT `idHab`, `metros` 'm2', 'DORMITORIO' AS `tipoHabitacion` FROM `dormitorio` d, `habhotel` h WHERE d.`idDorm` IN (SELECT `idDorm` FROM `habhotel` WHERE `idHot`=" + hotel.getId() + ") AND d.`idDorm`=h.`idDorm` AND tipoDorm='" + tipo + "'");
			Dormitorio[] dormitorios = gson.fromJson(json, Dormitorio[].class);
			matrix.add(new Vector<Dormitorio>(Arrays.asList(dormitorios)));
		}
		return matrix;
	}

	/**
	 * Carga el mobiliario en una matriz de dormitorios
	 * 
	 * @param dormitorios matriz (VectorXVector) de dormitorios
	 * @return
	 */
	private Vector<Vector<Dormitorio>> cargarMobiliarioDormitorio(Vector<Vector<Dormitorio>> dormitorios) {
		for (int i = 0; i < dormitorios.size(); i++) {
			for (int f = 0; f < dormitorios.get(i).size(); f++) {
				dormitorios.get(i).get(f).setMobiliario(mobiliarioDormitorio(dormitorios.get(i).get(f)));
			}
		}
		return dormitorios;
	}

	/**
	 * Comprueba si el dormitorio proporcionado por parametro esta reservado
	 * 
	 * @param dorm Dormitorio cual se quiere comprobar
	 * @return el dormitorio enviado por parametro con la disponibilidad cambiada
	 */
	private Dormitorio setDisponibilidadDormitorio(Dormitorio dorm,Date fechaEntrada,Date fechaSalida,SimpleDateFormat sdf) {
		if (dorm == null)
			return null;
		// fechaEntrada = mod.reserva.getFechaEntrada();
		// fechaSalida = mod.reserva.getFechaSalida();
		Date fechaIn = new Date();
		Date fechaOut = new Date();
		int idHab = 0;
		FechasReserva[] fechasReserva = comprobarDisponibilidadDormitorio(dorm, fechaEntrada, fechaSalida,FuncionesGenerales.sdf);

		if (fechasReserva != null) {
			for (int j = 0; j < fechasReserva.length; j++) {
				try {
					fechaIn = sdf.parse(fechasReserva[j].getFechaIn());
					fechaOut = sdf.parse(fechasReserva[j].getFechaOut());
					idHab = fechasReserva[j].getId();
				} catch (ParseException e) {
					e.printStackTrace();
				}
				if (fechaIn.compareTo(fechaSalida) <= 0 && fechaOut.compareTo(fechaEntrada) >= 0 && idHab == dorm.getIdHab()) {
					dorm.setDisponible(false);
					return dorm;
				} else
					dorm.setDisponible(true);
			}
			return dorm;
		} else {
			dorm.setDisponible(true);
			return dorm;
		}

	}

	/**
	 * Comprueba la disponibilidad de un dormitorio de un hotel segun las reservas de la base de datos
	 * 
	 * @param dorm Dormitorio al que se le va a comprobar su disponibilidad
	 * @param fechaIn Fecha de entrada de la reserva
	 * @param fechaOut Fecha de salida de la reserva
	 * @param sdf Variable tipo SimpleDateFormat usada de las funiones comunes del paquete util
	 * @return array de fechas de las reservas encontradas en la base de datos para ese dormitorio
	 */
	private FechasReserva[] comprobarDisponibilidadDormitorio(Dormitorio dorm, Date fechaIn, Date fechaOut,SimpleDateFormat sdf) {
		String json = bd.consultarToGson("SELECT r.`idRsv`, `idHab` 'id', `fechaIn`, `fechaOut` FROM `reserva` r, `rsvHab` h WHERE r.`idRsv`=h.`idRsv` AND `idHab`='" + dorm.getIdHab() + "' AND (CAST('" + sdf.format(fechaIn) + "' AS DATE) BETWEEN 'fechaIn' AND 'fechaOut') OR (CAST('" + sdf.format(fechaOut) + "' AS DATE) BETWEEN 'fechaIn' AND 'fechaOut')");
		FechasReserva[] fechasReserva = gson.fromJson(json, FechasReserva[].class);

		return fechasReserva;
	}

	/**
	 * Selecciona el mobiliario del dormitorio sacado de la base de datos
	 * @param dorm Dormitorio al que se le quiere buscar su mobiliario
	 * @return array de muebles encontrados para ese dormitorio
	 */
	private Mobiliario[] mobiliarioDormitorio(Dormitorio dorm) {
		String json = bd.consultarToGson("SELECT `tipoMob` 'nombre',`tipoMob` 'tipoMobiliario' FROM `mobiliario` WHERE `idMob` IN(SELECT `idMob` FROM `mobdorm` WHERE `idDorm`=" + dorm.getIdHab() + ")");
		Mobiliario[] mobiliario = gson.fromJson(json, Mobiliario[].class);
		return mobiliario;
	}

	/**
	 * Selecciona el mobiliario del dormitorio de una casa sacado de la base de datos
	 * @param dormitorio Dormitorio al que se le quiere buscar su mobiliario
	 */
	private void cargarMobiliarioDormitorioCasa(Dormitorio dormitorio) {
		String json = bd.consultarToGson("SELECT 'Cama' AS `nombre`, `tipoCama`,'CAMA' AS `tipoMobiliario` FROM `cama` WHERE `idCama` IN(SELECT `idCama` FROM `camadorm` WHERE `idDorm`=" + dormitorio.getIdHab() + ")");
		Cama[] camas = gson.fromJson(json, Cama[].class);

		json = bd.consultarToGson("SELECT `tipoMob` 'nombre',`tipoMob` 'tipoMobiliario' FROM `mobiliario` WHERE `idMob` IN(SELECT `idMob` FROM `mobdorm` WHERE `idDorm`=" + dormitorio.getIdHab() + ")");
		Mobiliario[] mobiliario = gson.fromJson(json, Mobiliario[].class);

		if (mobiliario != null && camas != null) {
			mobiliario = FuncionesGenerales.concatenate(mobiliario, camas);
			dormitorio.setMobiliario(mobiliario);
		} else if (camas != null) {
			dormitorio.setMobiliario(camas);
		} else {
			dormitorio.setMobiliario(null);
		}
	}

	/**
	 * Selecciona el mobiliario del dormitorio de un hotel sacado de la base de datos
	 * 
	 * @param dormitorioDormitorio al que se le quiere buscar su mobiliario
	 */
	private void cargarMobiliarioDormitorioHotel(Dormitorio dormitorio) {
		String json = bd.consultarToGson("SELECT 'CAMATEST' AS `nombre`,`tipoCama` FROM `cama` WHERE `idCama` IN (SELECT `idCama` FROM `camadorm` WHERE `idDorm` IN (SELECT `idDorm` FROM `habhotel` WHERE `idHab`=" + dormitorio.getIdHab() + "))");
		Cama[] camas = gson.fromJson(json, Cama[].class);
		dormitorio.setMobiliario(camas);
	}

	/**
	 * Fija si un hotel esta disponible para las fechas seleccionadas
	 * 
	 * @param hotel Hotel al que se le va a fijar su disponibilidad
	 * @param sdf SimpleDateFormat cogido de la clase del paquete util comun a toto el codigo
	 */
	private void setDisponibilidad(Hotel hotel,SimpleDateFormat sdf) {
		Date fechaEntrada = mod.reserva.getFechaEntrada();
		Date fechaSalida = mod.reserva.getFechaSalida();
		Date fechaIn = new Date();
		Date fechaOut = new Date();
		int idHab = 0;

		FechasReserva[] fechasReserva = buscarFechasReservas(hotel);

		for (int i = 0; i < hotel.getHabitaciones().length; i++) {
			if (fechasReserva != null) {
				for (int j = 0; j < fechasReserva.length; j++) {
					try {
						fechaIn = sdf.parse(fechasReserva[j].getFechaIn());
						fechaOut = sdf.parse(fechasReserva[j].getFechaOut());
						idHab = fechasReserva[j].getId();
					} catch (ParseException e) {
						e.printStackTrace();
					}
					if (fechaIn.compareTo(fechaSalida) <= 0 && fechaOut.compareTo(fechaEntrada) >= 0 && idHab == hotel.getHabitaciones()[i].getIdHab()) {
						((Dormitorio) hotel.getHabitaciones()[i]).setDisponible(false);
						break;
					} else
						((Dormitorio) hotel.getHabitaciones()[i]).setDisponible(true);
				}
			} else {
				((Dormitorio) hotel.getHabitaciones()[i]).setDisponible(true);
			}
		}
		hotel.setDisponible(comprobarDisponibilidad(hotel));
	}

	/**
	 * Fija si una casa esta disponible para las fechas seleccionadas
	 * 
	 * @param casa Casa a la que se le va a fijar su disponibilidad
	 * @param sdf SimpleDateFormat cogido de la clase del paquete util comun a toto el codigo
	 */
	private void setDisponibilidad(Casa casa,SimpleDateFormat sdf) {
		Date fechaEntrada = mod.reserva.getFechaEntrada();
		Date fechaSalida = mod.reserva.getFechaSalida();
		Date fechaIn = new Date();
		Date fechaOut = new Date();
		int idCasa = 0;

		FechasReserva[] fechasReserva = buscarFechasReservas(casa);

		if (fechasReserva != null) {
			for (int j = 0; j < fechasReserva.length; j++) {
				try {
					fechaIn = sdf.parse(fechasReserva[j].getFechaIn());
					fechaOut = sdf.parse(fechasReserva[j].getFechaOut());
					idCasa = fechasReserva[j].getId();
				} catch (ParseException e) {
					e.printStackTrace();
				}
				if (fechaIn.compareTo(fechaSalida) <= 0 && fechaOut.compareTo(fechaEntrada) >= 0 && idCasa == casa.getId()) {
					casa.setDisponible(false);
					break;
				} else
					casa.setDisponible(true);
			}
		} else {
			casa.setDisponible(true);
		}
	}

	/**
	 * Comprueba la disponibilidad de las habitaciones de un hotel
	 * 
	 * @param hotel Hotel al que se le comprueba la disponibilidad de sus habitaciones
	 */
	public static boolean comprobarDisponibilidad(Hotel hotel) {
		int count = 0;
		for (int i = 0; i < hotel.getHabitaciones().length; i++) {
			if (((Dormitorio) hotel.getHabitaciones()[i]).isDisponible() == false)
				count++;
		}
		if (count == hotel.getHabitaciones().length) {
			return false;
		} else
			return true;
	}
	
	/**
	 * Devuelve las fechas en las que esta reservado un alojamiento
	 * 
	 * @param aloj Alojamiento a comprobar
	 * @return Array de fechas en las que ese alojamiento esta reservado
	 */
	private FechasReserva[] buscarFechasReservas(Alojamiento aloj) {
		String tipo = FuncionesGenerales.tipoAloj(aloj);

		String json = bd.consultarToGson("SELECT r.`idRsv`, `id" + tipo + "` 'id', `fechaIn`, `fechaOut` FROM `reserva` r, `rsv" + tipo.toLowerCase() + "` h WHERE r.`idRsv`=h.`idRsv`");
		FechasReserva[] fechasReserva = gson.fromJson(json, FechasReserva[].class);

		return fechasReserva;
	}
	
	/**
	 * Busca las fechas de los dias festivos que estan dados de alta en la base de datos
	 * 
	 * @param sdf SimpleDateFormat del paquete util
	 * @return Array de fechas festivas
	 */
	public Calendar[] buscarFechasFestivos(SimpleDateFormat sdf) {
		String json = bd.consultarToGson("SELECT `fecha` 'auxiliar' FROM `festivos`");
		if (json.equals("")) {
			return null;
		}
		gson = new Gson();
		Global[] fechasBBDD = gson.fromJson(json, Global[].class);
		Calendar[] fechas = new Calendar[fechasBBDD.length];

		for (int i = 0; i < fechasBBDD.length; i++) {
			Date fechaAux = null;
			try {
				fechaAux = sdf.parse((String) fechasBBDD[i].getAuxiliar());
			} catch (ParseException e) {
				e.printStackTrace();
			}
			Calendar calendarAux = Calendar.getInstance();
			calendarAux.setTime(fechaAux);
			fechas[i] = calendarAux;
		}

		return fechas;
	}

	/** 
	 * Fija los servicios para un alojamiento sacados de la base de datos
	 * 
	 * @param aloj Alojamiento al que se le van a fijar los servicios
	 * @return Array de servicios para un alojamiento
	 */
	public Servicio[] setServicios(Alojamiento aloj) {
		String tipo = "";
		if (aloj instanceof Hotel)
			tipo = "Hot";
		else if (aloj instanceof Apartamento)
			tipo = "Apart";
		else if (aloj instanceof Casa)
			tipo = "Casa";
		String json = bd.consultarToGson("SELECT s.`idSrv` 'auxiliar', `precio` 'auxiliar2', `nombre` 'auxiliar3' FROM srv" + tipo.toLowerCase() + " h, servicio s WHERE s.`idSrv`=h.`idSrv` AND `id" + tipo + "` = " + aloj.getId());
		if (json.equals("")) {
			return null;
		}
		gson = new Gson();
		Global[] srvBBDD = gson.fromJson(json, Global[].class);
		Servicio[] servicios = aloj.getServicios();

		for (Global servicio : srvBBDD) {
			String nomSrv = servicio.getAuxiliar3().toString();
			int posicion = 0;
			switch (nomSrv) {
			case "WiFi":
				posicion = 0;
				break;
			case "Piscina":
				posicion = 1;
				break;
			case "Spa":
				posicion = 2;
				break;
			case "Parking":
				posicion = 3;
				break;
			case "Aire acondicionado":
				posicion = 4;
				break;
			case "Restaurante":
				posicion = 5;
				break;
			case "Bar":
				posicion = 6;
				break;
			case "Gimnasio":
				posicion = 7;
				break;
			case "Alojamiento y desayuno":
				posicion = 8;
				break;
			case "Media Pension":
				posicion = 9;
				break;
			case "Pension Completa":
				posicion = 10;
				break;
			}
			if ((Double) servicio.getAuxiliar2() == 0)
				servicios[posicion] = Servicio.incluido;
			else
				servicios[posicion] = Servicio.noIncluido;
		}

		return servicios;
	}
}
