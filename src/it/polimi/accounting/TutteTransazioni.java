package it.polimi.accounting;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class TutteTransazioni
 */
public class TutteTransazioni extends HttpServlet {
	private static final long serialVersionUID = 1L;
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String username=(String) request.getSession().getAttribute("username");

		String dataInizio =  "1980-1-1";
		String dataFine = "2020-12-31";
		 

		try {
			Connection conn = DriverManager.getConnection("jdbc:mysql://localhost/accounting?user=root&password=");
			TransazioniDao insiemeTransazioni = new TransazioniDao(conn, username);
			List<Transazione> transazioni =insiemeTransazioni.transazioniPerDate(dataInizio, dataFine);
			
			request.setAttribute("transazioni", transazioni);
			
			RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/mostraTransazioni.jsp");
			dispatcher.forward(request, response);
			} catch (SQLException e){
				e.printStackTrace();
	}
	}
}
