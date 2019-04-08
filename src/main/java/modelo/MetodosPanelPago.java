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
import javax.swing.JButton;
import vista.panelCard.PanelPago;

public class MetodosPanelPago {

	private DecimalFormatSymbols simbolos = new DecimalFormatSymbols(Locale.getDefault());
	private DecimalFormat dosDec;

	public MetodosPanelPago() {
		dosDecFormato();
	}

	/**
	 * Indica al decimal format como se quiere formatear los numeros
	 * 
	 * @param dosDec DecimalFormat para modificar su pattern
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
	 * @param btn   boton del cual se mira el texto y pasa a string para sumar esa
	 *              cantidad
	 */

	public void sumarDinero(PanelPago panel, JButton btn) {
		String[] arrDinero = operarDinero(panel.textAPagar.getText(), panel.textPagado.getText(), btn.getText());
		if (comprobarPago(arrDinero[0])) {
			panel.ActDesBotones(false);
			panel.textAPagar.setText("0.00");
			panel.textPagado.setText(arrDinero[1]);
			String cambios = floatAString2Dec(Math.abs(stringAFloat(arrDinero[0])));
			panel.textVueltas.setText(cambios);
			ArrayList<String> arrayCambios = Cambios(cambios);
			for (String val : arrayCambios)
				panel.modeloCambio.addElement(val);
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
	 * @param operacion solo acepta las strings "+" y "-"
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

	 */
	public void imprimirBillete(Reserva res) {
		PrintWriter writer;
		SimpleDateFormat formFecha = new SimpleDateFormat("dd-MM-yyyy");
		try {
			writer = new PrintWriter("Reserva de " + res.getCliente().getNombre() + ".txt", "UTF-8");
			writer.println("INFORMACIÓN DE LA RESERVA");
			writer.println("\nDatos del cliente:");
			writer.println("Nombre: " + res.getCliente().getNombre());
			writer.println("\nDatos de la reserva:");
			writer.println("Nombre Alojamiento: " + res.getAlojReservado().getNombre());
			writer.println("Fecha de la reserva: " + formFecha.format(res.getFechaReserva()));
			writer.println("Fecha de entrada   : " + formFecha.format(res.getFechaEntrada()));
			writer.println("Fecha de salida    : " + formFecha.format(res.getFechaSalida()));
			writer.println("\nPrecio total: " + redondear(res.getPrecio(), 2));
			writer.close();
		} catch (FileNotFoundException | UnsupportedEncodingException e) {
			e.printStackTrace();
		}
	}

}
