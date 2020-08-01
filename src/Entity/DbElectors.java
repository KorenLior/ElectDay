package Entity;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Time;
import java.util.ArrayList;
import java.util.Vector;


public class DbElectors {

	public DbElectors() {
		// TODO Auto-generated constructor stub
	}
	public ArrayList<Elector> getElectors() {
		 ArrayList<Elector> results = new ArrayList<Elector>();
		 try {
		 Class.forName("net.ucanaccess.jdbc.UcanaccessDriver");
		 try (Connection conn = DriverManager.getConnection(ConstsElectDayDB.CONN_STR);
		 PreparedStatement stmt = conn.prepareStatement(ConstsElectDayDB.SQL_SEL_ELECTORS);
		 ResultSet rs = stmt.executeQuery()) {
			 while (rs.next()) {
				 Elector res = readFromDb(rs);
				 results.add(res);
		 }
		 } catch (SQLException e) {
			 System.out.println("getElectors() readFromDb Failure");
		 e.printStackTrace();
		 }
		} catch (ClassNotFoundException e) {
			System.out.println("getElectors() readFromDb ClassNotFound Failure");
		 e.printStackTrace();
		}

		return results;
	}
	public ArrayList<Elector> getElectors(int ballotNum) {
		ArrayList<Elector> results = new ArrayList<Elector>();
		 try {
		 Class.forName("net.ucanaccess.jdbc.UcanaccessDriver");
		 try (Connection conn = DriverManager.getConnection(ConstsElectDayDB.CONN_STR);

		 PreparedStatement stmt = conn.prepareStatement(ConstsElectDayDB.SQL_SEL_ELECTOR_BALLOT
				 + String.valueOf(ballotNum));

		 ResultSet rs = stmt.executeQuery()) {
			 while (rs.next()) {
				 Elector res = readFromDb(rs);
				 results.add(res);
		 }
		 } catch (SQLException e) {
			 System.out.println("getElectors(int ballotNum) readFromDb Failure");
		 e.printStackTrace();
		 }
		} catch (ClassNotFoundException e) {
			System.out.println("getElectors(int ballotNum) readFromDb ClassNotFound Failure");
			e.printStackTrace();
		}

		return results;
	}
	
	public Elector getElector(int electorId) {
		Elector result = null;
		 try {
		 Class.forName("net.ucanaccess.jdbc.UcanaccessDriver");
		 //System.out.println(ConstsDbElector.SQL_SEL_ELECTOR_ID
		 //+ electorId);
		 try (Connection conn = DriverManager.getConnection(ConstsElectDayDB.CONN_STR);
				 
		 PreparedStatement stmt = conn.prepareStatement(ConstsElectDayDB.SQL_SEL_ELECTOR_ID
				 + electorId);

		 ResultSet rs = stmt.executeQuery()) {
			 while(rs.next()) {
				 result = readFromDb(rs);
			 }
			 } catch (SQLException e) {
				 System.out.println("Failure");
		 e.printStackTrace();
		 }
		} catch (ClassNotFoundException e) {
		 e.printStackTrace();
		}
		return result;
	}
	
