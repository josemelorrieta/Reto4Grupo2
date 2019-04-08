package vista.panelCard;

import java.awt.Component;
import java.awt.Dimension;
import java.awt.Font;
import java.text.DecimalFormat;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.ListCellRenderer;
import javax.swing.border.BevelBorder;
import javax.swing.SwingConstants;
import modelo.Hotel;

public class ItemResBusqueda extends JPanel  implements ListCellRenderer<Hotel> {

	private static final long serialVersionUID = 1L;
	
	private JLabel lblFoto, lblNombre, lblLocalidad, lblPrecio;
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
		lblNombre.setBounds(122, 10, 366, 30);
		add(lblNombre);
		
		lblLocalidad = new JLabel("Localidad");
		lblLocalidad.setFont(new Font("Tahoma", Font.ITALIC, 14));
		lblLocalidad.setBounds(122, 48, 366, 20);
		add(lblLocalidad);
		
		lblPrecio = new JLabel("Precio");
		lblPrecio.setFont(new Font("Tahoma", Font.PLAIN, 22));
		lblPrecio.setHorizontalAlignment(SwingConstants.RIGHT);
		lblPrecio.setBounds(353, 64, 106, 36);
		add(lblPrecio);
	}

	@Override
	public Component getListCellRendererComponent(JList<? extends Hotel> lista, Hotel hotel, int index, boolean isSelected,
			boolean cellHasFocus) {
		int foto = hotel.getId();
		//System.out.println(hotel.getId());
		ImageIcon imagen = new ImageIcon(getClass().getResource("/imagenes/alojamiento/hotel/"+ foto +".jpg"));
		
		lblFoto.setIcon(imagen);
		lblNombre.setText(hotel.getNombre());
		lblLocalidad.setText(hotel.getUbicacion().getLocalidad());
		lblPrecio.setText(df.format(hotel.getPrecioTAlta()));
		
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
