package controlador;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.File;
import java.io.IOException;
import java.text.NumberFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import javax.imageio.ImageIO;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JLabel;

import modelo.Alojamiento;
import modelo.Hotel;
import modelo.Modelo;
import modelo.Servicio;
import modelo.TipoServicio;
import util.FuncionesGenerales;
import vista.VentanaPpal;

/**
 * Controlador para el panel de servicios
 *
 */
public class ControladorPanelServicios {
	
	private VentanaPpal vis;
	private Modelo mod;
	
	private JLabel[] servicios;
	private JLabel[] serviciostxt;
	private JLabel[] preciosSrv;
	private Servicio[] serviciosAloj;
	
//	private ListenerMouse lm = new ListenerMouse();
	
	double precioExtras;
	
	NumberFormat moneda = NumberFormat.getCurrencyInstance();
	SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
	
	/**
	 * Constructor para el controlador
	 * @param mod Modelo donde se guarda la informacion
	 * @param vis Vista la cual edita
	 */
	public ControladorPanelServicios(VentanaPpal vis, Modelo mod) {
		this.vis = vis;
		this.mod = mod;
		
		this.servicios = vis.pCenter.pSelServ.servicios;
		this.serviciostxt = vis.pCenter.pSelServ.serviciostxt;
		this.preciosSrv = vis.pCenter.pSelServ.preciosSrv;
			
		initListeners();
	}

	/**
	 * Aniade listeners a los JLabels
	 */
	private void initListeners() {		
		for(JLabel servicio : servicios) 
			servicio.addMouseListener(new ListenerMouse());
	}
	
	/**
	 * Listener para los labels de servicios
	 *
	 */
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
	
	/**
	 * Inicializa los datos del alojamiento
	 */
	public void inicializarDatosAloj() {
		Alojamiento aloj = mod.reserva.getAlojReservado();
		
		vis.pCenter.pSelServ.lblNombre.setText(aloj.getNombre());
		vis.pCenter.pSelServ.lblDireccion.setText(aloj.getDireccion().getCalle() + " " + aloj.getDireccion().getLocalidad());
		vis.pCenter.pSelServ.lblFechaEntrada.setText(sdf.format(mod.reserva.getFechaEntrada()));
		vis.pCenter.pSelServ.lblFechaSalida.setText(sdf.format(mod.reserva.getFechaSalida()));
		
		java.net.URL url = null;
		Icon imagen = null;
		if (aloj instanceof Hotel) {
			url = getClass().getResource("/imagenes/alojamiento/hotel/estrellas" + ((Hotel) aloj).getNumEstrellas() + ".png");
			imagen = new ImageIcon(url);
			vis.pCenter.pSelServ.lblEstrellas.setIcon(imagen);
			vis.pCenter.pSelServ.lblEstrellas.setVisible(true);
		} else {
			vis.pCenter.pSelServ.lblEstrellas.setVisible(false);
		}
		
		String foto = aloj.getImagen();

		if (!foto.equals("")) {
			if (aloj instanceof Hotel) {
				url = getClass().getResource("/imagenes/alojamiento/hotel/" + foto + "_srv.jpg");
			} else
				url = getClass().getResource("/imagenes/alojamiento/noHotel/" + foto + "_srv.jpg");
		} else
			url = getClass().getResource("/imagenes/alojamiento/noimage.png");

		imagen = new ImageIcon(url);
		vis.pCenter.pSelServ.lblImagen.setIcon(imagen);
		inicializarServicios();
	}
	
	/**
	 * Comprueba las disponibilidades de los servicios
	 */
	public void inicializarServicios() {
			
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
				preciosSrv[i].setText(moneda.format(0));
			}
		}
		precioExtras = 0;
		vis.pCenter.pSelServ.lblTotal.setText(moneda.format(precioExtras));
	}
	
	/**
	 * Devuelve el indice del servicio seleccionado
	 * @param label servicio elegido
	 * @return el indice del servicio elegido, -1 en caso de no encontrar el servicio especificado
	 */
	public int buscarPosicionSrv(JLabel label) {
		for (int i=0;i<servicios.length;i++) {
			if (label == servicios[i])
				return i;
		}
		return -1;
	}
	
	/**
	 * Calcula el precio de todos los servicios seleccionado
	 * @return precio de los servicios
	 */
	public double calcularPrecioExtras() {
		precioExtras = 0;
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
