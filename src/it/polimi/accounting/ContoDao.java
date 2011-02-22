package it.polimi.accounting;

import java.math.BigDecimal;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import java.sql.Connection;

public class ContoDao {
	private Connection conn;
	private String username;

	public ContoDao(Connection conn, String username){
		this.conn = conn;
		this.username=username;
	}
	
	

	public void save(Conto conto) throws SQLException{
		PreparedStatement stmt = conn.prepareStatement("UPDATE conto SET nome=?, saldo=? WHERE id=?");
		stmt.setString(1, conto.getNome());
		stmt.setString(2, conto.getSaldo().toString());
		stmt.setInt(3, conto.getId());
		stmt.executeUpdate();
		
		
	}

	public ContoAttivo trovaConto(int id) throws SQLException{
		PreparedStatement stmt = conn.prepareStatement("Select * FROM conto WHERE id=?");
		stmt.setInt(1, id);
	    ResultSet risultato=stmt.executeQuery();
		return null ;

		
	}
	
	private Conto creaConto(int id, String nome, BigDecimal saldo,String tipo ){
		if(tipo.equals("attivo")){
			ContoAttivo conto= new ContoAttivo(id,nome,saldo);
			return conto;
		}
		return null;
	}
	
	public List<Conto> trovaConti() throws SQLException{
		PreparedStatement	stmt = conn.prepareStatement("SELECT * FROM conto WHERE username=?");	
		stmt.setString(1, username);
		ResultSet risultato=stmt.executeQuery();
		List<Conto> conti = new ArrayList<Conto>();
		while (risultato.next()){
			String saldo = risultato.getString("saldo");
			Conto conto=creaConto(risultato.getInt("id"),risultato.getString("nome"),new BigDecimal(saldo),risultato.getString("tipo"));
			conti.add(conto);
		}
		return conti;
			
		}
	
	public List<String> trovaContiNome() throws SQLException{
		PreparedStatement	stmt = conn.prepareStatement("SELECT nome FROM conto WHERE username=?");	
		stmt.setString(1, username);
		ResultSet risultato=stmt.executeQuery();
		List<String> nomiConti = new ArrayList<String>();
		while (risultato.next()){
			String conto=risultato.getString("nome");
			nomiConti.add(conto);
		}
		return nomiConti;
			
		}
	
	
	public void creaConto(String nomeConto, String saldoIniziale,String tipo) throws SQLException{
		PreparedStatement	stmt = conn.prepareStatement("INSERT INTO conto(nome,saldo,username,tipo) VALUES (? ,?,?,?);");	
		stmt.setString(1,nomeConto);
		stmt.setString(2,saldoIniziale);
		stmt.setString(3,username);	
		stmt.setString(4,tipo);
		stmt.executeUpdate();
return;
	}
		
		
	
}

