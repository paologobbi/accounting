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
			
			ContoDao creaConto=new ContoDao(conn,username);
			creaConto.creaConto(nomeConto, saldoIniziale, tipo);
			
			response.sendRedirect("welcome.jsp");
	
	
	
	
	 
	} catch (SQLException e) {
		
		e.printStackTrace();
	}
	 
}


}
