package it.polimi.accounting;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public class CreaConto extends HttpServlet {
	private static final long serialVersionUID = 1L;
   
    public CreaConto() {
        super();
    }

	
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String tipo = request.getParameter("tipoConto");
		String nomeConto = request.getParameter("nomeConto");
		String saldoIniziale = request.getParameter("saldoIniziale");
	    String username= (String) request.getSession().getAttribute("username");

	    
		try {
			Connection conn=DriverManager.getConnection("jdbc:mysql://localhost/accounting?user=root&password=");
			
			PreparedStatement	stmt = conn.prepareStatement("INSERT INTO conto(nome,saldo,username,tipo) VALUES (? ,?,?,?);");	
			stmt.setString(1,nomeConto);
			stmt.setString(2,saldoIniziale);
			stmt.setString(3,username);	
			stmt.setString(4,tipo);
			stmt.executeUpdate();
			response.sendRedirect("welcome.jsp");
	return;
	
	
	
	 
	} catch (SQLException e) {
		
		e.printStackTrace();
	}
	 
}


}
