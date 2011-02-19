package it.polimi.accounting;

import static org.junit.Assert.assertEquals;

import java.math.BigDecimal;

import org.junit.Test;


public class ContoEntrateTest {
	
	@Test
	public void effettuaTransazioneAUnContoDiAttivo() {
		ContoAttivo contoA = new ContoAttivo (null, null, new BigDecimal("1000"));
		ContoEntrate contoDa = new ContoEntrate(null,null,new BigDecimal("100"));
		contoDa.trasferisciA(contoA, new BigDecimal("200"));
		assertEquals(new BigDecimal("1200"), contoA.getSaldo());
		assertEquals(new BigDecimal("300"), contoDa.getSaldo());
		

	}

}
