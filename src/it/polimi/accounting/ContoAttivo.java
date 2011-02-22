package it.polimi.accounting;

import java.math.BigDecimal;

public class ContoAttivo extends Conto {
	
	public ContoAttivo(Integer id, String nome, BigDecimal saldo) {
		super(id, nome, saldo);
		
	}

	

	public Transazione trasferisciA(ContoAttivo contoA, BigDecimal importo) {
		this.saldo = this.saldo.subtract(importo);
		contoA.saldo = contoA.saldo.add(importo);
		Transazione t=new Transazione(this.id, contoA.id, importo);
		return t;
	}



	public Transazione trasferisciA(ContoUscite contoA, BigDecimal importo) {
		contoA.saldo=contoA.saldo.add(importo);
		this.saldo=this.saldo.subtract(importo);
		return null;
				
	}
}
