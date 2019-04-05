package vista.panelCard;

import java.awt.Dimension;
import java.awt.Font;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

public class PanelTitulo extends JPanel {

	private static final long serialVersionUID = 1L;

	public JLabel lblTitulo, lblSubtitulo;
	
	public PanelTitulo() {
		setParametros();
		instanciarObjetos();
	}
	
	private void setParametros() {
		setPreferredSize(new Dimension(800, 90));
	}
	
	private void instanciarObjetos() {
		setLayout(null);
		
		lblTitulo = new JLabel("Bidai-On");
		lblTitulo.setHorizontalAlignment(SwingConstants.CENTER);
		lblTitulo.setBounds(0, 15, 800, 30);
		lblTitulo.setPreferredSize(new Dimension(800, 30));
		lblTitulo.setFont(new Font("Tahoma", Font.PLAIN, 30));
		add(lblTitulo);
		
		lblSubtitulo = new JLabel("Buscador de alojamientos");
		lblSubtitulo.setHorizontalAlignment(SwingConstants.CENTER);
		lblSubtitulo.setBounds(10, 45, 800, 30);
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
