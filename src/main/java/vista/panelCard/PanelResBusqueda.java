package vista.panelCard;

import java.awt.Dimension;
import java.awt.Font;
import javax.swing.DefaultListModel;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.ListSelectionModel;
import modelo.Alojamiento;
import javax.swing.SwingConstants;
import javax.swing.JCheckBox;
import javax.swing.JSpinner;
import javax.swing.SpinnerNumberModel;
import java.awt.Color;
import javax.swing.ImageIcon;

public class PanelResBusqueda extends JPanel {

	private static final long serialVersionUID = 1L;
	
	public JLabel lblLocBusq;
	public DefaultListModel<Alojamiento> modelResBusq = new DefaultListModel<Alojamiento>();
	public JList<Alojamiento> resultBusq;
	public JScrollPane scroll;
	public JPanel panelFiltros;
	public JLabel lblFiltros,lblTipoDeAlojamiento,lblServicios;
	public JCheckBox chkHotel,chkCasa,chkApartamento;
	public JCheckBox[] chkTipoAlojamiento;
	public JLabel chkWifi,chkPiscina,chkSpa,chkParking,chkAc,chkRestaurante,chkBar,chkGimnasio, lblWifi, lblPiscina, lblSpa, lblParking, lblAc, lblRestaurante, lblBar, lblGimnasio;
	public JLabel[] lblArrayServicios;
	public JCheckBox chkAD,chkMP,chkPC;
	public JCheckBox[] chkTipoPension;
	public JLabel lblTipoDePensin;
	public JLabel lblNmeroDeEstrellas,lblMin, lblMax;
	public JSpinner spinnerMin, spinnerMax;
	public JPanel panelFiltrosHotel;
	
	public PanelResBusqueda() {
		setParametros();
		instanciarObjetos();
		panelFiltrosHotel.setVisible(false);
	}
	
	private void setParametros() {
		setPreferredSize(new Dimension(1024,588));
		setLayout(null);
	}
	
