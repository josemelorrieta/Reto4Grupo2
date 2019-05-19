package vista.panelBorder;

import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import java.awt.Color;
import javax.swing.ImageIcon;
import javax.swing.JButton;

public class PanelTitulo extends JPanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public JLabel lblTitulo, lblSubtitulo;
	private JLabel lblLinea;
	
	public PanelTitulo() {
		setParametros();
		instanciarObjetos();
	}
	
	private void setParametros() {
		setPreferredSize(new Dimension(1024, 80));
	}
	
	private void instanciarObjetos() {
		setLayout(null);
		lblTitulo = new JLabel("idai-On");
		lblTitulo.setForeground(new Color(0, 103, 219));
		lblTitulo.setBounds(58, 29, 137, 40);
		lblTitulo.setHorizontalAlignment(SwingConstants.CENTER);
		lblTitulo.setPreferredSize(new Dimension(800, 40));
		lblTitulo.setFont(new Font("Corbel Light", Font.BOLD, 35));
		add(lblTitulo);
		
		lblSubtitulo = new JLabel("Buscador de alojamientos");
		lblSubtitulo.setBounds(205, 37, 378, 30);
		lblSubtitulo.setHorizontalAlignment(SwingConstants.LEFT);
		lblSubtitulo.setPreferredSize(new Dimension(800, 30));
		lblSubtitulo.setFont(new Font("Corbel", Font.PLAIN, 23));
		add(lblSubtitulo);
		
		JLabel lblIcon = new JLabel("");
		lblIcon.setIcon(new ImageIcon(PanelTitulo.class.getResource("/imagenes/general/logo_texto.png")));
		lblIcon.setBounds(39, 24, 30, 40);
		add(lblIcon);
		
		lblLinea = new JLabel("");
		lblLinea.setOpaque(true);
		lblLinea.setBounds(0, 78, 1024, 2);
		lblLinea.setBackground(new Color(0, 103, 219));
		add(lblLinea);
	}
	
	public void cambiarTitulo (String titulo) {
		lblTitulo.setText(titulo);
	}
	
	public void cambiarSubtitulo (String subtitulo) {
		lblSubtitulo.setText(subtitulo);
	}
}
