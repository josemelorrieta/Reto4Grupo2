package controlador;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.File;
import java.io.IOException;
import java.text.NumberFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JLabel;

import modelo.Alojamiento;
import modelo.Hotel;
import modelo.Modelo;
import modelo.Servicio;
import modelo.TipoServicio;
import vista.VentanaPpal;

public class ControladorPanelServicios {
	
	private VentanaPpal vis;
	private Modelo mod;
	
	private JLabel[] servicios = new JLabel[11];
	private JLabel[] preciosSrv = new JLabel[11];
	private Servicio[] serviciosAloj;
	
	private ListenerMouse lm = new ListenerMouse();
	
	NumberFormat moneda = NumberFormat.getCurrencyInstance();
	SimpleDateFormat sdf = new SimpleDateFormat("dd-mm-YYYY");
	
	public ControladorPanelServicios(VentanaPpal vis, Modelo mod) {
		this.vis = vis;
		this.mod = mod;
		
		inicializar();
	}
	
	public void inicializar() {
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
		
		preciosSrv[0] = vis.pCenter.pSelServ.lblWifiprec;
		preciosSrv[1] = vis.pCenter.pSelServ.lblPiscinaprec;
		preciosSrv[2] = vis.pCenter.pSelServ.lblSpaprec;
		preciosSrv[3] = vis.pCenter.pSelServ.lblParkingprec;
		preciosSrv[4] = vis.pCenter.pSelServ.lblACprec;
		preciosSrv[5] = vis.pCenter.pSelServ.lblRestauranteprec;
		preciosSrv[6] = vis.pCenter.pSelServ.lblBarprec;
		preciosSrv[7] = vis.pCenter.pSelServ.lblGymprec;
		preciosSrv[8] = vis.pCenter.pSelServ.lblAdprec;
		preciosSrv[9] = vis.pCenter.pSelServ.lblMpprec;
		preciosSrv[10] = vis.pCenter.pSelServ.lblPcprec;

	}
	
	private void initListeners() {		
		for(JLabel servicio : servicios) 
			servicio.addMouseListener(new ListenerMouse());
	}
	
	private class ListenerMouse implements MouseListener {

		@Override
		public void mouseClicked(MouseEvent e) {
			serviciosAloj = mod.reserva.getAlojReservado().getServicios();
			JLabel trigger = (JLabel) e.getSource();
			int posicion = buscarPosicionSrv(trigger);
			if (!preciosSrv[posicion].getText().equals("Incluido")) {
				if (trigger.isEnabled()) {
					trigger.setEnabled(false);
					preciosSrv[posicion].setText(moneda.format(0));
				} else {
					trigger.setEnabled(true);
					preciosSrv[posicion].setText(moneda.format(serviciosAloj[posicion].getPrecio()));
					if(servicios[posicion].getText().equals("MP")) {
						servicios[posicion + 1].setEnabled(false);
						preciosSrv[posicion + 1].setText(moneda.format(0));
					}
					if(servicios[posicion].getText().equals("PC")) {
						servicios[posicion - 1].setEnabled(false);
						preciosSrv[posicion - 1].setText(moneda.format(0));
					}
				}
				vis.pCenter.pSelServ.lblTotal.setText(moneda.format(calcularPrecioExtras()));
			}
		}

		@Override
		public void mouseEntered(MouseEvent arg0) {
			
		}

		@Override
		public void mouseExited(MouseEvent arg0) {
			
		}

		@Override
		public void mousePressed(MouseEvent arg0) {
			
		}

		@Override
		public void mouseReleased(MouseEvent arg0) {
			
		}
		
	}
	
