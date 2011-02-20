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
	
	public void creaTransazione(int conto_a, int conto_da,BigDecimal importo,String causale, String data) throws SQLException{
		PreparedStatement	stmt = conn.prepareStatement("INSERT INTO transazione(conto_a,conto_da,importo,causale,data,username) VALUES (?,?,?,?,?,?);");	
		stmt.setInt(1,conto_a);
		stmt.setInt(2,conto_da);
		stmt.setBigDecimal(3,importo);
		stmt.setString(4,causale);
		stmt.setString(5,data);
		stmt.setString(3,username);	
		
		stmt.executeUpdate();
return;
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
			Transazione transazione = new Transazione(risultato.getInt("id"),risultato.getInt("conto_da"),risultato.getInt("conto_a"),new BigDecimal(importo),risultato.getString("causale"),risultato.getString("data"),risultato.getString("username"));
			transazioni.add(transazione);
		}
		return transazioni;
		
		
	}
	
	
	
}