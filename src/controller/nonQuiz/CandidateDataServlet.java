package controller.nonQuiz;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import daoPackage.candidate.InsertCandidate;
import modelPackage.CandidateData;

/**
 * Servlet implementation class CandidateDataServlet
 */
@WebServlet("/CandidateData")
public class CandidateDataServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	private InsertCandidate cand=new InsertCandidate();
	
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CandidateDataServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		RequestDispatcher dispatcher=request.getRequestDispatcher("/WEB-INF/views/candidate/CandidateData.jsp");
		dispatcher.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String name=request.getParameter("candidateName");
		String mobNmbr=request.getParameter("mobileNumber");
		
		CandidateData data=new CandidateData();
		data.setCandidateName(name);
		data.setMobileNumber(mobNmbr);
		
		cand.insertCandidate(data);
		
		RequestDispatcher dispatcher=request.getRequestDispatcher("/WEB-INF/views/candidate/PreQuizData.jsp");
		dispatcher.forward(request, response);
		
	}

}
