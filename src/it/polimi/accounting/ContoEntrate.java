package it.polimi.accounting;

import java.math.BigDecimal;

public class ContoEntrate extends Conto{

	
	public ContoEntrate(Integer id, String nome, BigDecimal saldo) {
		super(id, nome, saldo);
	}

	

	public Transazione trasferisciA(ContoAttivo contoA, BigDecimal importo) {
		
		contoA.saldo=contoA.saldo.add(importo);
		this.saldo=this.saldo.add(importo);
		return null;
		
	}



	@Override
	public Transazione trasferisciA(ContoUscite contoA, BigDecimal importo) {
		throw new RuntimeException("Operazione non supportata");
		
	}

	

}
