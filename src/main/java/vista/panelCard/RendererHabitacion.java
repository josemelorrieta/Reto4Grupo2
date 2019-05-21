package vista.panelCard;

import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Font;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.ListCellRenderer;
import javax.swing.border.BevelBorder;
import javax.swing.border.LineBorder;

import modelo.Cama;
import modelo.Dormitorio;
import modelo.Mobiliario;
import modelo.TipoCama;

public class RendererHabitacion extends JPanel implements ListCellRenderer<Dormitorio>{

	private static final long serialVersionUID = 1L;
	public JLabel lblFondo, lblFoto,lblNombre,lblCamas, lblDisponible;
	private JLabel lblPersona1;
	private JLabel lblPersona2;
	private JLabel lblPersona3;
	private JLabel lblNino;
	
	private File archImagen; 
	
	
	public RendererHabitacion() {
		setBackground(Color.WHITE);
		setParametros();
		instanciarObjetos();
	}

	private void setParametros() {
		setBorder(null);
		setPreferredSize(new Dimension(570, 155));
		setLayout(null);;
	}

	private void instanciarObjetos() {
		
		lblFoto = new JLabel("");
		lblFoto.setIcon(new ImageIcon(ItemResBusqueda.class.getResource("/imagenes/alojamiento/noimage.png")));
		lblFoto.setBounds(10, 10, 130, 130);
		add(lblFoto);
		
		lblNombre = new JLabel("Nombre Dormitorio");
		lblNombre.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblNombre.setBounds(170, 7, 368, 30);
		add(lblNombre);
		
		lblCamas = new JLabel("Camas:");
		lblCamas.setFont(new Font("Tahoma", Font.ITALIC, 14));
		lblCamas.setBounds(170, 38, 366, 20);
		add(lblCamas);
		
		lblDisponible = new JLabel("Disponible");
		lblDisponible.setForeground(new Color(50, 205, 50));
		lblDisponible.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 14));
		lblDisponible.setBounds(170, 108, 100, 20);
		add(lblDisponible);
		
		lblPersona1 = new JLabel("");
		lblPersona1.setIcon(new ImageIcon(RendererHabitacion.class.getResource("/imagenes/alojamiento/hotel/persona.png")));
		lblPersona1.setBounds(170, 65, 24, 24);
		add(lblPersona1);
		
		lblPersona2 = new JLabel("");
		lblPersona2.setIcon(new ImageIcon(RendererHabitacion.class.getResource("/imagenes/alojamiento/hotel/persona.png")));
		lblPersona2.setBounds(190, 65, 24, 24);
		add(lblPersona2);
		
		lblPersona3 = new JLabel("");
		lblPersona3.setIcon(new ImageIcon(RendererHabitacion.class.getResource("/imagenes/alojamiento/hotel/persona.png")));
		lblPersona3.setBounds(210, 65, 24, 24);
		add(lblPersona3);
		
		lblNino = new JLabel("");
		lblNino.setIcon(new ImageIcon(RendererHabitacion.class.getResource("/imagenes/alojamiento/hotel/nino.png")));
		lblNino.setBounds(235, 65, 24, 24);
		add(lblNino);
		lblFondo = new JLabel("");
		lblFondo.setBackground(Color.WHITE);
		lblFondo.setBorder(new LineBorder(Color.LIGHT_GRAY, 1, true));
		lblFondo.setBounds(0, 0, 570, 150);
		add(lblFondo);
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
		
		JLabel[] personas = {lblPersona1, lblPersona2, lblPersona3};
		
		lblPersona1.setVisible(false);
		lblPersona2.setVisible(false);
		lblPersona3.setVisible(false);
		lblNino.setVisible(false);
		
		int contadores[] = {0,0,0};
		int adultos = 0;
		int ninos = 0;
		for(Mobiliario mob:dormitorio.getMobiliario()) {
			if(mob instanceof Cama) {
				if(((Cama) mob).getTipoCama() == TipoCama.MATRIMONIO) {
					adultos += 2;
					contadores[0] += 1;
				}else if(((Cama) mob).getTipoCama() == TipoCama.INDIVIDUAL) {
					adultos += 1;
					contadores[1]+=1;
				}else if(((Cama) mob).getTipoCama() == TipoCama.INFANTIL) {
					ninos += 1;
					contadores[2]+=1;
				}
			}
		}

		int posicion = 170;
		for (int i=0;i<adultos;i++) {
			personas[i].setVisible(true);
			personas[i].setBounds(posicion, 65, 24, 24);
			posicion += 20;
		}
		
		if (ninos == 1) {
			posicion += 5;
			lblNino.setVisible(true);
			lblNino.setBounds(posicion, 65, 24, 24);
		}

		
		if (contadores[0] == 1 && contadores[1] == 0 && contadores[2] == 0 ) {
			lblNombre.setText("Habitación Matrimonio");
			archImagen = new File(getClass().getResource("/imagenes/alojamiento/hotel/hab_matrimonio.jpg").getPath());
		}
		if (contadores[0] == 0 && contadores[1] == 1 && contadores[2] == 0 ) {
			lblNombre.setText("Habitación Individual");
			archImagen = new File(getClass().getResource("/imagenes/alojamiento/hotel/hab_individual.jpg").getPath());
		}
		if (contadores[0] == 0 && contadores[1] == 2 && contadores[2] == 0 ) {
			lblNombre.setText("Habitación Doble");
			archImagen = new File(getClass().getResource("/imagenes/alojamiento/hotel/hab_doble.jpg").getPath());
		}
		if (contadores[0] == 1 && contadores[1] == 1 && contadores[2] == 0 ) {
			lblNombre.setText("Habitación Triple");
			archImagen = new File(getClass().getResource("/imagenes/alojamiento/hotel/hab_triple.jpg").getPath());
		}
		if (contadores[0] == 1 && contadores[1] == 0 && contadores[2] == 1 ) {
			lblNombre.setText("Habitación Triple Infantil");
			archImagen = new File(getClass().getResource("/imagenes/alojamiento/hotel/hab_cuna.jpg").getPath());
		}
		
		try {
			lblFoto.setIcon(new ImageIcon(ImageIO.read(archImagen)));
		} catch (IOException e) {
			e.printStackTrace();
		}
		int camas = contadores[0] + contadores[1] + contadores[2];
		lblCamas.setText("Camas:  " + camas);

		
		return this;
	}
}
