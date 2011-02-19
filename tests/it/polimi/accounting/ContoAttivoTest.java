package it.polimi.accounting;

import static org.junit.Assert.*;

import java.math.BigDecimal;

import org.junit.Test;


public class ContoAttivoTest {
	@Test
	public void conservaIPropriDati() {
		ContoAttivo conto = new ContoAttivo(3,"portafoglio", new BigDecimal("300"));
		assertEquals(3,(int) conto.getId());
		
	}
	
	@Test
	public void effettuaTransazioneSuUnAltroContoDiAttivo() {
		ContoAttivo contoDa = new ContoAttivo (1, null, new BigDecimal("1000"));
		ContoAttivo contoA = new ContoAttivo(2,null, new BigDecimal("2000"));
		Transazione t=contoDa.trasferisciA(contoA, new BigDecimal("200"));
		assertEquals(new BigDecimal("800"), contoDa.getSaldo());
		assertEquals(new BigDecimal("2200"), contoA.getSaldo());
		assertEquals(new BigDecimal("200"), t.getImporto());
		assertEquals(1,t.getContoDa());
		assertEquals(2,t.getContoA());

		
}
	
	@Test
	public void effettuaTransazioneSuUnContoDiUscite() {
		ContoAttivo contoDa = new ContoAttivo (null, null, new BigDecimal("1000"));
		ContoUscite contoA = new ContoUscite(null,null, new BigDecimal("2000"));
		contoDa.trasferisciA(contoA, new BigDecimal("200"));
		assertEquals(new BigDecimal("800"), contoDa.getSaldo());
		assertEquals(new BigDecimal("2200"), contoA.getSaldo());
}
}	
	