package modelo;

import java.util.Calendar;
import java.util.Date;
import java.util.concurrent.TimeUnit;

import util.FuncionesGenerales;

/**
 * Clase DesglosePrecio para guardar informacion relacionada con el pago/precio de la reserva
 *
 */
public class DesglosePrecio {
	private double pBaseAloj;
	private double pEquipamiento;

	private int noches;

	private double pBaseFestivos;
	private int numFestivos;
	private double totalExtraFestivos;
	private String temporada;
	private boolean codPromocional;

	// wifi etc
	private double precioExtras;

	private double total;
	/**
	 * Constructor vacio para inicializar un objeto DesglosePrecio
	 */
	public DesglosePrecio() {

	}

	/**
	 * Constructor para calcular el precio hasta el momento de todos los elementos elegidos por el cliente
	 * @param aloj Alojamiento seleccionado
	 * @param fechanEnt fecha de entrada de la reserva
	 * @param fechaSal fecha de salida de la reserva
	 * @param dormHotel dormitorio elegido en caso de que alojamiento sea Hotel
	 * @param festivos array con fechas de festivos
	 * @param extras precio total de los extra elegidos
	 */
	public DesglosePrecio(Alojamiento aloj, Date fechanEnt, Date fechaSal, Dormitorio dormHotel, Calendar[] festivos, double extras) {
		Calendar fechaEntrada = Calendar.getInstance();
		Calendar fechaSalida = Calendar.getInstance();

		fechaEntrada.setTime(fechanEnt);
		fechaSalida.setTime(fechaSal);

		if (fechaEntrada.get(Calendar.MONTH) > Calendar.MAY && fechaEntrada.get(Calendar.MONTH) < Calendar.OCTOBER) {
			this.pBaseAloj = aloj.getPrecioTAlta();
			this.setTemporada("Alta");
		} else {
			this.pBaseAloj = aloj.getPrecioTBaja();
			this.setTemporada("Baja");
		}

		if (aloj instanceof Hotel && dormHotel != null) {
			this.pEquipamiento = dormHotel.calcularPrecio(aloj.pvpM2);
		} else if (aloj instanceof Casa || aloj instanceof Apartamento) {
			this.pEquipamiento = aloj.precioDormitorios() + aloj.precioNoDormitorios();
		} else {
			pEquipamiento = 0;
		}

		this.noches = Math.abs((int) FuncionesGenerales.diferenciaEntreFechas(fechanEnt, fechaSal, TimeUnit.DAYS));

		this.pBaseFestivos = aloj.getPrecioTFest();
		this.numFestivos = NumFestivosEntreFechas(fechaEntrada, fechaSalida, festivos);
		this.totalExtraFestivos = pBaseFestivos * numFestivos;

		this.precioExtras = extras;

		calcularTotal();
		
		this.setCodPromocional(false);
	}

	/**
	 * Calcula el numero de festivos que hay entre las 2 fechas proporcionadas por parametro
	 * @param fecha1 Calendar con fecha entrada
	 * @param fecha2 Calendar con fecha salida
	 * @param festivos array Calendar con fechas de festivos
	 * @return int numero de festivos entre las fechas
	 */
	public int NumFestivosEntreFechas(Calendar fecha1, Calendar fecha2, Calendar[] festivos) {
		int num = 0;
		if (festivos==null) {
			return num;
		}
		for (Calendar festivo : festivos) {
			if (festivo.before(fecha2) && festivo.after(fecha1)) {
				num++;
			}
		}
		return num;
	}
	
	/**
	 * Aplica un descuento en caso de que llegue true como parametro y lo quita en caso contrario
	 * @param codPromocional boolean
	 */
	public void setCodPromocional(boolean codPromocional) {
		this.codPromocional = codPromocional;
		calcularTotal();
	}
	
	/**
	 * Calcula el precio si hay un codigo promocional
	 */
	private void calcularTotal() {
		if (codPromocional) {
			this.total = ((this.pBaseAloj + this.pEquipamiento + this.precioExtras) * this.noches + this.totalExtraFestivos) * 0.8;
		} else {
			this.total = ((this.pBaseAloj + this.pEquipamiento + this.precioExtras) * this.noches + this.totalExtraFestivos);
		}
	}

	public double getpBaseAloj() {
		return pBaseAloj;
	}

	public void setpBaseAloj(double pBaseAloj) {
		this.pBaseAloj = pBaseAloj;
	}

	public double getpEquipamiento() {
		return pEquipamiento;
	}

	public void setpEquipamiento(double pEquipamiento) {
		this.pEquipamiento = pEquipamiento;
	}

	public int getNoches() {
		return noches;
	}

	public void setNoches(int noches) {
		this.noches = noches;
	}

	public double getpBaseFestivos() {
		return pBaseFestivos;
	}

	public void setpBaseFestivos(double pBaseFestivos) {
		this.pBaseFestivos = pBaseFestivos;
	}

	public int getNumFestivos() {
		return numFestivos;
	}

	public void setNumFestivos(int numFestivos) {
		this.numFestivos = numFestivos;
	}

	public double getTotalExtraFestivos() {
		return totalExtraFestivos;
	}

	public void setTotalExtraFestivos(double totalExtraFestivos) {
		this.totalExtraFestivos = totalExtraFestivos;
	}

	public String getTemporada() {
		return temporada;
	}

	public void setTemporada(String temporada) {
		this.temporada = temporada;
	}

	public double getPrecioExtras() {
		return precioExtras;
	}

	public void setPrecioExtras(double precioExtras) {
		this.precioExtras = precioExtras;
	}

	public double getTotal() {
		return total;
	}

	public void setTotal(double total) {
		this.total = total;
	}

	public boolean isCodPromocional() {
		return codPromocional;
	}

}
