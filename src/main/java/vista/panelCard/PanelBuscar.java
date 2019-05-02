package vista.panelCard;

import javax.swing.JPanel;
import javax.swing.JSpinner;

import com.toedter.calendar.JDateChooser;
import com.toedter.calendar.JSpinnerDateEditor;

import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JComboBox;
import java.awt.Dimension;
import javax.swing.JButton;

public class PanelBuscar extends JPanel {

	/**
	 * Declaracion de atributos
	 */
	private static final long serialVersionUID = 1L;

	public JLabel lblTitulo, lblSubtitulo,lblElejirLoc, lblFechaEnt, lblFechaSal;
	public JComboBox<String> cbxBuscar;
	public JButton btnBuscar;
	
	public JDateChooser calenEntrada, calenSalida;
	JSpinnerDateEditor spnDateEditorFechaEnt, spnDateEditorFechaSal;
	
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
		cbxBuscar.setBounds(180, 135, 440, 50);
		cbxBuscar.setPreferredSize(new Dimension(440, 50));
		add(cbxBuscar);
		
		btnBuscar = new JButton("BUSCAR");
		btnBuscar.setFont(new Font("Tahoma", Font.PLAIN, 18));
		btnBuscar.setBounds(300, 340, 200, 50);
		btnBuscar.setPreferredSize(new Dimension(200, 50));
		btnBuscar.setActionCommand("BUSCAR");
		add(btnBuscar);
		
		lblElejirLoc = new JLabel("Seleccionar localidad:");
		lblElejirLoc.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblElejirLoc.setBounds(180, 97, 234, 39);
		add(lblElejirLoc);	
		
		lblFechaEnt = new JLabel("Fecha de entrada:");
		lblFechaEnt.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblFechaEnt.setBounds(180, 216, 244, 39);
		add(lblFechaEnt);
		
		spnDateEditorFechaEnt = new JSpinnerDateEditor();
		((JSpinner.DefaultEditor) spnDateEditorFechaEnt.getEditor()).getTextField().setEditable(false);
		
		calenEntrada = new JDateChooser(null, null, null, spnDateEditorFechaEnt);
		calenEntrada.setFont(new Font("Tahoma", Font.PLAIN, 18));
		calenEntrada.setBounds(180, 250, 185, 27);
		calenEntrada.setDateFormatString("dd-MM-yyyy");
		add(calenEntrada);
		
		lblFechaSal = new JLabel("Fecha de salida:");
		lblFechaSal.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblFechaSal.setBounds(435, 216, 244, 39);
		add(lblFechaSal);
		
		spnDateEditorFechaSal = new JSpinnerDateEditor();
		((JSpinner.DefaultEditor) spnDateEditorFechaSal.getEditor()).getTextField().setEditable(false);
		
		calenSalida = new JDateChooser(null, null, null, spnDateEditorFechaSal);
		calenSalida.setFont(new Font("Tahoma", Font.PLAIN, 18));
		calenSalida.setBounds(435, 250, 185, 27);
		calenSalida.setDateFormatString("dd-MM-yyyy");
		add(calenSalida);
		
	}	
}
