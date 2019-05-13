package vista.panelCard;

import java.awt.Dimension;
import java.awt.Font;

import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.JCheckBox;
import javax.swing.JTextField;
import java.awt.SystemColor;


public class PanelResumenReserva extends JPanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	public JLabel lblTitulo, lblCodigo, lblAlojamiento, lblNHab, lblFecEntrada, lblFecSalida;
	public JTextField txtAlojamiento, txtNHab, txtFecEntrada, txtFecSalida, txtPrecioBase, txtEquip, txtExtras, txtTotal, textNoches, textFestivos, txtTemporada, txtCodProm;
	
	/**
	 * Create the panel.
	 */
	public PanelResumenReserva() {
		setBorder(null);
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
		
		lblAlojamiento = new JLabel("Nombre Alojamiento:");
		lblAlojamiento.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblAlojamiento.setBounds(49, 84, 158, 20);
		add(lblAlojamiento);
		
		txtAlojamiento = new JTextField();
		txtAlojamiento.setEditable(false);
		txtAlojamiento.setBackground(SystemColor.control);
		txtAlojamiento.setBorder(null);
		txtAlojamiento.setFont(new Font("Tahoma", Font.PLAIN, 14));
		txtAlojamiento.setBounds(203, 82, 258, 26);
		add(txtAlojamiento);
		txtAlojamiento.setColumns(10);
		
		lblNHab = new JLabel("Nº Habitacion:");
		lblNHab.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNHab.setBounds(49, 124, 134, 20);
		add(lblNHab);
		
		txtNHab = new JTextField();
		txtNHab.setEditable(false);
		txtNHab.setBackground(SystemColor.control);
		txtNHab.setBorder(null);
		txtNHab.setFont(new Font("Tahoma", Font.PLAIN, 14));
		txtNHab.setBounds(203, 122, 86, 26);
		add(txtNHab);
		txtNHab.setColumns(10);
		
		lblFecEntrada = new JLabel("Fecha de Entrada");
		lblFecEntrada.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblFecEntrada.setBounds(496, 84, 120, 26);
		add(lblFecEntrada);
		lblFecEntrada.setHorizontalAlignment(SwingConstants.LEFT);
		
		txtFecEntrada = new JTextField();
		txtFecEntrada.setEditable(false);
		txtFecEntrada.setBackground(SystemColor.control);
		txtFecEntrada.setBorder(null);
		txtFecEntrada.setFont(new Font("Tahoma", Font.PLAIN, 14));
		txtFecEntrada.setBounds(632, 85, 120, 26);
		add(txtFecEntrada);
		txtFecEntrada.setColumns(10);
		
		lblFecSalida = new JLabel("Fecha de Salida");
		lblFecSalida.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblFecSalida.setBounds(496, 124, 120, 26);
		add(lblFecSalida);
		lblFecSalida.setHorizontalAlignment(SwingConstants.LEFT);
		
		txtFecSalida = new JTextField();
		txtFecSalida.setEditable(false);
		txtFecSalida.setBackground(SystemColor.control);
		txtFecSalida.setBorder(null);
		txtFecSalida.setFont(new Font("Tahoma", Font.PLAIN, 14));
		txtFecSalida.setBounds(632, 125, 120, 26);
		add(txtFecSalida);
		txtFecSalida.setColumns(10);
		
		lblCodigo = new JLabel("Código promocional");
		lblCodigo.setHorizontalAlignment(SwingConstants.CENTER);
		lblCodigo.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblCodigo.setBounds(520, 314, 134, 23);
		add(lblCodigo);
		
		JLabel lblPrecioBase = new JLabel("Precio Base");
		lblPrecioBase.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblPrecioBase.setBounds(49, 188, 105, 20);
		add(lblPrecioBase);
		
		JLabel lblEquipamiento = new JLabel("Equipamiento");
		lblEquipamiento.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblEquipamiento.setBounds(49, 220, 105, 20);
		add(lblEquipamiento);
		
		JLabel lblExtras = new JLabel("Extras");
		lblExtras.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblExtras.setBounds(49, 253, 78, 20);
		add(lblExtras);
		
		JLabel lblNoches = new JLabel("Noches");
		lblNoches.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNoches.setBounds(496, 219, 46, 14);
		add(lblNoches);
		
		JLabel lblTotal = new JLabel("Total");
		lblTotal.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblTotal.setBounds(49, 295, 46, 14);
		add(lblTotal);
		
		txtPrecioBase = new JTextField();
		txtPrecioBase.setEditable(false);
		txtPrecioBase.setBorder(null);
		txtPrecioBase.setBackground(SystemColor.control);
		txtPrecioBase.setBounds(203, 187, 86, 26);
		add(txtPrecioBase);
		txtPrecioBase.setColumns(10);
		
		txtEquip = new JTextField();
		txtEquip.setEditable(false);
		txtEquip.setBackground(SystemColor.control);
		txtEquip.setBorder(null);
		txtEquip.setColumns(10);
		txtEquip.setBounds(203, 219, 86, 26);
		add(txtEquip);
		
		txtExtras = new JTextField();
		txtExtras.setEditable(false);
		txtExtras.setBackground(SystemColor.control);
		txtExtras.setBorder(null);
		txtExtras.setColumns(10);
		txtExtras.setBounds(203, 252, 86, 26);
		add(txtExtras);
		
		txtTotal = new JTextField();
		txtTotal.setEditable(false);
		txtTotal.setBackground(SystemColor.control);
		txtTotal.setBorder(null);
		txtTotal.setColumns(10);
		txtTotal.setBounds(203, 291, 86, 26);
		add(txtTotal);
		
		textNoches = new JTextField();
		textNoches.setEditable(false);
		textNoches.setBackground(SystemColor.control);
		textNoches.setBorder(null);
		textNoches.setFont(new Font("Tahoma", Font.PLAIN, 14));
		textNoches.setColumns(10);
		textNoches.setBounds(632, 214, 41, 26);
		add(textNoches);
		
		JLabel lblFestivos = new JLabel("Festivos");
		lblFestivos.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblFestivos.setBounds(496, 263, 107, 20);
		add(lblFestivos);
		
		textFestivos = new JTextField();
		textFestivos.setEditable(false);
		textFestivos.setBackground(SystemColor.control);
		textFestivos.setBorder(null);
		textFestivos.setFont(new Font("Tahoma", Font.PLAIN, 14));
		textFestivos.setColumns(10);
		textFestivos.setBounds(632, 261, 41, 26);
		add(textFestivos);
		
		JLabel lblTemporada = new JLabel("Temporada");
		lblTemporada.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblTemporada.setBounds(496, 177, 107, 20);
		add(lblTemporada);
		
		txtTemporada = new JTextField();
		txtTemporada.setEditable(false);
		txtTemporada.setBackground(SystemColor.control);
		txtTemporada.setBorder(null);
		txtTemporada.setFont(new Font("Tahoma", Font.PLAIN, 14));
		txtTemporada.setColumns(10);
		txtTemporada.setBounds(632, 175, 120, 26);
		add(txtTemporada);
		
		txtCodProm = new JTextField();
		txtCodProm.setHorizontalAlignment(SwingConstants.CENTER);
		txtCodProm.setText("HM12Y");
		txtCodProm.setFont(new Font("Tahoma", Font.PLAIN, 16));
		txtCodProm.setBounds(520, 339, 134, 26);
		add(txtCodProm);
		txtCodProm.setColumns(10);
	}
}
