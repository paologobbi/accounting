package it.polimi.accounting;

import java.math.BigDecimal;

public class Transazione {
	
		private int id;
		private int conto_da;
		private int conto_a;
		private BigDecimal importo;
		private String causale;
		private String data;
		private String conto_daNome;
		private String conto_aNome;

		public Transazione(int id, int conto_da,String conto_daNome, int conto_a, String conto_aNome, BigDecimal importo, String causale,String data){
			this.id =id;
			this.conto_da=conto_da;
			this.conto_a=conto_a;
			this.importo=importo;
			this.causale=causale;
			this.data=data;
			this.conto_daNome=conto_daNome;
			this.conto_aNome=conto_aNome;
			
			
		}


		


		public String getContoDaNome() {
			return conto_daNome;
		}


		public String getContoANome() {
			return conto_aNome;
		}


		

		public Transazione(Integer contoDa, Integer contoA, BigDecimal importo) {
        this.conto_da=contoDa;
        this.conto_a=contoA;
        this.importo=importo;
		}


		public void setCausale(String causale) {
			this.causale = causale;
		}


		public void setData(String data) {
			this.data = data;
		}


		public int getId() {
			return id;
		}


		public int getContoDa() {
			return conto_da;
		}


		public int getContoA() {
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
