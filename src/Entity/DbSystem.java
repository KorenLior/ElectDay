package Entity;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class DbSystem {
	public SystemInfo getSystem() {
		
		String partyName = null;
		int managerId = -5555;
		 try {
			 Class.forName("net.ucanaccess.jdbc.UcanaccessDriver");
			 try (Connection conn = DriverManager.getConnection(ConstsElectDayDB.CONN_STR);
			
			 PreparedStatement stmt = conn.prepareStatement(ConstsElectDayDB.SQL_SEL_SYSTEM);
			
			 ResultSet rs = stmt.executeQuery()) {
					rs.next();
					int i = 1;
					managerId = rs.getInt(i++);
					partyName = rs.getString(i++);
					
			 
		 } catch (SQLException e) {
		 e.printStackTrace();
		 }
		} catch (ClassNotFoundException e) {
		 e.printStackTrace();
		}
		SystemInfo results = new SystemInfo(partyName, managerId);
		return results;
	}
}
