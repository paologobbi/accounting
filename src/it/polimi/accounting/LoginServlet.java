package it.polimi.accounting;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class LoginServlet
 */
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		
		try {
			Connection conn =
			       DriverManager.getConnection("jdbc:mysql://localhost/accounting?user=root&password=");
			PreparedStatement	stmt = conn.prepareStatement("SELECT * FROM utente WHERE username=?");	
			stmt.setString(1, username);
			ResultSet risultato=stmt.executeQuery();
			risultato.next();
		 String expectedPassword = risultato.getString("password");
		 if(expectedPassword.equals(password)){
			 request.getSession().setAttribute("username", username);
			 response.sendRedirect("welcome.jsp");
			 return;
		 }
			
			 else {
					
					 RequestDispatcher dispatcher = request.getRequestDispatcher("index.jsp");

				     dispatcher.forward(request, response);
					//dispatcher.include(request, response);
				    // request.getSession().setAttribute("username", username);
		 } 
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
