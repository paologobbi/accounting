package it.polimi.accounting;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class TransazioniDate
 */
public class TransazioniDate extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public TransazioniDate() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		ResultSet risultato;
		try {
			Connection conn =
			       DriverManager.getConnection("jdbc:mysql://localhost/accounting?user=root&password=");
			PreparedStatement	stmt = conn.prepareStatement("SELECT * FROM utente WHERE username=?");	
			stmt.setString(1, username);
			
			risultato=stmt.executeQuery();
		} catch (SQLException e){
	}

	

}
