package modelo;

import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Locale;

import com.google.gson.Gson;

import BaseDatos.ConsultaBD;
import vista.panelCard.PanelPago;

/**
 * Clase MetodosPanelPago con metodos relacionados con el pago
 *
 */
public class MetodosPanelPago {

	private DecimalFormatSymbols simbolos = new DecimalFormatSymbols(Locale.getDefault());
	public DecimalFormat dosDec;
	private ConsultaBD bd;
	private Modelo mod;

	/**
	 * Constructor de metodos panel pago
	 * @param bd conexion con el proyecto de la base de datos
	 * @param mod modelo
	 */
	public MetodosPanelPago(ConsultaBD bd, Modelo mod) {
		dosDecFormato();
		this.bd = bd;
		this.mod = mod;
	}

	/**
	 * Indica al decimal format como se quiere formatear los numeros
	 * 
	 */
	private void dosDecFormato() {
		this.simbolos.setDecimalSeparator('.');
		this.simbolos.setGroupingSeparator(',');
		this.dosDec = new DecimalFormat("#.##", simbolos);
		this.dosDec.setMinimumFractionDigits(2);
		this.dosDec.setGroupingSize(300);
		this.dosDec.setMaximumFractionDigits(2);
	}

	/**
	 * Redondea un double a n numero de decimales
	 * 
	 * @param value  numero que se desea redondear
	 * @param numDec numero de decimales
	 * @return el numero redondeado
	 */
	public double redondear(double value, int numDec) {
		BigDecimal bd = new BigDecimal(value);
		bd = bd.setScale(numDec, RoundingMode.HALF_UP);
		return bd.doubleValue();
	}

	/**
	 * Parsea un double a un string del numero con 2 decimales
	 * 
	 * @param num el numero
	 * @return string con formato
	 */
	public String doubleAString(double num) {
		return String.valueOf(dosDec.format(num));
	}

	/**
	 * Convierte un string en double si es posible
	 * 
	 * @param strg string
	 * @return numero de tipo double
	 */
	public double stringADouble(String strg) {
		return Double.parseDouble(strg);
	}

	/**
	 * Pasa de string a float
	 * 
	 * @param texto texto que parse
	 * @return float
	 */
	public float stringAFloat(String texto) {
		return Float.parseFloat(texto);
	}

	/**
	 * Pasa de float a string con 2 decimales
	 * 
	 * @param numf numero que parsea y formatea
	 * @return string de un numero con 2 decimales
	 */
	public String floatAString2Dec(Float numf) {
		return String.valueOf(dosDec.format(numf));
	}

	/**
	 * Calcula el cambio dando como resultado el menor numero de monedas posibles
	 * 
	 * @param cantTexto la cantidad de dinero en String, la funcion lo castea a int
	 *                  para trabajar con ello
	 * @return ArrayList de String con el cambio
	 */
	public ArrayList<String> Cambios(String cantTexto) {
		ArrayList<String> arrayReturn = new ArrayList<String>();
		int euros = (int) (stringAFloat(cantTexto));
		int decimales = Math.round((stringAFloat(cantTexto) - euros) * 100);
		final int[] billetesMonedas = { 500, 200, 100, 50, 20, 10, 5, 2, 1 };

		for (int i = 0; i < billetesMonedas.length; i++) {
			if (euros >= billetesMonedas[i]) {
				arrayReturn.add((billetesMonedas[i] + " €: " + (euros / billetesMonedas[i])));
				euros = euros % billetesMonedas[i];
			}
		}
		for (int i = 3; i < billetesMonedas.length; i++) {
			if (decimales >= billetesMonedas[i]) {
				arrayReturn.add(dosDec.format(billetesMonedas[i] / 100f) + " €: " + (decimales / billetesMonedas[i]));
				decimales = decimales % billetesMonedas[i];
			}
		}
		return arrayReturn;
	}

	/**
	 * Metodo para sumar dinero con un boton
	 * 
	 * @param panel donde se encuentra los textfielda editar y los botones
	 * @param valor cantida a sumar
	 * @param mod instancia del modelo de la aplicacion
	 */
	public void sumarDinero(PanelPago panel, String valor, Modelo mod) {
		String[] arrDinero = operarDinero(panel.textAPagar.getText(), panel.textPagado.getText(), valor);
		if (comprobarPago(arrDinero[0])) {
			actDesBotones(panel, false);
			panel.textAPagar.setText("0.00");
			panel.textPagado.setText(arrDinero[1]);
			String cambios = floatAString2Dec(Math.abs(stringAFloat(arrDinero[0])));
			panel.textVueltas.setText(cambios);
			ArrayList<String> arrayCambios = Cambios(cambios);
			mod.setPagoExitoso(true);
			for (String val : arrayCambios) {
				panel.modeloCambio.addElement(val);
			}
		} else {
			panel.textAPagar.setText(arrDinero[0]);
			panel.textPagado.setText(arrDinero[1]);
		}
	}

	/**
	 * Comprueba si el cliente tiene que seguir pagando
	 * 
	 * @param aPagar string del dinero que le falta por pagar al cliente
	 * @return true si el cliente ya no debe pagar mas, false si aun tiene que
	 *         seguir pagando
	 */
	public boolean comprobarPago(String aPagar) {
		if (stringAFloat(aPagar) <= 0) {
			return true;
		} else
			return false;
	}

