package util;

import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.lang.reflect.Array;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;

import modelo.Alojamiento;
import modelo.Apartamento;
import modelo.Casa;
import modelo.Hotel;

public class FuncionesGenerales {

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
	 * inserts y selects
	 * 
	 * @param aloj
	 * @return
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
	 * Concatena dos arrays
	 * @param a
	 * @param b
	 * @return
	 */
	public static <T> T[] concatenate(T[] a, T[] b) {
		int aLen = a.length;
		int bLen = b.length;

		@SuppressWarnings("unchecked")
		T[] c = (T[]) Array.newInstance(a.getClass().getComponentType(), aLen + bLen);
		System.arraycopy(a, 0, c, 0, aLen);
		System.arraycopy(b, 0, c, aLen, bLen);

		return c;
	}
}
