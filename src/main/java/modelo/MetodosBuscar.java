package modelo;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import com.google.gson.Gson;

import BaseDatos.ConsultaBD;
import util.FuncionesGenerales;

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
	public String[] buscarLocalidades() {
		String aux = bd.consultarToGson("SELECT DISTINCT `localidad` 'auxiliar' FROM `direccion`");
		if (aux != null) {
			Global[] localidadesGlobal = gson.fromJson(aux, Global[].class);
			String[] localidades=new String[localidadesGlobal.length];
			for(int i=0;i<localidadesGlobal.length;i++) {
				localidades[i]=(String) localidadesGlobal[i].getAuxiliar();
			}
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
		String json = bd.consultarToGson("SELECT `idHot` 'id',`nombre`,`numEstrellas`,`pvpTAlta` 'precioTAlta',`pvpTBaja` 'precioTBaja',`pvpRecFestivo` 'precioTFest', `pvpM2`, `imagen` FROM `hotel` WHERE `idDir` IN (SELECT `idDir` FROM `direccion` WHERE `localidad`='" + localidad + "')");
		mod.hotelesBusqueda = gson.fromJson(json, Hotel[].class);
		for (Hotel hotel : mod.hotelesBusqueda) {
			cargarDireccion(hotel,"hotel","idHot");
			cargarHabitaciones(hotel);
			setDisponibilidad(hotel);
		}
	}

	private void cargarCasas(String localidad) {
		String json = bd.consultarToGson("SELECT `idCasa` 'id',`nombre`,`pvpTAlta` 'precioTAlta',`pvpTBaja` 'precioTBaja',`pvpRecFestivo` 'precioTFest', `pvpM2`, `imagen` FROM `casa` WHERE `idDir` IN (SELECT `idDir` FROM `direccion` WHERE `localidad`='" + localidad + "')");
		mod.casasBusqueda = gson.fromJson(json, Casa[].class);
		for (Casa casa : mod.casasBusqueda) {
			cargarDireccion(casa,"casa","idCasa");
			cargarHabitaciones(casa);
			setDisponibilidad(casa);
		}
	}

	private void cargarApartamentos(String localidad) {
		String json = bd.consultarToGson("SELECT `idApart` 'id',`nombre`,`pvpTAlta` 'precioTAlta',`pvpTBaja` 'precioTBaja',`pvpRecFestivo` 'precioTFest', `pvpM2`, `piso`, `imagen` FROM `apartamento` WHERE `idDir` IN (SELECT `idDir` FROM `direccion` WHERE `localidad`='" + localidad + "')");
		mod.apartBusqueda = gson.fromJson(json, Apartamento[].class);
		for (Apartamento apart : mod.apartBusqueda) {
			cargarDireccion(apart,"Apartamento","idApart");
			cargarHabitaciones(apart);
			setDisponibilidad(apart);
		}
	}
	
	private void cargarDireccion(Alojamiento aloj, String tabla, String id) {
		String json = bd.consultarToGson("SELECT `calle`,`codPostal`,`localidad` FROM `direccion` WHERE `idDir` = (SELECT `idDir` FROM `" +tabla+ "` WHERE `"+id+"` = " + aloj.getId() + ")");
		Direccion[] dir = gson.fromJson(json, Direccion[].class);
		aloj.setDireccion(dir[0]);
	}

	
	
	
	private void cargarHabitaciones(Hotel hotel) {
		String json = bd.consultarToGson("SELECT `idHab`, `metros` 'm2', 'DORMITORIO' AS `tipoHabitacion` FROM `dormitorio` d, `habhotel` h WHERE d.`idDorm` IN (SELECT `idDorm` FROM `habhotel` WHERE `idHot`=" + hotel.getId() + ") AND d.`idDorm`=h.`idDorm`");
		Dormitorio[] dormitorios = gson.fromJson(json, Dormitorio[].class);
		for (Dormitorio dorm : dormitorios) {
			cargarMobiliarioDormitorioHotel(dorm);
		}
		hotel.setHabitaciones(dormitorios);
	}


	private void cargarHabitaciones(Casa casa) {
		String tipo = (casa.getClass()).getSimpleName().toLowerCase();

		String json = bd.consultarToGson("SELECT d.`idDorm` 'idHab', `metros` 'm2', 'DORMITORIO' AS `tipoHabitacion` FROM `dormitorio` d, `dorm" + tipo + "` c WHERE d.`idDorm` IN (SELECT `idDorm` FROM `dorm" + tipo + "` WHERE `id"+tipo.substring(0, 1).toUpperCase() + tipo.substring(1)+"`=" + casa.getId() + ") AND d.`idDorm`=c.`idDorm`");
		Dormitorio[] dormitorios = gson.fromJson(json, Dormitorio[].class);
		for (Dormitorio dorm : dormitorios)
			cargarMobiliarioDormitorioCasa(dorm, tipo);
		
		json = bd.consultarToGson("SELECT d.`idNDorm` 'idHab', `metros` 'm2', `tipoHab` 'tipoHabitacion' FROM `noDormitorio` d, `nDorm" + tipo + "` c WHERE d.`idNDorm` IN (SELECT `idNDorm` FROM `nDorm" + tipo + "` WHERE `id"+tipo.substring(0, 1).toUpperCase() + tipo.substring(1)+"`=" + casa.getId() + ") AND d.`idNDorm`=c.`idNDorm`");
		Habitacion[] noDormitorios = gson.fromJson(json, Habitacion[].class);
		
		if(dormitorios != null && noDormitorios != null) {
			noDormitorios = FuncionesGenerales.concatenate(noDormitorios, dormitorios);	
			casa.setHabitaciones(noDormitorios);
		}else if(dormitorios != null) {
			casa.setHabitaciones(dormitorios);
		}else {
			casa.setHabitaciones(null);
		}
		
	}

	private void cargarMobiliarioDormitorioCasa(Dormitorio dormitorio, String tipo) {
		String json = bd.consultarToGson("SELECT 'Cama' AS `nombre`, `tipoCama`,'CAMA' AS `tipoMobiliario` FROM `cama` WHERE `idCama` IN(SELECT `idCama` FROM `camadorm` WHERE `idDorm`="+ dormitorio.getIdHab() +")");
		Cama[] camas = gson.fromJson(json, Cama[].class);

		json = bd.consultarToGson("SELECT `tipoMob` 'nombre',`tipoMob` 'tipoMobiliario' FROM `mobiliario` WHERE `idMob` IN(SELECT `idMob` FROM `mobdorm` WHERE `idDorm`="+ dormitorio.getIdHab() +")");
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
	
	
	private void cargarMobiliarioDormitorioHotel(Dormitorio dormitorio) {
		String json = bd.consultarToGson("SELECT 'CAMATEST' AS `nombre`,`tipoCama` FROM `cama` WHERE `idCama` IN (SELECT `idCama` FROM `camadorm` WHERE `idDorm` IN (SELECT `idDorm` FROM `habhotel` WHERE `idHab`=" + dormitorio.getIdHab() + "))");
		Cama[] camas = gson.fromJson(json, Cama[].class);
		dormitorio.setMobiliario(camas);
	}

	private void setDisponibilidad(Hotel hotel) {
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

	private void setDisponibilidad(Casa casa) {
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
	
	

	private FechasReserva[] buscarFechasReservas(Alojamiento aloj) {
		String tipo="";
		if(aloj instanceof Hotel) {
			tipo="Hab";
		}else if(aloj instanceof Apartamento) {
			tipo="Apart";
		}else if(aloj instanceof Casa) {
			tipo="Casa";
		}
		
		String json = bd.consultarToGson("SELECT r.`idRsv`, `id"+tipo+"` 'id', `fechaIn`, `fechaOut` FROM `reserva` r, `rsv"+tipo.toLowerCase()+"` h WHERE r.`idRsv`=h.`idRsv`");
		FechasReserva[] fechasReserva = gson.fromJson(json, FechasReserva[].class);

		return fechasReserva;
	}
	

	
	public Calendar[] buscarFechasFestivos() {	
		String json=bd.consultarToGson("SELECT `fecha` 'auxiliar' FROM `festivos`");
		if(json.equals("")) {
			return null;
		}
		gson = new Gson();
		Global[] fechasBBDD = gson.fromJson(json, Global[].class);
		Calendar[] fechas=new Calendar[fechasBBDD.length];
		
		for(int i =0;i<fechasBBDD.length;i++) {
			Date fechaAux=null;
			try {
				fechaAux = sdf.parse((String) fechasBBDD[i].getAuxiliar());
			} catch (ParseException e) {
				e.printStackTrace();
			}
			Calendar calendarAux=Calendar.getInstance();
			calendarAux.setTime(fechaAux);
			fechas[i]=calendarAux; 
		}

		return fechas;
	}
}