	/**
	 * Calcula y devuelve las cantidades de dinero al restar o sumar con un boton
	 * 
	 * @param aPagar    dinero a pagar
	 * @param pagado    dinero ya pagado
	 * @param valorBtn  el valor monetario del boton
	 * @return array biposicional de strings con el dinero a pagar (pos 0) y el
	 *         dinero pagado (pos 1) formateado como numero con 2 decimales
	 */
	public String[] operarDinero(String aPagar, String pagado, String valorBtn) {
		float dineroAPagar = stringAFloat(aPagar);
		float dineroPagado = stringAFloat(pagado);
		float valorBoton = stringAFloat(valorBtn);
		dineroAPagar = dineroAPagar - valorBoton;
		dineroPagado = dineroPagado + valorBoton;
		return new String[] { floatAString2Dec(dineroAPagar), floatAString2Dec(dineroPagado) };
	}

	/**
	 * Imprime el ticket de la reserva con los datos requeridos
	 * 
	 * @param res La reserva
	 * 
	 */
	public void imprimirBillete(Reserva res) {
		PrintWriter writer;
		SimpleDateFormat formFecha = new SimpleDateFormat("dd-MM-yyyy");
		try {
			writer = new PrintWriter("Reserva de " + mod.mRegiLog.desencripta(res.getCliente().getNombre()) + ".txt", "UTF-8");
			writer.println("INFORMACIÓN DE LA RESERVA");
			writer.println("\nDatos del cliente:");
			writer.println("Nombre: " + mod.mRegiLog.desencripta(res.getCliente().getNombre()));
			writer.println("\nDatos de la reserva:");
			writer.println("Nombre Alojamiento: " + res.getAlojReservado().getNombre());
			writer.println("Fecha de la reserva: " + formFecha.format(res.getFechaReserva()));
			writer.println("Fecha de entrada   : " + formFecha.format(res.getFechaEntrada()));
			writer.println("Fecha de salida    : " + formFecha.format(res.getFechaSalida()));
			writer.println("\nPrecio total: " + doubleAString(res.getDesglose().getTotal()));
			writer.close();
		} catch (FileNotFoundException | UnsupportedEncodingException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Guarda los datos de la reserva en la base de datos
	 * 
	 * @param reserva La reserva
	 * 
	 * @return booleano que indica si el guardado ha sido correcto o no
	 * 
	 */
	public boolean guardarReserva(Reserva reserva) {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		int idRsv = ultimoNumReserva() + 1;
		String dni = reserva.getCliente().getDni();
		String fechaRsv = sdf.format(reserva.getFechaReserva());
		String fechaIn = sdf.format(reserva.getFechaEntrada());
		String fechaOut = sdf.format(reserva.getFechaSalida());
		double precio = reserva.getDesglose().getTotal();

		int id = 0;
		Alojamiento alojamiento = reserva.getAlojReservado();
		String tipo = "";

		if (alojamiento instanceof Hotel) {
			id = reserva.getDormitorioReservado().getIdHab();
			tipo = "hotel";
		} else {
			id = alojamiento.getId();
			if (alojamiento instanceof Apartamento) {
				tipo = "apartamento";
			} else {
				tipo = "casa";
			}
		}

		return bd.guardarReserva(idRsv, dni, fechaRsv, fechaIn, fechaOut, precio, id, tipo);
	}
	
	/**
	 * Guarda todos los clientes en la tabla de clientes extra
	 * @param idRes id de la reserva
	 * @param clientes array de clientes
	 * @return true
	 */
	public boolean guardarClientesExtra(int idRes,ArrayList<Cliente> clientes) {
		for(Cliente cli:clientes) {
			Object[] arrayInsert= {idRes, cli.getDni()};
			bd.insertGenerico(arrayInsert, "rsvcliextra");
		}
		return true;
	}

	/**
	 * Busca el siguiente numero de orden para insertar una nueva reserva
	 * 
	 * @return id de la ultima reserva en la BBDD
	 */
	public int ultimoNumReserva() {
		int numReserva = 0;

		String aux = bd.consultarToGson("SELECT COUNT(`idRsv`) 'auxiliar' FROM reserva");

		if (aux != null) {
			final Gson gson = new Gson();
			Object[] numReservas = gson.fromJson(aux, Global[].class);
			numReserva = ((Double) ((Global) numReservas[0]).getAuxiliar()).intValue();
		}

		return numReserva;
	}

	/**
	 * Limpia el panel reseteando todos los elementos a valores por defecto
	 * seleccionados por el programador
	 */
	public void limpiar(PanelPago panel) {
		panel.textPagado.setText("0.00");
		panel.textAPagar.setText("0.00");
		panel.textVueltas.setText("--------");
		panel.modeloCambio.clear();
		actDesBotones(panel, true);
	}

	/**
	 * Activa o desactiva su array de botones al estado que se le pasa por
	 * parametros
	 * 
	 * @param estado El estado "enables" que se quiere tener para los botones
	 */
	public void actDesBotones(PanelPago panel, boolean estado) {
		for (int i = 0; i < panel.arrayBtn.length; i++) {
			panel.arrayBtn[i].setEnabled(estado);
		}
	}
}
