package it.polimi.accounting;

import static org.junit.Assert.*;

import java.math.BigDecimal;

import org.junit.Test;


public class ContoTest {
	@Test
	public void conservaIPropriDati() {
		Conto conto = new Conto(3,"portafoglio", new BigDecimal("300"));
		assertEquals(3,(int) conto.getId());
		
	}
	@Test
	public void effettuaTransazioneConUnAltroContoDiAttivo() {
		Conto contoDa = new Conto (null, null, new BigDecimal("1000"));
		Conto contoA = new Conto(null,null, new BigDecimal("2000"));
		contoA.trasferisciDa(contoDa, new BigDecimal("200"));
		assertEquals(new BigDecimal("800"), contoDa.getSaldo());
		assertEquals(new BigDecimal("2200"), contoA.getSaldo());

	}
}
	