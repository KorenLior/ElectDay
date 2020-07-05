package Entity;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class DbGetPartyList {
	
	public DbGetPartyList() {
		// TODO Auto-generated constructor stub
	}
	ConstsDbParty dbConsts = new ConstsDbParty();
	public static ArrayList<Party> getParties() {
		 ArrayList<Party> results = new ArrayList<Party>();
		 try {
			 
		 Class.forName("net.ucanaccess.jdbc.UcanaccessDriver");
		 
		 try (Connection conn = DriverManager.getConnection(ConstsDbParty.CONN_STR);

		 PreparedStatement stmt = conn.prepareStatement(ConstsDbParty.SQL_SEL_PARTY);
				
		 ResultSet rs = stmt.executeQuery()) {
			
		 while (rs.next()) {
		 int i = 1;
		 Party result = null;
		 try
		 {
			
			 result = new Party(rs.getString(i++), rs.getString(i++),rs.getString(i++));
		 }
		 catch (Exception e) {
			// TODO: handle exception
			 System.out.println("Party readDb Failure");
		 }
		 results.add(result);
		 }
		 } catch (SQLException e) {
			 System.out.println("getParties() readFromDb Failure");
		 e.printStackTrace();
		 }
		} catch (ClassNotFoundException e) {
		 e.printStackTrace();
		}

		return results;
	}
}
