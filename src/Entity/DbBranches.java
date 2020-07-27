package Entity;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class DbBranches {
	
	
	public ArrayList<Branch> getBranches() {
		 ArrayList<Branch> results = new ArrayList<Branch>();
		 try {
		 Class.forName("net.ucanaccess.jdbc.UcanaccessDriver");
		 try (Connection conn = DriverManager.getConnection(ConstsDbManageElect.CONN_STR);

		 PreparedStatement stmt = conn.prepareStatement(ConstsDbManageElect.SQL_SEL_BRANCHES);

		 ResultSet rs = stmt.executeQuery()) {

		 while (rs.next()) {
		 int i = 1;
		 Branch result = null;
		 try
		 {
			 result = new Branch(rs.getInt(i++), rs.getInt(i++));
			 
		 }
		 catch (Exception e) {
			// TODO: handle exception
			 System.out.println("Branch readDb Failure");
		 }
		 results.add(result);
		 }
		 } catch (SQLException e) {
			 System.out.println("getBranches() readFromDb Failure");
		 e.printStackTrace();
		 }
		} catch (ClassNotFoundException e) {
		 e.printStackTrace();
		}

		return results;
	}
	public void addBranch(int branchNum, int managerId, int transportMngId) {
		try {
			Class.forName("net.ucanaccess.jdbc.UcanaccessDriver");
			try (Connection conn = DriverManager.getConnection(ConstsDbManageElect.CONN_STR);
				 
			CallableStatement stmt = conn.prepareCall(ConstsDbManageElect.SQL_INS_BRANCH)) {	
			int i = 1;
			
			stmt.setInt(i++, branchNum);
			stmt.setInt(i++, managerId);
			stmt.setInt(i++, transportMngId);
			stmt.executeUpdate();
			}
			catch (SQLException e) {
			System.out.println("insertBranch Failure2");
			e.printStackTrace();
			}
		} catch (ClassNotFoundException e) {
			System.out.println("insertBranch ClassNotFound Failure2");
			e.printStackTrace();
		}
	}
}
