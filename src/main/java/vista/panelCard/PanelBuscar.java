package vista.panelCard;

import javax.swing.JPanel;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.event.ActionListener;
import javax.swing.JComboBox;
import java.awt.FlowLayout;
import java.awt.Dimension;
import javax.swing.JButton;
import javax.swing.SwingConstants;

public class PanelBuscar extends JPanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public JLabel lblTitulo, lblSubtitulo;
	public JComboBox<String> cbxBuscar;
	public JLabel separador0, separador1;
	public JButton btnBuscar;
	
	/**
	 * Create the panel.
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
		add(btnBuscar);
	}
	
	public void conectaControlador(ActionListener l) {
		btnBuscar.addActionListener(l);
		btnBuscar.setActionCommand("BUSCAR");
	}
	
}
