package vista;

import javax.swing.JPanel;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JComboBox;

public class PanelBuscar extends JPanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 2L;

	/**
	 * Create the panel.
	 */
	public PanelBuscar() {
		setBounds(100, 100, 790, 590);
		setLayout(null);
		
		JLabel lblTitulo = new JLabel("Bidai-On");
		lblTitulo.setFont(new Font("Tahoma", Font.PLAIN, 30));
		lblTitulo.setBounds(315, 58, 114, 61);
		add(lblTitulo);
		
		JLabel lblSubtiltulo = new JLabel("Buscador de alojamientos");
		lblSubtiltulo.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblSubtiltulo.setBounds(262, 110, 230, 26);
		add(lblSubtiltulo);
		
		JComboBox<String> cBBuscar = new JComboBox<String>();
		cBBuscar.setBounds(228, 226, 301, 26);
		add(cBBuscar);
	}
}
