package controller.Login;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import genericPackage.GenericPackage;

/**
 * Servlet implementation class LoginPage
 */
@WebServlet("/LoginPage")
public class LoginPage extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginPage() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		RequestDispatcher dispatcher=request.getRequestDispatcher("/WEB-INF/views/loginDetails/LoginPage.jsp");
		dispatcher.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		

		String username=request.getParameter("username");
		String password=request.getParameter("password");
		
		
		try {
			if(username!=null) {
				Connection con=GenericPackage.getConnectionData();
				
				String Query="select * from LoginDetails where USERNAME=? and PASSWORD=?";
				
				PreparedStatement psmt=con.prepareStatement(Query);
				psmt.setString(1, username);
				psmt.setString(2, password);
				
				ResultSet rs=psmt.executeQuery();
				if(rs.next()) {
					
					HttpSession session=request.getSession();
					session.setAttribute("username", username);
					
					RequestDispatcher dispatcher=request.getRequestDispatcher("/WEB-INF/views/adminData/OptionPage.jsp");
					dispatcher.forward(request, response);
				}
				else {
					
					RequestDispatcher dispatcher=request.getRequestDispatcher("/WEB-INF/views/login/LoginPage.jsp");
					dispatcher.forward(request, response);
					
					
				}
			}
		}
		
		catch(Exception e) {
			PrintWriter out=response.getWriter();
			out.print("Exception : "+e);
		}
		
		
	}

}
