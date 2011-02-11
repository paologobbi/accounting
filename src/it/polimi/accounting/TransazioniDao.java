package it.polimi.accounting;

import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;



public class TransazioniDao {
	
	private Connection conn;
	private String username;



	public TransazioniDao(Connection conn, String username){
		this.conn = conn;
		this.username=username;
	}



	public List<Transazione> transazioniPerDate(String dataInizio,
			String dataFine) throws SQLException {
		PreparedStatement	stmt = conn.prepareStatement("SELECT * FROM transazione WHERE data>=? AND data<=?");	
		
		
		stmt.setString(1, dataInizio);
		stmt.setString(2, dataFine);

		
		ResultSet risultato=stmt.executeQuery();
		
		
		List<Transazione> transazioni = new ArrayList<Transazione>();
		while (risultato.next()){
			
			String importo = risultato.getString("importo");
			Transazione transazione = new Transazione(risultato.getInt("id"),risultato.getInt("conto_da"),risultato.getInt("conto_a"),new BigDecimal(importo),risultato.getString("causale"),risultato.getString("data"));
			transazioni.add(transazione);
		}
		return transazioni;
		
		
	}
	
	
	
}