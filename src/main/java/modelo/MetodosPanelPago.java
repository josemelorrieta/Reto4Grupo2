package modelo;

import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.util.ArrayList;
import java.util.Locale;

import javax.swing.JButton;

import vista.panelCard.PanelPago;

public class MetodosPanelPago {

	private DecimalFormatSymbols simbolos = new DecimalFormatSymbols(Locale.getDefault());
	private DecimalFormat dosDec;

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

	public float stringAFloat(String texto) {
		return Float.parseFloat(texto);
	}

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
	private ArrayList<String> Cambios(String cantTexto) {
		ArrayList<String> arrayReturn = new ArrayList<String>();
		int euros = (int) (stringAFloat(cantTexto));
		int decimales = Math.round((stringAFloat(cantTexto) - euros) * 100);
		final int[] billetesMonedas = { 500, 200, 100, 50, 20, 10, 5, 2, 1 };
		// Ejecutra dosDecFormato para inicializar el decimal format con los ajustes
		// necesarios
		dosDecFormato();

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
		String[] arrDinero = operarDinero(panel.textAPagar.getText(), panel.textPagado.getText(), btn.getText(), "+");
		if (comprobarPago(arrDinero[0])) {
			panel.ActDesBotones(false);
			panel.textAPagar.setText("0.00");
			panel.textPagado.setText(arrDinero[1]);
			String cambios=floatAString2Dec(Math.abs(stringAFloat(arrDinero[0])));
			panel.textVueltas.setText(cambios);
			ArrayList<String> arrayCambios=Cambios(cambios);
			for(String val : arrayCambios)
		         panel.modeloCambio.addElement(val);
		}else {
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
	private boolean comprobarPago(String aPagar) {
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
	private String[] operarDinero(String aPagar, String pagado, String valorBtn, String operacion) {
		float dineroPagado = stringAFloat(pagado);
		float dineroAPagar = stringAFloat(aPagar);
		float valorBoton = stringAFloat(valorBtn);
		switch (operacion) {
		case "+":
			dineroPagado = dineroPagado + valorBoton;
			dineroAPagar = dineroAPagar - valorBoton;
			break;
		case "-":
			dineroPagado = dineroPagado - valorBoton;
			dineroAPagar = dineroAPagar + valorBoton;
			break;
		default:
			throw new IllegalArgumentException("Simbolo de operacion invalido, solo se admite + y -");
		}
		return new String[] { floatAString2Dec(dineroAPagar), floatAString2Dec(dineroPagado) };
	}

}