	private void instanciarObjetos() {	
		lblLocBusq = new JLabel("Resultados para Bilbao");
		lblLocBusq.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblLocBusq.setBounds(40, 26, 869, 26);
		add(lblLocBusq);
		
		resultBusq = new JList<Alojamiento>(modelResBusq);
		resultBusq.setBackground(Color.WHITE);
		resultBusq.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		resultBusq.setCellRenderer(new ItemResBusqueda());
		
		scroll = new JScrollPane(resultBusq);
		scroll.setLocation(40, 80);
		scroll.setSize(590, 480);
		scroll.getVerticalScrollBar().setUnitIncrement(8);
		add(scroll);
		
		panelFiltros = new JPanel();
		panelFiltros.setBackground(Color.WHITE);
		panelFiltros.setBounds(670, 80, 314, 480);
		panelFiltros.setLayout(null);
		add(panelFiltros);
		
		lblTipoDeAlojamiento = new JLabel("Tipo de alojamiento");
		lblTipoDeAlojamiento.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblTipoDeAlojamiento.setBounds(27, 43, 257, 23);
		lblTipoDeAlojamiento.setForeground(new Color(0,103,219));
		panelFiltros.add(lblTipoDeAlojamiento);
		
		chkHotel = new JCheckBox("  Hotel");
		chkHotel.setBackground(Color.WHITE);
		chkHotel.setFont(new Font("Tahoma", Font.PLAIN, 14));
		chkHotel.setBounds(53, 73, 155, 23);
		chkHotel.setSelected(true);
		panelFiltros.add(chkHotel);
		
		chkCasa = new JCheckBox("  Casa");
		chkCasa.setBackground(Color.WHITE);
		chkCasa.setFont(new Font("Tahoma", Font.PLAIN, 14));
		chkCasa.setBounds(53, 99, 155, 23);
		chkCasa.setSelected(true);
		panelFiltros.add(chkCasa);
		
		chkApartamento = new JCheckBox("  Apartamento");
		chkApartamento.setBackground(Color.WHITE);
		chkApartamento.setFont(new Font("Tahoma", Font.PLAIN, 14));
		chkApartamento.setBounds(53, 125, 155, 23);
		chkApartamento.setSelected(true);
		panelFiltros.add(chkApartamento);
		
		lblServicios = new JLabel("Servicios");
		lblServicios.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblServicios.setBounds(27, 155, 181, 26);
		lblServicios.setForeground(new Color(0,103,219));
		panelFiltros.add(lblServicios);
		
		chkWifi = new JLabel("WiFi");
		chkWifi.setFont(new Font("Tahoma", Font.PLAIN, 14));
		chkWifi.setBackground(Color.WHITE);
		chkWifi.setBounds(90, 185, 94, 23);
		panelFiltros.add(chkWifi);
		
		chkPiscina = new JLabel("Piscina");
		chkPiscina.setFont(new Font("Tahoma", Font.PLAIN, 14));
		chkPiscina.setBackground(Color.WHITE);
		chkPiscina.setBounds(227, 185, 50, 23);
		panelFiltros.add(chkPiscina);
		
		chkSpa = new JLabel("Spa");
		chkSpa.setFont(new Font("Tahoma", Font.PLAIN, 14));
		chkSpa.setBackground(Color.WHITE);
		chkSpa.setBounds(227, 275, 50, 23);
		panelFiltros.add(chkSpa);
		
		chkParking = new JLabel("Parking");
		chkParking.setFont(new Font("Tahoma", Font.PLAIN, 14));
		chkParking.setBackground(Color.WHITE);
		chkParking.setBounds(90, 215, 94, 23);
		panelFiltros.add(chkParking);
		
		chkAc = new JLabel("A/C");
		chkAc.setFont(new Font("Tahoma", Font.PLAIN, 14));
		chkAc.setBackground(Color.WHITE);
		chkAc.setBounds(227, 215, 50, 23);
		panelFiltros.add(chkAc);
		
		chkRestaurante = new JLabel("Restaurante");
		chkRestaurante.setFont(new Font("Tahoma", Font.PLAIN, 14));
		chkRestaurante.setBackground(Color.WHITE);
		chkRestaurante.setBounds(90, 245, 94, 23);
		panelFiltros.add(chkRestaurante);
		
		chkBar = new JLabel("Bar");
		chkBar.setFont(new Font("Tahoma", Font.PLAIN, 14));
		chkBar.setBackground(Color.WHITE);
		chkBar.setBounds(227, 245, 50, 23);
		panelFiltros.add(chkBar);
		
		chkGimnasio = new JLabel("Gimnasio");
		chkGimnasio.setFont(new Font("Tahoma", Font.PLAIN, 14));
		chkGimnasio.setBackground(Color.WHITE);
		chkGimnasio.setBounds(90, 275, 94, 23);
		panelFiltros.add(chkGimnasio);
		
		lblFiltros = new JLabel("  Filtros");
		lblFiltros.setIcon(new ImageIcon(PanelResBusqueda.class.getResource("/imagenes/general/filtro.png")));
		lblFiltros.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblFiltros.setBounds(27, 0, 228, 26);
		panelFiltros.add(lblFiltros);
		lblFiltros.setHorizontalAlignment(SwingConstants.LEFT);
		
		lblWifi = new JLabel();
		lblWifi.setEnabled(false);
		lblWifi.setHorizontalAlignment(SwingConstants.CENTER);
		lblWifi.setIcon(new ImageIcon(PanelResBusqueda.class.getResource("/imagenes/alojamiento/servicios/wifi.png")));
		lblWifi.setBounds(53, 185, 26, 26);
		panelFiltros.add(lblWifi);
		
		lblParking = new JLabel();
		lblParking.setIcon(new ImageIcon(PanelResBusqueda.class.getResource("/imagenes/alojamiento/servicios/parking.png")));
		lblParking.setHorizontalAlignment(SwingConstants.CENTER);
		lblParking.setEnabled(false);
		lblParking.setBounds(53, 215, 26, 26);
		panelFiltros.add(lblParking);
		
		lblRestaurante = new JLabel();
		lblRestaurante.setIcon(new ImageIcon(PanelResBusqueda.class.getResource("/imagenes/alojamiento/servicios/restaurante.png")));
		lblRestaurante.setHorizontalAlignment(SwingConstants.CENTER);
		lblRestaurante.setEnabled(false);
		lblRestaurante.setBounds(53, 245, 26, 26);
		panelFiltros.add(lblRestaurante);
		
		lblGimnasio = new JLabel();
		lblGimnasio.setIcon(new ImageIcon(PanelResBusqueda.class.getResource("/imagenes/alojamiento/servicios/gimnasio.png")));
		lblGimnasio.setHorizontalAlignment(SwingConstants.CENTER);
		lblGimnasio.setEnabled(false);
		lblGimnasio.setBounds(53, 275, 26, 26);
		panelFiltros.add(lblGimnasio);
		
		lblPiscina = new JLabel();
		lblPiscina.setIcon(new ImageIcon(PanelResBusqueda.class.getResource("/imagenes/alojamiento/servicios/piscina.png")));
		lblPiscina.setHorizontalAlignment(SwingConstants.CENTER);
		lblPiscina.setEnabled(false);
		lblPiscina.setBounds(190, 185, 26, 26);
		panelFiltros.add(lblPiscina);
		
		lblAc = new JLabel();
		lblAc.setIcon(new ImageIcon(PanelResBusqueda.class.getResource("/imagenes/alojamiento/servicios/aireacondicionado.png")));
		lblAc.setHorizontalAlignment(SwingConstants.CENTER);
		lblAc.setEnabled(false);
		lblAc.setBounds(190, 215, 26, 26);
		panelFiltros.add(lblAc);
		
		lblBar = new JLabel();
		lblBar.setIcon(new ImageIcon(PanelResBusqueda.class.getResource("/imagenes/alojamiento/servicios/bar.png")));
		lblBar.setHorizontalAlignment(SwingConstants.CENTER);
		lblBar.setEnabled(false);
		lblBar.setBounds(190, 242, 26, 26);
		panelFiltros.add(lblBar);
		
		lblSpa = new JLabel();
		lblSpa.setIcon(new ImageIcon(PanelResBusqueda.class.getResource("/imagenes/alojamiento/servicios/spa.png")));
		lblSpa.setHorizontalAlignment(SwingConstants.CENTER);
		lblSpa.setEnabled(false);
		lblSpa.setBounds(190, 272, 26, 26);
		panelFiltros.add(lblSpa);
	
		panelFiltrosHotel = new JPanel();
		panelFiltrosHotel.setOpaque(false);
		//panelFiltrosHotel.setBackground(Color.WHITE);
		panelFiltrosHotel.setBounds(10, 310, 294, 159);
		panelFiltrosHotel.setLayout(null);
		panelFiltros.add(panelFiltrosHotel);
		
		lblTipoDePensin = new JLabel("Tipo de pensión");
		lblTipoDePensin.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblTipoDePensin.setBounds(6, 0, 192, 26);
		lblTipoDePensin.setForeground(new Color(0,103,219));
		panelFiltrosHotel.add(lblTipoDePensin);
		
		chkAD = new JCheckBox("  AD");
		chkAD.setBackground(Color.WHITE);
		chkAD.setFont(new Font("Tahoma", Font.PLAIN, 14));
		chkAD.setBounds(6,30,51,23);
		panelFiltrosHotel.add(chkAD);
		
		chkMP = new JCheckBox("  MP");
		chkMP.setBackground(Color.WHITE);
		chkMP.setFont(new Font("Tahoma", Font.PLAIN, 14));
		chkMP.setBounds(84, 30, 51, 23);
		panelFiltrosHotel.add(chkMP);
		
		chkPC = new JCheckBox("  PC");
		chkPC.setBackground(Color.WHITE);
		chkPC.setFont(new Font("Tahoma", Font.PLAIN, 14));
		chkPC.setBounds(168, 30, 51, 23);
		panelFiltrosHotel.add(chkPC);
		
		lblNmeroDeEstrellas = new JLabel("Número de estrellas");
		lblNmeroDeEstrellas.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNmeroDeEstrellas.setBounds(6, 60, 235, 26);
		lblNmeroDeEstrellas.setForeground(new Color(0,103,219));
		panelFiltrosHotel.add(lblNmeroDeEstrellas);
		
		lblMin = new JLabel("Mínimo");
		lblMin.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblMin.setBounds(6, 86, 51, 26);
		panelFiltrosHotel.add(lblMin);
		
		lblMax = new JLabel("Máximo");
		lblMax.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblMax.setBounds(125, 86, 60, 26);
		panelFiltrosHotel.add(lblMax);
		
		spinnerMin = new JSpinner();
		spinnerMin.setFont(new Font("Tahoma", Font.PLAIN, 14));
		spinnerMin.setBounds(62, 87, 46, 26);
		spinnerMin.setModel(new SpinnerNumberModel(1, 1, 5, 1));
		panelFiltrosHotel.add(spinnerMin);
		
		spinnerMax = new JSpinner();
		spinnerMax.setFont(new Font("Tahoma", Font.PLAIN, 14));
		spinnerMax.setBounds(184, 87, 46, 26);
		spinnerMax.setModel(new SpinnerNumberModel(5, 1, 5, 1));
		panelFiltrosHotel.add(spinnerMax);
		
		chkTipoAlojamiento = new JCheckBox[3];
		chkTipoAlojamiento[0] = chkHotel;
		chkTipoAlojamiento[1] = chkCasa;
		chkTipoAlojamiento[2] = chkApartamento;
		
		lblArrayServicios = new JLabel[8];
		lblArrayServicios[0] = lblWifi;
		lblArrayServicios[1] = lblPiscina;
		lblArrayServicios[2] = lblSpa;
		lblArrayServicios[3] = lblParking;
		lblArrayServicios[4] = lblAc;
		lblArrayServicios[5] = lblRestaurante;
		lblArrayServicios[6] = lblBar;
		lblArrayServicios[7] = lblGimnasio;
		
		chkTipoPension = new JCheckBox[3];
		chkTipoPension[0] = chkAD;
		chkTipoPension[1] = chkMP;
		chkTipoPension[2] = chkPC;
	}
}
