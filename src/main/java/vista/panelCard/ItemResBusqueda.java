package vista.panelCard;

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
import modelo.MetodosBuscar;
import util.FuncionesGenerales;
import java.awt.Color;

public class ItemResBusqueda extends JPanel implements ListCellRenderer<Alojamiento> {

	private static final long serialVersionUID = 1L;

	private JLabel lblFoto, lblNombre, lblLocalidad, lblPrecio, lblEstrellas, lblDisponible, lblCamas, lblNumCamas;
	private DecimalFormat df = new DecimalFormat("#.00 €");

	public ItemResBusqueda() {
		setParametros();
		instanciarObjetos();
	}

	private void setParametros() {
		setBorder(new BevelBorder(BevelBorder.RAISED, null, null, null, null));
		setPreferredSize(new Dimension(500, 111));
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
		lblPrecio.setBounds(353, 64, 106, 36);
		add(lblPrecio);

		lblEstrellas = new JLabel("");
		lblEstrellas.setIcon(new ImageIcon(ItemResBusqueda.class.getResource("/imagenes/alojamiento/hotel/estrellas5.png")));
		lblEstrellas.setBounds(376, 10, 100, 22);
		add(lblEstrellas);

		lblDisponible = new JLabel("Disponible");
		lblDisponible.setForeground(new Color(50, 205, 50));
		lblDisponible.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 14));
		lblDisponible.setBounds(122, 80, 100, 20);
		add(lblDisponible);

		lblCamas = new JLabel("");
		lblCamas.setBounds(118, 52, 39, 22);
		add(lblCamas);

		lblNumCamas = new JLabel("");
		lblNumCamas.setBounds(165, 52, 53, 22);
		add(lblNumCamas);
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

		if (aloj instanceof Hotel) {
			ImageIcon estrellas = FuncionesGenerales.resizeIcono(lblEstrellas.getWidth(), lblEstrellas.getHeight(), new File(getClass().getResource("/imagenes/alojamiento/hotel/estrellas" + ((Hotel) aloj).getNumEstrellas() + ".png").getPath()));
			lblEstrellas.setIcon(estrellas);
			lblEstrellas.setVisible(true);
			lblCamas.setVisible(false);
			lblNumCamas.setVisible(false);

			if (MetodosBuscar.comprobarDisponibilidad(((Hotel) aloj).getDormDisponibles())) {
				lblDisponible.setText("No disponible");
				lblDisponible.setForeground(new Color(255, 0, 0));
			} else {
				lblDisponible.setText("Disponible");
				lblDisponible.setForeground(new Color(50, 205, 50));
			}
		} else {
			ImageIcon cama = FuncionesGenerales.resizeIcono(lblCamas.getWidth(), lblCamas.getHeight(), new File(getClass().getResource("/imagenes/alojamiento/noHotel/cama.png").getPath()));
			lblCamas.setIcon(cama);
			lblEstrellas.setVisible(false);
			lblCamas.setVisible(true);
			lblNumCamas.setVisible(true);
			
			if (aloj instanceof Casa) {
				lblNumCamas.setText("5");
				// String.valueOf(((Casa) aloj).numCamas()) SUSTITUIR 5 CUANDO ESTE LA BBDD
			} else if (aloj instanceof Apartamento) {
				// DESCOMENTAR CUANDO ESTEN HECHAS LAS HABITACIONES EN LA BBDD
				// lblNumCamas.setText(String.valueOf(((Casa) aloj).numCamas()));
			}
		}

		return this;
	}
}
