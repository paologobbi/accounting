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
	
	public void creaTransazione(Transazione t) throws SQLException{
		PreparedStatement	stmt = conn.prepareStatement("INSERT INTO transazione(conto_a,conto_da,importo,causale,data) VALUES (?,?,?,?,?);");	
		stmt.setInt(1,t.getContoA());
		stmt.setInt(2,t.getContoDa());
		stmt.setBigDecimal(3,t.getImporto());
		stmt.setString(4,t.getCausale());
		stmt.setString(5,t.getData());
		
		stmt.executeUpdate();
return;
	}


	public List<Transazione> transazioniPerDate(String dataInizio,
			String dataFine) throws SQLException {
		PreparedStatement	stmt = conn.prepareStatement("SELECT t.*, c_da.nome AS conto_daNome, c_a.nome AS conto_aNome FROM transazione t JOIN conto c_da ON t.conto_da=c_da.id " +
				" JOIN conto c_a ON t.conto_a=c_a.id WHERE data>=? AND data<=? AND c_da.username=?");	
		
		
		stmt.setString(1, dataInizio);
		stmt.setString(2, dataFine);
		stmt.setString(3,username);


		
		ResultSet risultato=stmt.executeQuery();
		
		
		List<Transazione> transazioni = new ArrayList<Transazione>();
		while (risultato.next()){
			
			String importo = risultato.getString("importo");
			Transazione transazione = new Transazione(risultato.getInt("id"),risultato.getInt("conto_da"),
					risultato.getString("conto_daNome"),risultato.getInt("conto_a"),risultato.getString("conto_aNome"),new BigDecimal(importo),risultato.getString("causale"),risultato.getString("data"));
			transazioni.add(transazione);
		}
		return transazioni;
		
		
	}
	
	
	
}