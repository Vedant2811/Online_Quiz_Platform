package controller.Question;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import daoPackage.question.InsertQuestion;
import modelPackage.Questions;

/**
 * Servlet implementation class InputQuestion
 */
@WebServlet("/InputQuestion")
public class InputQuestion extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	private InsertQuestion insertion=new InsertQuestion();
	
    /**
     * @see HttpServlet#HttpServlet()
     */
    public InputQuestion() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		RequestDispatcher dispatcher=request.getRequestDispatcher("/WEB-INF/views/adminData/InputQuestion.jsp");
		dispatcher.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String questionText=request.getParameter("question");
		String option1=request.getParameter("option1");
		String option2=request.getParameter("option2");
		String option3=request.getParameter("option3");
		String option4=request.getParameter("option4");
		int answer=Integer.parseInt(request.getParameter("answer"));
		
		Questions ques=new Questions();
		ques.setQuestionText(questionText);
		ques.setOption1(option1);
		ques.setOption2(option2);
		ques.setOption3(option3);
		ques.setOption4(option4);
		ques.setAnswer(answer);
		
		insertion.insertQuestions(ques);
		
		RequestDispatcher dispatcher=request.getRequestDispatcher("/WEB-INF/views/adminData/OptionPage.jsp");
		dispatcher.forward(request, response);
	}

}