	public void inicializarDatosAloj() {
		Alojamiento aloj = mod.reserva.getAlojReservado();
		
		vis.pCenter.pSelServ.lblNombre.setText(aloj.getNombre());
		vis.pCenter.pSelServ.lblDireccion.setText(aloj.getDireccion().getCalle() + " " + aloj.getDireccion().getLocalidad());
		vis.pCenter.pSelServ.lblFechaEntrada.setText(sdf.format(mod.reserva.getFechaEntrada()));
		vis.pCenter.pSelServ.lblFechaSalida.setText(sdf.format(mod.reserva.getFechaSalida()));
		
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
				archImagen = new File(getClass().getResource("/imagenes/alojamiento/hotel/" + foto + "_srv.jpg").getPath());
			} else
				archImagen = new File(
						getClass().getResource("/imagenes/alojamiento/noHotel/" + foto + "_srv.jpg").getPath());
		} else
			archImagen = new File(getClass().getResource("/imagenes/alojamiento/noimage.png").getPath());

		try {
			imagen = new ImageIcon(ImageIO.read(archImagen));
		} catch (IOException e) {
			e.printStackTrace();
		}

		vis.pCenter.pSelServ.lblImagen.setIcon(imagen);
		inicializarServicios();		
		initListeners();
	}
	
	public void inicializarServicios() {
		
		JLabel[] serviciostxt = {vis.pCenter.pSelServ.lblWifitxt, vis.pCenter.pSelServ.lblPiscinatxt, vis.pCenter.pSelServ.lblSpatxt, vis.pCenter.pSelServ.lblParkingtxt, vis.pCenter.pSelServ.lblACtxt,
				vis.pCenter.pSelServ.lblRestaurantetxt, vis.pCenter.pSelServ.lblBartxt, vis.pCenter.pSelServ.lblGymtxt, vis.pCenter.pSelServ.lblAdtxt, vis.pCenter.pSelServ.lblMptxt, vis.pCenter.pSelServ.lblPctxt};
		
		int posicion = 140;
		for (int i = 0; i < mod.reserva.getAlojReservado().getServicios().length; i++) {
			if (mod.reserva.getAlojReservado().getServicios()[i].getTipo() == TipoServicio.incluido) {
				servicios[i].setVisible(true);
				servicios[i].setEnabled(true);
				servicios[i].setBounds(566, posicion, 16, 16);
				serviciostxt[i].setVisible(true);
				serviciostxt[i].setBounds(600, posicion - 2, 200, 18);
				preciosSrv[i].setText("Incluido");
				preciosSrv[i].setBounds(799, posicion - 2, 70, 18);
				preciosSrv[i].setVisible(true);
				posicion += 30;
			} else if (mod.reserva.getAlojReservado().getServicios()[i].getTipo() == TipoServicio.noIncluido) {
				servicios[i].setVisible(true);
				servicios[i].setEnabled(false);
				servicios[i].setBounds(566, posicion, 16, 16);
				serviciostxt[i].setVisible(true);
				serviciostxt[i].setBounds(600, posicion, 200, 18);
				preciosSrv[i].setText(moneda.format(0));
				preciosSrv[i].setBounds(799, posicion - 2, 70, 18);
				preciosSrv[i].setVisible(true);
				posicion += 30;
			} else if (mod.reserva.getAlojReservado().getServicios()[i].getTipo() == TipoServicio.noDisponible) {
				servicios[i].setVisible(false);
				serviciostxt[i].setVisible(false);
				preciosSrv[i].setVisible(false);
			}
		}
		vis.pCenter.pSelServ.lblTotal.setText(moneda.format(0));
	}
	
	public int buscarPosicionSrv(JLabel label) {
		for (int i=0;i<servicios.length;i++) {
			if (label == servicios[i])
				return i;
		}
		
		return -1;
	}
	
	public double calcularPrecioExtras() {
		double precioExtras = 0;
		double precio = 0;
		for (JLabel precioSrv : preciosSrv) {
			if (!precioSrv.getText().equals("Incluido")) {
				try {
					precio = (moneda.parse(precioSrv.getText())).doubleValue();
				} catch (ParseException e) {
					precio = 0;
				}
				if (precio > 0)
					precioExtras = precioExtras + precio;
			}
		}
		return precioExtras;
	}
}
