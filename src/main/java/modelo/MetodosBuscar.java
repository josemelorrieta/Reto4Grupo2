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

	//CARGAR LOCALIDADES
	
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

	//CARGAR ALOJAMIENTOS
	
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
			hotel.setMatrix(matrizHabitaciones(hotel,mod.tiposDormString));
			hotel.setMatrix(actualizarDisponibilidadDormitorios(hotel.getMatrix()));
			hotel.setDisponible(actualizarDisponibilidadHotel(hotel));
			hotel.setServicios(setServicios(hotel));
			hotel.setMatrix(cargarMobiliarioDormitorios(hotel.getMatrix()));
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
			setDisponibilidad(casa, FuncionesGenerales.sdf);
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
			setDisponibilidad(apart, FuncionesGenerales.sdf);
			apart.setServicios(setServicios(apart));
		}
	}

	//CARGAR DIRECCION
	
	/**
	 * Carga la direccion del alojamiento pasado como parametro para hoteles, casas
	 * y apartamentos
	 * 
	 * @param aloj  Alojamiento al que se le quiere guardar su direccion
	 * @param tabla Nombre de la tabla de la base de datos para distinguir entre
	 *              alojamientos (hotel, casa, apartamento)
	 * @param id    Nombre del campo id en la base de datos segun el tipo de
	 *              alojamiento (idHot, idCasa, idApart)
	 */
	public void cargarDireccion(Alojamiento aloj, String tabla, String id) {
		String json = bd.consultarToGson("SELECT `calle`,`codPostal`,`localidad` FROM `direccion` WHERE `idDir` = (SELECT `idDir` FROM `" + tabla + "` WHERE `" + id + "` = " + aloj.getId() + ")");
		Direccion[] dir = gson.fromJson(json, Direccion[].class);
		aloj.setDireccion(dir[0]);
	}

	//HOTEL

	public String[] tiposDormitorio() {
		String json = bd.consultarToGson("SELECT DISTINCT `tipoDorm` as 'auxiliar' FROM `habhotel` ORDER BY `tipoDorm` ASC");
		Global[] tiposDormGlobal = gson.fromJson(json, Global[].class);
		String[] tiposDorm = new String[tiposDormGlobal.length];
		int i = 0;
		for (Global global : tiposDormGlobal) {
			tiposDorm[i] = (String) global.getAuxiliar();
			i++;
		}
		return tiposDorm;
	}
	
	public Vector<Cama[]> crearModeloCamas(String[] tiposCama) {
		Vector<Cama[]> modeloCamas = new Vector<Cama[]>();
		for (String tipo : tiposCama) {
			int numCamasMatri = Integer.parseInt(tipo.substring(0, 1));
			int numCamasIndi = Integer.parseInt(tipo.substring(1, 2));
			int numCamasInfant = Integer.parseInt(tipo.substring(2, 3));
			int[] arrayNumeros = { numCamasMatri, numCamasIndi, numCamasInfant };
			Cama[] camas = new Cama[numCamasMatri + numCamasIndi + numCamasInfant];
			TipoCama[] tiposCamaEnum = { TipoCama.MATRIMONIO, TipoCama.INDIVIDUAL, TipoCama.INFANTIL };
			int i = 0;
			int f = 0;
			for (TipoCama tipoDeCama : tiposCamaEnum) {
				int contadorCama=0;
				while (contadorCama < arrayNumeros[i]) {
					camas[f] = new Cama(tipoDeCama);
					contadorCama++;
					f++;
				}
				i++;
			}
			modeloCamas.add(camas);
		}
		return modeloCamas;
	}
	
	
	public Dormitorio[] crearModeloDormitorios(Vector<Cama[]> camas){
		Dormitorio[] modeloDormitorios=new Dormitorio[camas.size()];
		for(int i=0;i<modeloDormitorios.length;i++) {
			modeloDormitorios[i]=new Dormitorio();
			modeloDormitorios[i].setMobiliario(camas.get(i));
		}
		return modeloDormitorios;
	}
	
	/**
	 * Carga las habitaciones de un hotel en una matriz separados segun el tipo de
	 * dormitorio
	 * 
	 * @param hotel hotel del cual se buscan las habitaciones
	 * @return matrix de dormitorios
	 */
	private Vector<Vector<Dormitorio>> matrizHabitaciones(Hotel hotel,String[] tiposDorm) {
		Vector<Vector<Dormitorio>> matrix = new Vector<Vector<Dormitorio>>();

		for (String tipo : tiposDorm) {
			String json = bd.consultarToGson("SELECT `idHab`, `metros` 'm2', 'DORMITORIO' AS `tipoHabitacion` FROM `dormitorio` d, `habhotel` h WHERE d.`idDorm` IN (SELECT `idDorm` FROM `habhotel` WHERE `idHot`=" + hotel.getId() + ") AND d.`idDorm`=h.`idDorm` AND tipoDorm='" + tipo + "'");
			if (json.equals("")) {
				matrix.add(null);
			} else {
				Dormitorio[] dormitorios = gson.fromJson(json, Dormitorio[].class);
				matrix.add(new Vector<Dormitorio>(Arrays.asList(dormitorios)));
			}
		}
		return matrix;
	}

	/**
	 * Carga el mobiliario en una matriz de dormitorios
	 * 
	 * @param dormitorios matriz (VectorXVector) de dormitorios
	 * @return
	 */
	private Vector<Vector<Dormitorio>> cargarMobiliarioDormitorios(Vector<Vector<Dormitorio>> dormitorios) {
		for (int i = 0; i < dormitorios.size(); i++) {
			if(dormitorios.get(i)==null) continue;
			for (int f = 0; f < dormitorios.get(i).size(); f++) {
				if(dormitorios.get(i).get(f)==null) continue;
				dormitorios.get(i).get(f).setMobiliario(mobiliarioDormitorio(dormitorios.get(i).get(f)));
			}
		}
		return dormitorios;
	}
	
	/**
	 * Selecciona el mobiliario del dormitorio sacado de la base de datos
	 * 
	 * @param dorm Dormitorio al que se le quiere buscar su mobiliario
	 * @return array de muebles encontrados para ese dormitorio
	 */
	private Mobiliario[] mobiliarioDormitorio(Dormitorio dorm) {
		String json = bd.consultarToGson("SELECT `tipoMob` 'nombre',`tipoMob` 'tipoMobiliario' FROM `mobiliario` WHERE `idMob` IN(SELECT `idMob` FROM `mobdorm` WHERE `idDorm`=" + dorm.getIdHab() + ")");
		Mobiliario[] mobiliario = gson.fromJson(json, Mobiliario[].class);
		return mobiliario;
	}
	
	private Vector<Vector<Dormitorio>> actualizarDisponibilidadDormitorios(Vector<Vector<Dormitorio>> dormitorios){
		for(Vector<Dormitorio> columna:dormitorios) {
			if(columna==null) continue;
			for(Dormitorio dormi:columna) {
				dormi=setDisponibilidadDormitorio(dormi,FuncionesGenerales.sdf);
			}
		}
		return dormitorios;
	}
	
	private boolean actualizarDisponibilidadHotel(Hotel hotel) {
		Vector<Vector<Dormitorio>> dormitorios=hotel.getMatrix();
		for(Vector<Dormitorio> columna:dormitorios) {
			if(columna==null) continue;
			for(Dormitorio dormi:columna) {
				if(dormi.isDisponible()) {
					return true;
				}
			}
		}
		return false;
	}

	/**
	 * Comprueba si el dormitorio proporcionado por parametro esta reservado
	 * 
	 * @param dorm Dormitorio cual se quiere comprobar
	 * @return el dormitorio enviado por parametro con la disponibilidad cambiada
	 */
	private Dormitorio setDisponibilidadDormitorio(Dormitorio dorm, SimpleDateFormat sdf) {
		if (dorm == null)
			return null;
		Date fechaEntrada = mod.reserva.getFechaEntrada();
		Date fechaSalida = mod.reserva.getFechaSalida();
		Date fechaIn = new Date();
		Date fechaOut = new Date();
		int idHab = 0;
		FechasReserva[] fechasReserva = comprobarDisponibilidadDormitorio(dorm, fechaEntrada, fechaSalida, FuncionesGenerales.sdf);

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
	 * Comprueba la disponibilidad de un dormitorio de un hotel segun las reservas
	 * de la base de datos
	 * 
	 * @param dorm     Dormitorio al que se le va a comprobar su disponibilidad
	 * @param fechaIn  Fecha de entrada de la reserva
	 * @param fechaOut Fecha de salida de la reserva
	 * @param sdf      Variable tipo SimpleDateFormat usada de las funiones comunes
	 *                 del paquete util
	 * @return array de fechas de las reservas encontradas en la base de datos para
	 *         ese dormitorio
	 */
	private FechasReserva[] comprobarDisponibilidadDormitorio(Dormitorio dorm, Date fechaIn, Date fechaOut, SimpleDateFormat sdf) {
		String query="SELECT r.`idRsv`, `idHab` 'id', `fechaIn`, `fechaOut` FROM `reserva` r, `rsvHab` h WHERE r.`idRsv`=h.`idRsv` AND `idHab`='" + dorm.getIdHab() + "' AND (CAST('" + sdf.format(fechaIn) + "' AS DATE) BETWEEN `fechaIn` AND `fechaOut`) OR (CAST('" + sdf.format(fechaOut) + "' AS DATE) BETWEEN `fechaIn` AND `fechaOut`)";
		String json = bd.consultarToGson(query);
		FechasReserva[] fechasReserva = gson.fromJson(json, FechasReserva[].class);

		return fechasReserva;
	}

	/**
	 * Comprueba la disponibilidad de las habitaciones de un hotel
	 * 
	 * @param hotel Hotel al que se le comprueba la disponibilidad de sus
	 *              habitaciones
	 */
	public boolean comprobarDisponibilidad(Hotel hotel) {
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


	
	//CASA
	
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
	 * Selecciona el mobiliario del dormitorio de una casa sacado de la base de
	 * datos
	 * 
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
	 * Fija si una casa esta disponible para las fechas seleccionadas
	 * 
	 * @param casa Casa a la que se le va a fijar su disponibilidad
	 * @param sdf  SimpleDateFormat cogido de la clase del paquete util comun a toto
	 *             el codigo
	 */
	private void setDisponibilidad(Casa casa, SimpleDateFormat sdf) {
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

	//GENERAL

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
	 * Busca las fechas de los dias festivos que estan dados de alta en la base de
	 * datos
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

		String[] nombreSrv = buscarNombresSrv();	
		aloj.setServicios(inicializarSrvAloj(nombreSrv));
		Servicio[] servicios = aloj.getServicios();
		
		for (int i=0;i<srvBBDD.length;i++) {
			int posicion = buscarPosSrv((String)srvBBDD[i].getAuxiliar3(), nombreSrv);
			servicios[posicion].setPrecio((double)srvBBDD[i].getAuxiliar2());
		}
		
//		for (int i=0;i<aloj.getServicios().length;i++) {
//			String nomSrv = srvBBDD[i].getAuxiliar3().toString();
//			switch (nomSrv) {
//			case "WiFi":
//				posicion = 0;
//				break;
//			case "Piscina":
//				posicion = 1;
//				break;
//			case "Spa":
//				posicion = 2;
//				break;
//			case "Parking":
//				posicion = 3;
//				break;
//			case "Aire acondicionado":
//				posicion = 4;
//				break;
//			case "Restaurante":
//				posicion = 5;
//				break;
//			case "Bar":
//				posicion = 6;
//				break;
//			case "Gimnasio":
//				posicion = 7;
//				break;
//			case "Alojamiento y desayuno":
//				posicion = 8;
//				break;
//			case "Media Pension":
//				posicion = 9;
//				break;
//			case "Pension Completa":
//				posicion = 10;
//				break;
//			}
//			if (posicion != i) {
//				for (int j=i;j<posicion;j++) {
//					servicios[j] = new Servicio (nombreSrv[j], -1);
//				}
//			}
//			servicios[posicion] = new Servicio(nomSrv, (double)srvBBDD[i].getAuxiliar2());
//			ultimaPos = posicion;
//			i = posicion;
//		}

		return servicios;
	}
	
	public String[] buscarNombresSrv() {
		String json = bd.consultarToGson("SELECT `nombre` 'auxiliar' FROM servicio");
		if (json.equals("")) {
			return null;
		}
		gson = new Gson();
		Global[] nombresSrvBBDD = gson.fromJson(json, Global[].class);
		String[] nombresSrv = new String[nombresSrvBBDD.length];
		for (int i=0;i<nombresSrv.length;i++)
			nombresSrv[i] = (String)nombresSrvBBDD[i].getAuxiliar();
			
		return nombresSrv;		
	}
	
	public Servicio[] inicializarSrvAloj(String[] nombreSrv) {
		Servicio[] servicios = new Servicio[nombreSrv.length];
		for (int i=0; i<nombreSrv.length;i++)
			servicios[i] = new Servicio(nombreSrv[i], -1);
		
		return servicios;
	}
	
	public int buscarPosSrv(String nombre, String[] nombreSrv) {
		for (int i=0;i<nombreSrv.length;i++) {
			if (nombreSrv[i].equals(nombre))
				return i;
		}
		return -1;
	}
}
