package controller.nonQuiz;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class OptionPageServlet
 */
@WebServlet("/OptionPage")
public class OptionPageServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public OptionPageServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		RequestDispatcher dispatcher=request.getRequestDispatcher("/WEB-INF/views/adminData/OptionPage.jsp");
		dispatcher.forward(request, response);
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String action=request.getParameter("action");
		if("inputQuiz".equals(action)) {			
			RequestDispatcher dispatcher=request.getRequestDispatcher("/WEB-INF/views/adminData/InputQuestion.jsp");
			dispatcher.forward(request, response);	
		}
		
		else {			
			RequestDispatcher dispatcher=request.getRequestDispatcher("/WEB-INF/views/candidate/CandidateData.jsp");
			dispatcher.forward(request, response);
		}
		
	}

}
