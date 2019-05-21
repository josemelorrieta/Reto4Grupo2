package vista.panelCard;

import javax.swing.JPanel;
import javax.swing.JSpinner;
import com.toedter.calendar.JDateChooser;
import com.toedter.calendar.JSpinnerDateEditor;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Insets;
import javax.swing.JComboBox;
import java.awt.Dimension;
import javax.swing.JButton;
import javax.swing.ImageIcon;
import java.awt.Color;
import javax.swing.SwingConstants;
import java.awt.Cursor;

public class PanelBuscar extends JPanel {

	/**
	 * Declaracion de atributos
	 */
	private static final long serialVersionUID = 1L;

	public JLabel lblTitulo, lblSubtitulo,lblElejirLoc, lblFechaEnt, lblFechaSal, lblFondo;
	public JComboBox<String> cbxBuscar;
	public JButton btnBuscar;
	
	public JDateChooser calenEntrada, calenSalida;
	public JSpinnerDateEditor spnDateEditorFechaEnt, spnDateEditorFechaSal;

	/**
	 * Constructor del panel
	 */
	public PanelBuscar() {
		setBackground(Color.WHITE);
		setBorder(null);
		setParametros();
		instanciarObjetos();
	}
	
	private void setParametros() {
		setPreferredSize(new Dimension(1024,588));
	}
	
	private void instanciarObjetos() {
		setLayout(null);
		
		cbxBuscar = new JComboBox<String>();
		cbxBuscar.setFont(new Font("Tahoma", Font.PLAIN, 14));
		cbxBuscar.setBounds(292, 181, 440, 50);
		cbxBuscar.setPreferredSize(new Dimension(440, 50));
		add(cbxBuscar);
		
		btnBuscar = new JButton("BUSCAR");
		btnBuscar.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnBuscar.setForeground(Color.WHITE);
		btnBuscar.setFocusPainted(false);
		btnBuscar.setMargin(new Insets(0, 0, 0, 0));
		btnBuscar.setContentAreaFilled(false);
		btnBuscar.setBorderPainted(false);
		btnBuscar.setOpaque(false);
		btnBuscar.setIcon(new ImageIcon(PanelBuscar.class.getResource("/imagenes/general/boton200.png")));
		btnBuscar.setFont(new Font("Tahoma", Font.PLAIN, 18));
		btnBuscar.setBounds(412, 480, 200, 50);
		btnBuscar.setPreferredSize(new Dimension(200, 50));
		btnBuscar.setActionCommand("BUSCAR");
		btnBuscar.setHorizontalTextPosition(JButton.CENTER);
		btnBuscar.setVerticalTextPosition(JButton.CENTER);
		add(btnBuscar);
		
		lblElejirLoc = new JLabel("Seleccionar localidad:");
		lblElejirLoc.setOpaque(true);
		lblElejirLoc.setBackground(new Color(0,103,219));
		lblElejirLoc.setHorizontalAlignment(SwingConstants.CENTER);
		lblElejirLoc.setForeground(Color.WHITE);
		lblElejirLoc.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblElejirLoc.setBounds(292, 147, 440, 35);
		add(lblElejirLoc);	
		
		lblFechaEnt = new JLabel("Fecha de entrada:");
		lblFechaEnt.setHorizontalAlignment(SwingConstants.CENTER);
		lblFechaEnt.setOpaque(true);
		lblFechaEnt.setBackground(new Color(0,103,219));
		lblFechaEnt.setForeground(Color.WHITE);
		lblFechaEnt.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblFechaEnt.setBounds(292, 334, 185, 35);
		add(lblFechaEnt);
		
		spnDateEditorFechaEnt = new JSpinnerDateEditor();
		spnDateEditorFechaEnt.setFont(new Font("Tahoma", Font.PLAIN, 14));
		((JSpinner.DefaultEditor) spnDateEditorFechaEnt.getEditor()).getTextField().setEditable(false);
		
		calenEntrada = new JDateChooser(null, null, null, spnDateEditorFechaEnt);
		calenEntrada.setFont(new Font("Tahoma", Font.PLAIN, 14));
		calenEntrada.setBounds(292, 369, 185, 32);
		calenEntrada.setDateFormatString("dd-MM-yyyy");
		add(calenEntrada);
		
		lblFechaSal = new JLabel("Fecha de salida:");
		lblFechaSal.setHorizontalAlignment(SwingConstants.CENTER);
		lblFechaSal.setOpaque(true);
		lblFechaSal.setBackground(new Color(0,103,219));
		lblFechaSal.setForeground(Color.WHITE);
		lblFechaSal.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblFechaSal.setBounds(546, 334, 185, 35);
		add(lblFechaSal);
		
		spnDateEditorFechaSal = new JSpinnerDateEditor();
		spnDateEditorFechaSal.setFont(new Font("Tahoma", Font.PLAIN, 14));
		((JSpinner.DefaultEditor) spnDateEditorFechaSal.getEditor()).getTextField().setEditable(false);

		calenSalida = new JDateChooser(null, null, null, spnDateEditorFechaSal);
		calenSalida.setFont(new Font("Tahoma", Font.PLAIN, 14));
		calenSalida.setBounds(546, 369, 185, 32);
		calenSalida.setDateFormatString("dd-MM-yyyy");
		add(calenSalida);
		
		lblFondo = new JLabel("");
		lblFondo.setIcon(new ImageIcon(PanelBuscar.class.getResource("/imagenes/general/inicio.jpg")));
		lblFondo.setBounds(0, 0, 1024, 460);
		add(lblFondo);		
	}	
}
