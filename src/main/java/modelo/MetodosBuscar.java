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
	private Gson gson;

	private SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");

	public MetodosBuscar(Modelo mod, ConsultaBD bd) {
		this.bd = bd;
		this.mod = mod;
		this.gson = new Gson();
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
		String aux = bd.consultarToJson("SELECT DISTINCT `localidad` FROM `direccion`");
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
		String json = bd.consultarToJson("SELECT `idHot` 'id',`nombre`,`numEstrellas`,`pvpTAlta`,`pvpTBaja`,`pvpRecFestivo`,`pvpM2`,`imagen` FROM `hotel` WHERE `idDir` IN (SELECT `idDir` FROM `direccion` WHERE `localidad`='" + localidad + "')");
		mod.hotelesBusqueda = gson.fromJson(json, Hotel[].class);
		for (Hotel hotel : mod.hotelesBusqueda) {
			cargarDireccion(hotel, "hotel", "idHot");
			cargarHabitaciones(hotel);
			setDisponibilidad(hotel);
			hotel.setNumCamas();
			hotel.setPrecioBase();
		}
	}

	private void cargarCasas(String localidad) {
		String json = bd.consultarToJson("SELECT `idCasa` 'id',`nombre`,`pvpTAlta`,`pvpTBaja`,`pvpRecFestivo`,`pvpM2`,`imagen` FROM `casa` WHERE `idDir` IN (SELECT `idDir` FROM `direccion` WHERE `localidad`='" + localidad + "')");
		mod.casasBusqueda = gson.fromJson(json, Casa[].class);
		for (Casa casa : mod.casasBusqueda) {
			cargarDireccion(casa, "casa", "idCasa");
			cargarHabitaciones(casa);
			setDisponibilidad(casa);
			casa.setNumCamas();
			casa.setNumBanios();
			casa.setM2();
			casa.setPrecioBase();
		}
	}

	private void cargarApartamentos(String localidad) {
		String json = bd.consultarToJson("SELECT `idApart` 'id',`nombre`,`pvpTAlta`,`pvpTBaja`,`pvpRecFestivo`,`pvpM2`,`piso`,`imagen` FROM `apartamento` WHERE `idDir` IN (SELECT `idDir` FROM `direccion` WHERE `localidad`='" + localidad + "')");
		mod.apartBusqueda = gson.fromJson(json, Apartamento[].class);
		for (Apartamento apart : mod.apartBusqueda) {
			cargarDireccion(apart, "apartamento", "idApart");
			cargarHabitaciones(apart);
			setDisponibilidad(apart);
			apart.setNumCamas();
			apart.setNumBanios();
			apart.setM2();
			apart.setPrecioBase();
		}
	}

	private void cargarDireccion(Alojamiento aloj, String tabla, String id) {
		String json = bd.consultarToJson("SELECT `calle`,`codPostal`,`localidad` FROM `direccion` WHERE `idDir` = (SELECT `idDir` FROM `" +tabla+ "` WHERE `"+id+"` = " + aloj.getId() + ")");
		Direccion[] dir = gson.fromJson(json, Direccion[].class);
		aloj.setDireccion(dir[0]);
	}
	
	private void cargarHabitaciones(Hotel hotel) {
		String json = bd.consultarToJson("SELECT `idHab`, `metros` 'm2', 'DORMITORIO' AS `tipoHab` FROM `dormitorio` d, `habhotel` h WHERE d.`idDorm` IN (SELECT `idDorm` FROM `habhotel` WHERE `idHot`=" + hotel.getId() + ") AND d.`idDorm`=h.`idDorm`");
		Habitacion[] dormitorios = gson.fromJson(json, Habitacion[].class);
		for (Habitacion hab : dormitorios) {
			cargarMobiliarioHab(hab,"habHotel","idHab");
			hab.setPvpTotalMobiliario();
		}
		hotel.setHabitaciones(dormitorios);
	}
	
	private void cargarHabitaciones(Casa casa) {
		
		String tabla,id;
		if(casa instanceof Casa) {
			tabla = "dormCasa";
			id = "idCasa";
		}else {
			tabla = "dormApartamento";
			id = "idApart";
		}
		
		String tipo = casa.getClass().getSimpleName().toLowerCase();
		String json = bd.consultarToJson("SELECT d.`idDorm` 'idHab',`metros` 'm2','DORMITORIO' AS `tipoHab` FROM `dormitorio` d, `dorm" + tipo + "` c WHERE d.`idDorm` IN (SELECT `idDorm` FROM `dorm" + tipo + "` WHERE `id"+tipo.substring(0, 1).toUpperCase() + tipo.substring(1)+"`=" + casa.getId() + ") AND d.`idDorm`=c.`idDorm`");
		Habitacion[] dormitorios = gson.fromJson(json, Habitacion[].class);
		
		json = bd.consultarToJson("SELECT d.`idNDorm` 'idHab',`metros` 'm2',`tipoHab` FROM `noDormitorio` d, `nDorm" + tipo + "` c WHERE d.`idNDorm` IN (SELECT `idNDorm` FROM `nDorm" + tipo + "` WHERE `id"+tipo.substring(0, 1).toUpperCase() + tipo.substring(1)+"`=" + casa.getId() + ") AND d.`idNDorm`=c.`idNDorm`");
		Habitacion[] noDormitorios = gson.fromJson(json, Habitacion[].class);
		
		if (noDormitorios != null && dormitorios != null) {
			Habitacion[] habitaciones = concatenate(noDormitorios, dormitorios);
			for (Habitacion hab : habitaciones) { 
				cargarMobiliarioHab(hab,tabla,id);	
				hab.setPvpTotalMobiliario();
			}
			casa.setHabitaciones(habitaciones);
		} else if (noDormitorios != null){
			for (Habitacion hab : noDormitorios) {
				cargarMobiliarioHab(hab,tabla,id);
				hab.setPvpTotalMobiliario();
			}
			casa.setHabitaciones(noDormitorios);
		} else if (dormitorios != null) {
			for (Habitacion hab : dormitorios) {
				cargarMobiliarioHab(hab,tabla,id);
				hab.setPvpTotalMobiliario();
			}
			casa.setHabitaciones(dormitorios);
		} else {
			casa.setHabitaciones(null);
		}	
	}
	
	private void cargarMobiliarioHab(Habitacion habitacion, String tabla, String id) {
		String json;
		Mobiliario[] mobiliario = null;
		Cama[] camas = null; 
		
		if(habitacion.tipoHab == TipoHabitacion.DORMITORIO) {
			json = bd.consultarToJson("SELECT 'Cama' AS `nombre`,`tipoCama`,`precio` FROM `cama` WHERE `idCama` IN (SELECT `idCama` FROM `camadorm` WHERE `idDorm` IN (SELECT `idDorm` FROM `"+tabla+"` WHERE `"+id+"`=" + habitacion.getIdHab() + "))");
			camas = gson.fromJson(json, Cama[].class);
			json = bd.consultarToJson("SELECT `tipoMob` 'nombre',`precio` FROM `mobiliario` WHERE `idMob` IN(SELECT `idMob` FROM `mobdorm` WHERE `idDorm`="+ habitacion.getIdHab() +")");
			mobiliario = gson.fromJson(json, Mobiliario[].class);
		} else {
			json = bd.consultarToJson("SELECT `tipoMob` 'nombre',`precio` FROM `mobiliario` WHERE `idMob` IN(SELECT `idMob` FROM `mobndorm` WHERE `idNDorm`="+ habitacion.getIdHab() +")");
			mobiliario = gson.fromJson(json, Mobiliario[].class);
		}
		
		if (mobiliario != null && camas != null) {
			mobiliario = concatenate(mobiliario, camas);
			habitacion.setMobiliario(mobiliario);
		} else if (camas != null) {
			habitacion.setMobiliario(camas);
		} else if (mobiliario != null){
			habitacion.setMobiliario(mobiliario);
		} else {
			habitacion.setMobiliario(null);
		}
	}

	/**
	 * 
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

		for (int i = 0; i < hotel.getHabitaciones().length; i++) {
			if (fechasReserva != null) {
				for (int j = 0; j < fechasReserva.length; j++) {
					try {
						fechaIn = sdf.parse(fechasReserva[j].getFechaIn());
						fechaOut = sdf.parse(fechasReserva[j].getFechaOut());
						idHab = fechasReserva[j].getIdHab();
					} catch (ParseException e) {
						e.printStackTrace();
					}
					if (fechaIn.compareTo(fechaSalida) <= 0 && fechaOut.compareTo(fechaEntrada) >= 0 && idHab == hotel.getHabitaciones()[i].getIdHab()) {
						hotel.habitaciones[i].setDisponible(false);
						break;
					} else
						hotel.habitaciones[i].setDisponible(true);
				}
			} else {
				hotel.habitaciones[i].setDisponible(true);
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
		for (int i = 0; i < hotel.getHabitaciones().length; i++) {
			if (hotel.habitaciones[i].isDisponible() == false)
				count++;
		}
		if (count == hotel.getHabitaciones().length) {
			return false;
		} else
			return true;
	}

	private FechasReserva[] buscarFechasReservas() {
		// Mejorar el filtro de resultados para que no muestre las reservas con fechaSalida anterior a hoy
		String json = bd.consultarToJson("SELECT r.`idRsv`, `idHab`, `fechaIn`, `fechaOut` FROM `reserva` r, `rsvhab` h WHERE r.`idRsv`=h.`idRsv`");
		FechasReserva[] fechasReserva = gson.fromJson(json, FechasReserva[].class);
		return fechasReserva;
	}
	
	public Calendar[] buscarFechasFestivos() {
		String json = bd.consultarToJson("SELECT COUNT(*) FROM `festivos`");
		gson = new Gson();
		Global[] fechasBBDD = gson.fromJson(json, Global[].class);
		
		Calendar[] fechas=new Calendar[(int) fechasBBDD[0].getAuxiliar()];
		
		json=bd.consultarToJson("SELECT * FROM `festivos`");
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
