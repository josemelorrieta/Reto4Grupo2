package vista.panelCard;

import java.awt.Dimension;
import java.awt.Font;

import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableModel;
import javax.swing.JCheckBox;

public class PanelResumenReserva extends JPanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public JTable tabResumen;
	public JLabel lblTitulo;
	public JCheckBox chkCodigo;
	public DefaultTableModel modelReserva;
	/**
	 * Create the panel.
	 */
	public PanelResumenReserva() {
		setPanelParametros();
		instanciarObjetos();
	}

	private void setPanelParametros() {
		setPreferredSize(new Dimension(800,400));
		setLayout(null);
	}

	private void instanciarObjetos() {
		
		lblTitulo = new JLabel("Resumen de la reserva");
		lblTitulo.setHorizontalAlignment(SwingConstants.CENTER);
		lblTitulo.setBounds(10, 11, 756, 38);
		lblTitulo.setFont(new Font("Tahoma", Font.PLAIN, 20));
		add(lblTitulo);
		
		modelReserva = new DefaultTableModel();
		
		tabResumen = new JTable(modelReserva);
		tabResumen.setBounds(10, 56, 756, 155);
		add(tabResumen);
		
		chkCodigo = new JCheckBox("Usar codigo promocional");
		chkCodigo.setBounds(317, 230, 177, 23);
		add(chkCodigo);	
	}
}
