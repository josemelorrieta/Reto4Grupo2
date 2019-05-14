package vista.panelCard;

import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Font;
import java.io.File;
import java.text.DecimalFormat;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.ListCellRenderer;
import javax.swing.SwingConstants;
import javax.swing.border.BevelBorder;

import modelo.Alojamiento;
import modelo.Apartamento;
import modelo.Casa;
import modelo.Hotel;
import util.FuncionesGenerales;

public class ItemResBusqueda extends JPanel implements ListCellRenderer<Alojamiento> {

	private static final long serialVersionUID = 1L;

	private JLabel lblFoto, lblNombre, lblLocalidad, lblPrecio, lblEstrellas, lblDisponible, lblCamas, lblNumCamas;
	private DecimalFormat df = new DecimalFormat("#.00 €");
	private JLabel lblBar;
	private JLabel label_4;
	private JLabel label;

	public ItemResBusqueda() {
		setParametros();
		instanciarObjetos();
	}

	private void setParametros() {
		setBorder(new BevelBorder(BevelBorder.RAISED, null, null, null, null));
		setPreferredSize(new Dimension(500, 150));
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
		add(lblNombre);

		lblLocalidad = new JLabel("Localidad");
		lblLocalidad.setFont(new Font("Tahoma", Font.ITALIC, 14));
		lblLocalidad.setBounds(122, 32, 366, 20);
		add(lblLocalidad);

		lblPrecio = new JLabel("Precio");
		lblPrecio.setFont(new Font("Tahoma", Font.PLAIN, 22));
		lblPrecio.setHorizontalAlignment(SwingConstants.RIGHT);
		lblPrecio.setBounds(370, 95, 106, 36);
		add(lblPrecio);

		lblEstrellas = new JLabel("");
		lblEstrellas.setIcon(new ImageIcon(ItemResBusqueda.class.getResource("/imagenes/alojamiento/hotel/estrellas5.png")));
		lblEstrellas.setBounds(376, 10, 100, 22);
		add(lblEstrellas);

		lblDisponible = new JLabel("");
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
		
		JLabel lblWifi = new JLabel("");
		lblWifi.setIcon(new ImageIcon(ItemResBusqueda.class.getResource("/imagenes/alojamiento/servicios/wifi.png")));
		lblWifi.setBounds(122, 80, 24, 24);
		add(lblWifi);
		
		JLabel lblPiscina = new JLabel("");
		lblPiscina.setIcon(new ImageIcon(ItemResBusqueda.class.getResource("/imagenes/alojamiento/servicios/piscina.png")));
		lblPiscina.setBounds(156, 80, 24, 24);
		add(lblPiscina);
		
		JLabel lblSpa = new JLabel("");
		lblSpa.setIcon(new ImageIcon(ItemResBusqueda.class.getResource("/imagenes/alojamiento/servicios/spa.png")));
		lblSpa.setBounds(190, 80, 24, 24);
		add(lblSpa);
		
		JLabel lblParking = new JLabel("");
		lblParking.setIcon(new ImageIcon(ItemResBusqueda.class.getResource("/imagenes/alojamiento/servicios/aparcamiento.png")));
		lblParking.setBounds(224, 80, 24, 24);
		add(lblParking);
		
		JLabel lblAC = new JLabel("");
		lblAC.setIcon(new ImageIcon(ItemResBusqueda.class.getResource("/imagenes/alojamiento/servicios/aire-acondicionado.png")));
		lblAC.setBounds(258, 80, 24, 24);
		add(lblAC);
		
		JLabel lblResturante = new JLabel("");
		lblResturante.setIcon(new ImageIcon(ItemResBusqueda.class.getResource("/imagenes/alojamiento/servicios/restaurante.png")));
		lblResturante.setBounds(288, 80, 24, 24);
		add(lblResturante);
		
		lblBar = new JLabel("");
		lblBar.setIcon(new ImageIcon(ItemResBusqueda.class.getResource("/imagenes/alojamiento/servicios/cafeteria.png")));
		lblBar.setBounds(322, 80, 24, 24);
		add(lblBar);
		
		label_4 = new JLabel("");
		label_4.setBounds(356, 80, 24, 24);
		add(label_4);
		
		label = new JLabel("");
		label.setIcon(new ImageIcon(ItemResBusqueda.class.getResource("/imagenes/alojamiento/servicios/gimnasio.png")));
		label.setBounds(356, 80, 24, 24);
		add(label);
	}

	

	@Override
	public Component getListCellRendererComponent(JList<? extends Alojamiento> lista, Alojamiento aloj, int index, boolean isSelected, boolean cellHasFocus) {
		String foto = aloj.getImagen();

		ImageIcon imagen;
		File archImagen;
		if (!foto.equals("")) {
			if (aloj instanceof Hotel) {
				archImagen = new File(getClass().getResource("/imagenes/alojamiento/hotel/" + foto + ".jpg").getPath());
			} else
				archImagen = new File(getClass().getResource("/imagenes/alojamiento/noHotel/" + foto + ".jpg").getPath());
		} else
			archImagen = new File(getClass().getResource("/imagenes/alojamiento/noimage.png").getPath());

		imagen = FuncionesGenerales.resizeIcono(90, 90, archImagen);
		
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
			lblDisponible.setForeground(new Color(50, 205, 50));
			aloj.setDisponible(true);
		} else {
			lblDisponible.setText("No disponible");
			lblDisponible.setForeground(new Color(255, 0, 0));
			aloj.setDisponible(false);
		}

		if (aloj instanceof Hotel) {
			ImageIcon estrellas = FuncionesGenerales.resizeIcono(lblEstrellas.getWidth(), lblEstrellas.getHeight(), new File(getClass().getResource("/imagenes/alojamiento/hotel/estrellas" + ((Hotel) aloj).getNumEstrellas() + ".png").getPath()));
			lblEstrellas.setIcon(estrellas);
			lblEstrellas.setVisible(true);
			lblCamas.setVisible(false);
			lblNumCamas.setVisible(false);

			
		} else {
			ImageIcon cama = FuncionesGenerales.resizeIcono(lblCamas.getWidth(), lblCamas.getHeight(), new File(getClass().getResource("/imagenes/alojamiento/noHotel/cama.png").getPath()));
			lblCamas.setIcon(cama);
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

		return this;
	}
}
