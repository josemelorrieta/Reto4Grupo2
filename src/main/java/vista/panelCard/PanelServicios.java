package vista.panelCard;

import java.awt.Dimension;
import java.awt.Font;
import java.awt.SystemColor;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

public class PanelServicios extends JPanel {

	private static final long serialVersionUID = 1L;
	
	public JLabel lblImagen, lblNombre, lblDireccion, lblEstrellas, lblWifi, lblWifitxt, lblPiscina, lblPiscinatxt, lblParking, lblParkingtxt, lblAC, lblACtxt, lblTitulo,
		lblBar, lblBartxt, lblRestaurante, lblRestaurantetxt, lblSpa, lblSpatxt, lblGym, lblGymtxt, lblAd, lblAdtxt, lblMp, lblMptxt, lblPc, lblPctxt, lblWifiprec, lblPiscinaprec,
		lblParkingprec, lblACprec, lblBarprec, lblRestauranteprec, lblSpaprec, lblGymprec, lblAdprec, lblMpprec, lblPcprec;
	/**
	 * Create the panel.
	 */
	public PanelServicios() {
		setBorder(null);
		setPanelParametros();
		instanciarObjetos();
	}

	private void setPanelParametros() {
		setPreferredSize(new Dimension(800,400));
		setLayout(null);
		
		
	}
	
