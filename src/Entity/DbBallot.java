package Entity;
import java.sql.CallableStatement;
/*
 * @returns Ballot List ArrayList<Ballot>
 */
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class DbBallot {

	public DbBallot() {
		// TODO Auto-generated constructor stub
	}

	
	public ArrayList<Ballot> getBallots() {
		 ArrayList<Ballot> results = new ArrayList<Ballot>();
		 try {
		 Class.forName("net.ucanaccess.jdbc.UcanaccessDriver");
		 try (Connection conn = DriverManager.getConnection(ConstsElectDayDB.CONN_STR);

		 PreparedStatement stmt = conn.prepareStatement(ConstsElectDayDB.SQL_SEL_BALLOTS);

		 ResultSet rs = stmt.executeQuery()) {

		 while (rs.next()) {
			 Ballot res = readFromDb(rs);
			 results.add(res);
		 }
		 } catch (SQLException e) {
			 System.out.print("Ballot Read Failure");
		 e.printStackTrace();
		 }
		} catch (ClassNotFoundException e) {
			 System.out.print("Ballot Class Not Found");
		 e.printStackTrace();
		}

		return results;
	}
	public Ballot getBallot(int ballotNum) {
		Ballot result = null;
		 try {
		 Class.forName("net.ucanaccess.jdbc.UcanaccessDriver");
		 
		 try (Connection conn = DriverManager.getConnection(ConstsElectDayDB.CONN_STR);
				 
		 PreparedStatement stmt = conn.prepareStatement(ConstsElectDayDB.SQL_SEL_BALLOTS_BALLOTNUM
				 + ballotNum);

		 ResultSet rs = stmt.executeQuery()) {
			 while(rs.next()) {
				 result = readFromDb(rs);
			 }
			 } catch (SQLException e) {
				 System.out.println("Ballot Failure");
		 e.printStackTrace();
		 }
		} catch (ClassNotFoundException e) {
		 e.printStackTrace();
		}
		return result;
	}
	
	
	public void closeBallot(int ballotNum, String closeTime)
	{
		try {
			 Class.forName("net.ucanaccess.jdbc.UcanaccessDriver");
			 try (Connection conn = DriverManager.getConnection(ConstsElectDayDB.CONN_STR);
					 
				CallableStatement stmt = conn.prepareCall(ConstsElectDayDB.SQL_CLOSE_BALLOT)) {

			
		int i = 1;

		stmt.setString(i++, closeTime);
		stmt.setInt(i++, ballotNum);

		 stmt.executeUpdate();
		 } catch (SQLException e) {
			 System.out.println("DbCloseBallot Failure2");
		 e.printStackTrace();
		 }
		 } catch (ClassNotFoundException e) {
			 System.out.println("DbCloseBallot ClassNotFound Failure2");
		 e.printStackTrace();
		 }
	}
	
	
	private Ballot readFromDb(ResultSet rs) throws SQLException {
		 int i = 1;
		 int ballotNum;
		 String city;
		 int branchNum;
		 String countCloseTime;
		 String ballotAddress;
		 Ballot result = null;
		 try {
			 ballotNum = rs.getInt(i++);
			 ballotAddress = rs.getString(i++);
			 city = rs.getString(i++);
			 branchNum = rs.getInt(i++);
			 countCloseTime = rs.getString(i++);
			 result = new Ballot(ballotNum, ballotAddress, city, branchNum, countCloseTime);
		 }
		 catch (Exception e) {
			System.out.println("DbGetBallot.readFromDd Failure");
		}
		 return result;
}
}
