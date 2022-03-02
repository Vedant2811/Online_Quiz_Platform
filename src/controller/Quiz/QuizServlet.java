package controller.Quiz;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import daoPackage.question.PrintQuiz;
import modelPackage.Questions;

/**
 * Servlet implementation class QuizServlet
 */
@WebServlet("/QuizServlet")
public class QuizServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	private PrintQuiz quiz=new PrintQuiz();
	public int nmbr;
	List<Integer> listAns=new ArrayList<Integer>();
	List<Integer> listUserAns=new ArrayList<Integer>();
	
    /**
     * @see HttpServlet#HttpServlet()
     */
    public QuizServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
//	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//		RequestDispatcher dispatcher=request.getRequestDispatcher("");
//		dispatcher.forward(request, response);
//	}

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	RequestDispatcher dispatcher=request.getRequestDispatcher("/WEB-INF/views/candidate/PreQuizData.jsp");
    	dispatcher.forward(request, response);
    }
    
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//		if(request.getParameter("submit")!=null) {
//			int marks = 0;			
//			for(int i=0;i<nmbr;i++) {
//				int ans=Integer.parseInt(request.getParameter("userAnswer"+i));
//				listUserAns.add(ans);
//			}
//			
//			
//			for(int i=0;i<nmbr;i++) {
//				if(listUserAns.get(i)==listAns.get(i)) {
//					marks++;
//				}
//			}
//			
//			request.setAttribute("marks", marks);
//			RequestDispatcher dispatcher=request.getRequestDispatcher("/WEB-INF/views/candidate/Score.jsp");
//			dispatcher.forward(request, response);
//			
//		}
//		else {
//			nmbr=Integer.parseInt(request.getParameter("totalQuestions"));
//			request.setAttribute("totQue", nmbr);
//			
//			List<Questions> list=quiz.getQuestionList();
//			Collections.shuffle(list);
//			
//			request.setAttribute("list", list);
//			for(int i=0;i<nmbr;i++) {
//				int ans=list.get(i).getAnswer();
//				listAns.add(ans);
//			}
//			
//			RequestDispatcher dispatcher=request.getRequestDispatcher("/WEB-INF/views/candidate/TakeQuiz.jsp");
//	    	dispatcher.forward(request, response);
//		}
		
		nmbr=Integer.parseInt(request.getParameter("totalQuestions"));
		String url=request.getServletPath();
		
		switch (url) {
		case "/QuizServlet": {
			TakeQuiz(request, response);
			break;
		}
		
		case "/Score" : {
			Score(request, response);
			break;
		}
		default:
			throw new IllegalArgumentException("Unexpected value: " + url);
		}
		
	}

	private void TakeQuiz(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		nmbr=Integer.parseInt(request.getParameter("totalQuestions"));
		request.setAttribute("totQue", nmbr);
		
		List<Questions> list=quiz.getQuestionList();
		Collections.shuffle(list);
		
		request.setAttribute("list", list);
		for(int i=0;i<nmbr;i++) {
			int ans=list.get(i).getAnswer();
			listAns.add(ans);
		}
		
		RequestDispatcher dispatcher=request.getRequestDispatcher("/WEB-INF/views/candidate/TakeQuiz.jsp");
    	dispatcher.forward(request, response);
	}

	private void Score(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		int marks = 0;			
		for(int i=0;i<nmbr;i++) {
			int ans=Integer.parseInt(request.getParameter("userAnswer"+i));
			listUserAns.add(ans);
		}
		
		
		for(int i=0;i<nmbr;i++) {
			if(listUserAns.get(i)==listAns.get(i))  {
				marks++;
			}
		}
		
		request.setAttribute("marks", marks);
		RequestDispatcher dispatcher=request.getRequestDispatcher("/WEB-INF/views/candidate/Score.jsp");
		dispatcher.forward(request, response);
		
	}

}