	public void instanciarObjetos() {
		lblImagen = new JLabel("Imagen");
		lblImagen.setBackground(SystemColor.activeCaptionBorder);
		lblImagen.setBounds(88, 60, 90, 90);
		add(lblImagen);
		
		lblNombre = new JLabel("New label");
		lblNombre.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblNombre.setBounds(16, 161, 274, 32);
		add(lblNombre);
		
		lblDireccion = new JLabel("New label");
		lblDireccion.setFont(new Font("Tahoma", Font.ITALIC, 14));
		lblDireccion.setBounds(16, 186, 274, 28);
		add(lblDireccion);
		
		lblEstrellas = new JLabel("New label");
		lblEstrellas.setIcon(new ImageIcon(PanelServicios.class.getResource("/imagenes/alojamiento/hotel/estrellas1.png")));
		lblEstrellas.setBounds(16, 216, 100, 21);
		add(lblEstrellas);
		
		lblWifi = new JLabel("New label");
		lblWifi.setEnabled(false);
		lblWifi.setIcon(new ImageIcon(PanelServicios.class.getResource("/imagenes/alojamiento/servicios/wifi.png")));
		lblWifi.setBounds(327, 70, 16, 16);
		add(lblWifi);
		
		lblWifitxt = new JLabel("WiFi");
		lblWifitxt.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblWifitxt.setBounds(361, 68, 200, 18);
		add(lblWifitxt);
		
		lblPiscina = new JLabel("New label");
		lblPiscina.setEnabled(false);
		lblPiscina.setIcon(new ImageIcon(PanelServicios.class.getResource("/imagenes/alojamiento/servicios/piscina.png")));
		lblPiscina.setBounds(327, 100, 16, 16);
		add(lblPiscina);
		
		lblPiscinatxt = new JLabel("Piscina");
		lblPiscinatxt.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblPiscinatxt.setBounds(361, 98, 200, 18);
		add(lblPiscinatxt);
		
		lblTitulo = new JLabel("SELECCIONAR SERVICIOS");
		lblTitulo.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblTitulo.setHorizontalAlignment(SwingConstants.CENTER);
		lblTitulo.setBounds(10, 11, 780, 32);
		add(lblTitulo);
		
		lblAC = new JLabel("New label");
		lblAC.setEnabled(false);
		lblAC.setIcon(new ImageIcon(PanelServicios.class.getResource("/imagenes/alojamiento/servicios/aireacondicionado.png")));
		lblAC.setBounds(327, 130, 16, 16);
		add(lblAC);
		
		lblACtxt = new JLabel("Aire Acondicionado");
		lblACtxt.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblACtxt.setBounds(361, 128, 200, 18);
		add(lblACtxt);
		
		lblParking = new JLabel("New label");
		lblParking.setEnabled(false);
		lblParking.setIcon(new ImageIcon(PanelServicios.class.getResource("/imagenes/alojamiento/servicios/parking.png")));
		lblParking.setBounds(327, 160, 16, 16);
		add(lblParking);
		
		lblParkingtxt = new JLabel("Parking");
		lblParkingtxt.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblParkingtxt.setBounds(361, 158, 200, 18);
		add(lblParkingtxt);
		
		lblBar = new JLabel("New label");
		lblBar.setEnabled(false);
		lblBar.setIcon(new ImageIcon(PanelServicios.class.getResource("/imagenes/alojamiento/servicios/bar.png")));
		lblBar.setBounds(327, 190, 16, 16);
		add(lblBar);
		
		lblBartxt = new JLabel("Bar / Cafetería");
		lblBartxt.setIcon(null);
		lblBartxt.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblBartxt.setBounds(361, 188, 200, 18);
		add(lblBartxt);
		
		lblRestaurante = new JLabel("New label");
		lblRestaurante.setEnabled(false);
		lblRestaurante.setIcon(new ImageIcon(PanelServicios.class.getResource("/imagenes/alojamiento/servicios/restaurante.png")));
		lblRestaurante.setBounds(327, 220, 16, 16);
		add(lblRestaurante);
		
		lblRestaurantetxt = new JLabel("Restaurante");
		lblRestaurantetxt.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblRestaurantetxt.setBounds(361, 218, 200, 18);
		add(lblRestaurantetxt);
		
		lblSpa = new JLabel("New label");
		lblSpa.setEnabled(false);
		lblSpa.setIcon(new ImageIcon(PanelServicios.class.getResource("/imagenes/alojamiento/servicios/spa.png")));
		lblSpa.setBounds(327, 250, 16, 16);
		add(lblSpa);
		
		lblSpatxt = new JLabel("Spa / Sauna");
		lblSpatxt.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblSpatxt.setBounds(361, 248, 200, 18);
		add(lblSpatxt);
		
		lblGym = new JLabel("New label");
		lblGym.setEnabled(false);
		lblGym.setIcon(new ImageIcon(PanelServicios.class.getResource("/imagenes/alojamiento/servicios/gimnasio.png")));
		lblGym.setBounds(327, 280, 16, 16);
		add(lblGym);
		
		lblGymtxt = new JLabel("Gimnasio");
		lblGymtxt.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblGymtxt.setBounds(361, 278, 200, 18);
		add(lblGymtxt);
		
		lblAd = new JLabel("AD");
		lblAd.setEnabled(false);
		lblAd.setHorizontalAlignment(SwingConstants.CENTER);
		lblAd.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblAd.setBounds(327, 310, 16, 16);
		add(lblAd);
		
		lblAdtxt = new JLabel("Alojamiento y desayuno");
		lblAdtxt.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblAdtxt.setBounds(361, 308, 200, 18);
		add(lblAdtxt);
		
		lblMp = new JLabel("MP");
		lblMp.setEnabled(false);
		lblMp.setHorizontalAlignment(SwingConstants.CENTER);
		lblMp.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblMp.setBounds(327, 340, 16, 16);
		add(lblMp);
		
		lblMptxt = new JLabel("Media pensión");
		lblMptxt.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblMptxt.setBounds(361, 338, 200, 18);
		add(lblMptxt);
		
		lblPctxt = new JLabel("Pensión completa");
		lblPctxt.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblPctxt.setBounds(361, 368, 200, 18);
		add(lblPctxt);
		
		lblPc = new JLabel("PC");
		lblPc.setEnabled(false);
		lblPc.setHorizontalAlignment(SwingConstants.CENTER);
		lblPc.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblPc.setBounds(327, 370, 16, 16);
		add(lblPc);
		
		lblWifiprec = new JLabel("Incluido");
		lblWifiprec.setHorizontalAlignment(SwingConstants.RIGHT);
		lblWifiprec.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblWifiprec.setBounds(560, 68, 70, 18);
		add(lblWifiprec);
		
		lblPiscinaprec = new JLabel("0");
		lblPiscinaprec.setHorizontalAlignment(SwingConstants.RIGHT);
		lblPiscinaprec.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblPiscinaprec.setBounds(560, 98, 70, 18);
		add(lblPiscinaprec);
		
		lblACprec = new JLabel("0");
		lblACprec.setHorizontalAlignment(SwingConstants.RIGHT);
		lblACprec.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblACprec.setBounds(560, 128, 70, 18);
		add(lblACprec);
		
		lblParkingprec = new JLabel("0");
		lblParkingprec.setHorizontalAlignment(SwingConstants.RIGHT);
		lblParkingprec.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblParkingprec.setBounds(560, 158, 70, 18);
		add(lblParkingprec);
		
		lblBarprec = new JLabel("0");
		lblBarprec.setHorizontalAlignment(SwingConstants.RIGHT);
		lblBarprec.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblBarprec.setBounds(560, 188, 70, 18);
		add(lblBarprec);
		
		lblRestauranteprec = new JLabel("0");
		lblRestauranteprec.setHorizontalAlignment(SwingConstants.RIGHT);
		lblRestauranteprec.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblRestauranteprec.setBounds(560, 218, 70, 18);
		add(lblRestauranteprec);
		
		lblSpaprec = new JLabel("0");
		lblSpaprec.setHorizontalAlignment(SwingConstants.RIGHT);
		lblSpaprec.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblSpaprec.setBounds(560, 248, 70, 18);
		add(lblSpaprec);
		
		lblGymprec = new JLabel("0");
		lblGymprec.setHorizontalAlignment(SwingConstants.RIGHT);
		lblGymprec.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblGymprec.setBounds(560, 278, 70, 18);
		add(lblGymprec);
		
		lblAdprec = new JLabel("0");
		lblAdprec.setHorizontalAlignment(SwingConstants.RIGHT);
		lblAdprec.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblAdprec.setBounds(560, 308, 70, 18);
		add(lblAdprec);
		
		lblMpprec = new JLabel("0");
		lblMpprec.setHorizontalAlignment(SwingConstants.RIGHT);
		lblMpprec.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblMpprec.setBounds(560, 338, 70, 18);
		add(lblMpprec);
		
		lblPcprec = new JLabel("0");
		lblPcprec.setHorizontalAlignment(SwingConstants.RIGHT);
		lblPcprec.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblPcprec.setBounds(560, 368, 70, 18);
		add(lblPcprec);
	}
}
