package vista.panelCard;

import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Font;
import java.io.File;
import java.io.IOException;
import java.text.DecimalFormat;
import javax.imageio.ImageIO;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.ListCellRenderer;
import javax.swing.SwingConstants;
import modelo.Alojamiento;
import modelo.Apartamento;
import modelo.Casa;
import modelo.Hotel;
import modelo.TipoServicio;
import javax.swing.border.LineBorder;

public class ItemResBusqueda extends JPanel implements ListCellRenderer<Alojamiento> {

	private static final long serialVersionUID = 1L;

	private JLabel lblFoto, lblNombre, lblLocalidad, lblPrecio, lblEstrellas, lblDisponible, lblCamas, lblNumCamas,
			lblBar, lblGym, lblWifi, lblPiscina, lblParking, lblAC, lblRestaurante, lblSpa, lblAd, lblMp, lblPc;
	private DecimalFormat df = new DecimalFormat("#.00 €");
	private JLabel lblFondo;


	public ItemResBusqueda() {
		setBackground(Color.WHITE);
		setParametros();
		instanciarObjetos();
	}

	private void setParametros() {
		setBorder(null);
		setPreferredSize(new Dimension(570, 155));
		setLayout(null);
	}

	private void instanciarObjetos() {
		
		lblFoto = new JLabel("New label");
		lblFoto.setIcon(new ImageIcon(ItemResBusqueda.class.getResource("/imagenes/alojamiento/noimage.png")));
		lblFoto.setBounds(10, 10, 90, 90);
		lblFoto.setPreferredSize(new Dimension(90, 90));
		add(lblFoto);

		lblNombre = new JLabel("Nombre Hotel");
		lblNombre.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblNombre.setBounds(122, 7, 366, 30);
		lblNombre.setForeground(new Color(0,103,219));
		add(lblNombre);

		lblLocalidad = new JLabel("Localidad");
		lblLocalidad.setFont(new Font("Tahoma", Font.ITALIC, 14));
		lblLocalidad.setBounds(122, 32, 366, 20);
		add(lblLocalidad);

		lblPrecio = new JLabel("Precio");
		lblPrecio.setFont(new Font("Tahoma", Font.PLAIN, 22));
		lblPrecio.setHorizontalAlignment(SwingConstants.RIGHT);
		lblPrecio.setBounds(442, 88, 106, 36);
		add(lblPrecio);

		lblEstrellas = new JLabel("");
		lblEstrellas.setIcon(
				new ImageIcon(ItemResBusqueda.class.getResource("/imagenes/alojamiento/hotel/estrellas1.png")));
		lblEstrellas.setBounds(454, 10, 100, 22);
		add(lblEstrellas);

		lblDisponible = new JLabel("Disponible");
		lblDisponible.setForeground(new Color(0, 128, 0));
		lblDisponible.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 14));
		lblDisponible.setBounds(20, 111, 100, 20);
		add(lblDisponible);

		lblCamas = new JLabel("");
		lblCamas.setIcon(new ImageIcon(ItemResBusqueda.class.getResource("/imagenes/alojamiento/noHotel/cama.png")));
		lblCamas.setBounds(122, 52, 32, 22);
		add(lblCamas);

		lblNumCamas = new JLabel("");
		lblNumCamas.setBounds(165, 52, 53, 22);
		add(lblNumCamas);

		lblWifi = new JLabel("");
		lblWifi.setEnabled(false);
		lblWifi.setIcon(new ImageIcon(ItemResBusqueda.class.getResource("/imagenes/alojamiento/servicios/wifi.png")));
		lblWifi.setBounds(122, 80, 16, 16);
		lblWifi.setToolTipText("Wifi");
		add(lblWifi);

		lblPiscina = new JLabel("");
		lblPiscina.setEnabled(false);
		lblPiscina.setIcon(
				new ImageIcon(ItemResBusqueda.class.getResource("/imagenes/alojamiento/servicios/piscina.png")));
		lblPiscina.setBounds(148, 80, 16, 16);
		add(lblPiscina);

		lblSpa = new JLabel("");
		lblSpa.setEnabled(false);
		lblSpa.setIcon(new ImageIcon(ItemResBusqueda.class.getResource("/imagenes/alojamiento/servicios/spa.png")));
		lblSpa.setBounds(278, 80, 16, 16);
		add(lblSpa);

		lblParking = new JLabel("");
		lblParking.setEnabled(false);
		lblParking.setIcon(
				new ImageIcon(ItemResBusqueda.class.getResource("/imagenes/alojamiento/servicios/parking.png")));
		lblParking.setBounds(200, 80, 16, 16);
		add(lblParking);

		lblAC = new JLabel("");
		lblAC.setEnabled(false);
		lblAC.setIcon(new ImageIcon(
				ItemResBusqueda.class.getResource("/imagenes/alojamiento/servicios/aireacondicionado.png")));
		lblAC.setBounds(174, 80, 16, 16);
		add(lblAC);

		lblRestaurante = new JLabel("");
		lblRestaurante.setEnabled(false);
		lblRestaurante.setIcon(
				new ImageIcon(ItemResBusqueda.class.getResource("/imagenes/alojamiento/servicios/restaurante.png")));
		lblRestaurante.setBounds(252, 80, 16, 16);
		add(lblRestaurante);

		lblBar = new JLabel("");
		lblBar.setEnabled(false);
		lblBar.setIcon(new ImageIcon(ItemResBusqueda.class.getResource("/imagenes/alojamiento/servicios/bar.png")));
		lblBar.setBounds(226, 80, 16, 16);
		add(lblBar);

		lblGym = new JLabel("");
		lblGym.setEnabled(false);
		lblGym.setIcon(
				new ImageIcon(ItemResBusqueda.class.getResource("/imagenes/alojamiento/servicios/gimnasio.png")));
		lblGym.setBounds(304, 80, 16, 16);
		add(lblGym);

		lblAd = new JLabel("AD");
		lblAd.setHorizontalAlignment(SwingConstants.CENTER);
		lblAd.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblAd.setEnabled(false);
		lblAd.setBounds(330, 80, 16, 16);
		add(lblAd);

		lblMp = new JLabel("MP");
		lblMp.setHorizontalAlignment(SwingConstants.CENTER);
		lblMp.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblMp.setEnabled(false);
		lblMp.setBounds(356, 80, 16, 16);
		add(lblMp);

		lblPc = new JLabel("PC");
		lblPc.setHorizontalAlignment(SwingConstants.CENTER);
		lblPc.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblPc.setEnabled(false);
		lblPc.setBounds(382, 80, 16, 16);
		add(lblPc);
		
		JLabel lblDesdeda = new JLabel("desde €/día");
		lblDesdeda.setHorizontalAlignment(SwingConstants.RIGHT);
		lblDesdeda.setBounds(479, 124, 70, 15);
		add(lblDesdeda);
		
		lblFondo = new JLabel("");
		lblFondo.setBackground(Color.WHITE);
		lblFondo.setBorder(new LineBorder(Color.LIGHT_GRAY, 1, true));
		lblFondo.setBounds(0, 0, 570, 150);
		add(lblFondo);

	}
	
	@Override
	public Component getListCellRendererComponent(JList<? extends Alojamiento> lista, Alojamiento aloj, int index,
			boolean isSelected, boolean cellHasFocus) {
		String foto = aloj.getImagen();

		java.net.URL url = null;
		if (!foto.equals("")) {
			if (aloj instanceof Hotel) 
				url = getClass().getResource("/imagenes/alojamiento/hotel/" + foto + ".jpg");
			else 
				url = getClass().getResource("/imagenes/alojamiento/noHotel/" + foto + ".jpg");
		} else
			url = getClass().getResource("/imagenes/alojamiento/noimage.png");

		Icon imagen = new ImageIcon(url);
		lblFoto.setIcon(imagen);
		lblNombre.setText(aloj.getNombre());
		lblLocalidad.setText(aloj.getDireccion().getCalle() + " (" + aloj.getDireccion().getLocalidad() + ")");
		lblPrecio.setText(df.format(aloj.getPrecioTAlta()));

		if (isSelected) {
			setBackground(lista.getSelectionBackground());
			setForeground(lista.getSelectionForeground());
		} else {
			setBackground(lista.getBackground());
			setForeground(lista.getForeground());
		}

		if (aloj.isDisponible()) {
			lblDisponible.setText("Disponible");
			lblDisponible.setForeground(new Color(0, 128, 0));
			aloj.setDisponible(true);
		} else {
			lblDisponible.setText("No disponible");
			lblDisponible.setForeground(new Color(255, 0, 0));
			aloj.setDisponible(false);
		}

		if (aloj instanceof Hotel) {
			url = getClass().getResource("/imagenes/alojamiento/hotel/estrellas" + ((Hotel) aloj).getNumEstrellas() + ".png");
			
			imagen = new ImageIcon(url);
			lblEstrellas.setIcon(imagen);
			lblEstrellas.setVisible(true);
			lblCamas.setVisible(false);
			lblNumCamas.setVisible(false);
		} else {
			url = getClass().getResource("/imagenes/alojamiento/noHotel/cama.png");
			
			imagen = new ImageIcon(url);
			lblCamas.setIcon(imagen);
			lblEstrellas.setVisible(false);
			lblCamas.setVisible(true);
			lblNumCamas.setVisible(true);

			if (aloj instanceof Casa) {
				lblNumCamas.setText(String.valueOf(((Casa) aloj).numCamas()));
				// String.valueOf(((Casa) aloj).numCamas()) SUSTITUIR 5 CUANDO ESTE LA BBDD
			} else if (aloj instanceof Apartamento) {
				lblNumCamas.setText(String.valueOf(((Apartamento) aloj).numCamas()));
			}

		}

		JLabel[] servicios = {lblWifi, lblPiscina, lblSpa, lblParking, lblAC, lblRestaurante, lblBar, lblGym, lblAd, lblMp, lblPc};
		int posicion = 122;
		for (int i = 0; i < aloj.getServicios().length; i++) {
			if (aloj.getServicios()[i].getTipo() == TipoServicio.incluido) {
				servicios[i].setVisible(true);
				servicios[i].setEnabled(true);
				servicios[i].setBounds(posicion, 80, 16, 16);
				posicion += 26;
			} else if (aloj.getServicios()[i].getTipo() == TipoServicio.noIncluido) {
				servicios[i].setVisible(true);
				servicios[i].setEnabled(false);
				servicios[i].setBounds(posicion, 80, 16, 16);
				posicion += 26;
			} else if (aloj.getServicios()[i].getTipo() == TipoServicio.noDisponible) {
				servicios[i].setVisible(false);
			}
		}
		return this;
	}
}
