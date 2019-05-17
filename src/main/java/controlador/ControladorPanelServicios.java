package controlador;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JLabel;

import modelo.Alojamiento;
import modelo.Hotel;
import modelo.Modelo;
import modelo.Servicio;
import vista.VentanaPpal;

public class ControladorPanelServicios {
	
	private VentanaPpal vis;
	private Modelo mod;
	private Controlador cont;
	
	private JLabel[] servicios = new JLabel[11]; 
	private Servicio[] serviciosAloj;
	
	public ControladorPanelServicios(VentanaPpal vis, Controlador cont, Modelo mod) {
		this.vis = vis;
		this.cont = cont;
		this.mod = mod;
		inicializar();
		initListeners();
	}
	
	private void inicializar() {
		servicios[0] = vis.pCenter.pSelServ.lblWifi;
		servicios[1] = vis.pCenter.pSelServ.lblPiscina;
		servicios[2] = vis.pCenter.pSelServ.lblSpa;
		servicios[3] = vis.pCenter.pSelServ.lblParking;
		servicios[4] = vis.pCenter.pSelServ.lblAC;
		servicios[5] = vis.pCenter.pSelServ.lblRestaurante;
		servicios[6] = vis.pCenter.pSelServ.lblBar;
		servicios[7] = vis.pCenter.pSelServ.lblGym;
		servicios[8] = vis.pCenter.pSelServ.lblAd;
		servicios[9] = vis.pCenter.pSelServ.lblMp;
		servicios[10] = vis.pCenter.pSelServ.lblPc;
		
//		serviciosAloj = mod.reserva.getAlojReservado().getServicios();
	}
	private void initListeners() {
//		for (int i=0;) {
//			if(mod.reserva.getAlojReservado().getServicios())
//			servicio.addMouseListener(new ListenerMouse());
//		}
	}
	
	private class ListenerMouse implements MouseListener {

		@Override
		public void mouseClicked(MouseEvent e) {
			JLabel trigger = (JLabel) e.getSource();
			if (trigger.isEnabled())
				trigger.setEnabled(false);
			else
				trigger.setEnabled(true);
		}

		@Override
		public void mouseEntered(MouseEvent arg0) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void mouseExited(MouseEvent arg0) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void mousePressed(MouseEvent arg0) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void mouseReleased(MouseEvent arg0) {
			// TODO Auto-generated method stub
			
		}
		
	}
	
	public void inicializarDatosAloj() {
		Alojamiento aloj = mod.reserva.getAlojReservado();
		
		vis.pCenter.pSelServ.lblNombre.setText(aloj.getNombre());
		vis.pCenter.pSelServ.lblDireccion.setText(aloj.getDireccion().getCalle() + " " + aloj.getDireccion().getLocalidad());
		
		if (aloj instanceof Hotel) {
			ImageIcon estrellas = null;
			try {
				estrellas = new ImageIcon(ImageIO.read(new File(getClass()
						.getResource(
								"/imagenes/alojamiento/hotel/estrellas" + ((Hotel) aloj).getNumEstrellas() + ".png")
						.getPath())));
			} catch (IOException e) {
				e.printStackTrace();
			}
			vis.pCenter.pSelServ.lblEstrellas.setIcon(estrellas);
			vis.pCenter.pSelServ.lblEstrellas.setVisible(true);
		} else {
			vis.pCenter.pSelServ.lblEstrellas.setVisible(false);
		}
		
		String foto = aloj.getImagen();

		ImageIcon imagen = null;
		File archImagen;
		if (!foto.equals("")) {
			if (aloj instanceof Hotel) {
				archImagen = new File(getClass().getResource("/imagenes/alojamiento/hotel/" + foto + ".jpg").getPath());
			} else
				archImagen = new File(
						getClass().getResource("/imagenes/alojamiento/noHotel/" + foto + ".jpg").getPath());
		} else
			archImagen = new File(getClass().getResource("/imagenes/alojamiento/noimage.png").getPath());

		try {
			imagen = new ImageIcon(ImageIO.read(archImagen));
		} catch (IOException e) {
			e.printStackTrace();
		}

		vis.pCenter.pSelServ.lblImagen.setIcon(imagen);
	}
	
	public void inicializarServicios() {
		
		JLabel[] serviciostxt = {vis.pCenter.pSelServ.lblWifitxt, vis.pCenter.pSelServ.lblPiscinatxt, vis.pCenter.pSelServ.lblSpatxt, vis.pCenter.pSelServ.lblParkingtxt, vis.pCenter.pSelServ.lblACtxt,
				vis.pCenter.pSelServ.lblRestaurantetxt, vis.pCenter.pSelServ.lblBartxt, vis.pCenter.pSelServ.lblGymtxt, vis.pCenter.pSelServ.lblAdtxt, vis.pCenter.pSelServ.lblMptxt, vis.pCenter.pSelServ.lblPctxt};
		int posicion = 70;
		for (int i = 0; i < mod.reserva.getAlojReservado().getServicios().length; i++) {
			if (mod.reserva.getAlojReservado().getServicios()[i] == Servicio.incluido) {
				servicios[i].setVisible(true);
				servicios[i].setEnabled(true);
				servicios[i].setBounds(327, posicion, 16, 16);
				serviciostxt[i].setVisible(true);
				serviciostxt[i].setBounds(361, posicion, 200, 16);
				posicion += 30;
			} else if (mod.reserva.getAlojReservado().getServicios()[i] == Servicio.noIncluido) {
				servicios[i].setVisible(true);
				servicios[i].setEnabled(false);
				servicios[i].setBounds(327, posicion, 16, 16);
				serviciostxt[i].setVisible(true);
				serviciostxt[i].setBounds(361, posicion, 200, 16);
				posicion += 30;
			} else if (mod.reserva.getAlojReservado().getServicios()[i] == Servicio.noDisponible) {
				servicios[i].setVisible(false);
				serviciostxt[i].setVisible(false);
				
			}
		}
	}
}
