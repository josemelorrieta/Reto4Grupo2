package util;

import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.lang.reflect.Array;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;

import modelo.Alojamiento;
import modelo.Apartamento;
import modelo.Casa;
import modelo.Hotel;

/**
 * Clase Funciones Generales
 * Metodos de uso general
 *
 */
public class FuncionesGenerales {

	public final static SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");
	
	/**
	 * Cambia el tamanio de un icono
	 * @param pixelsX numero de pixels horizontales
	 * @param pixelsY numero de pixels verticales
	 * @param imagen imagen que se quiere resizear
	 * @return icono con nuevo tamanio
	 */
	public static ImageIcon resizeIcono(int pixelsX, int pixelsY, File imagen) {
		BufferedImage img = null;
		try {
			img = ImageIO.read(imagen);
		} catch (IOException e) {
			e.printStackTrace();
		}

		Image imgTamAjus = img.getScaledInstance(pixelsX, pixelsY, Image.SCALE_SMOOTH);

		ImageIcon iconoFinal = new ImageIcon(imgTamAjus);
		return iconoFinal;
	}
	
	/**
	 * Devuelve el string correspondiente a cada tipo de objeto alojamiento, usar en
	 * inserts y selects. Posibles returns "Hab", "Apart", "Casa", ""
	 * 
	 * @param aloj alojamiento el cual determina que string vendra en el return
	 * @return String 4 posibles resultados "Hab", "Apart", "Casa" y ""
	 */
	public static String tipoAloj(Alojamiento aloj) {
		String tipo = "";
		if (aloj instanceof Hotel) {
			tipo = "Hab";
		} else if (aloj instanceof Apartamento) {
			tipo = "Apart";
		} else if (aloj instanceof Casa) {
			tipo = "Casa";
		}
		return tipo;
	}
	
	/**
	 * Calcula la diferencia de tiempo entre dos fechas
	 * @param fecha1 primera fecha del periodo
	 * @param fecha2 segunda fecha del periodo
	 * @param unidadTiempo utilizar TimeUnit.DAYS etc, devuelve ese tiempo en long(milisegundos)
	 * @return cantidad de tiempo en la unidad de tiempo especificada
	 */
	public static long diferenciaEntreFechas(Date fecha1, Date fecha2, TimeUnit unidadTiempo) {
	    long diffInMillies = fecha1.getTime() - fecha2.getTime();
	    return unidadTiempo.convert(diffInMillies,TimeUnit.MILLISECONDS);
	}
	
	
	/**
	 * Concatena dos arrays
	 * @param <T> clase abstracta
	 * @param a array uno, debe ser padre o estar al mismo nivel jerarquico de a
	 * @param b array dos, debe ser hijo o estar al mismo nivel jerarquico de b
	 * @return un array formado por a y b
	 */
	public static <T> T[] concatenate(T[] a, T[] b) {
		if (a==null && b==null) return null;
		else if(a==null) return b;
		else if(b==null) return a;
		int aLen = a.length;
		int bLen = b.length;

		@SuppressWarnings("unchecked")
		T[] c = (T[]) Array.newInstance(a.getClass().getComponentType(), aLen + bLen);
		System.arraycopy(a, 0, c, 0, aLen);
		System.arraycopy(b, 0, c, aLen, bLen);

		return c;
	}
}
