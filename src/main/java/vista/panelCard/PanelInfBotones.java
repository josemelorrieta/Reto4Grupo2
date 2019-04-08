package vista.panelCard;

import java.awt.Dimension;
import java.awt.Font;

import javax.swing.JButton;
import javax.swing.JPanel;

public class PanelInfBotones extends JPanel {

	private static final long serialVersionUID = 1L;
	
	public JButton btnSiguiente, btnVolver;

	public PanelInfBotones() {
		setParametros();
		instanciarObjetos();
	}
			
	private void setParametros() {
		setPreferredSize(new Dimension(800, 110));
	}
	
	private void instanciarObjetos() {
		setLayout(null);
		btnSiguiente = new JButton("SIGUIENTE");
		btnSiguiente.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnSiguiente.setActionCommand("SIGUIENTE");
		btnSiguiente.setBounds(620, 15, 140, 40);
		add(btnSiguiente);
		
		btnVolver = new JButton("VOLVER");
		btnVolver.setActionCommand("VOLVER");
		btnVolver.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnVolver.setBounds(40, 15, 140, 40);
		add(btnVolver);
	
	}
}
