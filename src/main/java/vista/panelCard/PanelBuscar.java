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

	public JLabel lblTitulo, lblSubtitulo,lblElejirLoc, lblSelFecha;
	public JComboBox<String> cbxBuscar;
	public JButton btnBuscar;
	
	JDateChooser calenBusqueda;
	JSpinnerDateEditor spnDateEditorFechaBus;
	private JLabel lblSeleccionarUnaFecha;
	
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
		btnBuscar.setBounds(300, 345, 200, 50);
		btnBuscar.setPreferredSize(new Dimension(200, 50));
		btnBuscar.setActionCommand("BUSCAR");
		add(btnBuscar);
		
		lblElejirLoc = new JLabel("Seleccionar localidad:");
		lblElejirLoc.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblElejirLoc.setBounds(180, 97, 234, 39);
		add(lblElejirLoc);
		
		lblSelFecha = new JLabel("Seleccionar una fecha");
		lblSelFecha.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblSelFecha.setBounds(180, 216, 244, 39);
		add(lblSelFecha);
		
		spnDateEditorFechaBus = new JSpinnerDateEditor();
		((JSpinner.DefaultEditor) spnDateEditorFechaBus.getEditor()).getTextField().setEditable(false);
		
		calenBusqueda = new JDateChooser(null, null, null, spnDateEditorFechaBus);
		calenBusqueda.setFont(new Font("Tahoma", Font.PLAIN, 18));
		calenBusqueda.setBounds(180, 250, 207, 27);
		calenBusqueda.setDateFormatString("dd-MM-yyyy");
		add(calenBusqueda);
		
	}	
}
