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
 * Servlet implementation class ServletRegistrazione
 */
public class ServletRegistrazione extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ServletRegistrazione() {
        super();
        
    }

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String nome = request.getParameter("nome");
		String cognome = request.getParameter("cognome");
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		String email = request.getParameter("email");
		System.out.println("ciao ciao");
		try {
			Connection conn =
			       DriverManager.getConnection("jdbc:mysql://localhost/accounting?user=root&password=");
			System.out.println("ciao ciao");
			PreparedStatement	stmt = conn.prepareStatement("INSERT INTO utente (nome,cognome,username,password,email) VALUES (? ,?,?, ?, ?);");	
			stmt.setString(1, nome);
			stmt.setString(2, cognome);
			stmt.setString(3, username);
			stmt.setString(4, password);
			stmt.setString(5, email);
			stmt.executeUpdate();
			
			request.getSession().setAttribute("username", username);
			response.sendRedirect("welcome.jsp");
			return;
			
	
			
		 
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		 
	}

}
