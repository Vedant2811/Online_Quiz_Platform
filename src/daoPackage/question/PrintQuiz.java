package daoPackage.question;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import genericPackage.GenericPackage;
import modelPackage.Questions;

public class PrintQuiz {

public List<Questions> getQuestionList() {
		
		List<Questions> list=new ArrayList<Questions>();
		
		try {
			Connection con=GenericPackage.getConnectionData();
			PreparedStatement stmt = con.prepareStatement("select * from Questions ");
			ResultSet rst=stmt.executeQuery();
			while (rst.next()) {
				
				Questions q=new Questions();
				q.setQuestionText(rst.getString(2));
				q.setOption1(rst.getString(3));
				q.setOption2(rst.getString(4));
				q.setOption3(rst.getString(5));
				q.setOption4(rst.getString(6));
				q.setAnswer(rst.getInt(7));
				list.add(q);
				
			}
			
			con.close();
		}
		catch(Exception e) {
			System.out.println(e);
		}
		return list;
	}
	
}
