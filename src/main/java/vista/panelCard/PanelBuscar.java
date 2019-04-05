package vista.panelCard;

import javax.swing.JPanel;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JComboBox;
import java.awt.Dimension;
import javax.swing.JButton;

public class PanelBuscar extends JPanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public JLabel lblElejirLoc;
	public JComboBox<String> cbxBuscar;
	public JButton btnBuscar;
	
	/**
	 * Create the panel.
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
		cbxBuscar.setBounds(180, 135, 440, 50);
		cbxBuscar.setPreferredSize(new Dimension(440, 50));
		add(cbxBuscar);
		
		btnBuscar = new JButton("BUSCAR");
		btnBuscar.setFont(new Font("Tahoma", Font.PLAIN, 18));
		btnBuscar.setBounds(300, 250, 200, 50);
		btnBuscar.setPreferredSize(new Dimension(200, 50));
		btnBuscar.setActionCommand("BUSCAR");
		add(btnBuscar);
		
		lblElejirLoc = new JLabel("Elejir localidad:");
		lblElejirLoc.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblElejirLoc.setBounds(180, 97, 234, 39);
		add(lblElejirLoc);
	}	
}
