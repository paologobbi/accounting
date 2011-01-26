package it.polimi.accounting;

import java.math.BigDecimal;

public class Conto {
	private Integer id;
	private String nome;
	private BigDecimal saldo;

	public Conto(Integer id,String nome, BigDecimal saldo){
		this.id =id;
		this.nome=nome;
		this.saldo=saldo;
		
		
	}

	public Integer getId() {
		return id;
	}

	public String getNome() {
		return nome;
	}

	public BigDecimal getSaldo() {
		return saldo;
	}

	public void trasferisciDa(Conto contoDa, BigDecimal importo) {
		contoDa.saldo = contoDa.saldo.subtract(importo);
		this.saldo = this.saldo.add(importo);
	
		
	}

	public void trasferisciA(Conto contoA, BigDecimal importo) {
		this.saldo = this.saldo.subtract(importo);
		contoA.saldo = contoA.saldo.add(importo);

	}
}
