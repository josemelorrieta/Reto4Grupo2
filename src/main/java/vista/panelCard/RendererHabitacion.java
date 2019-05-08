package vista.panelCard;

import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Font;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.ListCellRenderer;
import javax.swing.SwingConstants;
import javax.swing.border.BevelBorder;
import modelo.Cama;
import modelo.Habitacion;
import modelo.Mobiliario;

public class RendererHabitacion extends JPanel implements ListCellRenderer<Habitacion>{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public JLabel lblFoto,lblNombre,lblCamas,lblTamano, lblDisponible;
	
	
	public RendererHabitacion() {
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
		lblFoto.setIcon(new ImageIcon(RendererAlojamiento.class.getResource("/imagenes/alojamiento/noimage.png")));
		lblFoto.setBounds(10, 10, 90, 90);
		add(lblFoto);
		
		lblNombre = new JLabel("Nombre Dormitorio");
		lblNombre.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblNombre.setBounds(122, 7, 368, 30);
		add(lblNombre);
		
		lblCamas = new JLabel("Camas");
		lblCamas.setFont(new Font("Tahoma", Font.ITALIC, 14));
		lblCamas.setBounds(122, 32, 366, 20);
		add(lblCamas);

		lblTamano = new JLabel("Tamaño");
		lblTamano.setFont(new Font("Tahoma", Font.PLAIN, 22));
		lblTamano.setHorizontalAlignment(SwingConstants.RIGHT);
		lblTamano.setBounds(353, 64, 106, 36);
		add(lblTamano);
		
		lblDisponible = new JLabel("Disponible");
		lblDisponible.setForeground(new Color(50, 205, 50));
		lblDisponible.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 14));
		lblDisponible.setBounds(122, 80, 100, 20);
		add(lblDisponible);
	}

	@Override
	public Component getListCellRendererComponent(JList<? extends Habitacion> lista, Habitacion habitacion, int index, boolean isSelected, boolean cellHasFocus) {
		
		//lblFoto.setIcon(dormitorio.getImagen());
		lblNombre.setText(String.valueOf(habitacion.getTipoHab())+" "+habitacion.getIdHab());
		String camas = "";
		
		for(Mobiliario mob: habitacion.getMobiliario()) 
			if(mob instanceof Cama) 
				camas += ((Cama) mob).getTipoCama()+"\n";
					
		lblCamas.setText(camas);
		lblTamano.setText(String.valueOf(habitacion.getM2())+"m2");
		
		if (habitacion.isDisponible()) {
			lblDisponible.setText("Disponible");
			lblDisponible.setForeground(new Color(50, 205, 50));
		} else {
			lblDisponible.setText("No disponible");
			lblDisponible.setForeground(new Color(255, 0, 0));
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
