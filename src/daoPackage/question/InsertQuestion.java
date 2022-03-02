package daoPackage.question;

import java.sql.Connection;
import java.sql.PreparedStatement;

import genericPackage.GenericPackage;
import modelPackage.Questions;

public class InsertQuestion {

	public void insertQuestions(Questions ques) {
		
		String questionText=ques.getQuestionText();
		String option1=ques.getOption1();
		String option2=ques.getOption2();
		String option3=ques.getOption3();
		String option4=ques.getOption4();
		int answer=ques.getAnswer();
		
		try {
			Connection con=GenericPackage.getConnectionData();
			PreparedStatement stmt = con.prepareStatement("insert into Questions values(?,?,?,?,?,?)");
			stmt.setString(2, questionText);
			stmt.setString(3, option1);
			stmt.setString(4, option2);
			stmt.setString(5, option3);
			stmt.setString(6, option4);
			stmt.setInt(7, answer);
			
			int x=stmt.executeUpdate(); 
			System.out.println(x+"updated");
			
			con.close();
		} 
		catch (Exception e) {
			e.printStackTrace();
		} 
		
	}
	
}
