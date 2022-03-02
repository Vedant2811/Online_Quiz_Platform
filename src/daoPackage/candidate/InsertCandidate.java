package daoPackage.candidate;

import java.sql.Connection;
import java.sql.PreparedStatement;

import genericPackage.GenericPackage;
import modelPackage.CandidateData;

public class InsertCandidate {

	public void insertCandidate(CandidateData data) {
		
		String name=data.getCandidateName();
		String mobNmbr=data.getMobileNumber();
		
		try {
			Connection con=GenericPackage.getConnectionData();
			PreparedStatement stmt = con.prepareStatement("insert into Candidate values(?,?)");
			stmt.setString(1, name);
			stmt.setString(2, mobNmbr);
			
			int x=stmt.executeUpdate(); 
			System.out.println(x+"updated");
			
			con.close();
		} 
		catch (Exception e) {
			e.printStackTrace();
		} 
		
	}
	
}
