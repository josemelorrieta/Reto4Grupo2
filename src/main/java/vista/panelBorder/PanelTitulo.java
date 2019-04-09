package vista.panelBorder;

import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

public class PanelTitulo extends JPanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public JLabel lblTitulo, lblSubtitulo;
	
	public PanelTitulo() {
		setParametros();
		instanciarObjetos();
	}
	
	private void setParametros() {
		setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		setPreferredSize(new Dimension(800, 90));
	}
	
	private void instanciarObjetos() {
		lblTitulo = new JLabel("Bidai-On");
		lblTitulo.setHorizontalAlignment(SwingConstants.CENTER);
		lblTitulo.setPreferredSize(new Dimension(800, 40));
		lblTitulo.setFont(new Font("Tahoma", Font.PLAIN, 30));
		add(lblTitulo);
		
		lblSubtitulo = new JLabel("Buscador de alojamientos");
		lblSubtitulo.setHorizontalAlignment(SwingConstants.CENTER);
		lblSubtitulo.setPreferredSize(new Dimension(800, 30));
		lblSubtitulo.setFont(new Font("Tahoma", Font.PLAIN, 20));
		add(lblSubtitulo);
	}
	
	public void cambiarTitulo (String titulo) {
		lblTitulo.setText(titulo);
	}
	
	public void cambiarSubtitulo (String subtitulo) {
		lblSubtitulo.setText(subtitulo);
	}
}
