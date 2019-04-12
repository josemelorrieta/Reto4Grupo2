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

import modelo.Hotel;
import util.FuncionesGenerales;
import java.awt.Color;

public class ItemResBusqueda extends JPanel  implements ListCellRenderer<Hotel> {

	private static final long serialVersionUID = 1L;
	
	private JLabel lblFoto, lblNombre, lblLocalidad, lblPrecio, lblEstrellas, lblDisponible;
	private DecimalFormat df = new DecimalFormat("#.00 €");
	
	public ItemResBusqueda() {
		setParametros();
		instanciarObjetos();
	}

	private void setParametros() {
		setBorder(new BevelBorder(BevelBorder.RAISED, null, null, null, null));
		setPreferredSize(new Dimension(500,111));
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
		lblEstrellas.setBounds(118, 52, 100, 22);
		add(lblEstrellas);
		
		lblDisponible = new JLabel("Disponible");
		lblDisponible.setForeground(new Color(50, 205, 50));
		lblDisponible.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 14));
		lblDisponible.setBounds(122, 80, 100, 20);
		add(lblDisponible);
	}

	@Override
	public Component getListCellRendererComponent(JList<? extends Hotel> lista, Hotel hotel, int index, boolean isSelected,	boolean cellHasFocus) {
		String foto = hotel.getImagen();
		ImageIcon imagen, estrellas;
		int count = 0;
		boolean[] dormitoriosDisp = hotel.getDormDisponibles();
		
		if (!foto.equals(""))
			imagen = new ImageIcon(getClass().getResource("/imagenes/alojamiento/hotel/"+ foto +".jpg"));
		else
			imagen = new ImageIcon(getClass().getResource("/imagenes/alojamiento/noimage.png"));
		
		lblFoto.setIcon(imagen);
		lblNombre.setText(hotel.getNombre());
		lblLocalidad.setText(hotel.getDireccion().getCalle() + " (" + hotel.getDireccion().getLocalidad() + ")");
		lblPrecio.setText(df.format(hotel.getPrecioTAlta()));
		
		estrellas = FuncionesGenerales.resizeIcono(lblEstrellas.getWidth(), lblEstrellas.getHeight(), new File(getClass().getResource("/imagenes/alojamiento/hotel/estrellas" + hotel.getNumEstrellas() + ".png").getPath()));
		lblEstrellas.setIcon(estrellas);
		
		for (int i=0;i<dormitoriosDisp.length;i++) {
			if (dormitoriosDisp[i] == false)
				count++;
		}
		
		if (count > 0) {
			lblDisponible.setText("No disponible");
			lblDisponible.setForeground(new Color(255,0,0));
		}
		
		if (isSelected) {
		    setBackground(lista.getSelectionBackground());
		    setForeground(lista.getSelectionForeground());
		} else {
		    setBackground(lista.getBackground());
		    setForeground(lista.getForeground());
		}
		
		return this;
	}
}
