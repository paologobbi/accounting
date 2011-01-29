package it.polimi.accounting;

import java.sql.PreparedStatement;
import java.sql.SQLException;

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

	public Conto trovaConto(int id){
		return null;
		//Fare il codice ....
	}
}
