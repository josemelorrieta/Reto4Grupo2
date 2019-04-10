package util;

import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;

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
}
