package testUtil;

import static org.junit.Assert.*;

import org.junit.Test;

import modelo.Alojamiento;
import modelo.Apartamento;
import modelo.Casa;
import modelo.Dormitorio;
import modelo.Hotel;
import util.FuncionesGenerales;

public class TestFuncionesGenerales {

	@Test
	public void testTipoAlojamiento() {
		Alojamiento alojTest=new Alojamiento();
		Casa casaTest= new Casa();
		Hotel hotelTest=new Hotel();
		Apartamento apartamentoTest=new Apartamento();
		assertEquals(FuncionesGenerales.tipoAloj(alojTest), "");
		assertEquals(FuncionesGenerales.tipoAloj(casaTest), "Casa");
		assertEquals(FuncionesGenerales.tipoAloj(hotelTest), "Hab");
		assertEquals(FuncionesGenerales.tipoAloj(apartamentoTest), "Apart");
	}

	@Test
	public void testConcatenate() {
		Alojamiento hotelTest=new Hotel();
		Alojamiento[] arrayHotelTest= {hotelTest};
		
		Casa casaTest=new Casa();
		Apartamento apartamentoTest=new Apartamento();
		Casa[] arrayCasaTest= {casaTest,apartamentoTest};
		
		Object[] resultadoEsperado= {hotelTest,casaTest,apartamentoTest};
		
		assertArrayEquals(FuncionesGenerales.concatenate(arrayHotelTest, arrayCasaTest), resultadoEsperado);
	}
}
