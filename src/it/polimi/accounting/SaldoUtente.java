package it.polimi.accounting;

import java.io.IOException;
import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public class SaldoUtente extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
    public SaldoUtente() {
        super();
        
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	    String username= (String) request.getSession().getAttribute("username");

		try {
			Connection conn = DriverManager.getConnection("jdbc:mysql://localhost/accounting?user=root&password=");
			UtenteDao nuovoSaldo =new UtenteDao(conn, username);
			BigDecimal saldo = nuovoSaldo.saldo();
			System.out.println("il saldo totale è"+ saldo);
			
			
	RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/saldo.jsp");
	dispatcher.forward(request, response);
	} catch (SQLException e){
		e.printStackTrace();
}


	
	
}}
