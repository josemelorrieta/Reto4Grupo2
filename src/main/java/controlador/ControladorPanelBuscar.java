package controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import javax.swing.JOptionPane;

import modelo.Casa;
import modelo.Dormitorio;
import modelo.Hotel;
import modelo.Modelo;
import util.FuncionesGenerales;
import vista.VentanaPpal;
import vista.panelCard.PanelResBusqueda;

public class ControladorPanelBuscar {

	private VentanaPpal vis;
	private Controlador controlador;
	private Modelo mod;
	DateFormat formato = new SimpleDateFormat("dd-MM-yyyy");
	Calendar calendar = Calendar.getInstance();
	Date hoy = calendar.getTime();

	public ControladorPanelBuscar(VentanaPpal vis, Controlador cont, Modelo mod) {
		this.vis = vis;
		this.controlador = cont;
		this.mod = mod;
		cargarLocalidades();
		fechaHoy();
		cambioFechaEnt(hoy);
		vis.pBotones.setBotonesVisible(false);
		initListeners();
	}

	private void initListeners() {
		vis.pCenter.pBuscar.btnBuscar.addActionListener(new ListenerBotones());
		vis.pCenter.pBuscar.calenEntrada.addPropertyChangeListener(new ListenerFechaEnt());
	}

	public void cargarLocalidades() {
		String[] localidades = mod.mBuscar.buscarLocalidades();
		if (localidades != null) {
			for (String localidad : localidades)
				vis.pCenter.pBuscar.cbxBuscar.addItem(localidad);
		} else {
			JOptionPane.showMessageDialog(vis, "Error en la Base de Datos", "Error", JOptionPane.ERROR_MESSAGE);
			vis.dispose();
		}
	}

	public void fechaHoy() {
		mod.reserva.setFechaReserva(hoy);
		calendar.add(Calendar.DAY_OF_MONTH, 1);
		Date manana = calendar.getTime();
		try {
			vis.pCenter.pBuscar.calenEntrada.setSelectableDateRange(hoy, formato.parse("01-01-2100"));
			vis.pCenter.pBuscar.calenSalida.setSelectableDateRange(manana, formato.parse("01-01-2100"));
		} catch (ParseException e) {
			e.printStackTrace();
		}
		vis.pCenter.pBuscar.calenEntrada.setDate(hoy);
		vis.pCenter.pBuscar.calenSalida.setDate(manana);
	}

	public void cambioFechaEnt(Date fechaEntrada) {
		calendar.setTime(fechaEntrada);
		calendar.add(Calendar.DAY_OF_MONTH, 1);
		Date manana = calendar.getTime();

		if (fechaEntrada.compareTo(vis.pCenter.pBuscar.calenSalida.getDate()) >= 0) {
			vis.pCenter.pBuscar.calenSalida.setDate(manana);
		}
		try {
			vis.pCenter.pBuscar.calenSalida.setSelectableDateRange(manana, formato.parse("01-01-2100"));
		} catch (ParseException e) {
			e.printStackTrace();
		}
	}

	private class ListenerBotones implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent e) {
			mod.reserva.setFechaEntrada(vis.pCenter.pBuscar.calenEntrada.getDate());
			mod.reserva.setFechaSalida(vis.pCenter.pBuscar.calenSalida.getDate());
			mod.mBuscar.cargarAlojamientos(vis.pCenter.pBuscar.cbxBuscar.getSelectedItem().toString());
			setResultBusqueda(mod.hotelesBusqueda, vis.pCenter.pResBusq, mod.tiposDorm);
			setResultBusqueda(mod.casasBusqueda, vis.pCenter.pResBusq);
			setResultBusqueda(mod.apartBusqueda, vis.pCenter.pResBusq);
			vis.pCenter.pResBusq.resultBusq.ensureIndexIsVisible(0);
			vis.pBotones.setBotonesVisible(true);
			vis.pCenter.nextPanel();
		}
	}

	private class ListenerFechaEnt implements PropertyChangeListener {
		@Override
		public void propertyChange(PropertyChangeEvent e) {
			Date fechaEntrada = vis.pCenter.pBuscar.calenEntrada.getDate();
			cambioFechaEnt(fechaEntrada);
		}

	}

	public void setResultBusqueda(Hotel[] hoteles, PanelResBusqueda panel, Dormitorio[] tiposDorm) {
		panel.modelResBusq.clear();
		for (Hotel hotel : hoteles) {
			for (int i = 0; i < hotel.getMatrix().size(); i++) {
				if(hotel.getMatrix().get(i)==null) continue;
				for (int f = 0; f < hotel.getMatrix().get(i).size(); f++) {
					hotel.getMatrix().get(i).get(f).setMobiliario(FuncionesGenerales.concatenate(hotel.getMatrix().get(i).get(f).getMobiliario(), tiposDorm[i].getMobiliario()));
				}
			}
			panel.modelResBusq.addElement(hotel);
		}
		panel.lblLocBusq.setText("Resultados para " + hoteles[0].getDireccion().getLocalidad());
	}

	public void setResultBusqueda(Casa[] casas, PanelResBusqueda panel) {
		for (Casa casa : casas) {
			panel.modelResBusq.addElement(casa);
		}
		panel.lblLocBusq.setText("Resultados para " + casas[0].getDireccion().getLocalidad());
	}

}
