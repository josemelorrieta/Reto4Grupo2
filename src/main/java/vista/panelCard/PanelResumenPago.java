package vista.panelCard;

import java.awt.Dimension;
import java.awt.Font;

import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.JCheckBox;
import javax.swing.JTextField;


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
		
		panelDatosCliente = new JPanel();
		panelDatosCliente.setBounds(544, 60, 211, 142);
		panelDatosCliente.setLayout(null);
		add(panelDatosCliente);
		
		lblDatosCliente = new JLabel("DATOS CLIENTE");
		lblDatosCliente.setHorizontalAlignment(SwingConstants.CENTER);
		lblDatosCliente.setBounds(10, 11, 191, 26);
		panelDatosCliente.add(lblDatosCliente);
		
		lblDni = new JLabel("DNI:");
		lblDni.setBounds(10, 38, 51, 26);
		panelDatosCliente.add(lblDni);
		
		lblNombre = new JLabel("Nombre:");
		lblNombre.setBounds(10, 64, 51, 26);
		panelDatosCliente.add(lblNombre);
		
		lblApellidos = new JLabel("Apellidos:");
		lblApellidos.setBounds(10, 90, 51, 26);
		panelDatosCliente.add(lblApellidos);
		
		txtDni = new JTextField();
		txtDni.setBounds(71, 40, 117, 23);
		panelDatosCliente.add(txtDni);
		txtDni.setColumns(10);
		
		txtNombre = new JTextField();
		txtNombre.setBounds(71, 67, 117, 23);
		panelDatosCliente.add(txtNombre);
		txtNombre.setColumns(10);
		
		txtApellidos = new JTextField();
		txtApellidos.setBounds(71, 93, 117, 26);
		panelDatosCliente.add(txtApellidos);
		txtApellidos.setColumns(10);
		
		panelDatosReserva = new JPanel();
		panelDatosReserva.setBounds(20, 60, 478, 288);
		add(panelDatosReserva);
		panelDatosReserva.setLayout(null);
		
		lblDatosReserva = new JLabel("DATOS RESERVA");
		lblDatosReserva.setHorizontalAlignment(SwingConstants.CENTER);
		lblDatosReserva.setBounds(10, 11, 419, 26);
		panelDatosReserva.add(lblDatosReserva);
		
		lblAlojamiento = new JLabel("Nombre Alojamiento:");
		lblAlojamiento.setBounds(10, 44, 189, 20);
		panelDatosReserva.add(lblAlojamiento);
		
		lblNHab = new JLabel("Nº Habitacion:");
		lblNHab.setBounds(10, 75, 189, 20);
		panelDatosReserva.add(lblNHab);
		
		lblFecReserva = new JLabel("Fecha de Reserva");
		lblFecReserva.setHorizontalAlignment(SwingConstants.CENTER);
		lblFecReserva.setBounds(10, 130, 120, 26);
		panelDatosReserva.add(lblFecReserva);
		
		lblFecEntrada = new JLabel("Fecha de Entrada");
		lblFecEntrada.setHorizontalAlignment(SwingConstants.CENTER);
		lblFecEntrada.setBounds(140, 130, 120, 26);
		panelDatosReserva.add(lblFecEntrada);
		
		lblFecSalida = new JLabel("Fecha de Salida");
		lblFecSalida.setHorizontalAlignment(SwingConstants.CENTER);
		lblFecSalida.setBounds(272, 130, 120, 26);
		panelDatosReserva.add(lblFecSalida);
		
		lblPrecio = new JLabel("Precio Total:");
		lblPrecio.setBounds(153, 211, 107, 34);
		panelDatosReserva.add(lblPrecio);
		
		txtAlojamiento = new JTextField();
		txtAlojamiento.setBounds(124, 44, 319, 20);
		panelDatosReserva.add(txtAlojamiento);
		txtAlojamiento.setColumns(10);
		
		txtNHab = new JTextField();
		txtNHab.setBounds(124, 75, 112, 20);
		panelDatosReserva.add(txtNHab);
		txtNHab.setColumns(10);
		
		txtFecReserva = new JTextField();
		txtFecReserva.setBounds(10, 158, 120, 26);
		panelDatosReserva.add(txtFecReserva);
		txtFecReserva.setColumns(10);
		
		txtFecEntrada = new JTextField();
		txtFecEntrada.setBounds(140, 158, 120, 26);
		panelDatosReserva.add(txtFecEntrada);
		txtFecEntrada.setColumns(10);
		
		txtFecSalida = new JTextField();
		txtFecSalida.setBounds(272, 158, 120, 26);
		panelDatosReserva.add(txtFecSalida);
		txtFecSalida.setColumns(10);
		
		txtPrecio = new JTextField();
		txtPrecio.setBounds(240, 218, 134, 27);
		panelDatosReserva.add(txtPrecio);
		txtPrecio.setColumns(10);
	}
}
