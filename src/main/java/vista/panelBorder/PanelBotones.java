package vista.panelBorder;

import java.awt.Dimension;
import java.awt.Font;
import javax.swing.JButton;
import javax.swing.JPanel;


public class PanelBotones extends JPanel {

	
	private static final long serialVersionUID = 1L;
	
	public JButton btnSiguiente, btnVolver;
	
	public PanelBotones() {
		setParametros();
		instanciarObjetos();
	}
	
	private void setParametros() {
		setLayout(null);
		setPreferredSize(new Dimension(790, 90));
	}
	
	private void instanciarObjetos() {
		
		btnVolver = new JButton("VOLVER");
		btnVolver.setActionCommand("VOLVER");
		btnVolver.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnVolver.setBounds(40, 15, 140, 40);
		add(btnVolver);
		
		btnSiguiente = new JButton("SIGUIENTE");
		btnSiguiente.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnSiguiente.setActionCommand("SIGUIENTE");
		btnSiguiente.setBounds(620, 15, 140, 40);
		add(btnSiguiente);
	}
	
	public void setBotonesVisible(boolean flag) {
		btnVolver.setVisible(flag);
		btnSiguiente.setVisible(flag);
	}
}
