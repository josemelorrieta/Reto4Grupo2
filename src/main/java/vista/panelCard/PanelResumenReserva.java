package vista.panelCard;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Insets;
import java.awt.SystemColor;

import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSeparator;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.ImageIcon;
import java.awt.Cursor;


public class PanelResumenReserva extends JPanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	public JLabel lblTitulo, lblCodigo, lblAlojamiento, lblNHab, lblFecEntrada, lblFecSalida, lblTemporada, lblDescuento, lblPrecioBase, lblEquipamiento, lblExtras, lblNoches, lblTotal, lblFestivos, lblCondiciones;
	public JTextField txtAlojamiento, txtNHab, txtFecEntrada, txtFecSalida, txtPrecioBase, txtEquip, txtExtras, txtTotal, textNoches, textFestivos, txtTemporada, txtCodProm, txtDescuento;
	public JButton btnCodProm;
	public JCheckBox chckbxCondiciones;
	
	/**
	 * Create the panel.
	 */
	public PanelResumenReserva() {
		setBorder(null);
		setPanelParametros();
		instanciarObjetos();
	}

	private void setPanelParametros() {
		setPreferredSize(new Dimension(1024,588));
		setLayout(null);
	}

	private void instanciarObjetos() {
		
		lblTitulo = new JLabel("Resumen de la reserva");
		lblTitulo.setHorizontalAlignment(SwingConstants.CENTER);
		lblTitulo.setBounds(10, 11, 1004, 38);
		lblTitulo.setFont(new Font("Tahoma", Font.PLAIN, 22));
		lblTitulo.setForeground(new Color(0,103,219));
		add(lblTitulo);
		
		lblAlojamiento = new JLabel("Nombre Alojamiento:");
		lblAlojamiento.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblAlojamiento.setBounds(116, 130, 158, 26);
		add(lblAlojamiento);
		
		txtAlojamiento = new JTextField();
		txtAlojamiento.setEditable(false);
		txtAlojamiento.setBackground(Color.WHITE);
		txtAlojamiento.setBorder(null);
		txtAlojamiento.setFont(new Font("Tahoma", Font.PLAIN, 14));
		txtAlojamiento.setBounds(258, 131, 275, 26);
		add(txtAlojamiento);
		txtAlojamiento.setColumns(10);
		
		lblNHab = new JLabel("Nº Habitacion:");
		lblNHab.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNHab.setBounds(116, 170, 134, 26);
		add(lblNHab);
		
		txtNHab = new JTextField();
		txtNHab.setEditable(false);
		txtNHab.setBackground(Color.WHITE);
		txtNHab.setBorder(null);
		txtNHab.setFont(new Font("Tahoma", Font.PLAIN, 14));
		txtNHab.setBounds(258, 171, 86, 26);
		add(txtNHab);
		txtNHab.setColumns(10);
		
		lblFecEntrada = new JLabel("Fecha de Entrada");
		lblFecEntrada.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblFecEntrada.setBounds(605, 130, 120, 26);
		add(lblFecEntrada);
		lblFecEntrada.setHorizontalAlignment(SwingConstants.LEFT);
		
		txtFecEntrada = new JTextField();
		txtFecEntrada.setEditable(false);
		txtFecEntrada.setBackground(Color.WHITE);
		txtFecEntrada.setBorder(null);
		txtFecEntrada.setFont(new Font("Tahoma", Font.PLAIN, 14));
		txtFecEntrada.setBounds(735, 131, 120, 26);
		add(txtFecEntrada);
		txtFecEntrada.setColumns(10);
		
		lblFecSalida = new JLabel("Fecha de Salida");
		lblFecSalida.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblFecSalida.setBounds(605, 170, 120, 26);
		add(lblFecSalida);
		lblFecSalida.setHorizontalAlignment(SwingConstants.LEFT);
		
		txtFecSalida = new JTextField();
		txtFecSalida.setEditable(false);
		txtFecSalida.setBackground(Color.WHITE);
		txtFecSalida.setBorder(null);
		txtFecSalida.setFont(new Font("Tahoma", Font.PLAIN, 14));
		txtFecSalida.setBounds(735, 171, 120, 26);
		add(txtFecSalida);
		txtFecSalida.setColumns(10);
		
		lblCodigo = new JLabel("Código promocional");
		lblCodigo.setHorizontalAlignment(SwingConstants.CENTER);
		lblCodigo.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblCodigo.setBounds(629, 345, 165, 23);
		lblCodigo.setForeground(new Color(0,103,219));
		add(lblCodigo);
		
		lblPrecioBase = new JLabel("Precio Base");
		lblPrecioBase.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblPrecioBase.setBounds(116, 240, 105, 26);
		add(lblPrecioBase);
		
		txtPrecioBase = new JTextField();
		txtPrecioBase.setHorizontalAlignment(SwingConstants.RIGHT);
		txtPrecioBase.setEditable(false);
		txtPrecioBase.setBorder(null);
		txtPrecioBase.setBackground(Color.WHITE);
		txtPrecioBase.setBounds(270, 242, 86, 26);
		add(txtPrecioBase);
		txtPrecioBase.setColumns(10);
		
		lblEquipamiento = new JLabel("Equipamiento");
		lblEquipamiento.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblEquipamiento.setBounds(116, 270, 105, 26);
		add(lblEquipamiento);
		
		txtEquip = new JTextField();
		txtEquip.setHorizontalAlignment(SwingConstants.RIGHT);
		txtEquip.setEditable(false);
		txtEquip.setBackground(Color.WHITE);
		txtEquip.setBorder(null);
		txtEquip.setColumns(10);
		txtEquip.setBounds(270, 272, 86, 26);
		add(txtEquip);
		
		lblExtras = new JLabel("Extras");
		lblExtras.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblExtras.setBounds(116, 300, 78, 26);
		add(lblExtras);
		
		txtExtras = new JTextField();
		txtExtras.setHorizontalAlignment(SwingConstants.RIGHT);
		txtExtras.setEditable(false);
		txtExtras.setBackground(Color.WHITE);
		txtExtras.setBorder(null);
		txtExtras.setColumns(10);
		txtExtras.setBounds(270, 302, 86, 26);
		add(txtExtras);
		
		lblDescuento = new JLabel("Descuento:");
		lblDescuento.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblDescuento.setBounds(116, 330, 78, 26);
		add(lblDescuento);
		
		txtDescuento = new JTextField();
		txtDescuento.setHorizontalAlignment(SwingConstants.RIGHT);
		txtDescuento.setEditable(false);
		txtDescuento.setColumns(10);
		txtDescuento.setBorder(null);
		txtDescuento.setBackground(Color.WHITE);
		txtDescuento.setBounds(270, 332, 86, 26);
		add(txtDescuento);
		
		lblNoches = new JLabel("Noches");
		lblNoches.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNoches.setBounds(605, 250, 46, 14);
		add(lblNoches);
		
		textNoches = new JTextField();
		textNoches.setEditable(false);
		textNoches.setBackground(Color.WHITE);
		textNoches.setBorder(null);
		textNoches.setFont(new Font("Tahoma", Font.PLAIN, 14));
		textNoches.setColumns(10);
		textNoches.setBounds(735, 241, 41, 26);
		add(textNoches);
		
		lblTotal = new JLabel("Total");
		lblTotal.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblTotal.setBounds(116, 375, 46, 26);
		lblTotal.setForeground(new Color(0,103,219));
		add(lblTotal);
		
		txtTotal = new JTextField();
		txtTotal.setHorizontalAlignment(SwingConstants.RIGHT);
		txtTotal.setFont(new Font("Tahoma", Font.BOLD, 11));
		txtTotal.setEditable(false);
		txtTotal.setBackground(Color.WHITE);
		txtTotal.setBorder(null);
		txtTotal.setColumns(10);
		txtTotal.setBounds(270, 377, 86, 26);
		txtTotal.setForeground(new Color(0,103,219));
		add(txtTotal);
		
		lblFestivos = new JLabel("Festivos");
		lblFestivos.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblFestivos.setBounds(605, 290, 107, 20);
		add(lblFestivos);
		
		textFestivos = new JTextField();
		textFestivos.setEditable(false);
		textFestivos.setBackground(Color.WHITE);
		textFestivos.setBorder(null);
		textFestivos.setFont(new Font("Tahoma", Font.PLAIN, 14));
		textFestivos.setColumns(10);
		textFestivos.setBounds(735, 288, 41, 26);
		add(textFestivos);
		
		lblTemporada = new JLabel("Temporada");
		lblTemporada.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblTemporada.setBounds(605, 210, 107, 20);
		add(lblTemporada);
		
		txtTemporada = new JTextField();
		txtTemporada.setEditable(false);
		txtTemporada.setBackground(Color.WHITE);
		txtTemporada.setBorder(null);
		txtTemporada.setFont(new Font("Tahoma", Font.PLAIN, 14));
		txtTemporada.setColumns(10);
		txtTemporada.setBounds(735, 208, 120, 26);
		add(txtTemporada);
		
		txtCodProm = new JTextField();
		txtCodProm.setHorizontalAlignment(SwingConstants.CENTER);
		txtCodProm.setText("HM12Y");
		txtCodProm.setFont(new Font("Tahoma", Font.PLAIN, 16));
		txtCodProm.setBounds(629, 375, 105, 26);
		add(txtCodProm);
		txtCodProm.setColumns(10);
		
		btnCodProm = new JButton("Ok");
		btnCodProm.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnCodProm.setIcon(new ImageIcon(PanelResumenReserva.class.getResource("/imagenes/general/boton50.png")));
		btnCodProm.setForeground(Color.WHITE);
		btnCodProm.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnCodProm.setBounds(741, 375, 53, 26);
		btnCodProm.setFocusPainted(false);
		btnCodProm.setMargin(new Insets(0, 0, 0, 0));
		btnCodProm.setContentAreaFilled(false);
		btnCodProm.setBorderPainted(false);
		btnCodProm.setOpaque(false);
		btnCodProm.setHorizontalTextPosition(JButton.CENTER);
		btnCodProm.setVerticalTextPosition(JButton.CENTER);
		add(btnCodProm);

		chckbxCondiciones = new JCheckBox("  Acepto las");
		chckbxCondiciones.setBackground(Color.WHITE);
		chckbxCondiciones.setFont(new Font("Tahoma", Font.PLAIN, 14));
		chckbxCondiciones.setBounds(600, 441, 97, 23);
		add(chckbxCondiciones);
		
		lblCondiciones = new JLabel("Condiciones Legales");
		lblCondiciones.setForeground(new Color(0,103,219));
		lblCondiciones.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 14));
		lblCondiciones.setHorizontalAlignment(SwingConstants.LEFT);
		lblCondiciones.setBounds(697, 439, 158, 26);
		add(lblCondiciones);
	}
}
