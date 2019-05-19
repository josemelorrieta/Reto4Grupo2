package vista.panelBorder;

import java.awt.Dimension;
import java.awt.Font;
import java.awt.Insets;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JPanel;

import vista.panelCard.PanelBuscar;
import java.awt.Color;


public class PanelBotones extends JPanel {

	
	private static final long serialVersionUID = 1L;
	
	public JButton btnSiguiente, btnVolver;
	
	public PanelBotones() {
		setParametros();
		instanciarObjetos();
		setBotonesVisible(false);
	}
	
	private void setParametros() {
		setLayout(null);
		setPreferredSize(new Dimension(1014, 100));
	}
	
	private void instanciarObjetos() {
		
		btnVolver = new JButton("VOLVER");
		btnVolver.setForeground(Color.WHITE);
		btnVolver.setFocusPainted(false);
		btnVolver.setMargin(new Insets(0, 0, 0, 0));
		btnVolver.setContentAreaFilled(false);
		btnVolver.setBorderPainted(false);
		btnVolver.setOpaque(false);
		btnVolver.setIcon(new ImageIcon(PanelBotones.class.getResource("/imagenes/general/boton140.png")));
		btnVolver.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnVolver.setBounds(40, 30, 140, 40);
		btnVolver.setHorizontalTextPosition(JButton.CENTER);
		btnVolver.setVerticalTextPosition(JButton.CENTER);
		add(btnVolver);
	
		btnSiguiente = new JButton("SIGUIENTE");
		btnSiguiente.setForeground(Color.WHITE);
		btnSiguiente.setFocusPainted(false);
		btnSiguiente.setMargin(new Insets(0, 0, 0, 0));
		btnSiguiente.setContentAreaFilled(false);
		btnSiguiente.setBorderPainted(false);
		btnSiguiente.setOpaque(false);
		btnSiguiente.setIcon(new ImageIcon(PanelBotones.class.getResource("/imagenes/general/boton140.png")));
		btnSiguiente.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnSiguiente.setBounds(834, 30, 140, 40);
		btnSiguiente.setHorizontalTextPosition(JButton.CENTER);
		btnSiguiente.setVerticalTextPosition(JButton.CENTER);
		add(btnSiguiente);
	}
	
	public void setBotonesVisible(boolean flag) {
		btnVolver.setVisible(flag);
		btnSiguiente.setVisible(flag);
	}
}
