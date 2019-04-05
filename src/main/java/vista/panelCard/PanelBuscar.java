package vista.panelCard;

import java.awt.Dimension;
import java.awt.Font;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class PanelBuscar extends JPanel {

	/**
	 * Declaracion de atributos
	 */
	private static final long serialVersionUID = 1L;

	public JLabel lblTitulo, lblSubtitulo,lblElejirLoc;
	public JComboBox<String> cbxBuscar;
	public JButton btnBuscar;
	
	/**
	 * Constructor del panel
	 */
	public PanelBuscar() {
		setParametros();
		instanciarObjetos();
	}
	
	private void setParametros() {
		setPreferredSize(new Dimension(811, 524));
	}
	
	private void instanciarObjetos() {
		setLayout(null);
		
		cbxBuscar = new JComboBox<String>();
		cbxBuscar.setBounds(180, 175, 440, 50);
		cbxBuscar.setPreferredSize(new Dimension(440, 50));
		add(cbxBuscar);
		
		btnBuscar = new JButton("BUSCAR");
		btnBuscar.setFont(new Font("Tahoma", Font.PLAIN, 18));
		btnBuscar.setBounds(300, 290, 200, 50);
		btnBuscar.setPreferredSize(new Dimension(200, 50));
		btnBuscar.setActionCommand("BUSCAR");
		add(btnBuscar);
		
		lblElejirLoc = new JLabel("Elejir localidad:");
		lblElejirLoc.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblElejirLoc.setBounds(180, 137, 234, 39);
		add(lblElejirLoc);
	}	
}
