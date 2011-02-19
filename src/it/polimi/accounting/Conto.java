package it.polimi.accounting;

import java.math.BigDecimal;

public abstract class Conto {
	
	protected Integer id;
	protected String nome;
	protected BigDecimal saldo;

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

	public Transazione trasferisciA(Conto contoA, BigDecimal importo) {
		if(contoA instanceof ContoAttivo){
			ContoAttivo attivo= (ContoAttivo) contoA;
			return this.trasferisciA(attivo, importo);
			
		}
		if(contoA instanceof ContoUscite){
			ContoUscite uscite= (ContoUscite) contoA;
			return this.trasferisciA(uscite, importo);
		
		}
		throw new RuntimeException("Il conto di arrico  non appartiene a nessun tipo valido ");
		
		
	}
	
	public abstract Transazione trasferisciA(ContoAttivo contoA, BigDecimal importo) ;
		



	public abstract Transazione trasferisciA(ContoUscite contoA, BigDecimal importo);


}
