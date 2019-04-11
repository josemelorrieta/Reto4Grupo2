package controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import javax.swing.JOptionPane;

import modelo.Localidad;
import modelo.Modelo;
import vista.VentanaPpal;


public class ControladorPanelBuscar{

	private VentanaPpal vis;
	private Controlador controlador;
	private Modelo mod;
	DateFormat formato = new SimpleDateFormat("dd-MM-yyyy");

	public ControladorPanelBuscar(VentanaPpal vis,Controlador cont,Modelo mod){
		this.vis=vis;
		this.controlador=cont;
		this.mod = mod;
		cargarLocalidades();
		establecerFechas();
		vis.pBotones.setBotonesVisible(false);
		initListeners();
	}
	
	private void initListeners() {
		vis.pCenter.pBuscar.btnBuscar.addActionListener(new ListenerBotones());
	}

	public void cargarLocalidades() {
		Localidad[] localidades = mod.mBuscar.buscarLocalidades();
		if(localidades!=null) {
			for(Localidad localidad : localidades)
				vis.pCenter.pBuscar.cbxBuscar.addItem(localidad.getLocalidad());
		} else {
			JOptionPane.showMessageDialog(vis, "Error en la Base de Datos", "Error", JOptionPane.ERROR_MESSAGE);
			vis.dispose();
		}
	}
	
	public void establecerFechas() {
		Calendar calendar = Calendar.getInstance();
		Date hoy = calendar.getTime();
		calendar.add(calendar.DAY_OF_MONTH, 1);
		Date manana = calendar.getTime();
		try {
			vis.pCenter.pBuscar.calenEntrada.setSelectableDateRange(hoy, formato.parse("01-01-2100"));
			vis.pCenter.pBuscar.calenEntrada.setDate(hoy);
			vis.pCenter.pBuscar.calenSalida.setSelectableDateRange(manana, formato.parse("01-01-2100"));
			vis.pCenter.pBuscar.calenSalida.setDate(manana);
		} catch (ParseException e) {
			e.printStackTrace();
		}
	}


	private class ListenerBotones implements ActionListener{
		@Override
		public void actionPerformed(ActionEvent e) {
			mod.mBuscar.cargarHoteles(vis.pCenter.pBuscar.cbxBuscar.getSelectedItem().toString());
			vis.pCenter.pResBusq.setResultBusqueda(mod.hotelesBusqueda);
			vis.pBotones.setBotonesVisible(true);
			vis.pCenter.nextPanel();
		}
	}

}
