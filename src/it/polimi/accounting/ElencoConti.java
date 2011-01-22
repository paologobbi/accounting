package it.polimi.accounting;

import java.io.IOException;
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
		// fare la query
		List<String> conti = new ArrayList<String>();
		conti.add("Portafoglio");
		conti.add("Conto corrente");
		request.setAttribute("conti", conti);
		
		RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/conti.jsp");
		dispatcher.forward(request, response);
	}

}
