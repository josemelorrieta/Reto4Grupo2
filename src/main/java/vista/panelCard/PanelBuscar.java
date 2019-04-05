package vista.panelCard;

import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

public class PanelBuscar extends JPanel {

	/**
	 * Declaracion de atributos
	 */
	private static final long serialVersionUID = 1L;
	public JLabel lblTitulo, lblSubtitulo;
	public JComboBox<String> cbxBuscar;
	public JLabel separador0, separador1;
	public JButton btnBuscar;
	
	/**
	 * Constructor del panel
	 */
	public PanelBuscar() {
		setParametros();
		instanciarObjetos();
	}
	
	private void setParametros() {
		setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		setPreferredSize(new Dimension(590, 390));
	}
	
	private void instanciarObjetos() {
		
		lblTitulo = new JLabel("Bidai-On");
		lblTitulo.setHorizontalAlignment(SwingConstants.CENTER);
		lblTitulo.setPreferredSize(new Dimension(590, 30));
		lblTitulo.setFont(new Font("Tahoma", Font.PLAIN, 30));
		add(lblTitulo);
		
		lblSubtitulo = new JLabel("Buscador de alojamientos");
		lblSubtitulo.setHorizontalAlignment(SwingConstants.CENTER);
		lblSubtitulo.setHorizontalTextPosition(SwingConstants.CENTER);
		lblSubtitulo.setPreferredSize(new Dimension(590, 30));
		lblSubtitulo.setFont(new Font("Tahoma", Font.PLAIN, 20));
		add(lblSubtitulo);
		
		separador0 = new JLabel("");
		separador0.setPreferredSize(new Dimension(590, 100));
		add(separador0);
		
		cbxBuscar = new JComboBox<String>();
		cbxBuscar.setPreferredSize(new Dimension(590, 50));
		add(cbxBuscar);
		
		separador1 = new JLabel("");
		separador1.setPreferredSize(new Dimension(590, 50));
		add(separador1);
		
		btnBuscar = new JButton("BUSCAR");
		btnBuscar.setPreferredSize(new Dimension(300, 50));
		btnBuscar.setActionCommand("BUSCAR");
		add(btnBuscar);
	}	
}
