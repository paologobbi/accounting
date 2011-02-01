package it.polimi.accounting;

import java.io.IOException;
import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class ElencoConti
 */
public class ElencoConti extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.getSession().getAttribute("username");
		
		String username = (String) request.getSession().getAttribute("username");
		
		try {
			Connection conn=DriverManager.getConnection("jdbc:mysql://localhost/accounting?user=root&password=");
	
			
			PreparedStatement	stmt = conn.prepareStatement("SELECT * FROM conto WHERE username=?");	
			stmt.setString(1, username);
			ResultSet risultato=stmt.executeQuery();
			List<Conto> conti = new ArrayList<Conto>();

		
	
		while (risultato.next()){
			String saldo = risultato.getString("saldo");
			Conto conto = new Conto(risultato.getInt("id"),risultato.getString("nome"),new BigDecimal(saldo));
			conti.add(conto);
			
		}
		
		request.setAttribute("conti", conti);
		
		RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/conti.jsp");
		dispatcher.forward(request, response);
	} catch (SQLException e) {
		
		e.printStackTrace();
	}
		

}}
