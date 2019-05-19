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
import javax.swing.border.BevelBorder;

import modelo.Cama;
import modelo.Dormitorio;
import modelo.Mobiliario;
import modelo.TipoCama;

public class RendererHabitacion extends JPanel implements ListCellRenderer<Dormitorio>{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public JLabel lblFoto,lblNombre,lblCamas, lblDisponible,lblImgInfant,lblImgMatri,lblImgIndi, lblMatri,lblIndi,lblInfant;
	
	
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
		lblFoto.setIcon(new ImageIcon(ItemResBusqueda.class.getResource("/imagenes/alojamiento/noimage.png")));
		lblFoto.setBounds(10, 10, 90, 90);
		add(lblFoto);
		
		lblNombre = new JLabel("Nombre Dormitorio");
		lblNombre.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblNombre.setBounds(122, 7, 368, 30);
		add(lblNombre);
		
		lblCamas = new JLabel("Camas:");
		lblCamas.setFont(new Font("Tahoma", Font.ITALIC, 14));
		lblCamas.setBounds(122, 32, 366, 20);
		add(lblCamas);
		
		lblDisponible = new JLabel("Disponible");
		lblDisponible.setForeground(new Color(50, 205, 50));
		lblDisponible.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 14));
		lblDisponible.setBounds(122, 80, 100, 20);
		add(lblDisponible);
		
		lblImgMatri = new JLabel("");
		lblImgMatri.setIcon(new ImageIcon(RendererHabitacion.class.getResource("/imagenes/alojamiento/camas/camaDoble32x24.png")));
		lblImgMatri.setBounds(216, 48, 55, 37);
		add(lblImgMatri);
		
		lblImgIndi = new JLabel("");
		lblImgIndi.setIcon(new ImageIcon(RendererHabitacion.class.getResource("/imagenes/alojamiento/camas/camaIndi32x25.png")));
		lblImgIndi.setBounds(297, 48, 46, 37);
		add(lblImgIndi);
		
		lblImgInfant = new JLabel("");
		lblImgInfant.setIcon(new ImageIcon(RendererHabitacion.class.getResource("/imagenes/alojamiento/camas/camaInfant32x32.png")));
		lblImgInfant.setBounds(383, 48, 39, 37);
		add(lblImgInfant);
		
		lblMatri = new JLabel("0");
		lblMatri.setFont(new Font("Tahoma", Font.ITALIC, 14));
		lblMatri.setBounds(260, 57, 27, 14);
		add(lblMatri);
		
		lblIndi = new JLabel("0");
		lblIndi.setFont(new Font("Tahoma", Font.ITALIC, 14));
		lblIndi.setBounds(346, 57, 27, 14);
		add(lblIndi);
		
		lblInfant = new JLabel("0");
		lblInfant.setFont(new Font("Tahoma", Font.ITALIC, 14));
		lblInfant.setBounds(432, 57, 27, 14);
		add(lblInfant);
	}

	@Override
	public Component getListCellRendererComponent(JList<? extends Dormitorio> lista, Dormitorio dormitorio, int index, boolean isSelected, boolean cellHasFocus) {
		if (dormitorio.isDisponible()) {
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
		
		lblImgMatri.setVisible(false);
		lblImgIndi.setVisible(false);
		lblImgInfant.setVisible(false);
		
		lblMatri.setText("0");
		lblIndi.setText("0");
		lblInfant.setText("0");
		
		lblMatri.setVisible(false);
		lblIndi.setVisible(false);
		lblInfant.setVisible(false);
		
		int contadores[] = {0,0,0};
		for(Mobiliario mob:dormitorio.getMobiliario()) {
			if(mob instanceof Cama) {
				if(((Cama) mob).getTipoCama() == TipoCama.MATRIMONIO) {
					lblImgMatri.setVisible(true);
					lblMatri.setVisible(true);
					contadores[0]+=1;
				}else if(((Cama) mob).getTipoCama() == TipoCama.INDIVIDUAL) {
					lblImgIndi.setVisible(true);
					lblIndi.setVisible(true);
					contadores[1]+=1;
				}else if(((Cama) mob).getTipoCama() == TipoCama.INFANTIL) {
					lblImgInfant.setVisible(true);
					lblInfant.setVisible(true);
					contadores[2]+=1;
				}
			}
		}
		
		lblMatri.setText(String.valueOf(contadores[0]));
		lblIndi.setText(String.valueOf(contadores[1]));
		lblInfant.setText(String.valueOf(contadores[2]));
		
		return this;
	}
}