	public void turnout(int electorId) {
		try {
			 //System.out.println("here1" + ballotNum + votedFor+isValid+employeeId);
			 Class.forName("net.ucanaccess.jdbc.UcanaccessDriver");
			 try (Connection conn = DriverManager.getConnection(ConstsElectDayDB.CONN_STR);
					 
				CallableStatement stmt = conn.prepareCall(ConstsElectDayDB.SQL_ELECTOR_VOTE)) {

			
		int i = 1;
		Time now = new Time(System.currentTimeMillis());
		stmt.setTime(i++, now);
		stmt.setInt(i++, electorId);

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
	
	private Elector readFromDb(ResultSet rs) throws SQLException {
			 int i = 1;
			 int id;
			 String firstName;
			 String lastName;
			 String address;
			 String phoneNum;
			 int ballotNum;
			 int serialNum;
			 Time voteTime;
			 String status = null, gender = null;
			 Date birthDate;
			 Elector result = null;
			 try {


			 id = rs.getInt(i++);
			 ballotNum = rs.getInt(i++);
			 serialNum = rs.getInt(i++);
			 lastName = rs.getString(i++);
			 firstName = rs.getString(i++);
			 address = rs.getString(i++);
			 phoneNum = rs.getString(i++);
			 status = rs.getString(i++);
			 gender = rs.getString(i++);
			 voteTime = rs.getTime(i++);
			 birthDate = rs.getDate(i++);
			 int assDriverId = rs.getInt(i++);
			 String assRideTime = rs.getString(i++);
			 String preferenceParty = rs.getString(i++);
			 
			 
			 result = new Elector(id, ballotNum, serialNum, firstName, 
						lastName, address, phoneNum, status, gender, voteTime, birthDate, assDriverId, assRideTime, preferenceParty);
			 }
			 catch (Exception e) {
				System.out.println("DbGetElector.readFromDd Failure");
			}
			 return result;
	}
	
	
	public Vector<Vector<Object>> getRidersTable(){
		Vector<Vector<Object>> results = new Vector<Vector<Object>>();
		try {
			 Class.forName("net.ucanaccess.jdbc.UcanaccessDriver");
			 try (Connection conn = DriverManager.getConnection(ConstsElectDayDB.CONN_STR);
			 PreparedStatement stmt = conn.prepareStatement(ConstsElectDayDB.SQL_RIDERS_TABLE);
			 ResultSet rs = stmt.executeQuery()) {

			 while (rs.next()) {
				 int i = 1;
				 Vector<Object> result = new Vector<Object>();
				 try
				 {
					 int elector = rs.getInt(i++); 
					 String name = rs.getString(i++)+" "+rs.getString(i++);
					 String phone = rs.getString(i++); 
					 String electorAddress = rs.getString(i++); 
					 String ballotAddress = rs.getString(i++); 
					 int ballot = rs.getInt(i++); result.add(ballot);
					 String assignedTime = rs.getString(i++); 
					 int assignedID = rs.getInt(i++); 
					 String assignedName = rs.getString(i++)+" "+rs.getString(i++); 
					 int driverId = rs.getInt(i++); 
					 Time pickupT = rs.getTime(i++); 
					 Time returnT = rs.getTime(i++); 
					 
					 result.add(elector);
					 result.add(name);
					 result.add(phone);
					 result.add(electorAddress);
					 result.add(ballotAddress);
					 result.add(assignedTime.toString());
					 result.add(assignedID);
					 result.add(assignedName);
					 result.add(driverId);
					 result.add(pickupT);
					 result.add(returnT);
					 results.add(result);
				 }
				 catch (Exception e) {
					// TODO: handle exception
					 System.out.println("ElectionDayPosition readDb Failure");
				 }
				 
			 }
			 } catch (SQLException e) {
				 System.out.println("getElectionDayPosition() readFromDb Failure");
			 e.printStackTrace();
			 }
			} catch (ClassNotFoundException e) {
			 e.printStackTrace();
			}
		
		return results;
	}
	public void setRide(int elector, int employee, String pickUp, String returnTime) {
		try {
			 Class.forName("net.ucanaccess.jdbc.UcanaccessDriver");
			 try (Connection conn = DriverManager.getConnection(ConstsElectDayDB.CONN_STR);
					 
				CallableStatement stmt = conn.prepareCall(ConstsElectDayDB.SQL_INS_RIDE)) {
		int i = 1;
		stmt.setInt(i++, elector);
		stmt.setInt(i++, employee);
		stmt.setString(i++, pickUp);
		stmt.setString(i++, returnTime);
		 stmt.executeUpdate();
		 } catch (SQLException e) {
			 System.out.println("DbNewRide Failure2");
		 e.printStackTrace();
		 }
		 } catch (ClassNotFoundException e) {
			 System.out.println("DbNewRide ClassNotFound Failure2");
		 e.printStackTrace();
		 }
	}
}
