package vista.panelCard;

import java.awt.Component;
import java.awt.Dimension;
import java.awt.Font;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.ListCellRenderer;
import javax.swing.border.BevelBorder;

import modelo.Hotel;
import javax.swing.SwingConstants;

public class ItemResBusqueda extends JPanel  implements ListCellRenderer<Hotel> {

	private static final long serialVersionUID = 1L;
	
	private JLabel lblFoto, lblNombre, lblLocalidad, lblPrecio;
	
	public ItemResBusqueda() {
		setPreferredSize(new Dimension(500,111));
		setSize(500,111);
		setBorder(new BevelBorder(BevelBorder.RAISED, null, null, null, null));
		setLayout(null);

		lblFoto = new JLabel("New label");
		lblFoto.setIcon(new ImageIcon(ItemResBusqueda.class.getResource("/imagenes/foto.png")));
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
		
		lblPrecio = new JLabel("0");
		lblPrecio.setFont(new Font("Tahoma", Font.PLAIN, 22));
		lblPrecio.setHorizontalAlignment(SwingConstants.RIGHT);
		lblPrecio.setBounds(353, 64, 106, 36);
		add(lblPrecio);
		
		JLabel lblEuro = new JLabel("\u20AC");
		lblEuro.setFont(new Font("Tahoma", Font.PLAIN, 22));
		lblEuro.setBounds(469, 64, 21, 36);
		add(lblEuro);
	}

	@Override
	public Component getListCellRendererComponent(JList<? extends Hotel> lista, Hotel hotel, int index, boolean isSelected,
			boolean cellHasFocus) {
		//String foto = hotel.getFoto();
		ImageIcon imagen = new ImageIcon(getClass().getResource("/imagenes/foto.png"));
		
		lblFoto.setIcon(imagen);
		lblNombre.setText(hotel.getNombre());
		lblLocalidad.setText(hotel.getUbicacion().getLocalidad());
		lblPrecio.setText(Double.toString(hotel.getPrecioTAlta()));
		
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
