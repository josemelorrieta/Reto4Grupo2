package vista.panelCard;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.JTextField;
import javax.swing.border.LineBorder;


public class PanelResumenPago extends JPanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	public JLabel lblTitulo;
	public JPanel panelDatosCliente;
	public JLabel lblDatosCliente;
	public JLabel lblDni;
	public JLabel lblNombre;
	public JLabel lblApellidos;
	public JTextField txtDni;
	public JTextField txtNombre;
	public JTextField txtApellidos;
	public JPanel panelDatosReserva;
	public JLabel lblDatosReserva;
	public JLabel lblAlojamiento;
	public JLabel lblNHab;
	public JLabel lblFecReserva;
	public JLabel lblFecEntrada;
	public JLabel lblFecSalida;
	public JLabel lblPrecio;
	public JTextField txtAlojamiento;
	public JTextField txtNHab;
	public JTextField txtFecReserva;
	public JTextField txtFecEntrada;
	public JTextField txtFecSalida;
	public JTextField txtPrecio;
	
	/**
	 * Create the panel.
	 */
	public PanelResumenPago() {
		setBackground(Color.WHITE);
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
		
		panelDatosCliente = new JPanel();
		panelDatosCliente.setBorder(new LineBorder(new Color(0,103,219), 2));
		panelDatosCliente.setBackground(Color.WHITE);
		panelDatosCliente.setBounds(641, 149, 283, 288);
		panelDatosCliente.setLayout(null);
		add(panelDatosCliente);
		
		lblDni = new JLabel("D.N.I.");
		lblDni.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblDni.setBounds(48, 38, 74, 26);
		panelDatosCliente.add(lblDni);
		
		lblNombre = new JLabel("Nombre");
		lblNombre.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNombre.setBounds(48, 96, 74, 26);
		panelDatosCliente.add(lblNombre);
		
		lblApellidos = new JLabel("Apellidos");
		lblApellidos.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblApellidos.setBounds(48, 165, 74, 26);
		panelDatosCliente.add(lblApellidos);
		
		txtDni = new JTextField();
		txtDni.setFont(new Font("Tahoma", Font.PLAIN, 14));
		txtDni.setOpaque(false);
		txtDni.setBounds(48, 62, 117, 23);
		panelDatosCliente.add(txtDni);
		txtDni.setColumns(10);
		
		txtNombre = new JTextField();
		txtNombre.setFont(new Font("Tahoma", Font.PLAIN, 14));
		txtNombre.setOpaque(false);
		txtNombre.setBounds(48, 120, 185, 23);
		panelDatosCliente.add(txtNombre);
		txtNombre.setColumns(10);
		
		txtApellidos = new JTextField();
		txtApellidos.setFont(new Font("Tahoma", Font.PLAIN, 14));
		txtApellidos.setOpaque(false);
		txtApellidos.setBounds(48, 191, 185, 26);
		panelDatosCliente.add(txtApellidos);
		txtApellidos.setColumns(10);
		
		lblDatosReserva = new JLabel("DATOS DE LA RESERVA");
		lblDatosReserva.setBounds(85, 115, 478, 26);
		lblDatosReserva.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblDatosReserva.setHorizontalAlignment(SwingConstants.CENTER);
		lblDatosReserva.setForeground(new Color(0,103,219));
		add(lblDatosReserva);
		
		panelDatosReserva = new JPanel();
		panelDatosReserva.setBorder(new LineBorder(new Color(0, 103, 219), 2, true));
		panelDatosReserva.setBackground(Color.WHITE);
		panelDatosReserva.setBounds(85, 149, 480, 288);
		add(panelDatosReserva);
		panelDatosReserva.setLayout(null);
		
		lblAlojamiento = new JLabel("Nombre Alojamiento:");
		lblAlojamiento.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblAlojamiento.setBackground(Color.WHITE);
		lblAlojamiento.setBounds(30, 44, 170, 20);
		panelDatosReserva.add(lblAlojamiento);
		
		lblNHab = new JLabel("Nº Habitacion:");
		lblNHab.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNHab.setBackground(Color.WHITE);
		lblNHab.setBounds(30, 83, 107, 20);
		panelDatosReserva.add(lblNHab);
		
		lblFecReserva = new JLabel("Fecha de Reserva");
		lblFecReserva.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblFecReserva.setBackground(Color.WHITE);
		lblFecReserva.setHorizontalAlignment(SwingConstants.CENTER);
		lblFecReserva.setBounds(30, 131, 120, 26);
		panelDatosReserva.add(lblFecReserva);
		
		lblFecEntrada = new JLabel("Fecha de Entrada");
		lblFecEntrada.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblFecEntrada.setBackground(Color.WHITE);
		lblFecEntrada.setHorizontalAlignment(SwingConstants.CENTER);
		lblFecEntrada.setBounds(180, 131, 120, 26);
		panelDatosReserva.add(lblFecEntrada);
		
		lblFecSalida = new JLabel("Fecha de Salida");
		lblFecSalida.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblFecSalida.setBackground(Color.WHITE);
		lblFecSalida.setHorizontalAlignment(SwingConstants.CENTER);
		lblFecSalida.setBounds(330, 131, 120, 26);
		panelDatosReserva.add(lblFecSalida);
		
		lblPrecio = new JLabel("Precio Total:");
		lblPrecio.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblPrecio.setBackground(Color.WHITE);
		lblPrecio.setBounds(124, 214, 78, 34);
		lblPrecio.setForeground(new Color(0,103,219));
		panelDatosReserva.add(lblPrecio);
		
		txtAlojamiento = new JTextField();
		txtAlojamiento.setFont(new Font("Tahoma", Font.PLAIN, 14));
		txtAlojamiento.setBackground(Color.WHITE);
		txtAlojamiento.setOpaque(false);
		txtAlojamiento.setBounds(190, 42, 260, 26);
		panelDatosReserva.add(txtAlojamiento);
		txtAlojamiento.setColumns(10);
		
		txtNHab = new JTextField();
		txtNHab.setFont(new Font("Tahoma", Font.PLAIN, 14));
		txtNHab.setBackground(Color.WHITE);
		txtNHab.setOpaque(false);
		txtNHab.setBounds(190, 81, 112, 26);
		panelDatosReserva.add(txtNHab);
		txtNHab.setColumns(10);
		
		txtFecReserva = new JTextField();
		txtFecReserva.setFont(new Font("Tahoma", Font.PLAIN, 14));
		txtFecReserva.setBackground(Color.WHITE);
		txtFecReserva.setOpaque(false);
		txtFecReserva.setHorizontalAlignment(SwingConstants.CENTER);
		txtFecReserva.setBounds(30, 159, 120, 26);
		panelDatosReserva.add(txtFecReserva);
		txtFecReserva.setColumns(10);
		
		txtFecEntrada = new JTextField();
		txtFecEntrada.setFont(new Font("Tahoma", Font.PLAIN, 14));
		txtFecEntrada.setBackground(Color.WHITE);
		txtFecEntrada.setOpaque(false);
		txtFecEntrada.setHorizontalAlignment(SwingConstants.CENTER);
		txtFecEntrada.setBounds(180, 159, 120, 26);
		panelDatosReserva.add(txtFecEntrada);
		txtFecEntrada.setColumns(10);
		
		txtFecSalida = new JTextField();
		txtFecSalida.setFont(new Font("Tahoma", Font.PLAIN, 14));
		txtFecSalida.setBackground(Color.WHITE);
		txtFecSalida.setOpaque(false);
		txtFecSalida.setHorizontalAlignment(SwingConstants.CENTER);
		txtFecSalida.setBounds(330, 159, 120, 26);
		panelDatosReserva.add(txtFecSalida);
		txtFecSalida.setColumns(10);
		
		txtPrecio = new JTextField();
		txtPrecio.setFont(new Font("Tahoma", Font.PLAIN, 14));
		txtPrecio.setBackground(Color.WHITE);
		txtPrecio.setOpaque(false);
		txtPrecio.setBounds(240, 218, 134, 27);
		txtPrecio.setForeground(new Color(0,103,219));
		panelDatosReserva.add(txtPrecio);
		txtPrecio.setColumns(10);
		
		lblDatosCliente = new JLabel("DATOS DEL CLIENTE");
		lblDatosCliente.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblDatosCliente.setBounds(641, 117, 283, 26);
		add(lblDatosCliente);
		lblDatosCliente.setHorizontalAlignment(SwingConstants.CENTER);
	}
}
