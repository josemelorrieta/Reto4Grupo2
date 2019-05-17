package vista.panelCard;

import java.awt.Dimension;
import java.awt.Font;
import java.awt.SystemColor;

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

public class PanelResBusqueda extends JPanel {

	private static final long serialVersionUID = 1L;
	
	public JLabel lblLocBusq;
	public DefaultListModel<Alojamiento> modelResBusq = new DefaultListModel<Alojamiento>();
	public JList<Alojamiento> resultBusq;
	public JScrollPane scroll;
	public JPanel panelFiltros;
	public JLabel lblFiltros,lblTipoDeAlojamiento,lblServicios;
	public JCheckBox chkHotel,chkCasa,chkApartamento;
	public JCheckBox[] chkTipoAlojamiento = {chkHotel,chkCasa,chkApartamento};
	public JCheckBox chkWifi,chkPiscina,chkSpa,chkParking,chkAc,chkRestaurante,chkBar,chkGimnasio;
	public JCheckBox[] chkServicios = {chkWifi,chkPiscina,chkSpa,chkParking,chkAc,chkRestaurante,chkBar,chkGimnasio};
	public JPanel panelFiltrosHotel;
	public JCheckBox[] chkTipoPension;
	public JCheckBox chkAD,chkMP,chkPC;
	public JLabel lblTipoDePensin;
	public JLabel lblNmeroDeEstrellas,lblMin, lblMax;
	public JSpinner spinnerMin, spinnerMax;
	
	public PanelResBusqueda() {
		setParametros();
		instanciarObjetos();
		panelFiltrosHotel.setVisible(false);
	}
	
	private void setParametros() {
		setPreferredSize(new Dimension(800, 400));
		setLayout(null);
	}
	
	private void instanciarObjetos() {	
		lblLocBusq = new JLabel("Resultados para Bilbao");
		lblLocBusq.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblLocBusq.setBounds(10, 28, 360, 26);
		add(lblLocBusq);
		
		resultBusq = new JList<Alojamiento>(modelResBusq);
		resultBusq.setBackground(SystemColor.control);
		resultBusq.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		resultBusq.setCellRenderer(new ItemResBusqueda());
		
		scroll = new JScrollPane(resultBusq);
		scroll.setLocation(10, 57);
		scroll.setSize(520, 320);
		add(scroll);
		
		panelFiltros = new JPanel();
		panelFiltros.setBounds(540, 59, 250, 318);
		add(panelFiltros);
		panelFiltros.setLayout(null);
		
		lblTipoDeAlojamiento = new JLabel("Tipo de alojamiento");
		lblTipoDeAlojamiento.setBounds(10, 11, 230, 14);
		panelFiltros.add(lblTipoDeAlojamiento);
		
		chkHotel = new JCheckBox("Hotel");
		chkHotel.setBounds(10, 32, 57, 23);
		panelFiltros.add(chkHotel);
		
		chkCasa = new JCheckBox("Casa");
		chkCasa.setBounds(69, 32, 57, 23);
		panelFiltros.add(chkCasa);
		
		chkApartamento = new JCheckBox("Apartamento");
		chkApartamento.setBounds(128, 32, 97, 23);
		panelFiltros.add(chkApartamento);
		
		lblServicios = new JLabel("Servicios");
		lblServicios.setBounds(10, 62, 77, 14);
		panelFiltros.add(lblServicios);
		
		chkWifi = new JCheckBox("WiFi");
		chkWifi.setBounds(10, 83, 52, 23);
		panelFiltros.add(chkWifi);
		
		chkPiscina = new JCheckBox("Piscina");
		chkPiscina.setBounds(84, 83, 66, 23);
		panelFiltros.add(chkPiscina);
		
		chkSpa = new JCheckBox("Spa");
		chkSpa.setBounds(173, 83, 52, 23);
		panelFiltros.add(chkSpa);
		
		chkParking = new JCheckBox("Parking");
		chkParking.setBounds(10, 112, 66, 23);
		panelFiltros.add(chkParking);
		
		chkAc = new JCheckBox("A/C");
		chkAc.setBounds(83, 112, 57, 23);
		panelFiltros.add(chkAc);
		
		chkRestaurante = new JCheckBox("Restaurante");
		chkRestaurante.setBounds(143, 112, 97, 23);
		panelFiltros.add(chkRestaurante);
		
		chkBar = new JCheckBox("Bar");
		chkBar.setBounds(10, 143, 66, 23);
		panelFiltros.add(chkBar);
		
		chkGimnasio = new JCheckBox("Gimnasio");
		chkGimnasio.setBounds(84, 143, 97, 23);
		panelFiltros.add(chkGimnasio);
		
		panelFiltrosHotel = new JPanel();
		panelFiltrosHotel.setBounds(10, 189, 230, 118);
		panelFiltros.add(panelFiltrosHotel);
		panelFiltrosHotel.setLayout(null);
		
		chkAD = new JCheckBox("AD");
		chkAD.setBounds(6, 19, 51, 23);
		panelFiltrosHotel.add(chkAD);
		
		lblTipoDePensin = new JLabel("Tipo de pensión");
		lblTipoDePensin.setBounds(6, 0, 83, 21);
		panelFiltrosHotel.add(lblTipoDePensin);
		
		chkMP = new JCheckBox("MP");
		chkMP.setBounds(65, 19, 51, 23);
		panelFiltrosHotel.add(chkMP);
		
		chkPC = new JCheckBox("PC");
		chkPC.setBounds(127, 19, 51, 23);
		panelFiltrosHotel.add(chkPC);
		
		lblNmeroDeEstrellas = new JLabel("Número de estrellas");
		lblNmeroDeEstrellas.setBounds(6, 49, 115, 14);
		panelFiltrosHotel.add(lblNmeroDeEstrellas);
		
		lblMin = new JLabel("Min.");
		lblMin.setBounds(6, 74, 33, 14);
		panelFiltrosHotel.add(lblMin);
		
		spinnerMin = new JSpinner();
		spinnerMin.setModel(new SpinnerNumberModel(1, 1, 5, 1));
		spinnerMin.setBounds(36, 71, 29, 20);
		panelFiltrosHotel.add(spinnerMin);
		
		lblMax = new JLabel("Max.");
		lblMax.setBounds(75, 74, 46, 14);
		panelFiltrosHotel.add(lblMax);
		
		spinnerMax = new JSpinner();
		spinnerMax.setModel(new SpinnerNumberModel(5, 1, 5, 1));
		spinnerMax.setBounds(108, 71, 29, 20);
		panelFiltrosHotel.add(spinnerMax);
		
		lblFiltros = new JLabel("Filtros");
		lblFiltros.setHorizontalAlignment(SwingConstants.CENTER);
		lblFiltros.setBounds(540, 37, 250, 11);
		add(lblFiltros);
	}
}
