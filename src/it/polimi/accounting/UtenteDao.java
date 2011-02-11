package it.polimi.accounting;


import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class UtenteDao {
	private Connection conn;
	private String username;

	

public UtenteDao(Connection conn, String username){
	this.conn = conn;
	this.username=username;
}


public void registrazione(String nome,String cognome,String password,String email) throws SQLException{
	PreparedStatement	stmt = conn.prepareStatement("INSERT INTO utente (nome,cognome,username,password,email) VALUES (? ,?,?, ?, ?);");	
	stmt.setString(1, nome);
	stmt.setString(2, cognome);
	stmt.setString(3, username);
	stmt.setString(4, password);
	stmt.setString(5, email);
	stmt.executeUpdate();
	return;
}

public BigDecimal saldo()  throws SQLException{
	PreparedStatement	stmt = conn.prepareStatement("SELECT saldo FROM conto WHERE username=?;");	
	
	ResultSet risultato=stmt.executeQuery();
	BigDecimal saldoTotale=null;
	while (risultato.next()){
	saldoTotale=saldoTotale.add(risultato.getBigDecimal("saldo"));
	saldoTotale.toString();
	
	
	 }

return saldoTotale;
}
}

