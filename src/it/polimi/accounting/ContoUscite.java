package it.polimi.accounting;

import java.math.BigDecimal;

public class ContoUscite extends Conto {

	public ContoUscite(Integer id, String nome, BigDecimal saldo) {
		super(id, nome, saldo);
	}

	@Override
	public Transazione trasferisciA(ContoAttivo contoA, BigDecimal importo) {
		throw new RuntimeException("Operazione non supportata");

		
	}

	@Override
	public Transazione trasferisciA(ContoUscite contoA, BigDecimal importo) {
		//throw new RuntimeException("Operazione non supportata");
		contoA.saldo=contoA.saldo.add(importo);
		this.saldo=this.saldo.subtract(importo);
		return null;
		
	}

}
