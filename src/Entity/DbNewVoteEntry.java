package Entity;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DbNewVoteEntry {
	private int ballotNum;
	private String votedFor, isValid;
	private int employeeId;
	
	public DbNewVoteEntry(int ballotNum, String votedFor, String isValid, int employeeId) {
		super();
		this.ballotNum = ballotNum;
		this.votedFor = votedFor;
		this.isValid = isValid;
		this.employeeId = employeeId;
	}
	public void SetEntry(){
		 try {
			 //System.out.println("here1" + ballotNum + votedFor+isValid+employeeId);
			 Class.forName("net.ucanaccess.jdbc.UcanaccessDriver");
			 try (Connection conn = DriverManager.getConnection(ConstsElectDayDB.CONN_STR);
					 
				CallableStatement stmt = conn.prepareCall(ConstsElectDayDB.SQL_INS_VOTE)) {

			
		int i = 1;
		stmt.setInt(i++, ballotNum);
		stmt.setString(i++, votedFor);
		stmt.setString(i++, isValid);
		stmt.setInt(i++, employeeId);
		 stmt.executeUpdate();
		 } catch (SQLException e) {
			 System.out.println("DbNewVote Failure2");
		 e.printStackTrace();
		 }
		 } catch (ClassNotFoundException e) {
			 System.out.println("DbNewVote ClassNotFound Failure2");
		 e.printStackTrace();
		 }
	}
	
}
