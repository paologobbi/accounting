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
 * Servlet implementation class TransazioniDate
 */
public class TransazioniTipoConto extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
    public TransazioniTipoConto() {
        super();
       
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.getSession().getAttribute("username");
		String tipo=(String) request.getParameter("TipoContoTransazioni");
		

		try {
			Connection conn = DriverManager.getConnection("jdbc:mysql://localhost/accounting?user=root&password=");
			PreparedStatement	stmt = conn.prepareStatement("SELECT * FROM transazione WHERE tipo=?");	
			stmt.setString(1, tipo);
			

			
			ResultSet risultato=stmt.executeQuery();
			
			
			List<Transazione> transazioni = new ArrayList<Transazione>();
			while (risultato.next()){
				
				String importo = risultato.getString("importo");
				Transazione transazione = new Transazione(risultato.getInt("id"),risultato.getInt("conto_da"),risultato.getInt("conto_a"),new BigDecimal(importo),risultato.getString("causale"),risultato.getString("data"));
				transazioni.add(transazione);
				
			
		}
			request.setAttribute("transazioni", transazioni);
			
			RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/mostraTransazioni.jsp");
			dispatcher.forward(request, response);
			} catch (SQLException e){
				e.printStackTrace();
	}

	

}}
