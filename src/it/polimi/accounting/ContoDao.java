package it.polimi.accounting;

import java.math.BigDecimal;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.mysql.jdbc.Connection;

public class ContoDao {
	private Connection conn;

	public ContoDao(Connection conn){
		this.conn = conn;
	}
	
	

	public void save(Conto conto) throws SQLException{
		PreparedStatement stmt = conn.prepareStatement("UPDATE conto SET nome=?, saldo=? WHERE id=?");
		stmt.setString(1, conto.getNome());
		stmt.setString(2, conto.getSaldo().toString());
		stmt.setInt(3, conto.getId());
		stmt.executeUpdate();
		
		
	}

	public Conto trovaConto(int id) throws SQLException{
		PreparedStatement stmt = conn.prepareStatement("Select * FROM conto WHERE id=?");
		stmt.setInt(1, id);
	    ResultSet risultato=stmt.executeQuery();
		return null ;

		
	}
	
	public List<Conto> trovaConti(String username) throws SQLException{
		PreparedStatement	stmt = conn.prepareStatement("SELECT * FROM conto WHERE username=?");	
		stmt.setString(1, username);
		ResultSet risultato=stmt.executeQuery();
		List<Conto> conti = new ArrayList<Conto>();
		while (risultato.next()){
			String saldo = risultato.getString("saldo");
			Conto conto = new Conto(risultato.getInt("id"),risultato.getString("nome"),new BigDecimal(saldo));
			conti.add(conto);
		}
		return conti;
			
		}


		//return null;
	
}

