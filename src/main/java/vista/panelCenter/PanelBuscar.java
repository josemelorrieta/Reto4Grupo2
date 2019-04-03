package vista.panelCenter;

import javax.swing.JPanel;

import controlador.Controlador;

import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JComboBox;
import java.awt.FlowLayout;
import java.awt.Dimension;
import javax.swing.JButton;
import javax.swing.SwingConstants;

public class PanelBuscar extends JPanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 2L;

	public JLabel lblTitulo, lblSubtitulo;
	public JComboBox<String> cBBuscar;
	private JLabel separador0, separador1;
	private JButton btnBuscar;
	/**
	 * Create the panel.
	 */
	public PanelBuscar() {
		setParametros();
		instanciarObjetos();
	}
	
	private void setParametros() {
		setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		setPreferredSize(new Dimension(790, 590));
	}
	
	private void instanciarObjetos() {
		
		lblTitulo = new JLabel("Bidai-On");
		lblTitulo.setHorizontalAlignment(SwingConstants.CENTER);
		lblTitulo.setPreferredSize(new Dimension(700, 30));
		lblTitulo.setFont(new Font("Tahoma", Font.PLAIN, 30));
		add(lblTitulo);
		
		lblSubtitulo = new JLabel("Buscador de alojamientos");
		lblSubtitulo.setHorizontalAlignment(SwingConstants.CENTER);
		lblSubtitulo.setHorizontalTextPosition(SwingConstants.CENTER);
		lblSubtitulo.setPreferredSize(new Dimension(700, 30));
		lblSubtitulo.setFont(new Font("Tahoma", Font.PLAIN, 20));
		add(lblSubtitulo);
		
		separador0 = new JLabel("");
		separador0.setPreferredSize(new Dimension(700, 100));
		add(separador0);
		
		cBBuscar = new JComboBox<String>();
		cBBuscar.setPreferredSize(new Dimension(600, 50));
		add(cBBuscar);
		
		separador1 = new JLabel("");
		separador1.setPreferredSize(new Dimension(700, 50));
		add(separador1);
		
		btnBuscar = new JButton("BUSCAR");
		btnBuscar.setPreferredSize(new Dimension(300, 50));
		add(btnBuscar);
	}
	
	public void conectaControlador(Controlador c) {
		btnBuscar.addActionListener(c);
		btnBuscar.setActionCommand("BUSCAR");
	}
	
}
