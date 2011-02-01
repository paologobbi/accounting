package it.polimi.accounting;

import java.math.BigDecimal;

public class Transazione {
	
		private int id;
		private int conto_da;
		private int conto_a;
		private BigDecimal importo;
		private String causale;
		private String data;
		

		public Transazione(int id, int conto_da, int conto_a, BigDecimal importo, String causale,String data){
			this.id =id;
			this.conto_da=conto_da;
			this.conto_a=conto_a;
			this.importo=importo;
			this.causale=causale;
			this.data=data;
			
			
		}


		public Integer getId() {
			return id;
		}


		public Integer getConto_da() {
			return conto_da;
		}


		public Integer getConto_a() {
			return conto_a;
		}


		public BigDecimal getImporto() {
			return importo;
		}


		public String getCausale() {
			return causale;
		}


		public String getData() {
			return data;
		}

}
