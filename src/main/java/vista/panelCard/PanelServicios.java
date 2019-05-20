package vista.panelCard;

import java.awt.Color;
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
		lblParkingprec, lblACprec, lblBarprec, lblRestauranteprec, lblSpaprec, lblGymprec, lblAdprec, lblMpprec, lblPcprec, lblFechaEntrada, lblFechaSalida, lblTotal, lblEntradatxt, lblSalidatxt, lblTotaltxt;
	
	public JLabel[] servicios = new JLabel[11];
	public JLabel[] serviciostxt = new JLabel[11];
	public JLabel[] preciosSrv = new JLabel[11];
	
	/**
	 * Create the panel.
	 */
	public PanelServicios() {
		setBorder(null);
		setPanelParametros();
		instanciarObjetos();
	}

	private void setPanelParametros() {
		setPreferredSize(new Dimension(1024,588));
		setLayout(null);		
	}
	
	public void instanciarObjetos() {
		lblImagen = new JLabel("");
		lblImagen.setBackground(SystemColor.activeCaptionBorder);
		lblImagen.setBounds(111, 46, 300, 200);
		add(lblImagen);
		
		lblNombre = new JLabel("New label");
		lblNombre.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblNombre.setBounds(111, 256, 340, 32);
		lblNombre.setForeground(new Color(0,103,219));
		add(lblNombre);
		
		lblDireccion = new JLabel("New label");
		lblDireccion.setFont(new Font("Tahoma", Font.ITALIC, 14));
		lblDireccion.setBounds(111, 281, 340, 28);
		add(lblDireccion);
		
		lblEstrellas = new JLabel("New label");
		lblEstrellas.setIcon(new ImageIcon(PanelServicios.class.getResource("/imagenes/alojamiento/hotel/estrellas1.png")));
		lblEstrellas.setBounds(111, 311, 100, 21);
		add(lblEstrellas);
		
		lblWifi = new JLabel("New label");
		lblWifi.setEnabled(false);
		lblWifi.setIcon(new ImageIcon(PanelServicios.class.getResource("/imagenes/alojamiento/servicios/wifi.png")));
		lblWifi.setBounds(565, 100, 16, 16);
		add(lblWifi);
		
		lblWifitxt = new JLabel("WiFi");
		lblWifitxt.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblWifitxt.setBounds(599, 98, 200, 18);
		add(lblWifitxt);
		
		lblPiscina = new JLabel("New label");
		lblPiscina.setEnabled(false);
		lblPiscina.setIcon(new ImageIcon(PanelServicios.class.getResource("/imagenes/alojamiento/servicios/piscina.png")));
		lblPiscina.setBounds(565, 130, 16, 16);
		add(lblPiscina);
		
		lblPiscinatxt = new JLabel("Piscina");
		lblPiscinatxt.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblPiscinatxt.setBounds(599, 128, 200, 18);
		add(lblPiscinatxt);
		
		lblTitulo = new JLabel("Seleccionar Servicios");
		lblTitulo.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblTitulo.setHorizontalAlignment(SwingConstants.LEFT);
		lblTitulo.setBounds(565, 46, 375, 32);
		lblTitulo.setForeground(new Color(0,103,219));
		add(lblTitulo);
		
		lblAC = new JLabel("New label");
		lblAC.setEnabled(false);
		lblAC.setIcon(new ImageIcon(PanelServicios.class.getResource("/imagenes/alojamiento/servicios/aireacondicionado.png")));
		lblAC.setBounds(565, 160, 16, 16);
		add(lblAC);
		
		lblACtxt = new JLabel("Aire Acondicionado");
		lblACtxt.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblACtxt.setBounds(599, 158, 200, 18);
		add(lblACtxt);
		
		lblParking = new JLabel("New label");
		lblParking.setEnabled(false);
		lblParking.setIcon(new ImageIcon(PanelServicios.class.getResource("/imagenes/alojamiento/servicios/parking.png")));
		lblParking.setBounds(565, 190, 16, 16);
		add(lblParking);
		
		lblParkingtxt = new JLabel("Parking");
		lblParkingtxt.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblParkingtxt.setBounds(599, 188, 200, 18);
		add(lblParkingtxt);
		
		lblBar = new JLabel("New label");
		lblBar.setEnabled(false);
		lblBar.setIcon(new ImageIcon(PanelServicios.class.getResource("/imagenes/alojamiento/servicios/bar.png")));
		lblBar.setBounds(565, 220, 16, 16);
		add(lblBar);
		
		lblBartxt = new JLabel("Bar / Cafetería");
		lblBartxt.setIcon(null);
		lblBartxt.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblBartxt.setBounds(599, 218, 200, 18);
		add(lblBartxt);
		
		lblRestaurante = new JLabel("New label");
		lblRestaurante.setEnabled(false);
		lblRestaurante.setIcon(new ImageIcon(PanelServicios.class.getResource("/imagenes/alojamiento/servicios/restaurante.png")));
		lblRestaurante.setBounds(565, 250, 16, 16);
		add(lblRestaurante);
		
		lblRestaurantetxt = new JLabel("Restaurante");
		lblRestaurantetxt.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblRestaurantetxt.setBounds(599, 248, 200, 18);
		add(lblRestaurantetxt);
		
		lblSpa = new JLabel("New label");
		lblSpa.setEnabled(false);
		lblSpa.setIcon(new ImageIcon(PanelServicios.class.getResource("/imagenes/alojamiento/servicios/spa.png")));
		lblSpa.setBounds(565, 280, 16, 16);
		add(lblSpa);
		
		lblSpatxt = new JLabel("Spa / Sauna");
		lblSpatxt.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblSpatxt.setBounds(599, 278, 200, 18);
		add(lblSpatxt);
		
		lblGym = new JLabel("New label");
		lblGym.setEnabled(false);
		lblGym.setIcon(new ImageIcon(PanelServicios.class.getResource("/imagenes/alojamiento/servicios/gimnasio.png")));
		lblGym.setBounds(565, 310, 16, 16);
		add(lblGym);
		
		lblGymtxt = new JLabel("Gimnasio");
		lblGymtxt.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblGymtxt.setBounds(599, 308, 200, 18);
		add(lblGymtxt);
		
		lblAd = new JLabel("AD");
		lblAd.setEnabled(false);
		lblAd.setHorizontalAlignment(SwingConstants.CENTER);
		lblAd.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblAd.setBounds(565, 340, 16, 16);
		add(lblAd);
		
		lblAdtxt = new JLabel("Alojamiento y desayuno");
		lblAdtxt.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblAdtxt.setBounds(599, 338, 200, 18);
		add(lblAdtxt);
		
		lblMp = new JLabel("MP");
		lblMp.setEnabled(false);
		lblMp.setHorizontalAlignment(SwingConstants.CENTER);
		lblMp.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblMp.setBounds(565, 370, 16, 16);
		add(lblMp);
		
		lblMptxt = new JLabel("Media pensión");
		lblMptxt.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblMptxt.setBounds(599, 368, 200, 18);
		add(lblMptxt);
		
		lblPctxt = new JLabel("Pensión completa");
		lblPctxt.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblPctxt.setBounds(599, 398, 200, 18);
		add(lblPctxt);
		
		lblPc = new JLabel("PC");
		lblPc.setEnabled(false);
		lblPc.setHorizontalAlignment(SwingConstants.CENTER);
		lblPc.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblPc.setBounds(565, 400, 16, 16);
		add(lblPc);
		
		lblWifiprec = new JLabel("Incluido");
		lblWifiprec.setHorizontalAlignment(SwingConstants.RIGHT);
		lblWifiprec.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblWifiprec.setBounds(798, 98, 70, 18);
		add(lblWifiprec);
		
		lblPiscinaprec = new JLabel("0");
		lblPiscinaprec.setHorizontalAlignment(SwingConstants.RIGHT);
		lblPiscinaprec.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblPiscinaprec.setBounds(798, 128, 70, 18);
		add(lblPiscinaprec);
		
		lblACprec = new JLabel("0");
		lblACprec.setHorizontalAlignment(SwingConstants.RIGHT);
		lblACprec.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblACprec.setBounds(798, 158, 70, 18);
		add(lblACprec);
		
		lblParkingprec = new JLabel("0");
		lblParkingprec.setHorizontalAlignment(SwingConstants.RIGHT);
		lblParkingprec.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblParkingprec.setBounds(798, 188, 70, 18);
		add(lblParkingprec);
		
		lblBarprec = new JLabel("0");
		lblBarprec.setHorizontalAlignment(SwingConstants.RIGHT);
		lblBarprec.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblBarprec.setBounds(798, 218, 70, 18);
		add(lblBarprec);
		
		lblRestauranteprec = new JLabel("0");
		lblRestauranteprec.setHorizontalAlignment(SwingConstants.RIGHT);
		lblRestauranteprec.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblRestauranteprec.setBounds(798, 248, 70, 18);
		add(lblRestauranteprec);
		
		lblSpaprec = new JLabel("0");
		lblSpaprec.setHorizontalAlignment(SwingConstants.RIGHT);
		lblSpaprec.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblSpaprec.setBounds(798, 278, 70, 18);
		add(lblSpaprec);
		
		lblGymprec = new JLabel("0");
		lblGymprec.setHorizontalAlignment(SwingConstants.RIGHT);
		lblGymprec.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblGymprec.setBounds(798, 308, 70, 18);
		add(lblGymprec);
		
		lblAdprec = new JLabel("0");
		lblAdprec.setHorizontalAlignment(SwingConstants.RIGHT);
		lblAdprec.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblAdprec.setBounds(798, 338, 70, 18);
		add(lblAdprec);
		
		lblMpprec = new JLabel("0");
		lblMpprec.setHorizontalAlignment(SwingConstants.RIGHT);
		lblMpprec.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblMpprec.setBounds(798, 368, 70, 18);
		add(lblMpprec);
		
		lblPcprec = new JLabel("0");
		lblPcprec.setHorizontalAlignment(SwingConstants.RIGHT);
		lblPcprec.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblPcprec.setBounds(798, 398, 70, 18);
		add(lblPcprec);
		
		lblFechaEntrada = new JLabel("New label");
		lblFechaEntrada.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblFechaEntrada.setBounds(221, 360, 148, 26);
		add(lblFechaEntrada);
		
		lblEntradatxt = new JLabel("Entrada:");
		lblEntradatxt.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblEntradatxt.setBounds(111, 360, 100, 26);
		add(lblEntradatxt);
		
		lblSalidatxt = new JLabel("Salida:");
		lblSalidatxt.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblSalidatxt.setBounds(111, 410, 100, 26);
		add(lblSalidatxt);
		
		lblFechaSalida = new JLabel("New label");
		lblFechaSalida.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblFechaSalida.setBounds(221, 410, 148, 26);
		add(lblFechaSalida);
		
		lblTotaltxt = new JLabel("Total Extras");
		lblTotaltxt.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblTotaltxt.setBounds(565, 426, 113, 28);
		lblTotaltxt.setForeground(new Color(0,103,219));
		add(lblTotaltxt);
		
		lblTotal = new JLabel("0");
		lblTotal.setHorizontalAlignment(SwingConstants.RIGHT);
		lblTotal.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblTotal.setBounds(776, 427, 92, 26);
		lblTotal.setForeground(new Color(0,103,219));
		add(lblTotal);
		
		servicios[0] = lblWifi;
		servicios[1] = lblPiscina;
		servicios[2] = lblSpa;
		servicios[3] = lblParking;
		servicios[4] = lblAC;
		servicios[5] = lblRestaurante;
		servicios[6] = lblBar;
		servicios[7] = lblGym;
		servicios[8] = lblAd;
		servicios[9] = lblMp;
		servicios[10] = lblPc;
		
		serviciostxt[0] = lblWifitxt;
		serviciostxt[1] = lblPiscinatxt;
		serviciostxt[2] = lblSpatxt;
		serviciostxt[3] = lblParkingtxt;
		serviciostxt[4] = lblACtxt;
		serviciostxt[5] = lblRestaurantetxt;
		serviciostxt[6] = lblBartxt;
		serviciostxt[7] = lblGymtxt;
		serviciostxt[8] = lblAdtxt;
		serviciostxt[9] = lblMptxt;
		serviciostxt[10] = lblPctxt;
		
		preciosSrv[0] = lblWifiprec;
		preciosSrv[1] = lblPiscinaprec;
		preciosSrv[2] = lblSpaprec;
		preciosSrv[3] = lblParkingprec;
		preciosSrv[4] = lblACprec;
		preciosSrv[5] = lblRestauranteprec;
		preciosSrv[6] = lblBarprec;
		preciosSrv[7] = lblGymprec;
		preciosSrv[8] = lblAdprec;
		preciosSrv[9] = lblMpprec;
		preciosSrv[10] = lblPcprec;
	}
}
